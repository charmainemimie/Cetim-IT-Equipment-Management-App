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
public class modifier_materiel extends HttpServlet {

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
            out.println("<title>Modifier materiel</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String nom_tab=request.getParameter("table_name");
            String code_barre=request.getParameter("code_barre");
            String count_doc=request.getParameter("count");
            
            int count=Integer.parseInt(count_doc);
            
            int con=count-3;
            
            //out.print("<p>"+nom_tab+" "+code_barre+" con="+con+" count="+count+"</p>");
            String [] val_col= new String[con];
            String [] name_col=new String[con];
            for(int i=0;i<con;i++){
            String nmt="column"+(i+4);
            val_col[i]=request.getParameter(nmt);
            String nmt1="column_name"+(i+4);
            name_col[i]=request.getParameter(nmt1);
           //out.print("<p>"+name_col[i]+" "+val_col[i]+"</p>");
        }
            
            String q="UPDATE "+nom_tab
                         + " SET Status='"+val_col[0]+"'";
            String q1=" WHERE Code_barre='"+code_barre+"'";
            
            /*for(int i=1;i<con;i++){
                q=q+", "+name_col[i]+"="+val_col[i];
            }*/
            String q2=q+q1;
            
            //out.print("<p>"+q2+"</p>");
            
            
            
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetim","root","");
            
            PreparedStatement pst=conn.prepareStatement(q2);
            int res=pst.executeUpdate(); 
            
            RequestDispatcher rd1=request.getRequestDispatcher("liste_materiel");
            
            if(res>0){
                request.setAttribute("feedback", "Update successful!");
            }else{
                request.setAttribute("feedback", "Update failed!");
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
