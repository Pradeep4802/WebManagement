
<%@page import="com.pojo.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Form</title>
    </head>
    <style>
        body {
            background: linear-gradient(to left, #cac728,#6ddbd1,#cd2cbd);
        }
        table {
            color: #edfcf0;
            font-size: 2rem;

        }
        thead {
            background: linear-gradient(to right, #cd2cbd,#cac728,#6ddbd1);
        }
        tbody {
            background: linear-gradient(to right, #cac728,#6ddbd1,#cd2cbd);
        }
    </style>
    <body>

        <%
            Employee e = (Employee) session.getAttribute("e");
        %>

        <div align="center">
            <h1 style="color: red; border-radius: 10px;background: aqua;" align="center">User Update Form</h1>
            <form action="UserServlet" method="post">
                <input type="hidden" name="action" value="updateForm">
                <table border="3" cellspacing="10px" cellpadding="10px" style="border-collapse: collapse;">
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="id" value="<%=e.getId()%>"></td>
                    </tr>
                    
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="<%=e.getName()%>"></td>
                    </tr>

                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="passw" value="<%=e.getPassword()%>"></td>
                    </tr>

                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" value="<%=e.getEmail()%>"></td>
                    </tr>

                    <tr>
                        <td>Contact</td>
                        <td><input type="text" name="contact" value="<%=e.getContact()%>"></td>
                    </tr>

                    <tr>
                        <td>City</td>
                        <td><input type="text" name="city" value="<%=e.getCity()%>"></td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Save"></td>
                        <td><input type="reset" value="Reset"></td>
                    </tr>
                </table>
            </form>

            <div align="center" style="margin-top: 2rem;">
                <a href="index.html" style="text-decoration: none; font-size: 2rem;">Home Page</a>
            </div>
        </div>
    </body>
</html>
