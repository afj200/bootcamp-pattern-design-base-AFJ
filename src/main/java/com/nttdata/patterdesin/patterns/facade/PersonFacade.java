package com.nttdata.patterdesin.patterns.facade;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.patterdesin.patterns.domain.Person;

public class PersonFacade {
	
	List<Person> list;
	
	public PersonFacade(int num) {
		list = new ArrayList<Person>();
		for(int i = 0; i < num; i++) {
			Person personC = new Person();
			personC.setName("Persona de la lista" + i);
			personC.setAge((int) (20 + (Math.random() * 10)));
			list.add(personC);
		}
	}
	
	public List<Person> getListPersonCreated(){
		return this.list;
	}
}
