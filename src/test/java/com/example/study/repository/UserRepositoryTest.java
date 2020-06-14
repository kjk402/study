package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {


    @Autowired // repository 이용해서 crud 텟스트할려면 필요한 di =의존성 주입 Dependency Injection
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test03@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        //User u = User.builder().account(account).password(password).status(status).email(email).build();



        User newuser =userRepository.save(user);

        Assertions.assertNotNull(newuser);

    }

    @Test
    @Transactional

    public void read(){
        //phoneNumber 로 검색
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("-------------주문내역-------------");
            System.out.println("수령인 : "+orderGroup.getRevName());
            System.out.println("수령지 : "+orderGroup.getRevAddress());
            System.out.println("총금액 : "+orderGroup.getTotalPrice());


            System.out.println("---------------주문상세----------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                //Partner
                System.out.println("파트너사 이름 : "+orderDetail.getItem().getPartner().getName());
                //Category
                System.out.println("파트너사 카테고리 : "+orderDetail.getItem().getPartner().getCategory().getTitle());
                //Item
                System.out.println("주문상품 : "+orderDetail.getItem().getName());
                //Partner
                System.out.println("고객센터 번호 : "+orderDetail.getItem().getPartner().getCallCenter());
                //OrderDetail
                System.out.println("상품상태 : "+orderDetail.getStatus());
                System.out.println("도착예정일 : "+ orderDetail.getArrivalDate());
            });
        });

        Assertions.assertNotNull(user);





    }

    @Test
    public void update(){
        //update 할려면 특정 데이터 select 해야함.



    }


    @Test
    //@DeleteMapping("/api/user")
    public void delete(){
        Optional<User> user = userRepository.findById(8L);

        //Assert.asserttrue
        user.ifPresent(selectuser ->{
            userRepository.delete(selectuser);
        });

        Optional<User> deleteuser = userRepository.findById(8L);

        if (deleteuser.isPresent()) {

            System.out.println("데이터 존재 : "+deleteuser.get());
        }else {
            System.out.println("데이터 존재하지 않음");

        }


    }



}
