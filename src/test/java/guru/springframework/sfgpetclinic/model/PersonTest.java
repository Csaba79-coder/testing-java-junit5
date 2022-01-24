package guru.springframework.sfgpetclinic.model;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class PersonTest implements ModelTests {

    @Test
    void groupAssertions() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then

        assertAll("Test Props Set",
                // here comes a list of lambda expressions! as many we need!
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }


    @Test
    void groupAssertionsMessages() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then

        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed!"),
                () -> assertEquals("Buck", person.getLastName(), "Last Name Failed!!!"));
    }
}