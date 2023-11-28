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
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class modifierTechnicien extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      Connection conn;
    PreparedStatement prep;
    Statement statement;
    static final String driver="com.mysql.cj.jdbc.Driver";
    static final String db_url="jdbc:mysql://localhost:3306/cetim";
    static final String USER="root",PASS="";
    
    static  String name,surname,username,password,id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addTechnicien</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addTechnicien at " + request.getContextPath() + "</h1>");
            
            id = request.getParameter("id");
            name = request.getParameter("name");
            surname  = request.getParameter("surname");
            username = request.getParameter("username");
            password = request.getParameter("password");
            
            System.out.println(name);
               System.out.println(surname);
             System.out.println(username);
             out.println("<p> the labellis"+name+"</p>");
             System.out.println(password);
            out.print("<p>"+surname+"</p>");
            
            out.print("<p>"+username+"</p>");
            Class.forName(driver);
            conn=DriverManager.getConnection(db_url,USER,PASS);
            statement  = conn.createStatement();
            //insertion dans la base de donnees
            
           
          String sql1="UPDATE technicien SET Nom=?,Prenom=?,Username=?,Password=? where ID="+id;
            prep=conn.prepareStatement(sql1);
            
            prep.setString(1,name);
            prep.setString(2,surname);
            prep.setString(3,username);
            prep.setString(4,password);
            
            
         int res1 =   prep.executeUpdate();
          
         if((res1 > 0))
         {
            request.setAttribute("x","modifier");
             RequestDispatcher rd;
                rd = request.getServletContext().getRequestDispatcher("/afficheTrchnicians.jsp");
            rd.forward(request, response);
         }
         else{
              request.setAttribute("x","n'est pas modifier");
             RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/afficheTrchnicians.jsp");
            rd.forward(request, response);
              
         }
           
         prep.close();
         conn.close();
         out.flush();
         
         }catch(Exception e)
        {
            e.printStackTrace();
        }
           out.print("</body>");
              out.print("</html>");
        }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
