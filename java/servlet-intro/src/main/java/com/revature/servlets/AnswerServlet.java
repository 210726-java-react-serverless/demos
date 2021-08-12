package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/answer"}, loadOnStartup = 2) // This annotation registers the servlet with the context (no need to include it in the web.xml)
public class AnswerServlet extends HttpServlet {

    public AnswerServlet() {
        System.out.println("AnswerServlet instantiated!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get the answer that was added as an attribute to the request by the proceeding servlet
        String answer = (String) req.getAttribute("answer");

        // If there is no answer contained within the request, redirect the user back to the calculator form
        if (answer == null) {
            resp.sendRedirect("http://localhost:8080/servlet-intro");
            return;
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
