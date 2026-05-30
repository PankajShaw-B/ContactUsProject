package com.contactus.controller;

import java.io.IOException;

import com.contactus.dao.ContactDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/archive")
public class ArchiveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ContactDAO dao = new ContactDAO();

        dao.archiveRequest(id);

        response.sendRedirect(request.getContextPath() + "/admin/contactus/requests");
    }
}