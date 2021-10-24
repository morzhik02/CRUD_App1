package ru.izteleumarzhan.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.izteleumarzhan.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Adil", 20, "adil@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Ruslan", 21, "ruslan@email.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Asem", 19, "asem@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Olzhas", 19, "olzhas@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(final int id){
        return people.stream()
                    .filter(person -> person.getId() == id).findAny()
                    .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
