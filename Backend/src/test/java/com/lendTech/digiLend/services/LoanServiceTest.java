package com.lendTech.digiLend.services;

import com.lendTech.digiLend.models.Loan;
import com.lendTech.digiLend.repositories.LoanRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    LoanRepository loanRepository;

    @InjectMocks
    LoanService loanService;

    @Test
    @DisplayName("Should be able to save a loan")
    void saveLoan() {
        Loan loan = new Loan();
        loan.setUserId(123L);
        loan.setUserId(3L);
        loan.setAmount(24000L);
        loan.setRepaymentDate("2022-04-04 14:23:38");
        loan.setDisbursementDate("2022-03-04 14:23:38");
        when(loanRepository.save(ArgumentMatchers.any(Loan.class))).thenReturn(loan);
        loanService.saveLoan(loan);
        verify(loanRepository).save(loan);
    }

    @Test
    @DisplayName("Should be able to get previous loans by userId")
    void getLoansByUserId() {
        loanRepository.findByUserId(123L);
    }

    @Test
    @DisplayName("Should be able to see all loans stored in db")
    void getAllLoans() {
        loanRepository.findAll();
    }

    @Test
    void getLoanLimitForUser() {
        loanService.getLoanLimitForUser(123L);
    }

}