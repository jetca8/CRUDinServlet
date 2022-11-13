/*
StudentDTO Name: Jian Zhou
StudentDTO Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
package dataaccesslayer;

import java.util.List;

/**
 * Generic interface of Dao
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 * @param <T> first generic parameter
 * @param <S> second generic parameter
 */
public interface Dao <T, S> {
	List<T> getAll();
	T getById(S s);
	void add(T t);
	void update(T t);
	void delete(T t);
}
