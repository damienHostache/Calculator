package com.damien.hostache.beans;

import javax.servlet.http.HttpServletRequest;

public class Operation {

    private String operand1;
    private String operand2;
    private String operator;

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean checkFormEntries(HttpServletRequest request) {
        int operand1;
        int operand2;
        String operator;

        try {
            operand1 = Integer.parseInt((String) request.getParameter("operand1"));
            operand2 = Integer.parseInt((String) request.getParameter("operand2"));
            operator = (String) request.getParameter("operator");
        } catch (NumberFormatException ex)
        {
            return false;
        }

        if (operator.equals("/") && operand2 == 0) {
            return false;
        }

        return true;
    }

    public String computeRequest(HttpServletRequest request) {
        int result;
        int operand1 = Integer.parseInt((String) request.getParameter("operand1"));
        int operand2 = Integer.parseInt((String) request.getParameter("operand2"));
        String operator = (String) request.getParameter("operator");

        switch (operator) {
            case "+" : result = operand1 + operand2;
                break;
            case "-" : result = operand1 - operand2;
                break;
            case "*" : result = operand1 * operand2;
                break;
            case "/" : result = operand1 / operand2;
                break;
            default : return "0";
        }

        return String.valueOf(result);
    }
}
