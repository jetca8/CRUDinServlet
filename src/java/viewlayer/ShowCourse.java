/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewlayer;

import businesslayer.CourseBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import transferobjects.CredentialsDTO;
import transferobjects.CourseDto;

/**
 * display all the current course in the table, and insert, delete and update
 * forms.
 *
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class ShowCourse extends HttpServlet {

    CredentialsDTO creds = new CredentialsDTO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowCourse at " + request.getContextPath() + "</h1>");

            creds.setUsername(request.getParameter("username"));
            creds.setPassword(request.getParameter("password"));

            HttpSession hs = request.getSession();
            
            String username;
            String password;
            
            if (hs.getAttribute("username") == null) {
                hs.setAttribute("username", creds.getUsername());
                hs.setAttribute("password", creds.getPassword());
                out.println("<p> null, first time, save pass from form, username: " + hs.getAttribute("username") + "password: " +hs.getAttribute("password") + "</p>");
                
            } else {
                creds.setUsername((String)hs.getAttribute("username"));
                creds.setPassword((String)hs.getAttribute("password"));
                out.println("<p> not null " + creds.getUsername() + creds.getPassword() + "</p>");
            }
            // Integer is an immutable data structure. So, you
            // cannot modify the old one in-place. Instead, you
            // have to allocate a new one and redo setAttribute.
//            HttpSession hs = request.getSession();
            out.println("<p> hs id: " + hs.getId() + "</p>");
            out.println("<p> creds data: " + creds.getUsername() + creds.getPassword() + "</p>");
            
            
//            if (null == (CredentialsDTO) hs.getAttribute("creds")) {
//                hs.setAttribute("creds", creds);
////                out.println("<p> null" + creds.getUsername() + creds.getPassword() + "</p>");
//            } else {
//                creds = (CredentialsDTO) hs.getAttribute("creds");
////                out.println("<p> creds is not null, " + creds.getUsername() + creds.getPassword() + "</p>");
//            }

            CourseBusinessLogic logic = new CourseBusinessLogic(creds);

            List<CourseDto> courseList = logic.getAll();

            CourseTool.displayCourseList(out, courseList);

            CourseTool.displayInsertForm(out);
            CourseTool.displayDeleteForm(out);
            CourseTool.displayUpdateForm(out, courseList);
            CourseTool.displayRefreshButton(out);

            out.println("</body>");
            out.println("</html>");
        }
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
