package com.lenovo.m2.oc.canal.service;


import com.lenovo.m2.arch.framework.domain.RemoteResult;
import org.springframework.stereotype.Component;

@Component("TransOrderInfoToESService")
public class TransToESService {

    public RemoteResult injectData2ES(Long orderId){
        RemoteResult result = new RemoteResult(false);


        return result;
    }


}
