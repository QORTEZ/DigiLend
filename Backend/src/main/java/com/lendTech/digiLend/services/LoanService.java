package com.lendTech.digiLend.services;

import com.lendTech.digiLend.models.Loan;
import com.lendTech.digiLend.models.LoanDetails;
import com.lendTech.digiLend.repositories.LoanRepository;
import com.lendTech.digiLend.utils.DatesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    /**
     * This method saves a loan object
     *
     * @param loan
     * @return
     */
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    /**
     * Returns all loans for a particular user
     *
     * @param userId
     * @return
     */
    public List<Loan> getLoansByUserId(Long userId) {

        return loanRepository.findByUserId(userId);
    }

    /**
     * Returns all loans in database
     *
     * @return
     */
    public List<LoanDetails> getAllLoans() {

        ArrayList<Long> loanIds = new ArrayList<>();
        List<Loan> all = loanRepository.findAll();
        for ( Loan loan : all) {
            loanIds.add(loan.getId());
        }
        return loanRepository.getLoanDetails(loanIds);
    }


    /**
     * Simulates risk assessment and offering  of loan limit
     *
     * @param userId
     * @return
     */
    public int getLoanLimitForUser(Long userId) {

        int min = 20000;
        int max = 30000;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    /**
     * Saves loan details
     *
     * @param userId
     * @param amount
     * @return
     * @throws ParseException
     */
    public Loan applyLoan(Long userId, Long amount) throws ParseException {

        DatesHelper datesHelper = new DatesHelper();

        String disbursementDate = datesHelper.currentDateTime();

        String repaymentDate = datesHelper.addOneMonthToDate(disbursementDate);

        Loan loan = new Loan();
        loan.setAmount(amount);
        loan.setUserId(userId);
        loan.setDisbursementDate(disbursementDate);
        loan.setRepaymentDate(repaymentDate);
        return loanRepository.save(loan);
    }


}
