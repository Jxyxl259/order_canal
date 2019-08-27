package com.lenovo.m2.oc.canal.service;


import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.oc.canal.dao.ordercenter.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("TransOrderInfoToESService")
public class TransToESService {

    @Autowired
    private MainDao mainDao;


    public RemoteResult injectData2ES(Long orderId){
        RemoteResult result = new RemoteResult(false);


        return result;
    }


}
