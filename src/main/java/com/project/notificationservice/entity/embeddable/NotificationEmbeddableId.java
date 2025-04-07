package com.project.notificationservice.entity.embeddable;

import com.project.notificationservice.enums.Time;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEmbeddableId {
    @Column(name = "USERNAME", nullable = false, length = 100)
    private String username;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length =  10)
    private Time time;
}
