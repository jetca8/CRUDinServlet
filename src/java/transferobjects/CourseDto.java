

package transferobjects;

/*
CourseDto Name: Jian Zhou
CourseDto Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
*/

/**
 * DTO of course
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class CourseDto {
    private String courseCode;
    private String courseName;
    private String courseDescription;

/**
 * constructor with empty parameter.
 */
    public CourseDto() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
   
    
    
    

}
