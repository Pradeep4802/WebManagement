
<%@page import = "java.util.*" %>
<%@page import = "com.pojo.*" %>
<%@page import = "com.bean.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
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
        <div>
            <h1 align="center" style="color: #3e120c; background: #cd2cbd;">Employee List</h1>
            <%
                List<Employee> list = new UserDAO().showAllUser();
            %>
            <table border="3" cellspacing="10px" cellpadding="10px" style="border-collapse: collapse;" align="center">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>City</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Employee e : list) {%>

                    <tr>
                        <td><%= e.getId()%></td>
                        <td><%= e.getName()%></td>
                        <td><%= e.getPassword()%></td>
                        <td><%= e.getEmail()%></td>
                        <td><%= e.getContact()%></td>
                        <td><%= e.getCity()%></td>
                        <td><a href="UserServlet?id=<%=e.getId()%>">Delete</a></td>
                        <td><a href="UserServlet?action=edit&&id=<%=e.getId()%>">Edit</a></td>
                    </tr>

                    <%}%>
                </tbody>
            </table>
            <div align="center" style="margin-top: 2rem;">
                <a href="index.html" style="text-decoration: none; font-size: 2rem;">Home Page</a>
            </div>

        </div>
    </body>
</html>
