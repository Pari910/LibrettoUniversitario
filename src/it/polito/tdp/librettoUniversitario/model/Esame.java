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
	public void setSuperato(boolean superato) {
		this.superato = superato;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public LocalDate getDataSuperamento() {
		return dataSuperamento;
	}
	public void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}
}
