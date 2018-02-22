package it.polito.tdp.librettoUniversitario.db;

import it.polito.tdp.librettoUniversitario.model.Esame;

public class TestEsameDAO {

	public static void main(String[] args) {
		DAO_Esame dao = new DAO_Esame();
		Esame e1 = dao.find("03FYZ");
		System.out.println(e1);
		Esame e2 = dao.find("99QQQ");
		System.out.println(e2);
	}

}
