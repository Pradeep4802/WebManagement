
package com.bean;

import com.userdata.*;
import com.pojo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankDAO {

    static Connection con = DBConnect.getConnect();

    public static boolean insertBank(BankAccount bk) {

        try {
            String INSERT_BANK = "INSERT INTO bank(AccountNo,BankName,Ifsc,Salary,SalaryDate) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(INSERT_BANK);
            pst.setString(1, bk.getAccount());
            pst.setString(2, bk.getBankname());
            pst.setString(3, bk.getIfsc());
            pst.setString(4, bk.getSalary());
            pst.setString(5, bk.getSalarydate());

            int status = pst.executeUpdate();

            if (status > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public static boolean deleteBank(int id) {
        try {
            String DELETE_BANK = "DELETE FROM bank where ID = ?";
            PreparedStatement pst = con.prepareStatement(DELETE_BANK);
            pst.setInt(1,id);
            int status = pst.executeUpdate();
            
            if(status > 0) {
                return true;
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public List<BankAccount> showAllUser() {
        List<BankAccount> list = new ArrayList();
        try {
            String SELECT_ALL = "SELECT * from bank";
            PreparedStatement pst = con.prepareStatement(SELECT_ALL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BankAccount emp = new BankAccount();
                emp.setId(rs.getInt("ID"));
                emp.setAccount(rs.getString("AccountNo"));
                emp.setBankname(rs.getString("BankName"));
                emp.setIfsc(rs.getString("Ifsc"));
                emp.setSalary(rs.getString("Salary"));
                emp.setSalarydate(rs.getString("SalaryDate"));

                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
