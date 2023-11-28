<%-- 
    Document   : modifiier
    Created on : 21-Jul-2022, 18:48:32
    Author     : Vickie Romad
--%>

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
        
        <title>Modifier Modele</title>
    </head>
    <center>
        <body>
            <h1>Modifier Modele</h1>

            <%
                String code=request.getParameter("code");
                String modele=request.getParameter("nom_modele");
                %>
            <form action='modifier'>
                Code: <input type='text' name='code1' value='<%= code %>' required><br><br>
                Nom Modele: <input type='text' name='nom_modele1' value='<%= modele %>' required><br><br>

                <input type="hidden" name="code0" value="<%= code%>">
                <input type="hidden" name="nom_modele0" value="<%= modele %>">

                <input type='submit'  value='Modifier'>
            </form><br><br>

            <a href='liste_modele'>Retour a la page des modeles</a>


        </body>
    </center>
</html>
