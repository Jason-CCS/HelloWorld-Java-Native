package com.jason.app;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jc6t on 2015/3/11.
 */
public class HelloForm extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * create cookies
         */
        Cookie firstName = new Cookie("first_name",request.getParameter("first_name"));
        Cookie lastName= new Cookie("last_name",request.getParameter("last_name"));
        // Set response content type

        firstName.setMaxAge(60);
        lastName.setMaxAge(60);

        // add cookies to response
        response.addCookie(firstName);
        response.addCookie(lastName);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using cookies";
        String docType = "<!doctype html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
