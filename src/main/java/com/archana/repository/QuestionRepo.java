package com.archana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.archana.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer>{

	 public List<Question> findByCategory(String category);

	 @Query(value = """
		        SELECT id FROM
		        (
		            SELECT q.id FROM QUESTION q
		            WHERE q.CATEGORY = :category
		            ORDER BY DBMS_RANDOM.VALUE
		        )
		        WHERE ROWNUM <= :numberOfQuestion
		        """,
		        nativeQuery = true)
		List<Integer> findRandomQuestionByCategory(
		        @Param("category") String category,
		        @Param("numberOfQuestion") Integer numberOfQuestion);
	
}
