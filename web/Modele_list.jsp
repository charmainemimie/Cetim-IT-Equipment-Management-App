<%-- 
    Document   : Modele_list
    Created on : 27-Jul-2022, 15:41:32
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
        <title>Techniciens</title>
    </head>
    <body class="d-flex flex column min-vh-100">
        <div class="container-fluid min-vh-100" >
        <div class="vertical-nav" id="sidebar" style="overflow-y: scroll">
  <div class="py-4 px-3">
    <div class="media d-flex align-items-center"><img src="LOGO_GICA/Horizontal_sigle_logotype_safia_horizontal.jpg" alt="logo" width="200px" height="100px" class="mr-3 img-thumbnail shadow-sm">

    </div>
  </div>

  <!--p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">Main</p-->

  <ul class="nav flex-column bg-white mb-0"style="text-align: left; align-items: flex-start">
      <li class="nav-item" >
      <a href="#" class="nav-link text-light  ">
                <i class="fa-solid fa-house mr-2"></i>
                Home
            </a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link text-light ">
                <i class="fa-solid fa-computer mr-2"></i>
                Materials
            </a>
    </li>
  </ul>
  
  <!--p class="text-gray font-weight-bold text-uppercase px-3 small py-4 mb-0">Admin</p-->
  
  <ul class="nav flex-column bg-white mb-0">
    <li class="nav-item">
      <a href=offices.jsp class="nav-link text-light ">
                <i class="fa-solid fa-building mr-2"></i>
               Bureaux
            </a>
    </li>
    <li class="nav-item">
      <a href="afficheDirections.jsp" class="nav-link text-light ">
                <i class="fa-solid fa-folder-tree mr-2"></i>
                Departements
            </a>
    </li>
    
    <li class="nav-item">
      <a href="affiche_techniciens.jsp" class="nav-link text-light ">
                <i class="fa-solid fa-user-group mr-2"></i>
                Techniciens
            </a>
    </li>
    
    <li class="nav-item">
      <a href="#" class="nav-link text-light ">
                <i class="fa-solid fa-database mr-2"></i>
                Modeles de Materiaux
            </a>
    </li>
  </ul>

  <p class="text-gray font-weight-bold text-uppercase px-3 small py-4 mb-0">Charts</p>

  <ul class="nav flex-column bg-white mb-0">
    <li class="nav-item">
      <a href="#" class="nav-link text-light ">
                <i class="fa fa-area-chart mr-3 text-primary fa-fw"></i>
                Area charts
            </a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link text-light ">
                <i class="fa fa-bar-chart mr-3 text-primary fa-fw"></i>
                Bar charts
            </a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link text-light ">
                <i class="fa fa-pie-chart mr-3 text-primary fa-fw"></i>
                Pie charts
            </a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link text-light">
                <i class="fa fa-line-chart mr-3 text-primary fa-fw"></i>
                Line charts
            </a>
    </li>
  </ul>
</div>
        <div class="row">
                <nav class="navbar navbar-expand-lg  navbar-light bg-light  fixed-top" id="horizontalnav">
                    <!--Brand logo-->
                    
                    <!-- Toggler/collapsibe Button -->
                    <button class="navbar-toggler " style="color: black;" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <!--links-->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <div class=" mx-auto">
                    <form class="d-flex"> 
                        <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search"> 
                        <button class="btn btn-outline-success" type="submit"><i class="fa fa-search"></i></button>
                    </form>
                            
                            <!--form class="d-flex">
                                
                                <input type="search" class="form-control me-2" placeholder="Rechercher" aria-label="Search" style="padding-right: 100px">
                                <button class="btn btn-secondary" type="submit">Recherche</button>
                            </form-->
                        
                        </div>
                        
                         
                            
                    </div>
                    
                </nav><br><br>
            </div>            
<!-- End vertical navbar -->


<!-- Page content holder -->
<div class="page-content p-5" id="content">
        

            <div class=" mx-2 mt-5  p-3" id="aboutpara">
                
                <center><h4>Les Modeles</h4></center>
                <div class="addtch"><a class='btn' href="ajouteMaintenance.jsp">Ajoute <i class="fas fa-user-plus"></i></a></div>
                 <div class=" container mt-3  px-5 tech-table">
                     
                     <%   //dbconnection
          try {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                 java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
                  Statement statement = conn.createStatement() ;
                  ResultSet result;
       result=statement.executeQuery("select * from modele") ; 
               
         if(result.isBeforeFirst())
                { %>
                   
                    <table class="table table-bordered  caption-top table-hover" id="A">
                        <!--caption>Liste des Informaticiens</caption-->
                        <thead>
                            <tr>
                                
                                <th scope="col">Code</th>
                                <th scope="col">Modele de materiel</th>
                                <th scope="col">Modifier</th>
                                <!--th scope="col">Supprimer</th-->
                            </tr>
                        </thead>
                        <tbody>
                    
                <% while(result.next())
                {
                    //session.setAttribute("userid",result.getInt("ID"));
                     
                    %>
                    <tr>
                        <td><%= result.getString(2) %></td>
                        <td><%= result.getString(3) %></td>
                        <td>
                            <a class="pen"  href="modifier_modele.jsp?code=<%= result.getString(2) %>&nom_modele=<%= result.getString(3)%>">
                                <i class="fas fa-pen"></i></a></td>
                        <!--td><a  class="trash" href="deleteTech?id=</%= result.getInt("ID") %>" onclick="return confirm('Etes vous sur de supprimmer?')"> <i class="fa fa-trash"></i></a></td-->
                        
                    <% }
                %>
                </tbody>
                    </table>
                    
                
               <%         
                result.close();
                
                }
                

       
    }catch(Exception e){

        e.printStackTrace();}

    %>
    
     </div>
                
            </div>
</div>
        </div>
    </body>
</html>
