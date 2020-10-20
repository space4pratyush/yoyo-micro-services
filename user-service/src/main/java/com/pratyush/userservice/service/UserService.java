package com.pratyush.userservice.service;

import com.pratyush.userservice.dto.*;
import com.pratyush.userservice.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserRegistrationDto registerUser(UserDto userDto);

    AddYoyoBalanceDto addYoyoBalance(AddBalanceDto addBalanceDto, String userId) throws ServiceException;

    UpdateResponseDto updateProfile(UpdateProfileDto updateProfileDto, String userId) throws ServiceException;

    UserResponseDto profileDetails(String userId) throws  ServiceException;

    LoginResponseDto loginUser(LoginDto loginDto) throws  ServiceException;

    UserResponseDto updateBalance(String userId, double bill);

    UserResponseDto verifyYoyoBalance(double yoyoBalance, String userId) throws  ServiceException;

}
