package com.onur.reading.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class OutOfStockExceptionTest {
    /**
     * Method under test: default or parameterless constructor of {@link OutOfStockException}
     */
    @Test
    void testConstructor() {
        OutOfStockException actualOutOfStockException = new OutOfStockException("An error occurred");
        assertNull(actualOutOfStockException.getCause());
        assertEquals(0, actualOutOfStockException.getSuppressed().length);
        assertNull(actualOutOfStockException.getMessage());
        assertNull(actualOutOfStockException.getLocalizedMessage());
        assertEquals("An error occurred", actualOutOfStockException.getErrorMessage());
        assertEquals("000003", actualOutOfStockException.getErrorCode());
    }
}

