package com.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    // 신규 회원가입
    public void newSign(SignUpForm signUpForm) {
        try{
            Account account = new Account();
            account.setEmail(signUpForm.getEmail());
            account.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
            account.setCompany(signUpForm.getCompany());
            accountRepository.save(account);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Email 중복체크
    public boolean checkDuplicateEmail(String email) {
        return accountRepository.existsAccountByEmail(email);
    }

}
