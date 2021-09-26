package com.springonly.health.service.impl;

import com.springonly.health.dto.request.InfoRequest;
import com.springonly.health.dto.response.InfoResponse;
import com.springonly.health.model.InetAddressVO;
import com.springonly.health.model.NetworkInterfaceVO;
import com.springonly.health.service.InfoService;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public InfoResponse getInfo(InfoRequest infoRequest) {
        InfoResponse infoResponse = new InfoResponse();

        infoResponse.setClientId(infoRequest.getClientId());
        infoResponse.setRequestId(infoRequest.getRequestId());

        List<NetworkInterfaceVO> networkInterfaceVOList = new ArrayList<>();

        // get network interfaces
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            // recorrer las tarjetas de red
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                NetworkInterfaceVO networkInterfaceVO = new NetworkInterfaceVO();

                networkInterfaceVO.setName(networkInterface.getName());
                networkInterfaceVO.setDisplayName(networkInterface.getDisplayName());

                List<InetAddressVO> inetAddressVOList = new ArrayList<>();

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                // recorrer las direcciones IP de una tarjeta de red
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    InetAddressVO inetAddressVO = new InetAddressVO();

                    inetAddressVO.setHostAddress(inetAddress.getHostAddress());
                    inetAddressVO.setHostName(inetAddress.getHostName());


                    inetAddressVOList.add(inetAddressVO);
                }
                networkInterfaceVO.setInetAddressVOList(inetAddressVOList);

                // agregar solo si tiene direcciones IP
                if (!networkInterfaceVO.getInetAddressVOList().isEmpty())
                    networkInterfaceVOList.add(networkInterfaceVO);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        infoResponse.setNetworkInterfaceVOList(networkInterfaceVOList);

        return infoResponse;
    }
}
