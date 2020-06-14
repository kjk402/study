package com.example.study.model.network.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class OrderGroupApiRequest {

    private Long id;

    private String status;

    private String orderType;

    private String revAddress; //수신 주소

    private String revName;   //수신인

    private String paymentType; //카드or 현금

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;  //주문일자

    private LocalDateTime arrivalDate;

    private Long userId;



}
