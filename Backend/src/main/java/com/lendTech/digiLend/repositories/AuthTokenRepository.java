package com.lendTech.digiLend.repositories;

import com.lendTech.digiLend.models.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthTokenRepository extends JpaRepository<AuthToken,Long> {

    AuthToken findByAuthToken(String token);

}
