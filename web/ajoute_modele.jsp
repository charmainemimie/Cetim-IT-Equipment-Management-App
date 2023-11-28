<%-- 
    Document   : ajoute_modele
    Created on : 18-Jul-2022, 22:54:26
    Author     : Vickie Romad
--%>

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
        <title>Ajouter un Modele</title>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            var count=0;
            $(document).ready(function(){
              $("button").click(function(){
                  count=count+1;
                $("<div class='row id='row'> New Field:<input type='text' name='field_name"+count+"' placeholder='Nom Field (no spaces)' onKeyUp='chText()' onKeyDown='chText()' id='aliasEntry' required> Type:<select name='type"+count+"' required> <option value='varchar'>String</option><option value='int'>Integer</option> <option value='date'>Date</option>	 <option value='float'>Float</option> </select>  Number:<input type='number' name='number"+count+"' required> </div><br><br>").clone().appendTo("body").insertBefore(".add-row");
            
             document.getElementById("count").value=count; 
          });
        });
        
        function chText()
            {
                var str=document.getElementById("aliasEntry");
                var str1=document.getElementById("aliasEntry1");
                var regex=/[^a-zA-Z0-9]/gi;
                str.value=str.value.replace(regex ,"");
                str.value=str.value.replace(regex ,"");
            }
            function chText1()
            {
                var str2=document.getElementById("alias");
                
                var regex1=/[A-Z][^0-9]/gi;
                str2.value=str2.value.replace(regex1 ,"");
                
            }
        </script>

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
                <center><h1>Ajouter un Modele de Materiel</h1></center>
       
       
        <center>
       <form class="form-horizontal pt-3 px-5" method="GET" action="ajoute_modele">
            
           <!--div class="model-details" style="align-content: center">		
                <div class="row1" >
                    			
                    
                        Code:
                        <input type="text" name="code" placeholder="ex. F1" onKeyUp="chText1()" onKeyDown="chText1()" id="alias" maxlength="5" minlength="2"  required>
                    
                    
                        <br><br>
                       
                    
                </div-->
           <div class="p-5 mx-auto bck"  >  
        <div class="row mb-3 col-md-6 ">
            <label for="code" class="col-sm-3 col-form-label"><strong>Code:<i class="glyphicon glyphicon-user"></i></strong></label>
          <div class="col-sm-9">
              <input type="text" name="code" placeholder="ex. F1" onKeyUp="chText1()" onKeyDown="chText1()" id="alias" maxlength="5" minlength="2"  required>
          </div>
        </div>
                
                <!--div class="row2">			
                    
                        Nom Modele:
                        <input type="text" name="model_name" placeholder="Nom Modele" onKeyUp="chText()" onKeyDown="chText()" id="aliasEntry1"  required>
                    
                        <br><br>
                    
                    
                </div-->
                <div class="row mb-3 col-md-6 ">
                    <label for="model_name" class="col-sm-3 col-form-label"><strong>Nom Modele:<i class="glyphicon glyphicon-user"></i></strong></label>
                  <div class="col-sm-9">
                      <input type="text" name="model_name" placeholder="Nom Modele" onKeyUp="chText()" onKeyDown="chText()" id="aliasEntry1"  required>
                  </div>
                </div>
                
           
           <input type="hidden" name="num_dynamic" id="count" value="0">
           <button type="button" name="add_field" class="add-row" >+ add field</button>
        <div class="submit-div">
            <input type="submit" value="Ajouter Modele" class="submit-btn" />
            
	
        </div> </div>
        </form>
        </center> 
            </div>
</div>
        </div>
    </body>     
</html>
