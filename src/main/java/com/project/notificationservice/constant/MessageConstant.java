package com.project.notificationservice.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageConstant {
    USERNAME_CANNOT_BLANK("Username cannot be left blank."),
    USERNAME_BY_SYSTEM_ERROR("Operations cannot be performed with the SYSTEM user.");
    private final String message;
}
