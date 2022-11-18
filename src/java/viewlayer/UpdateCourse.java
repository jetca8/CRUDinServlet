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
import transferobjects.CourseDto;
import transferobjects.CredentialsDTO;

/**
 * update the record information in course table
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class UpdateCourse extends HttpServlet {

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
            out.println("<title>Servlet UpdateCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCourse at " + request.getContextPath() + "</h1>");

            HttpSession hs = request.getSession();
            CredentialsDTO creds = new CredentialsDTO();
            creds.setUsername((String)hs.getAttribute("username"));
            creds.setPassword((String)hs.getAttribute("password"));
            
            CourseBusinessLogic logic = new CourseBusinessLogic(creds);
            List<CourseDto> courseList = logic.getAll();
            int i = 0; 
            while (courseList.iterator().hasNext())
//            for (CourseDto courseInList : courseList) 
            {
                if (i == Integer.parseInt(request.getParameter("index"))) {
                    CourseDto course = new CourseDto();
                    course.setCourseCode(request.getParameter("updateCourseCode"));
                    course.setCourseName(request.getParameter("updateCourseName"));
                    course.setCourseDescription(request.getParameter("updateCourseDescription"));
                    out.println("<p> index # " + i  +"coursecode "+ course.getCourseCode()  +"coursename " + course.getCourseName() + " is updated.</p>");
                    logic.update(course);
                    out.println("<p> record # " + i + " is updated.</p>");
                    break;
                } else {
                    i++;
                }

            }
            courseList = logic.getAll();
            CourseTool.displayCourseList(out, courseList);
            CourseTool.displayReturn(out);
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
