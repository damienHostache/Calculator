<%--
  Created by IntelliJ IDEA.
  User: Damien
  Date: 15/03/2019
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <form action="#" method="POST">
        <input type="text" name="operand1" value="${ operation.operand1 }" />
        <select name="operator">
            <option value="+" ${ (operation.operator == "+")? "selected" : ''}>+</option>
            <option value="-" ${ (operation.operator == "-")? "selected" : ''}>-</option>
            <option value="*" ${ (operation.operator == "*")? "selected" : ''}>*</option>
            <option value="/" ${ (operation.operator == "/")? "selected" : ''}>/</option>
        </select>
        <input type="text" name="operand2" value="${ operation.operand2 }" />
        <input type="submit" name="compute" value="=" />
        <input type="text" value="${ !empty result? result : '' }" readonly />
    </form>
    <p>${ !empty message? message : '' }</p>
</body>
</html>
