package com.damien.hostache.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.damien.hostache.beans.Operation;

public class Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result;
        String message;
        Operation operation = new Operation();

        if (operation.checkFormEntries(request)) {
            result = operation.computeRequest(request);
            message = "";
        } else {
            result = "";
            message = "Invalid arguments supplied, please check your form entries.";
        }

        operation.setOperand1((String) request.getParameter("operand1"));
        operation.setOperand2((String) request.getParameter("operand2"));
        operation.setOperator((String) request.getParameter("operator"));

        request.setAttribute("result", result);
        request.setAttribute("message", message);
        request.setAttribute("operation", operation);
        this.getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Operation operation = new Operation();
        operation.setOperand1("");
        operation.setOperand2("");
        operation.setOperator("+");
        request.setAttribute("operation", operation);
        this.getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }
}
