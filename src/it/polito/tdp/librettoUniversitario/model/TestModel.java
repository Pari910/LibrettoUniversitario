package it.polito.tdp.librettoUniversitario.model;

public class TestModel {
	public static void main(String[] args) {
		Model m = new Model();
		
		m.addEsame(new Esame("03FYZ", "Tecniche di programmazione", "Fulvio Corno"));
		m.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno"));
		
		System.out.println(m.trovaEsame("03FYZ"));
		System.out.println(m.trovaEsame("01QZP"));
		System.out.println(m.trovaEsame("00000"));
		
		System.out.println(m.addEsame(new Esame("11111", "Apa", "Fulvio Corno")));
		System.out.println(m.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno")));
	}
}
