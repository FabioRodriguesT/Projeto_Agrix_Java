package com.betrybe.agrix.solution;

import com.betrybe.agrix.entity.Person;
import com.betrybe.agrix.service.exception.PersonNotFoundException;
import com.betrybe.agrix.repository.PersonRepository;
import com.betrybe.agrix.security.Role;
import com.betrybe.agrix.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Requisito 02 - Teste da Class PersonService")
public class PersonServiceTest {

  @Autowired
  PersonService personService;

  @MockBean
  PersonRepository personRepository;

  @Test
  @DisplayName("Se consigo criar/salvar uma pessoa, e encontra-la no repositório.")
  public void testPersonCreation() {
    Person person = new Person();
    person.setUsername("João");
    person.setPassword("123456");
    person.setRole(Role.valueOf("USER"));

    Person personToReturn = new Person();
    personToReturn.setId(123L);
    personToReturn.setUsername(person.getUsername());
    personToReturn.setPassword(person.getPassword());
    personToReturn.setRole(person.getRole());
    Mockito.when(personRepository.save(any()))
            .thenReturn(personToReturn);

    Person savedPerson = personService.create(person);
    Mockito.verify(personRepository).save(any());
    assertEquals(123L, savedPerson.getId());
    assertEquals(person.getUsername(), savedPerson.getUsername());
    assertEquals(person.getPassword(), savedPerson.getPassword());
  }

  @Test
  @DisplayName("Se consigo encontrar uma pessoa pelo Id com sucesso.")
  public void testGetPersonById() {
    Person person = new Person();
    person.setId(321L);
    person.setUsername("João");
    person.setPassword("123456");
    person.setRole(Role.valueOf("USER"));

    Mockito.when(personRepository.findById(eq(321L)))
            .thenReturn(Optional.of(person));
    Person returnedPerson = personService.getPersonById(321L);
    Mockito.verify(personRepository).findById(eq(321L));
    assertEquals(returnedPerson.getId(), person.getId());
    assertEquals(returnedPerson.getUsername(), person.getUsername());
    assertEquals(returnedPerson.getPassword(), person.getPassword());
  }

  @Test
  @DisplayName("Se consigo encontrar um erro ao buscar por um id inválido.")
  public void testGetPersonByIdNotFound() {
    Mockito.when(personRepository.findById(eq(938L)))
            .thenReturn(Optional.empty());
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(938L));
    Mockito.verify(personRepository).findById(eq(938L));
  }

  @Test
  @DisplayName("Se consigo encontrar uma pessoa pelo username com sucesso.")
  public void testGetPersonByUsername() {
    Person person = new Person();
    person.setId(535L);
    person.setUsername("João");
    person.setPassword("123456");
    person.setRole(Role.valueOf("USER"));

    Mockito.when(personRepository.findByUsername(eq("João")))
            .thenReturn(Optional.of(person));
    Person returnedPerson = personService.getPersonByUsername("João");
    Mockito.verify(personRepository).findByUsername(eq("João"));
    assertEquals(returnedPerson.getId(), person.getId());
    assertEquals(returnedPerson.getUsername(), person.getUsername());
    assertEquals(returnedPerson.getPassword(), person.getPassword());
  }

  @Test
  @DisplayName("Se consigo encontrar um erro ao buscar por um username inválido.")
  public void testGetPersonByUsernameNotFound() {
    Mockito.when(personRepository.findByUsername(eq("João")))
            .thenReturn(Optional.empty());
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("João"));
    Mockito.verify(personRepository).findByUsername(eq("João"));
  }

}
