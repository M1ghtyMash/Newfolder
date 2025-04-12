package servlets;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DBTestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/studentmanagement";
        String username = "root";
        String password = "";  // Change if you set a password in XAMPP

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            out.println("<h2>✅ Database connected successfully!</h2>");
            conn.close();
        } catch (Exception e) {
            out.println("<h2>❌ Connection failed: " + e.getMessage() + "</h2>");
        }
    }
}
