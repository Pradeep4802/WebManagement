package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.UserDAO;
import com.pojo.*;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    UserDAO us = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            if (action != null && action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Employee emp = us.getEmp(id);
                session.setAttribute("e", emp);
                response.sendRedirect("updateemp.jsp");
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean b = us.deleteEmp(id);
                if (b) {
                    response.sendRedirect("listUser.jsp");
                } else {
                    response.sendRedirect("error.html");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String action = request.getParameter("action");

            String name = request.getParameter("name");
            String password = request.getParameter("passw");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String city = request.getParameter("city");

            if (action != null && action.equals("addForm")) {
                boolean b = us.insertUser(name, password, email, contact, city);
                if (b) {
                    response.sendRedirect("index.html");
                } else {
                    response.sendRedirect("Error.jsp");
                }
            } else if (action != null && action.equals("updateForm")) {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean b = us.updateEmp(id, name, password, email, contact, city);
                if (b) {
                    response.sendRedirect("listUser.jsp");
                } else {
                    response.sendRedirect("Error.jsp");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
