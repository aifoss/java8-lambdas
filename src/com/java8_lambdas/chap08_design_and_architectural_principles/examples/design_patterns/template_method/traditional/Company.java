package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.template_method.traditional;

/**
 * Created by sofia on 12/25/16.
 */
public interface Company {

    void checkIdentity() throws ApplicationDenied;
    void checkProfitAndLoss() throws ApplicationDenied;
    void checkHistoricalDebt() throws ApplicationDenied;

}
