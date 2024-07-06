package com.project_railway.domain.Repository;

import com.project_railway.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByCardNumberOrAccountNumber(String cardNumber, String accountNumber);
}
