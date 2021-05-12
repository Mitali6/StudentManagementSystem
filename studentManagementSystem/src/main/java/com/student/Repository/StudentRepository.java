package com.student.Repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;
import com.student.entity.UniqueCourses;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("SELECT new com.student.entity.UniqueCourses(s.course as course, count(s.id) as numberOfStudents, SUM(s.fees) as totalFees)"
			+ " from Student s group by s.course" )
	List<UniqueCourses> getUniqueCoursesInfo();

}
