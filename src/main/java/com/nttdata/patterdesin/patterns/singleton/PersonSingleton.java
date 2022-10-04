package com.nttdata.patterdesin.patterns.singleton;

import com.nttdata.patterdesin.patterns.domain.Person;

public class PersonSingleton {
	
	public static Person INSTANCE = new Person();
	
	private PersonSingleton() {
		super();
	}
	
	public static Person getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Person();
		}
		return INSTANCE;		
	}
}
