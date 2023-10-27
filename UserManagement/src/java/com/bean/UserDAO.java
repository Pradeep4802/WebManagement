package com.bean;

import java.sql.*;
import com.userdata.*;
import com.pojo.*;
import java.util.*;

public class UserDAO {

    Connection con = DBConnect.getConnect();

    public boolean insertUser(String name, String password, String email, String contact, String city) {

        try {
            String INSERT_DATA = "INSERT INTO user(name,password,email,contact,city) values(?,?,?,?,?)";

            PreparedStatement pt = con.prepareStatement(INSERT_DATA);
            pt.setString(1, name);
            pt.setString(2, password);
            pt.setString(3, email);
            pt.setString(4, contact);
            pt.setString(5, city);

            int status = pt.executeUpdate();

            if (status > 0) {
                return true;
            }
        } catch (Exception es) {
            es.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmp(int id) throws SQLException {
        String DELETE_EMP = "DELETE FROM user where id = ?";
        PreparedStatement pst = con.prepareStatement(DELETE_EMP);
        pst.setInt(1, id);
        int status = pst.executeUpdate();
        if (status > 0) {
            return true;
        }
        return false;
    }

    public boolean updateEmp(int id, String name, String password, String email, String contact, String city) {
        try {
            String UPDATE_EMP = "UPDATE user SET name=?,password=?,email=?,contact=?,city=? where id = ?";
            PreparedStatement pst = con.prepareStatement(UPDATE_EMP);
            pst.setString(1, name);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.setString(4, contact);
            pst.setString(5, city);
            pst.setInt(6, id);

            int status = pst.executeUpdate();

            if (status > 0) {
                return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Employee> showAllUser() throws SQLException {
        String SELECT_ALL = "SELECT * from user";
        List<Employee> list = new ArrayList();
        PreparedStatement pst = con.prepareStatement(SELECT_ALL);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setEmail(rs.getString("email"));
            emp.setContact(rs.getString("contact"));
            emp.setCity(rs.getString("city"));

            list.add(emp);
        }

        return list;
    }

    public Employee getEmp(int id) throws SQLException {
        String SELECT_ALL = "SELECT * from user where id = ?";

        Employee emp = new Employee();
        PreparedStatement pst = con.prepareStatement(SELECT_ALL);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setEmail(rs.getString("email"));
            emp.setContact(rs.getString("contact"));
            emp.setCity(rs.getString("city"));

        }
        return emp;
    }
}
