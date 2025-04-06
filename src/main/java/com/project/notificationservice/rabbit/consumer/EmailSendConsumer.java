package com.project.notificationservice.rabbit.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.notificationservice.rabbit.data.EmailSendMessage;
import com.project.notificationservice.rabbit.queue.EmailSendQueue;
import com.project.notificationservice.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class EmailSendConsumer {

    @Autowired
    private EmailService emailService;

    @Transactional(rollbackFor = Exception.class)
    @RabbitListener(queues = EmailSendQueue.QUEUE_NAME)
    public void consumer(Message message) throws JsonProcessingException, MessagingException {
        log.info(new String(message.getBody()));
        EmailSendMessage emailSendMessage = new ObjectMapper().readValue(new String(message.getBody()), EmailSendMessage.class);
        emailService.send(emailSendMessage.getTo(),emailSendMessage.getTitle(),emailSendMessage.getContent(),emailSendMessage.getSimple());
    }

}
