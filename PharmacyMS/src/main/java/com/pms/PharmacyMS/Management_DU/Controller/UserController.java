package com.pms.PharmacyMS.Management_DU.Controller;

import com.pms.PharmacyMS.Management_DU.DTO.ResponseDTO;
import com.pms.PharmacyMS.Management_DU.DTO.UserDTO;
import com.pms.PharmacyMS.Management_DU.Service.UserService;
import com.pms.PharmacyMS.Management_DU.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",allowCredentials = "false")
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity user_login(@RequestBody UserDTO loginDTO)
    {
        ResponseDTO responseDTO=userService.UserAuthentication(loginDTO);
        if(responseDTO.getCode()== VarList.RIP_NO_DATA_FOUND)
        {
            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
        }else if(responseDTO.getCode()== VarList.RIP_FAIL)
        {
            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
        } else if (responseDTO.getCode()==VarList.RIP_SUCCESS) {
            return new ResponseEntity(responseDTO, HttpStatus.OK);
        }
        else
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
