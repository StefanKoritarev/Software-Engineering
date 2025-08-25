package de.tum.in.ase.eist.service;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonService {
    // do not change this
    private final List<Person> persons;

    public PersonService() {
        this.persons = new ArrayList<>();
    }

    public Person savePerson(Person person) {
        var optionalPerson = persons.stream().filter(existingPerson -> existingPerson.getId().equals(person.getId())).findFirst();
        if (optionalPerson.isEmpty()) {
            person.setId(UUID.randomUUID());
            persons.add(person);
            return person;
        } else {
            var existingPerson = optionalPerson.get();
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setBirthday(person.getBirthday());
            return existingPerson;
        }
    }

    public void deletePerson(UUID personId) {
        this.persons.removeIf(person -> person.getId().equals(personId));
    }

    public List<Person> getAllPersons(PersonSortingOptions sortingOptions) {
        // TODO Part 3: Add sorting here

        if (sortingOptions.getSortField() == null) {
            sortingOptions.setSortField(PersonSortingOptions.SortField.ID);
        }
        if (sortingOptions.getSortingOrder() == null) {
            sortingOptions.setSortingOrder(PersonSortingOptions.SortingOrder.ASCENDING);
        }

        if (sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.ASCENDING) && sortingOptions.getSortField().equals(PersonSortingOptions.SortField.ID)) {
            return persons.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList());
        } else if (sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.ASCENDING) && sortingOptions.getSortField().equals(PersonSortingOptions.SortField.FIRST_NAME)) {
            return persons.stream().sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.toList());
        } else if (sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.ASCENDING) && sortingOptions.getSortField().equals(PersonSortingOptions.SortField.LAST_NAME)) {
            return persons.stream().sorted(Comparator.comparing(Person::getLastName)).collect(Collectors.toList());
        } else if (sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.ASCENDING) && sortingOptions.getSortField().equals(PersonSortingOptions.SortField.BIRTHDAY)) {
            return persons.stream().sorted(Comparator.comparing(Person::getBirthday)).collect(Collectors.toList());
        } else if (sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.DESCENDING) && sortingOptions.getSortField().equals(PersonSortingOptions.SortField.ID)) {
            return persons.stream().sorted(Comparator.comparing(Person::getId).reversed()).collect(Collectors.toList());
        } else if (sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.DESCENDING) && sortingOptions.getSortField().equals(PersonSortingOptions.SortField.FIRST_NAME)) {
            return persons.stream().sorted(Comparator.comparing(Person::getFirstName).reversed()).collect(Collectors.toList());
        } else if (sortingOptions.getSortingOrder().equals(PersonSortingOptions.SortingOrder.DESCENDING) && sortingOptions.getSortField().equals(PersonSortingOptions.SortField.LAST_NAME)) {
            return persons.stream().sorted(Comparator.comparing(Person::getLastName).reversed()).collect(Collectors.toList());
        } else {
            return persons.stream().sorted(Comparator.comparing(Person::getBirthday).reversed()).collect(Collectors.toList());
        }

        // return persons.stream().sorted(Comparator.comparing(person -> sortingOptions.getSortingOrder()).thenComparing(Comparator.comparing(person ->
        //     sortingOptions.getSortField()));
    }
}
