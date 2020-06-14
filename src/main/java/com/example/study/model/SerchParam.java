package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

// 모든 매개변수 갖는 생성자  추가명령어
public class SerchParam {

    private String account;
    private String email;
    private int page;
    // { "account" : "", "email" : "", "page" : ""} 어떻게 받는지 ? => return SerchPara;
}
