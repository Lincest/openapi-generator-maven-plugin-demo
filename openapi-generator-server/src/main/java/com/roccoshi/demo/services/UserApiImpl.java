package com.roccoshi.demo.services;

import com.roccoshi.demo.api.*;
import com.roccoshi.demo.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserApiImpl implements UserApiDelegate {
    @Override
    public ResponseEntity<Response> saveUser(User user) {
        Response res = new Response();
        res.setCode("200");
        res.setMessage("received message: " + user.toString());
        res.setData(user);
        res.setSuccess(true);
        return ResponseEntity.ok().body(res);
    }
}
