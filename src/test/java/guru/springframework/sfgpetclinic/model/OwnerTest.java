package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

// @Tag("model")
class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("+1-011-555-0000");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                            () -> assertEquals("Joe", owner.getFirstName(),
                                    "First name did not match"),
                            () -> assertEquals("Buck", owner.getLastName(),
                                    "Last name did not match")),
                () -> assertAll("Owner Properties",
                            () -> assertEquals("Key West", owner.getCity(),
                                    "City did not match"),
                            () -> assertEquals("+1-011-555-0000", owner.getTelephone(),
                                    "Telephone did not match")
                ));

        //hamcrest uses assertThat() as well as in IndexControllerTest class!
        assertThat(owner.getCity(), is("Key West")); // this one uses Hamcrest
    }

    @DisplayName("Value Source Test")
    // great for testing credit card -> the first 4 number says the type of the card etc.
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String value) {
        System.out.println(value);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }
}