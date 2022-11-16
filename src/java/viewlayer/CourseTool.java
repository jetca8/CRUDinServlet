/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewlayer;

import java.io.PrintWriter;
import java.util.List;
import transferobjects.CourseDto;

/*
Student Name: Jian Zhou
Student Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
 */
/**
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class CourseTool {

    /**
     * display all the course in the list
     * @param out printwriter object for output html
     * @param courseList list of course to be showed
     */
    public static void displayCourseList(final PrintWriter out, List<CourseDto> courseList) {
        out.println("<p>Display Course List Table:</p>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<td>Course Code</td>");
        out.println("<td>Course Name</td>");
        out.println("<td>Course Description</td>");
        out.println("</tr>");

        for (CourseDto courseInList : courseList) {
            out.printf("<tr><td>%s</td><td>%s</td><td>%s</td></tr>",
                    courseInList.getCourseCode(), courseInList.getCourseName(), courseInList.getCourseDescription());
        }
        out.println("</table>");
    }
/**
 * display the html of the insert record form
 * @param out printwriter object for output html
 */
    public static void displayInsertForm(final PrintWriter out) {
        out.println("<p> Insert a new record:</p>");
        out.println(" <form action=\"InsertCourse\" method=\"post\">");
        out.println(" <table border=\"1\">");
        out.println("  <tr>");
        out.println("     <td>course code</td>");
        out.println("     <td>course name</td>");
        out.println("     <td>course description</td>");
        out.println("     <td></td>");
        out.println(" </tr>");
        out.println(" <tr>");
        out.println("    <td><input type=\"text\" name=\"courseCode\"></td>");
        out.println("    <td><input type=\"text\" name=\"courseName\"></td>");
        out.println("    <td><input type=\"text\" name=\"courseDescription\"></td>");
        out.println("    <td><input type=\"submit\" value=\"insert\"></td>");
        out.println(" </tr>");
        out.println("</table>");
        out.println("</form>");
    }
/**
 * display html of the delete record form
 * @param out printwriter object for output html
 */
    public static void displayDeleteForm(final PrintWriter out) {
        out.println("<p> Delete a record by Course Code:</p>");
        out.println(" <form action=\"DeleteCourse\" method=\"post\">");
        out.println(" <table border=\"1\">");
        out.println("  <tr>");
        out.println("     <td>course code</td>");
        out.println("     <td><input type=\"text\" name=\"deleteCourseCode\"></td>");
        out.println("     <td><input type=\"submit\" value=\"delete\"></td>");
        out.println(" </tr>");

        out.println("</table>");
        out.println("</form>");
    }
/**
 * display html of the update record form
 * @param out printwriter object for output html
 * @param courseList course list to be update
 */
    public static void displayUpdateForm(final PrintWriter out, List<CourseDto> courseList) {
        out.println("<p>Update course info:</p>");

        int i = 0;
        for (CourseDto courseInList : courseList) {
            out.println("<form action=\"UpdateCourse\" method=\"get\">");
            out.println("<table border=\"1\">");
            if (i == 0) {
                out.println("<tr>");
                out.println("<td>Course Code</td>");
                out.println("<td>Course Name</td>");
                out.println("<td>Course Description</td>");
                out.println("<td></td>");
                out.println("</tr>");
            }
            out.printf("<tr>"
                    + "<td><input type=\"text\" name=\"updateCourseCode\" placeholder=\"%s\" readonly></td>"
                    + "<td><input type=\"text\" name=\"updateCourseName\" value=\"%s\"></td>"
                    + "<td><input type=\"text\" name=\"updateCourseDescription\" value=\"%s\"></td>"
                    + "<td><input type=\"hidden\" name=\"index\" value=\"%d\"> <input type=\"submit\" value=\"Update\"></td>"
                    + "</tr>",
                     courseInList.getCourseCode(),  courseInList.getCourseName(),  courseInList.getCourseDescription(),i);
            out.println("</table>");
            out.println("</form>");
            i++;
        }

    }

    public static void displayRefreshButton(final PrintWriter out) {
        out.println(" <form action=\"ShowCourse\" method=\"post\">");
        out.println(" <table>");
        out.println("  <tr>");
//        out.println("     <td>course code</td>");
//        out.println("     <td><input type=\"text\" name=\"deleteCourseCode\"></td>");
        out.println("     <td><input type=\"submit\" value=\"Refresh\"></td>");
        out.println(" </tr>");

        out.println("</table>");
        out.println("</form>");
    }

    public static void displayReturn(final PrintWriter out) {
        out.println("<a href=\"ShowCourse\">return</a>");

    }
}
