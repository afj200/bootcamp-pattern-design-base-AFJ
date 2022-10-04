package com.nttdata.patterdesin.patterns;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.domain.Person;
import com.nttdata.patterdesin.patterns.facade.PersonFacade;
import com.nttdata.patterdesin.patterns.proxy.AbstractPersonProxy;
import com.nttdata.patterdesin.patterns.proxy.PersonProxyBBDD;
import com.nttdata.patterdesin.patterns.singleton.PersonSingleton;
import com.nttdata.patterdesin.patterns.singleton.PersonSingletonEnum;

@SpringBootApplication
@ComponentScan(value = "com.nttdata")
public class PatternsApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    private PersonInterface personPrototype;

    public PatternsApplication(PersonInterface personPrototype) {
        this.personPrototype = personPrototype;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicio...");

        System.out.println("=============================================================================");
        System.out.println("Prácticas con Singleton");
        System.out.println("=============================================================================");
        PersonSingletonEnum.INSTANCE.person().setName("Joselito");

        System.out.println(PersonSingletonEnum.INSTANCE.person().getName());
        
        PersonSingleton.getInstance().setName("Angel");
        PersonSingleton.getInstance().setAge(20);
        System.out.println(PersonSingleton.getInstance().getName());
        
        System.out.println("Patrón clone");
        Person person = new Person();
        person.setAge(20);
        person.setName("Angel");
        
        Person clonePerson = (Person) person.clone();
        System.out.println("Clon de Person: " + clonePerson);
        
        System.out.println("Patrón Builder");
        
        Person buildPerson = Person.Builder().name("Manuel").age(30).build();
        
        System.out.println("Persona construida a través de build: "+ buildPerson.getName() + ", " + buildPerson.getAge());
        
        System.out.println("Patrón fachada");
        
        PersonFacade fachada = new PersonFacade(10);
        List<Person> listFachada = fachada.getListPersonCreated();
        System.out.println("Lista de personas creadas a través de fachada: ");
        for(Person personF : listFachada) {
        	System.out.println(personF + "," + personF.getAge());
        }
        
        System.out.println("Patrón proxy");
        Person entidad = Person.Builder().age(42).name("Fulanito Fernandez").build();
        //AbstractPersonProxy proxyBBDD = new PersonProxyBBDD(entidad);
        //proxyBBDD.operacion();
        System.out.println("Fin...");
    }
}
