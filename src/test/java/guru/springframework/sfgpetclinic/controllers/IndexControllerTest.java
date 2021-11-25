package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned!");
        assertEquals("index", controller.index(), () -> "Wrong with lambda message!");
        // assertEquals("indexd", controller.index(), "Wrong view returned!");
    }

    @Test
    void oopsHandler() {
        // assertTrue("asdf".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");
        assertTrue("notImplemented".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");
        assertFalse("asdf".equals(controller.oopsHandler()), () -> "This is some expensive message tp build for my test");

    }
}