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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vickie Romad
 */
public class modifier extends HttpServlet {

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
            
            String code=request.getParameter("code0");
            String modele=request.getParameter("nom_modele0");
            String newcode=request.getParameter("code1");
            String newmodele=request.getParameter("nom_modele1");
            
            String q1="UPDATE modele" +
                          " SET code=?" +
                          " WHERE code=? and nom=?";
                String q2="UPDATE modele" +
                          " SET nom=?" +
                          " WHERE code=? and nom=?";
                
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
            int res=0,res1=0;
            PrintWriter out = response.getWriter(); 
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modifier Modele</title>");            
            out.println("</head>");
            out.println("<body>");
       
            RequestDispatcher rd1=request.getRequestDispatcher("liste_modele");
            
            //if(!(code.equals(newcode))||!(modele.equals(newmodele))){
                
                
                //if(!(code.equals(newcode))){


                    PreparedStatement pst1=conn.prepareStatement(q1);
                    pst1.setString(1, newcode);
                    pst1.setString(2, code);
                    pst1.setString(3, modele);
                    res=pst1.executeUpdate();

                /*}
                if(!(modele.equals(newmodele))){*/
                    PreparedStatement pst2=conn.prepareStatement(q2);
                    pst2.setString(1, newmodele);
                    pst2.setString(2, code);
                    pst2.setString(3, modele);
                    res1=pst2.executeUpdate();


               // }
                if(res>0 || res1>0){
                    request.setAttribute("feedback", "Update successful!");
                
                    
                }
                else{
                    request.setAttribute("feedback", "Update failed!");
                }
                rd1.forward(request, response);
            //}
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            
        }
    }

    

}
