package com.project.notificationservice.service;

import com.project.notificationservice.dto.NotificationDTO;
import com.project.notificationservice.entity.NotificationEntity;
import com.project.notificationservice.entity.embeddable.NotificationEmbeddableId;
import com.project.notificationservice.enums.Time;
import com.project.notificationservice.repository.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationDTO save(NotificationDTO notificationDTO){
        return mapper.map(notificationRepository.save(mapper.map(notificationDTO, NotificationEntity.class)),NotificationDTO.class);
    }

    public void deleteByUser(String username, Time time){
        notificationRepository.deleteById(new NotificationEmbeddableId(username,time));
    }

}
