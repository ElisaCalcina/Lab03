package it.polito.tdp.spellchecker.model;

import java.util.*;
import java.io.*;

public class Dictionary {
	
	List<String> words= new LinkedList<String>();
	String language;
	
	public Dictionary() {
		
	}
	
	public Dictionary(List<String> words, String language) {
		super();
		this.words = words;
		this.language = language;
	}

	public void loadDictionary(String language) {
		if(language.compareTo("English")==0) {
			try {
				FileReader fr= new FileReader("src/main/resources/English.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word = br.readLine())!=null) {
					words.add(word);
				}
				br.close();
			} catch(IOException e) {
				System.out.println("Errore nella lettura del file English.txt");
			}
		}
		else if(language.compareTo("Italian")==0) {
			try {
				FileReader fr= new FileReader("src/main/resources/Italian.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word = br.readLine())!=null) {
					words.add(word);
				}
				br.close();
			} catch(IOException e) {
				System.out.println("Errore nella lettura del file Italian.txt");
			}
		}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> lista= new LinkedList<RichWord>();
		for(String l: inputTextList) {
			RichWord r= new RichWord(l);
			if(words.contains(l)) {
				r.setCorrect(true); 
			}
			else {
				r.setCorrect(false);
			}
			lista.add(r);
		}
		return lista;
	}

}
