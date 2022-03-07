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
    private List<String> roles;
    private Long id;
    private String firstName;
    private String secondName;


    public JwtResponse(String accessToken, String refreshToken, List<String> roles,
                       Long id, String firstName, String secondName) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.roles = roles;
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
