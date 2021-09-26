package com.springonly.health.dto.response;

import com.springonly.health.model.NetworkInterfaceVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.NetworkInterface;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoResponse {
    private String clientId;
    private String requestId;

    private List<NetworkInterfaceVO> networkInterfaceVOList;
}
