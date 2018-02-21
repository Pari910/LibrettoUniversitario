package it.polito.tdp.librettoUniversitario.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author LP
 *
 */
public class Model {
	private List<Esame> esami;
	
	public Model(){
		this.esami = new ArrayList<Esame>();
	}
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti,
	 * verificando che non ci sia già
	 * 
	 * @param esame
	 * @return true se è stato inserito, false se esisteva già
	 */
	public boolean addEsame(Esame esame){
		if(!esami.contains(esame)){
			esami.add(esame);
			return true;
		}else
			return false;
	}
	/**
	 * Ricerca se esiste un esame con il codice specificato.
	 * Se esiste, lo restituisce.
	 * Altrimenti restituisce null.
	 * 
	 * @param codice Codice esame da cercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice){
		// indexOf effettua una equals su due oggetti di tipo esame
		// Creo un esame fittizio con solo il codice in modo da potere 
		// verificare se esiste in esami un esame con quel codice
		int position = esami.indexOf(new Esame(codice, "", ""));
		if(-1==position)
			return null;
		else
			return esami.get(position);
	}
}
