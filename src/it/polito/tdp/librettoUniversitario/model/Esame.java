package it.polito.tdp.librettoUniversitario.model;

import java.time.LocalDate;

/**
 * Oggetto semplice(=POJO) che contiene i dati relativi ad un singolo esame.
 *
 * POJO - Plain old java object:
 * 	- Dati privati (proprietà)
 *  - Costruttore
 *  - Metodi get/set
 *  - Metodi di servizio (toString equals hashCode compareTO)
 * 
 * 	 
 * @author LP
 *
 */
public class Esame {
	private String codice;
	private String titolo;
	private String docente;
	//private Docente docente;
	
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento; //NON USARE java.util.Date
	
	/**
	 * Nuovo esame, non ancora superato
	 * 
	 * @param codice Codice esame
	 * @param titolo Denominazione corso
	 * @param docente Cognome e nome del docente titolare
	 */
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		
		//Quando creo un nuovo esame non è ancora stato superato
		this.superato = false; 
	}
	/**
	 * Se l'esame non è ancora superato, lo considera superato
	 * con voto e data specificati.
	 * Se invece fosse già superato, genera un'eccezione
	 * 
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		// Siccome questo metodo gestisce il superamento dell'esame,
		// non faccio chiamare dall'esterno i metodi setSuperato,
		// setVoto e setDataSuperamento => private
		if(!this.superato){
			//non ancora superato: OK
			this.superato = true;
			this.voto = voto;
			this.dataSuperamento = data;
		}else{
			//Ho chiamato un metodo su un oggetto il cui stato interno 
			//non permetteva di chiamarlo
			throw new IllegalStateException("Esame "+this.codice+" già superato!"); 
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public boolean isSuperato() {
		return superato;
	}
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}
	/**
	 * Restituisce il voto solo se l'esame è stato superato
	 * Altrimenti eccezione
	 * @return
	 */
	public int getVoto() {
		if(this.superato)
			return voto;
		else
			throw new IllegalStateException("Esame "+this.codice+" non ancora superato!");
	}
	private void setVoto(int voto) {
		this.voto = voto;
	}
	public LocalDate getDataSuperamento() {
		if(this.superato)
			return dataSuperamento;
		else
			throw new IllegalStateException("Esame "+this.codice+"non ancora superato!");
	}
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}
}
