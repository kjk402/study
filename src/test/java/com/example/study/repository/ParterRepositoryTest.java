package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class ParterRepositoryTest extends StudyApplicationTests {


    @Autowired
    private PartnerRepository partnerRepository;


    @Test
    public void create(){
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-7777-7777";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123"; //사업자번호
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 3L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);

        //partner.setCategoryId(categoryId);

        Partner newpartner = partnerRepository.save(partner);
        Assertions.assertNotNull(newpartner);
        Assertions.assertEquals(newpartner.getName(), name);


    }


   @Test
    public void read(){


    }




}
