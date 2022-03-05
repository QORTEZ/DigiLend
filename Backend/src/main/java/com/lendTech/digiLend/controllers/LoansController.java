package com.lendTech.digiLend.controllers;

import com.lendTech.digiLend.models.Loan;
import com.lendTech.digiLend.models.LoanDetails;
import com.lendTech.digiLend.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class LoansController {

    @Autowired
    LoanService loanService;

    @PostMapping("/check-limit")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public String getLoanLimit(@RequestParam Long userId) {
        return String.valueOf(loanService.getLoanLimitForUser(userId));
    }

    @PostMapping("/apply-loan")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public Loan applyLoan(@RequestParam Long userId, @RequestParam Long amount) throws ParseException {
        return loanService.applyLoan(userId, amount);
    }

    @RequestMapping("/customer/loans/{userId}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public List<Loan> getCustomerLoans(@PathVariable Long userId){
        return loanService.getLoansByUserId(userId);
    }

    @RequestMapping("/all/customers/loans")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<LoanDetails> getAllCustomerLoans(){
        return loanService.getAllLoans();
    }
}
