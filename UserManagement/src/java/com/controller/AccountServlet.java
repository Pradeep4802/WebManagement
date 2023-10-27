package com.controller;

import com.pojo.BankAccount;
import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.BankDAO;
import java.sql.*;

@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {
    BankDAO us = new BankDAO(); 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean b = us.deleteBank(id);
                if (b) {
                    response.sendRedirect("listBank.jsp");
                } else {
                    response.sendRedirect("error.html");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String AccountNo = request.getParameter("accno");
            String Name = request.getParameter("bname");
            String Ifsc = request.getParameter("ifsc");
            String Salary = request.getParameter("salary");
            String SDate = request.getParameter("sdate");

            BankAccount ba = new BankAccount(AccountNo, Name, Ifsc, Salary, SDate);

            if (BankDAO.insertBank(ba)) {
                response.sendRedirect("index.html");
            } else {
                response.sendRedirect("Error.html");
            }

        }
    }

}
