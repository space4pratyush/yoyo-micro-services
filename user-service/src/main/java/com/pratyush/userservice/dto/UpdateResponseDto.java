package com.pratyush.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResponseDto {

    List<String> updatedResponse;

    List<String> errorsInUpdate;
}
