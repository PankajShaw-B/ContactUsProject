package com.contactus.controller;

import java.io.IOException;


import java.util.List;

import com.contactus.dao.ContactDAO;
import com.contactus.model.ContactRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/contactus/requests")
public class RequestListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("admin") == null) {

            response.sendRedirect(request.getContextPath() + "/admin/login");

            return;
        }

        ContactDAO dao = new ContactDAO();

        List<ContactRequest> activeRequests = dao.getAllRequests("ACTIVE");

        List<ContactRequest> archivedRequests = dao.getAllRequests("ARCHIVED");

        request.setAttribute("activeRequests", activeRequests);

        request.setAttribute("archivedRequests", archivedRequests);
        
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    	response.setHeader("Pragma", "no-cache");
    	response.setDateHeader("Expires", 0);

        request.getRequestDispatcher("/requests.jsp").forward(request, response);
    }
}