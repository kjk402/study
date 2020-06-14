package com.example.study.model.entity;


import com.example.study.model.enumclass.UserStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"user"})
@Builder
@Accessors(chain = true)
//@Table(name = "user") 데이터베이스랑 이름 같으니깐 생략가능

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;


    //User 1: N OrderGroup

   @OneToMany(fetch = FetchType.LAZY , mappedBy = "user")
   //private OrderGroup orderGroup;
    private List<OrderGroup> orderGroupList;


    // 1:N
    //@OneToMany(fetch = FetchType.LAZY , mappedBy = "user") //orderdetail 에있는 변수와 같아야한다. => user
    //private List<OrderDetail> orderDetailList;

}

