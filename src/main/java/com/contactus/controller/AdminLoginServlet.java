package com.contactus.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("pankajshaw7986@gmail.com") && password.equals("Pankaj@123")) {

            HttpSession session = request.getSession();

            session.setAttribute("admin", username);

            response.sendRedirect(request.getContextPath() + "/admin/contactus/requests");

        } else {

            response.getWriter().println("Invalid Credentials");
        }
    }
}