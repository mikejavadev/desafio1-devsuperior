package com.mikedgl.desafio1.service.impl;

import com.mikedgl.desafio1.entities.Order;
import com.mikedgl.desafio1.service.ShippingService;
import org.springframework.stereotype.Service;

@Service
public class SedexShippingService implements ShippingService {
    @Override
    public Double shipment(Order order) {
        if(order.getBasic() < 100.0) return 20.0;
        else if(order.getBasic() <= 200.0) return 12.0;
        else return 0.0;
    }
}
