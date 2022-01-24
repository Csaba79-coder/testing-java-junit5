package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements ModelRepeatedTests {

    //@RepeatedTest(10)
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My repeated test")
    // @Test
    void myRepeatedTest() {
        // TODO - impl
    }

    @RepeatedTest(value = 5, name = "{displayName}")
    @DisplayName("Repeated test with DI")
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) { // DI - dependency injection
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition() +
                " - " + repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 3, name = "{displayName} : {currentRepetition}" + " of " + " {totalRepetitions}")
    @DisplayName("Assignment repeated test")
    void myAssignmentRepeated() {

    }
}
