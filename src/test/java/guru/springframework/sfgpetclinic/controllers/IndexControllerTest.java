package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

// @Tag("controllers")
class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName(value = "Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned!");
        assertEquals("index", controller.index(), () -> "Wrong with lambda message!");
        // assertEquals("indexd", controller.index(), "Wrong view returned!");
        assertNotEquals("indexd", controller.index(), "Wrong view returned!");

        // after adding dependency: assertj comes assertThat ...
        assertThat(controller.index()).isEqualTo("index"); // this is an assertj assertion!
    }

    @Disabled
    @DisplayName(value = "Test exception")
    // after implementation see bellow!
    @Test
    void oopsHandlerTest() {
        // assertTrue("asdf".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");
        assertTrue("notImplemented".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");
        assertFalse("asdf".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");

    }

    @DisplayName(value = "Test exception after implementation")
    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled(value = "Demo of time out!")
    @Test
    void testTimeOut() {

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000); // this one will run 5 sec!

            System.out.println("I got here"); // prints this one!
        });
    }

    @Disabled(value = "Demo of time out preempt!")
    @Test
    void testTimeOutPreempt() {

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000); // this one runs only 116 millis!

            System.out.println("I got here Preempt"); // does not print anything!
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJT() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }
}