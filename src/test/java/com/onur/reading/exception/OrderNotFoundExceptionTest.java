package com.onur.reading.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class OrderNotFoundExceptionTest {
    /**
     * Method under test: default or parameterless constructor of {@link OrderNotFoundException}
     */
    @Test
    void testConstructor() {
        OrderNotFoundException actualOrderNotFoundException = new OrderNotFoundException();
        assertNull(actualOrderNotFoundException.getCause());
        assertEquals(0, actualOrderNotFoundException.getSuppressed().length);
        assertNull(actualOrderNotFoundException.getMessage());
        assertNull(actualOrderNotFoundException.getLocalizedMessage());
        assertEquals("Order Not Found", actualOrderNotFoundException.getErrorMessage());
        assertEquals("000003", actualOrderNotFoundException.getErrorCode());
    }
}

