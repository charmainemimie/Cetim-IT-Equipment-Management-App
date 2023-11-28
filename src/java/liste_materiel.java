/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vickie Romad
 */
public class liste_materiel extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Les Materiaux</title>");         
            out.println("</head>");
            out.println("<body>");
            
            String nom_modele=request.getParameter("modele");
            //out.println("<p>"+nom_modele+"</p><br><br>");
            String q="Select * from "+nom_modele;
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
            
            
            PreparedStatement pst=conn.prepareStatement(q);
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            int count=rsmd.getColumnCount();
            
            //out.println("<p>"+count+"</p>");
            
            /*String q1="SELECT count(*)  FROM information_schema.columns WHERE table_name ="+nom_modele;
            
             //String q1 ="SELECT count(*) Noofcolumns FROM SYSCOLUMNS where id=(select id from SYSOBJECTS where name="+nom_modele;          
            
            PreparedStatement pst1=conn.prepareStatement(q1);
            pst1.setString(1, nom_modele);
            
            ResultSet rs1=pst1.executeQuery();
            out.println("<p>"+rs1+"</p>");
            
            int count=Integer.parseInt(rs1.getObject(1).toString());
            
            
            
            out.println("<h1>"+nom_modele+" count= "+count+"</h1>");*/
            
            
            
            if(rs.isBeforeFirst()){
                
                out.print("<h1>"+nom_modele+" Table</h1>");
                out.print("<a href='ajoute_materiel'>+ Ajouter un materiel</a><br>");
                out.print("<table border='1' align='center'>");
                out.println("<tr>");
                for(int j=1;j<=count;j++){
                    String col=rsmd.getColumnName(j);
                    out.println("<th>"+col+"</th>");
                }
                out.println("<th>Modifier</th>");
                out.println("</tr>");
                while(rs.next())
                {
                    out.println("<tr>");
                    
                    for(int i=1;i<=count;i++){
                    out.print("<td>"+rs.getString(i)+"</td>");
                    
                    }
                    out.print("<td><a href='modifier_materiel.jsp?code_barre="+rs.getString(1)+"&nom_table="+nom_modele+"'>Modifier</a></td>");
                    out.println("</tr>");
                }
                
                out.print("</table");
            }
            
            out.println("</body>");
            out.println("</html>");
            
            //RequestDispatcher rd1=request.getRequestDispatcher("liste_materiel.jsp");
            //rd1.include(request,response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

   

}
