package com.example.grpcclient.controller;

import com.example.grpcclient.service.GrpcClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloController {
    private final GrpcClientService grpcClientService;

    @PostMapping
    public ResponseEntity<?> post(@RequestParam String message) {
        return ResponseEntity.ok(grpcClientService.sendMessage(message));
    }
}
