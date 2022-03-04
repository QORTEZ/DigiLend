package com.lendTech.digiLend.repositories;

import com.lendTech.digiLend.models.Loan;
import com.lendTech.digiLend.models.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByUserId(Long userId);

    @Query("select new com.lendTech.digiLend.models.LoanDetails(user.firstName, user.secondName, user.username, " +
            "user.identificationNumber ,loan.amount, loan.disbursementDate, loan.repaymentDate)"+
            "from Loan  loan, User user where loan.userId = user.id and loan.id in :loanIds")
    List<LoanDetails> getLoanDetails(List<Long> loanIds);

}
