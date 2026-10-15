package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void validatesAndTrimsInput() {
        assertEquals("Validated: hello", App.validateMessage("  hello  "));
    }

    @Test
    void rejectsBlankInput() {
        assertThrows(IllegalArgumentException.class, () -> App.validateMessage("  "));
    }

    @Test
    void rejectsNullInput() {
        assertThrows(IllegalArgumentException.class, () -> App.validateMessage(null));
    }
}
