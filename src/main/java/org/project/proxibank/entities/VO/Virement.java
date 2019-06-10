package org.project.proxibank.entities.VO;

public class Virement {
    private Long accountDeb;
    private Long accountCred;
    private double amount;

    public Long getAccountDeb() {
        return accountDeb;
    }

    public void setAccountDeb(Long accountDeb) {
        this.accountDeb = accountDeb;
    }

    public Long getAccountCred() {
        return accountCred;
    }

    public void setAccountCred(Long accountCred) {
        this.accountCred = accountCred;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
