package com.archana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.archana.model.Question;
import com.archana.model.QuestionWrapper;
import com.archana.model.Response;
import com.archana.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionContoller {
	
	@Autowired
	QuestionService service;
	
	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> getAllQuestion()
	{
		return service.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category)
	{
		return service.getQuestionByCategory(category);
	}
	
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		
		return service.saveQuestion(question);
	}
	
	@GetMapping("genrate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numberOfQuestion)
	{
		return service.getQuestionForQuiz(category, numberOfQuestion);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> id)
	{
		return service.getQuestionFromId(id);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> response)
	{
		return service.getScore(response);
	}
	

}
