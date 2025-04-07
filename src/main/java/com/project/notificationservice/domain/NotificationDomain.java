package com.project.notificationservice.domain;

import com.project.notificationservice.constant.GlobalConstant;
import com.project.notificationservice.constant.MessageConstant;
import com.project.notificationservice.dto.NotificationDTO;
import com.project.notificationservice.enums.Time;
import com.project.notificationservice.exception.GlobalException;
import com.project.notificationservice.service.NotificationService;
import com.project.notificationservice.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class NotificationDomain {

    @Autowired
    private HeaderUtil headerUtil;

    @Autowired
    private NotificationService notificationService;

    public NotificationDTO save(NotificationDTO notificationDTO){
        if(Objects.isNull(headerUtil.getUsername())){
            throw new GlobalException(MessageConstant.USERNAME_CANNOT_BLANK.getMessage());
        }
        if(GlobalConstant.SYSTEM.equalsIgnoreCase(headerUtil.getUsername())){
            throw new GlobalException(MessageConstant.USERNAME_BY_SYSTEM_ERROR.getMessage());
        }
        notificationDTO.setUsername(headerUtil.getUsername());
        notificationDTO.setInsertDate(new Date());
        return notificationService.save(notificationDTO);
    }

    public void deleteByUser(Time time){
        if(Objects.isNull(headerUtil.getUsername())){
            throw new GlobalException(MessageConstant.USERNAME_CANNOT_BLANK.getMessage());
        }
        notificationService.deleteByUser(headerUtil.getUsername(),time);
    }

}
