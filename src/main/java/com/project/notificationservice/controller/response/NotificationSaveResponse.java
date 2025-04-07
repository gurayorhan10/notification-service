package com.project.notificationservice.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.notificationservice.dto.NotificationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationSaveResponse {
    private NotificationDTO notification;
}