package com.project.notificationservice.config;

import com.project.notificationservice.dto.NotificationDTO;
import com.project.notificationservice.entity.NotificationEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

    @Bean
    @Primary
    public ModelMapper mapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<NotificationDTO, NotificationEntity>() {
            @Override
            protected void configure() {
                map().getNotificationEmbeddableId().setUsername(source.getUsername());
                map().getNotificationEmbeddableId().setTime(source.getTime());
            }
        });
        mapper.addMappings(new PropertyMap<NotificationEntity, NotificationDTO>() {
            @Override
            protected void configure() {
                map().setUsername(source.getNotificationEmbeddableId().getUsername());
                map().setTime(source.getNotificationEmbeddableId().getTime());
            }
        });
        return mapper;
    }

}
