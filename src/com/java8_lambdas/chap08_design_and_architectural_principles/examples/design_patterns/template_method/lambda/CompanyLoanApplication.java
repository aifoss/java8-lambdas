package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.template_method.lambda;

/**
 * Created by sofia on 12/25/16.
 */
public class CompanyLoanApplication extends LoanApplication {

    public CompanyLoanApplication(Company company) {
        super(company::checkIdentity,
                company::checkHistoricalDebt,
                company::checkProfitAndLoss);
    }

}
