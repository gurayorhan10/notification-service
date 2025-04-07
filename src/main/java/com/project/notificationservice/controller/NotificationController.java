package com.project.notificationservice.controller;

import com.project.notificationservice.controller.request.NotificationSaveRequest;
import com.project.notificationservice.controller.response.NotificationSaveResponse;
import com.project.notificationservice.domain.NotificationDomain;
import com.project.notificationservice.enums.Time;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationDomain notificationDomain;

    @Transactional
    @PostMapping(path = {"/save"})
    public ResponseEntity<NotificationSaveResponse> save(@RequestBody @Valid NotificationSaveRequest notificationSaveRequest){
        return ResponseEntity.ok(new NotificationSaveResponse(notificationDomain.save(notificationSaveRequest.getNotification())));
    }

    @Transactional
    @PostMapping(path = {"/deleteByUser/{time}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByUser(@PathVariable Time time){
        notificationDomain.deleteByUser(time);
    }

}