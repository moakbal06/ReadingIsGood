package com.onur.reading.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BookNotFoundExceptionTest {
    /**
     * Method under test: default or parameterless constructor of {@link BookNotFoundException}
     */
    @Test
    void testConstructor() {
        BookNotFoundException actualBookNotFoundException = new BookNotFoundException();
        assertNull(actualBookNotFoundException.getCause());
        assertEquals(0, actualBookNotFoundException.getSuppressed().length);
        assertNull(actualBookNotFoundException.getMessage());
        assertNull(actualBookNotFoundException.getLocalizedMessage());
        assertEquals("Book Not Found", actualBookNotFoundException.getErrorMessage());
        assertEquals("000002", actualBookNotFoundException.getErrorCode());
    }
}

