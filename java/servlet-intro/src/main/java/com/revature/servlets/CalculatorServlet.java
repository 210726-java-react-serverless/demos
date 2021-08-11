package com.revature.servlets;

import com.revature.exceptions.UnrecognizedOperatorException;
import com.revature.services.CalculationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    This servlet is programmatically registered with the servlet context
    via the CustomServletContextListener class.
 */
public class CalculatorServlet extends HttpServlet {

    private final CalculationService calculationService;

    public CalculatorServlet(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("CalculatorServlet.doPost() invoked!");
        System.out.println(req.getRequestURI()); // /servlet-intro/calculator
        System.out.println(req.getRequestURL()); // http://localhost:8080/servlet-intro/calculator
        System.out.println(req.getMethod()); // POST

        // Grab needed data from the request
        String op1 = req.getParameter("operand1");
        String op2 = req.getParameter("operand2");
        String op = req.getParameter("operator");

        // Declare an empty string that will eventually hold the answer to the requested operation
        String answer = "";

        try {

            // Parse the provided values into doubles for calculation
            double operand1 = Double.parseDouble(op1);
            double operand2 = Double.parseDouble(op2);

            // Determine the desired operation and calculate the answer
            switch (op) {
                case "add":
                    answer = "" + calculationService.add(operand1, operand2);
                    break;
                case "subtract":
                    answer = "" + calculationService.subtract(operand1, operand2);
                    break;
                case "multiply":
                    answer = "" + calculationService.multiply(operand1, operand2);
                    break;
                case "divide":
                    answer = "" + calculationService.divide(operand1, operand2);
                    break;
                default:
                    // client specified an improper operator; we return a 400 (Bad Request)
                    throw new UnrecognizedOperatorException();
            }

        } catch (NumberFormatException | UnrecognizedOperatorException e) {

            /*
                If this occurs, it means that the user provided us bad data. Send back an appropriate
                status code and return.
             */
            resp.setStatus(400);
            return;
        }

        // Add the calculated answer as an attribute to the request
        req.setAttribute("answer", answer);

        /*
            Use a RequestDispatcher to forward the current request and response to the AnswerServlet
            for further processing.
         */
        RequestDispatcher dispatcher = req.getRequestDispatcher("answer");
        dispatcher.forward(req, resp); // forwarding maintains the original request and response objects! (redirects do not)

    }
}
