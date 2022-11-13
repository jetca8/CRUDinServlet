

package businesslayer;

import dataaccesslayer.CourseDaoImpl;
import java.util.List;
import transferobjects.CredentialsDTO;
import transferobjects.CourseDto;
import dataaccesslayer.CourseDao;

/*
Student Name: Jian Zhou
Student Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * business logic class for course
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class CourseBusinessLogic {
    private CourseDao courseDao = null;
    private CredentialsDTO creds;
/**
 * empty parameter constructor 
 */
    public CourseBusinessLogic(CredentialsDTO creds) {
        courseDao = new CourseDaoImpl(creds);
    }
    /**
     * get all the course and put it into a list
     * @return the list contains all the course
     */
    public List<CourseDto>  getAll (){
        return courseDao.getAll();
    }
    /**
     * add new course info
     * @param dto course dto to be added
     */
    public void add(CourseDto dto) {
        courseDao.add(dto);
    }
    /**
     * update course info
     * @param dto course dto to be update
     */
    public void update(CourseDto dto) {
        courseDao.update(dto);
    }
    /**
     *  delete course record
     * @param dto course dto to be deleted
     */
    public void delete(CourseDto dto) {
        courseDao.delete(dto);
    }
    /**
     *  get the course dto by given course id
     * @param id id of the course
     * @return course dto of the given course id
     */
    public CourseDto getById(String courseCode) {
        return courseDao.getById(courseCode);
    }
            
            
}
