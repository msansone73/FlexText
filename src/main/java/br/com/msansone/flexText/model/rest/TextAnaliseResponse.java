package br.com.msansone.flexText.model.rest;

import java.util.Map;

public class TextAnaliseResponse {


	private Integer numberOfLetters;
	private Integer numberOfWords;
	private Map listOfWords;
	
	public Integer getNumberOfLetters() {
		return numberOfLetters;
	}
	public void setNumberOfLetters(Integer numberOfLetters) {
		this.numberOfLetters = numberOfLetters;
	}
	public Integer getNumberOfWords() {
		return numberOfWords;
	}
	public void setNumberOfWords(Integer numberOfWords) {
		this.numberOfWords = numberOfWords;
	}
	public Map getListOfWords() {
		return listOfWords;
	}
	public void setListOfWords(Map listOfWords) {
		this.listOfWords = listOfWords;
	}
	
	
	
}
