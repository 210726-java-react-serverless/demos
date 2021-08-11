package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/answer") // This annotation registers the servlet with the context (no need to include it in the web.xml)
public class AnswerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get the answer that was added as an attribute to the request by the preceeding servlet
        String answer = (String) req.getAttribute("answer");

        // If there is no answer contained within the request, redirect the user back to the calculator form
        if (answer == null) {
            resp.sendRedirect("http://localhost:8080/servlet-intro");
        }

        // Write the answer to the response along with link back to the calculator form
        resp.getWriter().write("<p>The answer is: " + answer + "</p>");
        resp.getWriter().write("<br/><a href=\"index.html\">Calculate something else</a>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // If a POST request was set to this endpoint, treat it just like a GET request.
        doGet(req, resp);
    }
}
