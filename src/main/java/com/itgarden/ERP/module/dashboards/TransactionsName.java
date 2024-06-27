/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.dashboards;

/**
 *
 * @author User
 */
public class TransactionsName {

    public String sales;
    public String purchase;
    public String CoustomerPayment;
    public String SupplierPayment;
    public String deposit;
    public String payment;

    public TransactionsName(String sales, String purchase, String CoustomerPayment, String SupplierPayment, String deposit, String payment) {
        this.sales = sales;
        this.purchase = purchase;
        this.CoustomerPayment = CoustomerPayment;
        this.SupplierPayment = SupplierPayment;
        this.deposit = deposit;
        this.payment = payment;
    }

    public TransactionsName() {
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public String getCoustomerPayment() {
        return CoustomerPayment;
    }

    public void setCoustomerPayment(String CoustomerPayment) {
        this.CoustomerPayment = CoustomerPayment;
    }

    public String getSupplierPayment() {
        return SupplierPayment;
    }

    public void setSupplierPayment(String SupplierPayment) {
        this.SupplierPayment = SupplierPayment;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
