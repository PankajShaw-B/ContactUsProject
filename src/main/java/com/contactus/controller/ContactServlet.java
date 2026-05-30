package com.contactus.controller;

import java.io.IOException;

import com.contactus.dao.ContactDAO;
import com.contactus.model.ContactRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("contactus.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ContactRequest contact = new ContactRequest();

        contact.setFullName(fullName);
        contact.setEmail(email);
        contact.setMessage(message);

        ContactDAO dao = new ContactDAO();

        boolean status = dao.saveRequest(contact);

        if(status) {
            response.sendRedirect("success.jsp");
        } else {
            response.getWriter().println("Something went wrong");
        }
    }
}