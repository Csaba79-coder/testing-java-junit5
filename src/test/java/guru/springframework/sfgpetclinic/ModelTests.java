package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEach(TestInfo testInfo){
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
