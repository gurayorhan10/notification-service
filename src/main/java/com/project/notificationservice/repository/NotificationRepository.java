package com.project.notificationservice.repository;

import com.project.notificationservice.entity.NotificationEntity;
import com.project.notificationservice.entity.embeddable.NotificationEmbeddableId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, NotificationEmbeddableId> {

}