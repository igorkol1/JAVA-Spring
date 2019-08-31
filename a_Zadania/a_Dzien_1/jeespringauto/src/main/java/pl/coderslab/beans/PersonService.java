package pl.coderslab.beans;

import org.springframework.stereotype.Component;

@Component
public class PersonService {

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private PersonRepository personRepository;

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
