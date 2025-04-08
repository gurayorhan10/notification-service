package com.project.notificationservice.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageConstant {
    USERNAME_CANNOT_BLANK("Kullanıcı adı boş bırakılamaz."),
    USERNAME_BY_SYSTEM_ERROR("SYSTEM kullanıcısı ile işlem yapılamaz.");
    private final String message;
}
