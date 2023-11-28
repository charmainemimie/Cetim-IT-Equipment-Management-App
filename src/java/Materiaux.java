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
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vickie Romad
 */
public class Materiaux extends HttpServlet {

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
            
            String q1="Select * from modele";
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Les Materiaux</title>");            
            out.println("</head>");
            out.println("<center><body>");
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
            
            PreparedStatement pst=conn.prepareStatement(q1);
            RequestDispatcher rd1=request.getRequestDispatcher("Materiaux.jsp");
            
            ResultSet rs=pst.executeQuery();
            
            if(rs.isBeforeFirst()){
                
                
                out.print("<table class='table table-bordered  caption-top table-hover'>");
                out.print("<thead><tr>");
                out.print("<th>Type de Materiel</th>");
                
                out.print("</tr></thead>");
                    out.print("<tbody>");
                while(rs.next())
                {
                    out.println("<tr>");
                    out.print("<td><a href='liste_materiel?modele="+rs.getString(3)+"'>"+rs.getString(3)+"</a></td>");
                    
                    out.println("</tr>");
                }
                 out.print("<tbody>");
                out.print("</table");
      
            
            }
            
            rd1.include(request,response);
                
            rs.close();
            conn.close();
            pst.close();
            
            
            out.println("</body></center>");
            out.println("</html>");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    

}
