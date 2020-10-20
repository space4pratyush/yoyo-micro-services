package com.pratyush.userservice.controller;

import com.pratyush.userservice.dto.*;
import com.pratyush.userservice.exception.ServiceException;
import com.pratyush.userservice.exception.UserServiceException;
import com.pratyush.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userSignUp")
    public ResponseEntity<UserRegistrationDto> userSignUp(@RequestBody UserDto userDto) throws UserServiceException {
        return new ResponseEntity<UserRegistrationDto>(userService.registerUser(userDto), HttpStatus.OK);
    }

    @PutMapping("/addYoyoBalance/{userId}")
    public ResponseEntity<AddYoyoBalanceDto> addYoyoBalance(@RequestBody AddBalanceDto addBalance, @PathVariable String userId) throws UserServiceException {
        return new ResponseEntity<AddYoyoBalanceDto>(userService.addYoyoBalance(addBalance, userId), HttpStatus.OK);
    }

    @PutMapping("/updateProfile/{userId}")
    public ResponseEntity<UpdateResponseDto> updateProfile(@RequestBody UpdateProfileDto updateProfileDto,
                                                           @PathVariable String userId) throws UserServiceException {
        return new ResponseEntity<UpdateResponseDto>(userService.updateProfile(updateProfileDto, userId),HttpStatus.OK);
    }

    @GetMapping("/profileDetail/{userId}")
    public ResponseEntity<UserResponseDto> ProfileDetails(@PathVariable String userId) throws UserServiceException {
        return new ResponseEntity<UserResponseDto>(userService.profileDetails(userId),HttpStatus.OK);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginDto loginDto)throws  UserServiceException
    {
        return new ResponseEntity<LoginResponseDto>(userService.loginUser(loginDto),HttpStatus.OK);
    }

    @PutMapping("/verifybalance/{yoyoBalance}/{userId}")
    public ResponseEntity<UserResponseDto> verifyYoyoBalanceController(@PathVariable double yoyoBalance,
                                                                       @PathVariable String userId) throws UserServiceException {
        try {
            return new ResponseEntity<UserResponseDto>(userService.verifyYoyoBalance(yoyoBalance,userId),HttpStatus.OK);
        }catch(ServiceException ex) {
            throw new UserServiceException(ex.getMessage());
        }
    }

    @PutMapping("/updatebalance/{userId}/{bill}")
    public ResponseEntity<UserResponseDto> updateBalanceController(@PathVariable String userId,@PathVariable double bill){
        UserResponseDto user=userService.updateBalance(userId,bill);
        System.out.println(user.getYoYoBalance());
        return new ResponseEntity<UserResponseDto>(user, HttpStatus.OK);

    }


}
