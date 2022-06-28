package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	private DizionarioDAO parola;
	private List<String> anagCorretti;
	private List<String> anagScorretti;

	public Model() {
		this.parola = new DizionarioDAO();
		anagCorretti = new LinkedList<String>();
		anagScorretti = new LinkedList<String>();
	}
//	ricevo dal controller 's' 
	public void anagramma(String s) {
		anagramma_ricorsiva("",0,s);
	}
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length()==0) { /* Caso terminale */
			if(esisteParola(parziale)) {
				anagCorretti.add(parziale);
			}
			else if(!esisteParola(parziale)) {
				anagScorretti.add(parziale);
				}
			return;
		}else {
			for(int pos = 0; pos < rimanenti.length(); pos++) {
				anagramma_ricorsiva(parziale+rimanenti.charAt(pos), livello+1, rimanenti.substring(0, pos) + rimanenti.substring(pos+1));
			}
		}
	}
	public List<String> getAnagCorretti() {
		return anagCorretti;
	}
	public List<String> getAnagScorretti() {
		return anagScorretti;
	}
	public boolean esisteParola(String parola) {
		return this.parola.esisteParola(parola);
	}
	
	
}
