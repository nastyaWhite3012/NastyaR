<%@ page import="java.util.HashMap" %>
<%@ page import="app.Person" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 27-11-2016
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    HashMap<String, String> jsp_parameters = new HashMap<String, String>();
    Person person = new Person();
    String error_message = "";

    if (request.getAttribute("jsp_parameters") != null) {
        jsp_parameters = (HashMap<String, String>) request.getAttribute("jsp_parameters");
    }

    if (request.getAttribute("person") != null) {
        person = (Person) request.getAttribute("person");
    }

    error_message = jsp_parameters.get("error_message");
%>

<form action="<%=request.getContextPath()%>/" method="post">
    <input type="hidden" name="id" value="<%=person.getId()%>"/>
    <table align="center" border="1" width="70%">
        <%
            if ((error_message != null) && (!error_message.equals(""))) {
        %>
        <tr>
            <td colspan="2" align="center"><span style="color:red"><%=error_message%></span></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="2" align="center">Информация о человеке</td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><input type="text" name="surname" value="<%=person.getSurname()%>"/></td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="name" value="<%=person.getName()%>"/></td>
        </tr>
        <tr>
            <td>Отчество:</td>
            <td><input type="text" name="middlename" value="<%=person.getMiddlename()%>"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="<%=jsp_parameters.get("next_action")%>"
                       value="<%=jsp_parameters.get("next_action_label")%>"/>
                <br><a href="http://localhost:8080/">Вернуться к списку</a>
            </td>
        </tr>
    </table>
</form>
 </body>
</html>
