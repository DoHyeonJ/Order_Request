package com.module.account;

import com.module.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String company; // 회사명

    @Column
    private Character status; // Y : 활동중, N : 접속중지, D : 삭제

    @Column
    private LocalDateTime quitDate; // 탈퇴일 , 3개월 경과시 자동삭제처리

    @Column
    private String role; // 권한 , 일반유저 : USER, 관리자 : ADMIN

}
