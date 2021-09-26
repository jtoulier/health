package com.springonly.health.controller;

import com.google.gson.Gson;
import com.springonly.health.dto.request.InfoRequest;
import com.springonly.health.dto.response.InfoResponse;
import com.springonly.health.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/info")
    public ResponseEntity<InfoResponse> getInfo(
            @RequestBody InfoRequest infoRequest
    ) {
        log.info("REQUEST: " + new Gson().toJson(infoRequest));
        InfoResponse infoResponse = infoService.getInfo(infoRequest);
        log.info("RESPONSE: " + new Gson().toJson(infoResponse));

        return new ResponseEntity<InfoResponse>(infoResponse, HttpStatus.OK);
    }
}
