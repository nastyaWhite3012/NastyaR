<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="app.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Управление данными о человеке</title>
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
                    <%if (!jsp_parameters.get("current_action").equals("add")) { %>
        <tr>
            <td>Телефоны:</td>
            <td>
                <table size >
                    <%
                        HashMap<String,String> phones = person.getPhones();
                        Iterator it = phones.entrySet().iterator();
                        int lastkey=0;
                        while (it.hasNext()) {
                            Map.Entry<String,String> pair = (Map.Entry)it.next();
                            try {
                                lastkey = Integer.parseInt(pair.getKey()) + 1;
                            }catch(Exception ex){}
                    %>
                    <tr>
                        <td ><%=pair.getValue()%></td>
                        <td width="10%"></td>
                        <td ><a href="/?action=edit_phone&id=<%=person.getId()%>&phone_id=<%=pair.getKey()%>">Редактировать</a></td>
                        <td width="10%"></td>
                        <td ><a href="/?action=delete_phone&id=<%=person.getId()%>&phone_id=<%=pair.getKey()%>">Удалить</a></td>
                    </tr>
                    <%}%>
                    <tr>
                        <td>
                            <a href="/?action=add_phone&id=<%=person.getId()%>&phone_id=<%=lastkey%>">Добавить</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <% } %>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="<%=jsp_parameters.get("next_action")%>" value="<%=jsp_parameters.get("next_action_label")%>" />
                <a href="/"><br/>Вернуться к списку</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>