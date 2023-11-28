<%-- 
    Document   : ajoute_modele
    Created on : 18-Jul-2022, 22:54:26
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
    <body>
        <h1>Ajouter un Modele de Materiel</h1>
       
       
        
       <form  method="GET" action="ajoute_modele">
            
           <div class="model-details" style="align-content: center">		
                <div class="row1" >
                    			
                    
                        Code:
                        <input type="text" name="code" placeholder="ex. F1" onKeyUp="chText1()" onKeyDown="chText1()" id="alias" maxlength="5" minlength="2"  required>
                    
                    
                        <!--Type:
                        <select name="type1" required>
                            <option value="varchar" selected>String</option>
                                <option value="int">Integer</option>
                                <option value="date">Date</option>
                                <option value="float">Float</option>
                        </select>
                    
                        Number:
                        <input type="number" name="number1" required>--><br><br>
                       
                    
                </div>
                
                <div class="row2">			
                    
                        Nom Modele:
                        <input type="text" name="model_name" placeholder="Nom Modele" onKeyUp="chText()" onKeyDown="chText()" id="aliasEntry1"  required>
                    
                        <!--Type:
                        <select name="type2" required>
                            <option value="varchar" selected>String</option>
                                <option value="int">Integer</option>
                                <option value="date">Date</option>
                                <option value="float">Float</option>
                        </select>
                    
                            Number:
                            <input type="number" name="number2" required>--><br><br>
                    
                    
                </div>
            </div>
           <input type="hidden" name="num_dynamic" id="count" value="0">
           <button type="button" name="add_field" class="add-row" >+ add field</button>
        <div class="submit-div">
            <input type="submit" value="Ajouter Modele" class="submit-btn" />
            
	
        </div>
        </form>
        
        
</html>
