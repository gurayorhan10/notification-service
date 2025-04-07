package com.project.notificationservice.entity;

import com.project.notificationservice.entity.embeddable.NotificationEmbeddableId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NOTIFICATION")
public class NotificationEntity {
    @Id
    private NotificationEmbeddableId notificationEmbeddableId;
    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;
    @Column(name = "INSERT_DATE", nullable = false)
    private Date insertDate;
}
