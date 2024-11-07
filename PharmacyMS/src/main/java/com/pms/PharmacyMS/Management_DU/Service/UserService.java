package com.pms.PharmacyMS.Management_DU.Service;

import com.pms.PharmacyMS.Management_DU.DTO.ResponseDTO;
import com.pms.PharmacyMS.Management_DU.DTO.UserDTO;
import com.pms.PharmacyMS.Management_DU.DTO.UserDetails;
import com.pms.PharmacyMS.Management_DU.DTO.UserManageDTO;
import com.pms.PharmacyMS.Management_DU.Entity.UserEntity;
import com.pms.PharmacyMS.Management_DU.Repository.UserRepo;
import com.pms.PharmacyMS.Management_DU.Util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseDTO UserAuthentication(UserDTO userDTO) {
        UserEntity user = userRepo.findByEmail(userDTO.getEmail());

        if (user == null) {
            // User not found, set response for no user found
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(userDTO);
            responseDTO.setMessage("Invalid User Name");
            return responseDTO; // Early return here
        }

        // Now that we know user is not null, proceed with password check
        if (!user.getPassword().equals(userDTO.getPassword())) {
            responseDTO.setCode(VarList.RIP_FAIL);
            responseDTO.setContent(userDTO);
            responseDTO.setMessage("Invalid Password");
            return responseDTO; // Early return here
        }

        // Password matches, set user details
        UserDetails userDetails = new UserDetails();
        userDetails.setName(user.getName());
        userDetails.setEmail(user.getEmail());
        userDetails.setSalary(user.getSalary());
        userDetails.setContact_no(user.getContact_no());
        userDetails.setJoined_date(user.getJoined_date());
        userDetails.setBranch_id(user.getBranch_id());
        userDetails.setRole_id(user.getRole_id());

        responseDTO.setCode(VarList.RIP_SUCCESS);
        responseDTO.setContent(userDetails);
        responseDTO.setMessage("Successful");

        return responseDTO;
    }

//    public ResponseDTO UserAuthentication(UserDTO userDTO) {
//        UserEntity user = userRepo.findByEmail(userDTO.getEmail());
//
//        UserDetails userDetails = new UserDetails();
//
//        userDetails.setName(user.getName());
//        userDetails.setEmail(user.getEmail());
//        userDetails.setSalary(user.getSalary());
//        userDetails.setContact_no(user.getContact_no());
//        userDetails.setJoined_date(user.getJoined_date());
//        userDetails.setBranch_id(user.getBranch_id());
//        userDetails.setRole_id(user.getRole_id());
//
//        if (user == null){
//            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
//            responseDTO.setContent(userDTO);
//            responseDTO.setMessage("Invalid User Name");
//
//        }else if(!user.getPassword().equals(userDTO.getPassword()) )
//        {
//            responseDTO.setCode(VarList.RIP_FAIL);
//            responseDTO.setContent(userDTO);
//            responseDTO.setMessage("Invalid Password");
//        }else if(user.getPassword().equalsIgnoreCase(userDTO.getPassword())){
//
//            responseDTO.setCode(VarList.RIP_SUCCESS);
//            responseDTO.setContent(userDetails);
//            responseDTO.setMessage("Successfull");
//        }
//
//        return responseDTO;
//
//    }


    public ResponseDTO getAllUsers(){
        List<UserEntity> userEntities = userRepo.findAll();
        if (userEntities.isEmpty()){
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("users not found!");
        }else {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(modelMapper.map(userEntities, new TypeToken<ArrayList<UserManageDTO>>(){}.getType()));
            responseDTO.setMessage("users found!");
        }
        return responseDTO;
    }

    public ResponseDTO insertUsersAsBulk(List<UserManageDTO> userManageDTOS){
        List<UserEntity> usersAsBulk = modelMapper.map(userManageDTOS,new TypeToken<ArrayList<UserEntity>>(){}.getType());
        try {
            userRepo.saveAll(usersAsBulk);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(userManageDTOS);
            responseDTO.setMessage("Users have been inserted");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(userManageDTOS);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO insertAUser(UserManageDTO userManageDTO){
        UserEntity insertOneMedical = modelMapper.map(userManageDTO,UserEntity.class);
        try {
            userRepo.save(insertOneMedical);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(userManageDTO);
            responseDTO.setMessage("User has been inserted");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(userManageDTO);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    public ResponseDTO getAUserById(int id){
        if (userRepo.existsById(id)){

            Optional<UserEntity> userRepoById = userRepo.findById(id);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(userRepoById);
            responseDTO.setMessage("Data found");

        }else {
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Data not found");
        }

        return responseDTO;
    }
    public ResponseDTO updateAUserById(UserManageDTO medicalDTO){
        UserEntity updateOneUserById = modelMapper.map(medicalDTO,UserEntity.class);
        try {
            userRepo.save(updateOneUserById);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(medicalDTO);
            responseDTO.setMessage("user has been updated");
        }catch (Exception e){
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(medicalDTO);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
    public ResponseDTO deleteAUserById(int id){
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(id);
            responseDTO.setMessage("medical has been deleted");
        }else {
            responseDTO.setCode(VarList.RIP_ERROR);
            responseDTO.setContent(id);
            responseDTO.setMessage("medical id not found");
        }
        return responseDTO;
    }

    public void createUser(UserEntity user) {
        userRepo.createUser(
                user.getName(),
                user.getContact_no(),
                user.getSalary(),
                user.getJoined_date(),
                user.getEmail(),
                user.getPassword(),
                user.getBranch_id(),
                user.getRole_id()
        );
    }

    public List<UserEntity> getAllActiveUsers() {
        return userRepo.getAllActiveUsers();
    }

    //getAllDisabledUsers
    public List<UserEntity> getAllDisabledUsers() {
        return userRepo.getAllDisabledUsers();
    }





    public Optional<UserEntity> getUserById(Integer userId) {
        return Optional.ofNullable(userRepo.getUserById(userId));
    }


    public void updateUser(Integer userId, UserEntity userDetails) {
        userRepo.updateUser(
                userId,
                userDetails.getName(),
                userDetails.getContact_no(),
                userDetails.getSalary(),
                userDetails.getJoined_date(),
                userDetails.getEmail(),
                userDetails.getPassword(),
                userDetails.getBranch_id(),
                userDetails.getRole_id()
        );
    }

    public void softDeleteUser(Integer userId) {
        userRepo.softDeleteUser(userId);
    }

    public void hardDeleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }

}
