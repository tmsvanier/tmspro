
package tmsModelLayer;

import BussinessLayer.Impl.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author omid
 */
public class LoginServlet extends HttpServlet {
UserLogin log;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String role=request.getParameter("role");
//        HttpSession mysession = request.getSession();
       
        //sesion scope
  // String t= request.getAttribute("username");
//      HttpSession mysession =request.getSession();
//      if(mysession !=null){
//          mysession.getAttribute("username");
//      }
       int check=-1;
       check= getLogin().check_Username(Integer.parseInt(role), username,password);
           if(check==1)//correct information
               response.sendRedirect("client.jsp");
           else if(check==0)//meets username only
              response.sendRedirect("index.jsp");
           else if(check==-1)// not exist in database
                response.sendRedirect("alert.jsp");           
             processRequest(request, response);    
              
             
            //HttpSession loginSession =request.getSession();
            //loginSession.setAttribute("login", log);
            // mysession.setAttribute("accountname", username);
    }
    private UserLogin getLogin(){
      log=new UserLogin();
      return log;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
