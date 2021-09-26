package com.springonly.health.service;

import com.springonly.health.dto.request.InfoRequest;
import com.springonly.health.dto.response.InfoResponse;
import org.springframework.stereotype.Service;

public interface InfoService {
    InfoResponse getInfo(InfoRequest infoRequest);
}
