package test;

import personnes.IPersonne;
import java.util.Date;
import java.util.Random;

public class DoublureDePersonne implements IPersonne {
	
	public static final Random RANDOM = new Random(10);
	
	private int age_;
	
	public DoublureDePersonne() {
		age_ = Math.abs(RANDOM.nextInt()) % 121;
	}
	
	public DoublureDePersonne(int n) {
		age_ = n;
	}
	
	@Override
	public String getNom() {
		throw new RuntimeException("Acces au nom de la personne");
	}

	@Override
	public String getPrenom() {
		throw new RuntimeException("Acces au prenom de la personne");
	}

	@Override
	public Date getDate() {
		return null;
	}

	@Override
	public int getAge(Date d) {
		return age_;
	}
	
	@Override
	public int getAge() {
		return age_;
	}
}