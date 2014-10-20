package com.hib.inheritance.tablepersubclass;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="bankaccountid")
public class BankAccount extends BillingDetails {

    
    protected String account;

    
    protected String bankname;

    
    protected String swift;

    public BankAccount() {
        super();
    }

    public BankAccount(String owner, String account, String bankname, String swift) {
        super(owner);
        this.account = account;
        this.bankname = bankname;
        this.swift = swift;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}