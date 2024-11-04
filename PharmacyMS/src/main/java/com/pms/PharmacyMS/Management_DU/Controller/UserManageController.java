package com.pms.PharmacyMS.Management_DU.Controller;

import com.pms.PharmacyMS.Management_DU.DTO.ResponseDTO;
import com.pms.PharmacyMS.Management_DU.DTO.UserManageDTO;
import com.pms.PharmacyMS.Management_DU.Service.UserService;
import com.pms.PharmacyMS.Management_DU.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping("/api/usermng")
public class UserManageController {

    @Autowired
    private UserService userService;


    @GetMapping("getallusers")
    public ResponseEntity<ResponseDTO> getAllMedicals(){
        ResponseDTO allUsers = userService.getAllUsers();
        if (allUsers.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(allUsers,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("insertbulkusers")
    public ResponseEntity insertUsersAsBulk(@RequestBody List<UserManageDTO> userDTOS){
        ResponseDTO usersAsBulk = userService.insertUsersAsBulk(userDTOS);
        if (usersAsBulk.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(usersAsBulk,HttpStatus.CREATED);

        }else{
            return new ResponseEntity(usersAsBulk,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("insertauser")
    public ResponseEntity insertAMedical(@RequestBody UserManageDTO userManageDTO){
        ResponseDTO insertOneUser = userService.insertAUser(userManageDTO);
        if (insertOneUser.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(insertOneUser,HttpStatus.CREATED);
        }else {
            return new ResponseEntity(insertOneUser,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getauser/{id}")
    public ResponseEntity getAUserById(@PathVariable int id){
        ResponseDTO getAUserById =userService.getAUserById(id);
        if (getAUserById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(getAUserById,HttpStatus.OK);
        }else {
            return new ResponseEntity(getAUserById,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateauser/{id}")
    public ResponseEntity updateAUserById(@RequestBody UserManageDTO userManageDTO){
        ResponseDTO updateOneUserById = userService.updateAUserById(userManageDTO);
        if (updateOneUserById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(updateOneUserById,HttpStatus.OK);
        }else {
            return new ResponseEntity(updateOneUserById,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delauser/{id}")
    public ResponseEntity deleteAUserById(@PathVariable int id){
        ResponseDTO deleteOneUserById = userService.deleteAUserById(id);
        if (deleteOneUserById.getCode().equals(VarList.RIP_SUCCESS)){
            return new ResponseEntity(deleteOneUserById,HttpStatus.OK);
        }else {
            return new ResponseEntity(deleteOneUserById,HttpStatus.NOT_FOUND);
        }
    }

}
