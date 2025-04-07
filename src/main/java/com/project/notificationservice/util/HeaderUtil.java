package com.project.notificationservice.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeaderUtil {

    @Autowired
    private HttpServletRequest request;

    public String getUsername(){
        return request.getHeader("username");
    }

}
