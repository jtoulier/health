package com.springonly.health.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InetAddressVO {
    private String hostAddress;
    private String hostName;
}
