package br.com.msansone.flexText.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.flexText.model.rest.TextAnaliseRequest;
import br.com.msansone.flexText.model.rest.TextAnaliseResponse;
import br.com.msansone.flexText.service.TextAnaliseService;

@RestController
@RequestMapping("/flextext")
public class TextToolsController {
	
	@Autowired
	TextAnaliseService textAnalise;

	@PostMapping("/analise")
	public ResponseEntity<TextAnaliseResponse> textAnalise(@RequestBody TextAnaliseRequest texto){
		
		TextAnaliseResponse resp = new TextAnaliseResponse();
		
		HashMap<String, Object>  hashReso = textAnalise.analise(texto.getText());
		
		resp.setNumberOfLetters(Integer.parseInt( hashReso.get("NumberOfLetters").toString()));
		resp.setNumberOfWords(Integer.parseInt( hashReso.get("NumberOfWords").toString()));
		resp.setListOfWords((Map) hashReso.get("listOfWords"));
		
		return ResponseEntity.ok(resp);
		
	}
}
