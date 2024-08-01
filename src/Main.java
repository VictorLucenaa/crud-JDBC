import Domain.Person;
import Service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Person pessoa1 = new Person("victor", 32);
        PersonService.createPerson(pessoa1);


        List<Person> pessoas = PersonService.readPersons();

       pessoas.forEach(System.out::println);

        PersonService.updatePerson(1, "victin", 28);
        PersonService.deletePerson(5);
    }
}