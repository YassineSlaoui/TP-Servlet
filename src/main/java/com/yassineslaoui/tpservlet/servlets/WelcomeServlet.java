package com.yassineslaoui.tpservlet.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class WelcomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Setting content type of the response to HTML.
        response.setContentType("text/html");

        // Getting response writer object to write the response body.
        PrintWriter out = response.getWriter();

        // Getting username value from the original POST request parameter that was forwarded in the First Servlet.
        String n = request.getParameter("username");

        // Printing response body.
        out.print("Welcome " + n);

        // Closing the PrintWriter Resource.
        out.close();
    }

}
