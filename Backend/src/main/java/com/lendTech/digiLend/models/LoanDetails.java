package com.lendTech.digiLend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanDetails {

    private String phoneNumber;
    private String identificationNumber;
    private String firstName;
    private String secondName;
    private Long amount;
    private String disbursementDate;
    private String repaymentDate;

    public LoanDetails( String firstName, String secondName, String username, String identificationNumber ,
                        Long amount, String disbursementDate, String repaymentDate){

        this.firstName = firstName;
        this.secondName = secondName;
        this.identificationNumber = identificationNumber;
        this.amount = amount;
        this.disbursementDate = disbursementDate;
        this.repaymentDate = repaymentDate;
        this.phoneNumber = username;
    }


}
