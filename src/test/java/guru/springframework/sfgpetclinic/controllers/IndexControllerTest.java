package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

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
    }

    /*
    @DisplayName(value = "Test exception")
    // after implementation see bellow!
    @Test
    void oopsHandlerTest() {
        // assertTrue("asdf".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");
        assertTrue("notImplemented".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");
        assertFalse("asdf".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");

    }
    */

    @DisplayName(value = "Test exception after implementation")
    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }
}