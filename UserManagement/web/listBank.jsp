
<%@page import = "java.util.*" %>
<%@page import = "com.pojo.*" %>
<%@page import = "com.bean.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank User</title>
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
            <h1 align="center" style="color: #3e120c; background: #cd2cbd;">BANK USER LIST</h1>
            <%
                List<BankAccount> list = new BankDAO().showAllUser();
            %>
            <table border="3" cellspacing="10px" cellpadding="10px" style="border-collapse: collapse;" align="center">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Account No</th>
                        <th>Bank Name</th>
                        <th>IFSC</th>
                        <th>Salary</th>
                        <th>Salary Date</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (BankAccount e : list) {%>

                    <tr>
                        <td><%= e.getId()%></td>
                        <td><%= e.getAccount()%></td>
                        <td><%= e.getBankname()%></td>
                        <td><%= e.getIfsc()%></td>
                        <td><%= e.getSalary()%></td>
                        <td><%= e.getSalarydate()%></td>
                        <td><a href="AccountServlet?id=<%=e.getId()%>">Delete</a></td>
                        <td><a href="AccountServlet?action=edit&&id=<%=e.getId()%>">Edit</a></td>
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
