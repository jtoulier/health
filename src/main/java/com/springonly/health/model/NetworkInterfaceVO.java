package com.springonly.health.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetworkInterfaceVO {
    private String name;
    private String displayName;

    private List<InetAddressVO> inetAddressVOList;
}
