package com.example.demo;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {
	// public Entry[] entries;
	private String type;
	private String difficulty;
	private String question;
	@JsonProperty("incorrect_answers")
	private ArrayList<String> incorrectAnswers;
	@JsonProperty("correct_answer")
	private String correctAnswers;
	private String category;  
	
	public String getType() {
		return this.type;
	}
	
	public String getDifficulty() {
		return this.difficulty;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public ArrayList<String>  getIncorrectAnswers() {
		return this.incorrectAnswers;
	}
	
	public String getCorrectAnswer() {
		return this.correctAnswers;
	}
	
	public String getCategory() {
		return this.category;
	}  // convert to all answers to incorrect answers.
	
   /*
	public String toString() {
	   return "Type: "+type+" , Difficulty: "+difficulty+" , Question: "+question+" ,All answers: "+allAnswers+
			   " ,Correct answers: ,"+correctAnswers;
   }*/

} // array of results objects.
