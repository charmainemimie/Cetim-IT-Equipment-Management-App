<%-- 
    Document   : ajouteMaintenance
    Created on : 18-Jul-2022, 16:40:38
    Author     : HP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web\css\all.css">
        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
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
        <title>Modifier Informaticien</title>
    </head>
    
        <body class="d-flex flex column min-vh-100">

        <div class="container-fluid min-vh-100" >
            <div class="row">
                <nav class="navbar navbar-expand-lg  navbar-light bg-light eg" alt="images/logo 50x50.png" style="width: 100px;"></a>

                    <!-- Toggler/collapsibe Button -->
                    <button class="navbar-toggler " style="color: black;" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expa fixed-top">
                    <!--Brand logo-->
                    <a class="navbar-brand" href="#"> <img src="kosi wlogo.jpnded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <!--links-->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <div class="card mx-auto">

                            <ul class="nav navbar-nav mr-auto">
                                <a class="nav-link active" href ="Articles.php" style="color: white;" >Accueil</a>
                              
                                <a class="nav-link active" href ="/index.php" style="color: white;" >Page de clients</a>
                                <a class="nav-link active" href="About.html" style="color: white;" target="_blank">About</a>
                            </ul>
                        
                        </div>
                    </div>
                    
                </nav><br><br>
            </div>            

        
            <div class=" mx-2 mt-5  p-3" id="aboutpara">
                

 <div><a class="mx-3" href="afficheTrchnicians.jsp" style="color: black;"><i class='fas fa-arrow-alt-circle-left' style="font-size: 20px;">Retour</i></a></div>
                <center><h3>  Modifier informaticien </h3></center>
    <center><!--form class="form-horizontal mx-auto " action="addFemme" method="POST" enctype="multipart/form-data" >
        <input type="hidden" name="id" value="<?php echo $i[0]['id']; ?>">
    
        <div class="col-md-6 row mb-3 form-group">
            <!--div classcol-2 col-form-label>
                <label class="" for="Username"><strong>Libelle:</strong>
                </label>
            </div-->
                
                <!--div class="input-group col-10">
                  <label class="p-2" for="Username"><strong>Libelle:  </strong>
                </label>  <span class="input-group-text" id="basic-addon1"><i class="glyphicon glyphicon-user"></i></span>
                   <input type="text" class="form-control" name="Username" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
        </div>
            <div class="form-group w-100 ">
              <label class=" control-label" for="prix"><strong>Prix:</strong></label>
                <div class="col-sm-10 inputGroupContainer">
                    <div class="col-md-4 input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input class="form-control w-50 p-3" required type="text"name="prix" id="prix" >
               
                    </div>
            </div>
              
              
            </div>
            

                    <input class="submit" type="submit" name="submit" value="Submit" style="border:none; background-color:#00cc00">
                
        </form-->
     <%   //dbconnection
         
         
          try {
              
              String id= request.getParameter("id");
                   Class.forName("com.mysql.cj.jdbc.Driver");
                 java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
                  Statement statement = conn.createStatement() ;
                  ResultSet result;
       result=statement.executeQuery("select * from technicien where ID="+id) ; 
          
 
         while(result.next())
                {

    %>
                
    <form class="form-horizontal pt-3 px-5" action="modifier_Technicien" method="POST" >
        <input type="hidden" name="id" value="<%= id %>">
        <div class="p-5 mx-auto bck"  >  
        <div class="row mb-3 col-md-6 ">
            <label for="surname" class="col-sm-3 col-form-label"><strong>Nom:<i class="glyphicon glyphicon-user"></i></strong></label>
          <div class="col-sm-9">
              <input type="text" class="form-control" name="surname" required id="name" value="<%= result.getString("Nom")%>">
          </div>
        </div>
        
        <div class="row mb-3 col-md-6">
            <label for="name" class="col-sm-3 col-form-label"><strong>Prenom:</strong></label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="name" required id="name" value="<%= result.getString("Prenom")%>">
          </div>
        </div>
        
        <div class="row mb-3 col-md-6">
            <label for="username" class="col-sm-3 col-form-label"><strong>Utilisateur:</strong></label>
          <div class="col-sm-9">
              <input type="text" class="form-control" name="username" id="username" required value="<%= result.getString("Username")%>">
          </div>
        </div>
        
        <div class="row mb-3 col-md-6">
            <label for="inputPassword3" class="col-sm-3 col-form-label"><strong>Mot de passe:</strong></label>
          <div class="col-sm-9">
              <input type="password" class="form-control" name="password" id="inputPassword3" required value="<%= result.getString("Password")%>">
          </div>
        </div>
  
          <button type="submit" class="btn btn-primary" id="registre" style="background-color: #009900">Registre</button>
        <button type="reset" class="btn btn-primary" id="cancel" style="background-color: #005ce6;margin-left:5px ">Cancel</button>
  
        </div>
</form>
    </center>

         <% } 
             }
          catch(Exception e){

        e.printStackTrace();}
%>
            <div class="success">
                <%
                   if(request.getAttribute("x")!=null)
                out.print(request.getAttribute("x"));
                    %>
                    
                    
            </div>

  </div>
  </div>

    </body>
</html>
