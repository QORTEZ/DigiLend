package com.lendTech.digiLend.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SignUpRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @NotBlank
    private String username;

    @NotBlank
    private String identificationNumber;

    @NotBlank
    private String password;
}
