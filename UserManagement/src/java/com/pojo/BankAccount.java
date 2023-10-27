
package com.pojo;


public class BankAccount {
    private int Id;
    private String AccountNo;
    private String BankName;
    private String Ifsc;
    private String Salary;
    private String SDate;
    
    public BankAccount() {}
    
    public BankAccount(String AccountNo,String BankName,String Ifsc,String Salary,String SDate) {
        this.AccountNo = AccountNo;
        this.BankName = BankName;
        this.Ifsc = Ifsc;
        this.Salary = Salary;
        this.SDate = SDate;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }
    
    public int getId() {
        return Id;
    }
    
    public void setAccount(String AccountNo) {
        this.AccountNo = AccountNo;
    }
    
    public String getAccount() {
        return AccountNo;
    }
    
    public void setBankname(String BankName) {
        this.BankName = BankName;
    }
    
    public String getBankname() {
        return BankName;
    }
    
    public void setIfsc(String Ifsc) {
        this.Ifsc = Ifsc;
    }
    
    public String getIfsc() {
        return Ifsc;
    }
    
    public void setSalary(String Salary) {
        this.Salary = Salary;
    }
    
    public String getSalary() {
        return Salary;
    }
    
    public void setSalarydate(String SDate) {
        this.SDate = SDate;
    }
    
    public String getSalarydate() {
        return SDate;
    }
}
