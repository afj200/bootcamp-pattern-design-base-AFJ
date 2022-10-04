package com.nttdata.patterdesin.patterns.decorator;

public class PersonDecorator implements PersonInterface{

	private PersonInterface personI;
	
	public PersonDecorator(PersonInterface personI) {
		this.personI = personI;
	}

	@Override
	public String getName() {
		
		return personI.getName();
	}

	@Override
	public void setName(String name) {
		this.personI.setName(name);
	}

	@Override
	public int getAge() {
		
		return personI.getAge();
	}

	@Override
	public void setAge(int age) {
		this.personI.setAge(age);
		
	}
}
