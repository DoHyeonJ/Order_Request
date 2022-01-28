package account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String company; // 회사명

    @Column
    private LocalDateTime registrationDate; // 등록일

    @Column
    private Character status; // Y : 활동중, N : 접속중지, D : 삭제

    @Column
    private LocalDateTime quitDate; // 탈퇴일 , 3개월 경과시 자동삭제처리

}
