package com.contactus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.contactus.model.ContactRequest;

public class ContactDAO {

    public boolean saveRequest(ContactRequest request) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO contact_requests(full_name,email,message,status) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, request.getFullName());
            ps.setString(2, request.getEmail());
            ps.setString(3, request.getMessage());
            ps.setString(4, "ACTIVE");

            int row = ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<ContactRequest> getAllRequests(String requestStatus) {

        List<ContactRequest> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM contact_requests WHERE status=? ORDER BY id DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, requestStatus);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                ContactRequest request = new ContactRequest();

                request.setId(rs.getInt("id"));
                request.setFullName(rs.getString("full_name"));
                request.setEmail(rs.getString("email"));
                request.setMessage(rs.getString("message"));
                request.setStatus(rs.getString("status"));

                list.add(request);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void archiveRequest(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE contact_requests SET status='ARCHIVED' WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}