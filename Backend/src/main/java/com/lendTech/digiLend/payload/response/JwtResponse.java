package com.lendTech.digiLend.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private Long id;
    private String username;
    private String firstName;
    private String secondName;
    private String accountStatus;
    private String identificationNumber;
    private List<String> roles;

    public JwtResponse(String accessToken, String refreshToken, Long id, String username, String firstName, String secondName,
                       String accountStatus, String identificationNumber, List<String> roles) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountStatus = accountStatus;
        this.identificationNumber = identificationNumber;
        this.roles = roles;
    }
}
