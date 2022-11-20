package com.onur.reading.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRoles(Set)}
     *   <li>{@link User#setUsername(String)}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setId(123L);
        actualUser.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<>();
        actualUser.setRoles(roleSet);
        actualUser.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(roleSet, actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String, String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRoles(Set)}
     *   <li>{@link User#setUsername(String)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("janedoe", "jane.doe@example.org", "iloveyou");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setId(123L);
        actualUser.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<>();
        actualUser.setRoles(roleSet);
        actualUser.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(roleSet, actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
    }
}

