package com.example.study.repository;


import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
    // 가장 마지막에 (최근)에 핸드폰 번호와 맞는사람 찾는 것
    // 한 번호로 여러번 가입가능하기에 findFirstBy
}
