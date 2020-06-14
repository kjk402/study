package com.example.study.repository;


import com.example.study.StudyApplicationTests;

import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("배송준비중");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2)); // 현재일자에 2일 더한것
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));

        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("Partner01");


        //orderDetail.setOrderGroupId (4L); //장바구니에
        // 어떤 상품?
        //orderDetail.setItemId(3L);



        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }



}
