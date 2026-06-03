package com.archana.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.archana.model.Question;
import com.archana.model.QuestionWrapper;
import com.archana.model.Response;
import com.archana.repository.QuestionRepo;
@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo repo;

	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		List<Question> ques = repo.findAll();
		
		return ResponseEntity
	            .status(HttpStatus.OK)
	            .body(ques);
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category)
	{
		List<Question> ques = repo.findByCategory(category);
		
		if(ques.isEmpty())
		{
			   throw new IllegalArgumentException(
	                    "No questions available for category : " + category);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ques);
	}

	public ResponseEntity<String> saveQuestion(Question question) {
		// TODO Auto-generated method stub
		

	        repo.save(question);

	        return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body("Question added successfully");

	   	}

	public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, Integer numberOfQuestion) {
		// TODO Auto-generated method stub
		
		List<Integer> quesId = repo.findRandomQuestionByCategory(category, numberOfQuestion);
		return new ResponseEntity<List<Integer>>(quesId, HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> id) {
		// TODO Auto-generated method stub
		List<QuestionWrapper> wrappers = new ArrayList<QuestionWrapper>();
		List<Question> questions= new ArrayList<Question>();
		for(Integer i : id)
		{
			questions.add(repo.findById(i).get());
		}
		
		for(Question q : questions)
		{
			QuestionWrapper wrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			wrappers.add(wrapper);
		}
		
		return new ResponseEntity<List<QuestionWrapper>>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> response) {
		// TODO Auto-generated method stub
		int right =0;
		for(Response resp : response)
		{
			Question ques= repo.findById(resp.getId()).get();
			if(resp.getAnswer().equals(ques.getRightAnswer()))
			{
				right++;
			}
		}
		
		return new ResponseEntity<Integer>(right, HttpStatus.OK);
	}

}
