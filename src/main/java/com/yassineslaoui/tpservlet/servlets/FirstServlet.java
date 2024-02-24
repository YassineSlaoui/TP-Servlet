package com.yassineslaoui.tpservlet.servlets;

import com.yassineslaoui.tpservlet.dao.LoginDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * First Servlet Class*/
public class FirstServlet extends HttpServlet {
    /**
     * Implementation of the doPost method overriding the HttpServlet.doPost
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Setting content type of the response to HTML.
        response.setContentType("text/html");

        // Getting response writer object to write the response body.
        PrintWriter out = response.getWriter();

        // Getting username and password values from parameters sent in the POST request
        String n = request.getParameter("username");
        String p = request.getParameter("userpass");

        // Checking if the user exitst in the database using the LoginDao.validate static method.
        if (LoginDao.validate(n, p)) {
            // If the username/password combo exists in the database,
            // redirect the request to Servlet2, that is the WelcomeServlet
            RequestDispatcher rd = request.getRequestDispatcher("servlet2");
            rd.forward(request, response);
        } else {
            // Else, attach an error message in the response,
            // and include the "index.html" home/login page to it.
            out.print("Sorry username or password error");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }

        //Finally close the PrintWrite Resource.
        out.close();
    }

}
