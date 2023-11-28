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
public class liste_modele extends HttpServlet {

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
            
            String q1="select * from modele";
            String ques="Are you sure you want to delete?";
            String ques1="Are you sure you want to modify?";
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modeles des Materiaux</title>");            
            out.println("</head>");
            out.println("<center><body>");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
            
            PreparedStatement pst=conn.prepareStatement(q1);
            
            RequestDispatcher rd1=request.getRequestDispatcher("modele_materiel.jsp");
            
            ResultSet res=pst.executeQuery();
            if((res.next()))
            {
                out.print("<table  >");
                out.print("<tr>");
                out.print("<th>Code</th>");
                out.print("<th>Modele de materiel</th>");
                out.print("<th>Modifier</th>");
                
                out.print("</tr>");
                    
                while(res.next())
                {
                    out.println("<tr>");
                    out.print("<td>"+res.getString(2)+"</td>");
                    out.print("<td>"+res.getString(3)+"</td>");
                    out.print("<td><a href='modifier.jsp?code="+res.getString(2)+"&nom_modele="+res.getString(3)+"'>Modifier</a></td>");
                    
                    
                    out.println("</form></tr>");
                }
                
                out.print("</table");
            
            }
            
            
            out.println("</body></center>");
            out.println("</html>");
            
            rd1.include(request,response);
                
            res.close();
            conn.close();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
    

}
