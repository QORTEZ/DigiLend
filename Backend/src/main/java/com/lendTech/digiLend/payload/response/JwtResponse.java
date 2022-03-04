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

    public JwtResponse(String accessToken, String refreshToken, List<String> roles) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.roles = roles;
    }
}
