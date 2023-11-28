<%-- 
    Document   : modifier_materiel
    Created on : 26-Jul-2022, 18:19:01
    Author     : Vickie Romad
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web\css\all.css">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <!--link rel="stylesheet" href="C:/wamp64/www/PHP/fontawesome-free-6.1.1-web/fontawesome-free-6.1.1-web/css/all.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script-->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/65cd332cc9.js" crossorigin="anonymous"></script>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" type="text/css" href="custom.css">
        
        <title>Modifier Materiel</title>
    </head>
    <body>
        
        <%
            String code_barre=request.getParameter("code_barre");
            String nom_table=request.getParameter("nom_table");
            //out.print(code_barre);
            //out.print(nom_table);
           try{ 
                String q1="select * from "+nom_table+" where Code_barre='"+code_barre+"'";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
                Statement statement = conn.createStatement() ;
                ResultSet result;
                result=statement.executeQuery(q1) ; 
                ResultSetMetaData rsmd=result.getMetaData();
                int count=rsmd.getColumnCount();
                //out.print(count);

                while(result.next())
                    {%>
                    
                
                    <form action="modifier_materiel" method="Get">
                            <h1>Modifier Materiel</h1>
                            <input type="hidden" name="count" value="<%= count %>">
                            Code Barre:
                            <input type="text" name="code_barre" value="<%= result.getString(1) %>" readonly><br><br>
                            Model:
                            <input type="text" name="model" value="<%= result.getString(2) %>" readonly><br><br>
                            Date acquired:
                            <input type="date" name="date_acquisiton" value="<%= result.getString(3) %>"readonly><br><br>

                            <% for(int j=4;j<=count;j++)
                            {
                                String col=rsmd.getColumnName(j);%>
                                <input type="hidden" name="column_name<%=j%>" value="<%= col %>">
                                <%= col %>:
                                <input type="text" name="column<%=j%>" value="<%= result.getString(j) %>"><br><br>
                    <%      }
                    }%>

                    <input type="hidden" name="table_name" value="<%= nom_table%>">
                    <input type="submit" value="Modifier">
                </form>
                    <%}
                        catch(Exception e){
                        
                            e.printStackTrace();
                        }%>
    </body>
</html>
