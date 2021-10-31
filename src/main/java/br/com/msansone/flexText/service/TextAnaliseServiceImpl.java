package br.com.msansone.flexText.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class TextAnaliseServiceImpl implements TextAnaliseService{

	@Override
	public HashMap<String, Object> analise(String text) {
		HashMap<String, Object> resp = new HashMap<>();
		resp.put("NumberOfLetters", text.getBytes().length);
		resp.put("NumberOfWords", text.split(" ").length);
		
		String[] lista = text.split(" ");
		Stream<String> stream = Arrays.stream(lista);
		Map<String,Long> retorno=  stream.collect(Collectors.groupingBy(Function.identity(),  Collectors.counting()));
		
		Map<String, Object> retorno2 = retorno
										.entrySet()
										.stream()
										.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
										.collect(Collectors
												.toMap(Map.Entry::getKey, Map.Entry::getValue, 
			    (newValue, oldValue) -> newValue, LinkedHashMap::new));
		
		resp.put("listOfWords", retorno2);
		
		return resp;
	}

}
