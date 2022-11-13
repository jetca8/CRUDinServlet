package dataaccesslayer;

import java.util.List;
import transferobjects.CourseDto;
import java.sql.*;
import java.util.ArrayList;
import transferobjects.CredentialsDTO;

/*
Student Name: Jian Zhou
Student Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
 */
/**
 * DAO implementation for course
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class CourseDaoImpl implements CourseDao {
private CredentialsDTO creds;

    public CourseDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }
    /**
     * get all the course and put it into a list
     * @return the list with all the course info
     */
    @Override
    public List<CourseDto> getAll() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<CourseDto> courses = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT CourseCode, CourseName, CourseDescription  FROM course");
            rs = pstmt.executeQuery();
            courses = new ArrayList<>();
            while (rs.next()) {
                CourseDto course = new CourseDto();
                course.setCourseCode(rs.getString("CourseCode"));
                course.setCourseName(rs.getString("CourseName"));
                course.setCourseDescription(rs.getString("CourseDescription"));

                courses.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
        return courses;
    }
/**
 * get course by the courseID
 * @param courseID course ID 
 * @return course object of given courseID
 */
    @Override
    public CourseDto getById(String courseCode) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CourseDto course = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT CourseCode, CourseName, CourseDescription   FROM course WHERE CourseCode = ?");
            pstmt.setString(1, courseCode);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                course = new CourseDto();
                course.setCourseCode(rs.getString("CourseCode"));
                course.setCourseName(rs.getString("CourseName"));
                course.setCourseDescription(rs.getString("CourseDescription"));


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
        return course;
    }
/**courseadd new course record
 * @param course to be added
 */

    @Override
    public void add(CourseDto course) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO course (CourseCode, CourseName, CourseDescription) "
                    + "VALUES(?, ?, ?)");
            pstmt.setString(1, course.getCourseCode());
            pstmt.setString(2, course.getCourseName());
            pstmt.setString(3, course.getCourseDescription());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert failed!");
            e.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
    }
/**
 * update the information of the given course
 * @param course object to be updated
 */
    @Override
    public void update(CourseDto course) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                "UPDATE course SET CourseName = ?, " + 
		"CourseDescription = ? " + 
                  "WHERE CourseCode = ? ");
            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getCourseDescription());
            pstmt.setString(3, course.getCourseCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, pstmt, rs);
        }
    }
/**
 * delete the given course object
 * @param course course object to be deleted
 */
    @Override
    public void delete(CourseDto course) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                "DELETE FROM course WHERE CourseCode = ?"  );
            pstmt.setString(1, course.getCourseCode());
            pstmt.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeConnection(con,pstmt,rs);
        }
        
    }
/**
 * clean up, close resultset, preparedstatement, connection
 * @param con connection
 * @param pstmt preparedstatement
 * @param rs connection
 */
    private void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
