/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vickie Romad
 */
public class ajoute_modele extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            PrintWriter out = response.getWriter(); 
            String code=request.getParameter("code");
            /*String type_code= request.getParameter("");
            String number_code=request.getParameter("");
            int num_code=Integer.parseInt(number_code);*/
            
            String nom_modele=request.getParameter("model_name");
            /*String type_modele=request.getParameter("");
            String number_modele=request.getParameter("");
            int num_modele=Integer.parseInt(number_modele)*/;
            
            String num=request.getParameter("num_dynamic");
            int count=Integer.parseInt(num);
            
            String [] field_name= new String[count];
            String [] type=new String[count];
            String number;
            int [] num_element =new int[count];
            for (int i=0;i<count;i++){
                String nom="field_name"+(i+1);
                field_name[i]=request.getParameter(nom);
                
                String nom_type="type"+(i+1);
                type[i]=request.getParameter(nom_type);
                
                String nom_num="number"+(i+1);
                number=request.getParameter(nom_num);
                num_element[i]=Integer.parseInt(number);
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Ajoute modele</title>");            
                out.println("</head>");
                out.println("<body>");
                out.print(field_name[i]);
                out.print(type[i]);
                out.print(num_element[i]);
            
            }
            
            
            String q="INSERT INTO modele "
                    + "(Code, Nom, Admin_id) "
                    + " VALUES (?,?,?)";
            
            String q1="CREATE TABLE IF NOT EXISTS "+nom_modele
                    + " ( Code_barre VARCHAR(10) PRIMARY KEY,"
                    + " Modele VARCHAR(150) Not Null,"
                    + " Date_acquisition Date Not Null,"
                    + " Situation VARCHAR(20) NOT NULL, "
                    + " Num_id VARCHAR(10) not NULL, " 
                    + " Matricule VARCHAR(10) not NULL, "
                    + " Unique(Modele), " 
                    + " FOREIGN KEY (Num_id) REFERENCES Bureau (Num_id)," 
                    + " FOREIGN KEY (Matricule) REFERENCES Founisseur (Matricule))";
                    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
            
            PreparedStatement pst=conn.prepareStatement(q);
            
            pst.setString(1,code);
            pst.setString(2,nom_modele);
            pst.setInt(3, 1);
            
            int res1=pst.executeUpdate();
            
            //Statement stmt = conn.createStatement();
            
            //int res2=stmt.executeUpdate(q1);
            PreparedStatement pst2=conn.prepareStatement(q1);
            int res2=pst2.executeUpdate(q1);
            System.out.println(nom_modele+" table created ...");
            
            String q2="";
            int res3=0;
            
            
            q2="Alter table "+nom_modele
                        + " add "+field_name[0]+" "+type[0]+"("+num_element[0]+")";
            
            if(count>1){
                for (int i=1;i<count;i++){
                    /*q2=" Alter table "+nom_modele
                      + " Add "+field_name[i]
                      + " "+type[i]
                      + "("+num_element[i]+")";*/
                    //String p="pst"+i;
                    /*q2="Alter table ?"
                            + " add ? ?(?)";*/

                  q2=q2+", add "+field_name[i]+" "+type[i]+"("+num_element[i]+")";
                           




                    /*pst1.setString(1,nom_modele);
                    pst1.setString(2, field_name[i]);
                    pst1.setString(3, type[i]);
                    pst1.setInt(4, num_element[i]);*/



                    //q2="Alter table "+nom_modele+" add "+field_name[i]+" "+type[i]+" ("+num_element[i]+")";


                //System.out.println(nom_modele+" table updated "+field_name[i]+" added ..."); 

                //pst1.close();
                }
            }
            PreparedStatement pst1=conn.prepareStatement(q2);
            res3=pst1.executeUpdate();
            
            RequestDispatcher rd1=request.getRequestDispatcher("liste_modele");
           
            
            
            
            
            
            
            
            
            if(res1>0 && res2>0 && res3>0){
                    request.setAttribute("feedback", "Model added successful!");
                
                    
                }
                else{
                    request.setAttribute("feedback", "Adding model failed!");
                }
                rd1.forward(request, response);
            
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

   
}
