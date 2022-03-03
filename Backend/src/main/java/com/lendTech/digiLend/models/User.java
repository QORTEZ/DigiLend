package com.lendTech.digiLend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @NotBlank
    private String username;

    @NotBlank
    private String identificationNumber;


    @NotBlank
    @JsonIgnore
    private String password;

    private String accountStatus;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public User(String firstName, String secondName, String username, String identificationNumber, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.identificationNumber = identificationNumber;
        this.password = password;
        this.accountStatus = "1"; // one for active
    }

}
