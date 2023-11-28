<%-- 
    Document   : index
    Created on : Jul 19, 2022, 11:17:29 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web\css\all.css">
        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
        <meta name="viewport" content="width=device-width, initial-scale=1 ; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>CETIM_Login</title>
    </head>
    
    <body >
        <nav class="navbar" style="background-color:#223a66 ">
        <img src="LOGO_GICA/Horizontal_sigle_logotype_safia_horizontal.jpg" style="float: left; width: 150px; height: 100px"/>
        </nav>
        <marquee><h3 style="color:#223a66">BIENVENUE SUR LA PLATEFORME DE GESTION ET DE SUIVI DU PARC INFORMATIQUE!</h2></marquee><br><br>
    
    <div class="container sm border" style="width: 60%" >
        <div>
       
         

   
        
      <form action="home" method="POST">
          <center> 
              
               <h4 style="color:#223a66">Veuillez entrer vos données de connexion</h4><br>
<div class="mb-3"  >
    <label for="username" class="form-label"><b>Nom d'utilisateur :</b> </label>
  <input type="text" class="form-control" id="username" name="username" placeholder="nom d'utilisateur" style="width:50%">
</div>
         
     <br>
      
     <div class="mb-3" >
         <label for="password" class="form-label"><b>Mot de passe : </b></label>
    <input type="password" id="password" name="password" class="form-control" style="width:50%; ">
 </div>
    
     <br>
     
      <button type="submit" class="btn btn-primary" style="background-color:#223a66">Se Connecter</button>
             </center>   
</form>
     
    <br> 
    
    </div>
        <% if(request.getAttribute("x")!=null)
        out.print(request.getAttribute("x"));
            
        %>
</div>
     
        
       
    </body>
</html>
