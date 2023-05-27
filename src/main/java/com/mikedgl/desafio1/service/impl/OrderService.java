package com.mikedgl.desafio1.service.impl;

import com.mikedgl.desafio1.entities.Order;
import com.mikedgl.desafio1.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public Double total(Order order){
        Double shippingValue = shippingService.shipment(order);
        Double discount = order.getBasic() * (order.getDiscount() / 100);
        return order.getBasic() - discount + shippingValue;
    }


}
