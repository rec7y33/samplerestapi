package com.tymm.samplerestapi.repository;

import com.tymm.samplerestapi.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cheong.tymm
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    @Query(value = "SELECT * FROM student ORDER BY enrolldate LIMIT ?2 OFFSET ?1", nativeQuery = true)
    public List<Student> findAllWithPagination(int offset, int pageSize);
}
