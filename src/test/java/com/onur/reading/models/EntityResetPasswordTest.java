package com.onur.reading.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class EntityResetPasswordTest {
    /**
     * Method under test: {@link EntityResetPassword#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new EntityResetPassword()).canEqual("Other"));
    }

    /**
     * Method under test: {@link EntityResetPassword#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        EntityResetPassword entityResetPassword = new EntityResetPassword();

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword1 = new EntityResetPassword();
        entityResetPassword1.setCode("Code");
        entityResetPassword1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setId(1);
        entityResetPassword1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword1.setUser(user);
        assertTrue(entityResetPassword.canEqual(entityResetPassword1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EntityResetPassword#EntityResetPassword()}
     *   <li>{@link EntityResetPassword#setCode(String)}
     *   <li>{@link EntityResetPassword#setDate(Date)}
     *   <li>{@link EntityResetPassword#setId(Integer)}
     *   <li>{@link EntityResetPassword#setStatus(EnumResetPassword)}
     *   <li>{@link EntityResetPassword#setUser(User)}
     * </ul>
     */
    @Test
    void testConstructor() {
        EntityResetPassword actualEntityResetPassword = new EntityResetPassword();
        actualEntityResetPassword.setCode("Code");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualEntityResetPassword.setDate(fromResult);
        actualEntityResetPassword.setId(1);
        actualEntityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        actualEntityResetPassword.setUser(user);
        assertEquals("Code", actualEntityResetPassword.getCode());
        assertSame(fromResult, actualEntityResetPassword.getDate());
        assertEquals(1, actualEntityResetPassword.getId().intValue());
        assertEquals(EnumResetPassword.AVAILABLE, actualEntityResetPassword.getStatus());
        assertSame(user, actualEntityResetPassword.getUser());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EntityResetPassword#EntityResetPassword(Integer, User, String, EnumResetPassword, Date)}
     *   <li>{@link EntityResetPassword#setCode(String)}
     *   <li>{@link EntityResetPassword#setDate(Date)}
     *   <li>{@link EntityResetPassword#setId(Integer)}
     *   <li>{@link EntityResetPassword#setStatus(EnumResetPassword)}
     *   <li>{@link EntityResetPassword#setUser(User)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        EntityResetPassword actualEntityResetPassword = new EntityResetPassword(1, user, "Code",
                EnumResetPassword.AVAILABLE, Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        actualEntityResetPassword.setCode("Code");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualEntityResetPassword.setDate(fromResult);
        actualEntityResetPassword.setId(1);
        actualEntityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");
        actualEntityResetPassword.setUser(user1);
        assertEquals("Code", actualEntityResetPassword.getCode());
        assertSame(fromResult, actualEntityResetPassword.getDate());
        assertEquals(1, actualEntityResetPassword.getId().intValue());
        assertEquals(EnumResetPassword.AVAILABLE, actualEntityResetPassword.getStatus());
        assertSame(user1, actualEntityResetPassword.getUser());
    }

    /**
     * Method under test: {@link EntityResetPassword#equals(Object)}
     */
    @Test
    void testEquals() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword = new EntityResetPassword();
        entityResetPassword.setCode("Code");
        entityResetPassword.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setId(1);
        entityResetPassword.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword.setUser(user);
        assertNotEquals(entityResetPassword, null);
    }

    /**
     * Method under test: {@link EntityResetPassword#equals(Object)}
     */
    @Test
    void testEquals2() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword = new EntityResetPassword();
        entityResetPassword.setCode("Code");
        entityResetPassword.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setId(1);
        entityResetPassword.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword.setUser(user);
        assertNotEquals(entityResetPassword, "Different type to EntityResetPassword");
    }

    /**
     * Method under test: {@link EntityResetPassword#equals(Object)}
     */
    @Test
    void testEquals3() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword = new EntityResetPassword();
        entityResetPassword.setCode("Code");
        entityResetPassword.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setId(1);
        entityResetPassword.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword.setUser(user);
        assertEquals(entityResetPassword, entityResetPassword);
        int expectedHashCodeResult = entityResetPassword.hashCode();
        assertEquals(expectedHashCodeResult, entityResetPassword.hashCode());
    }

    /**
     * Method under test: {@link EntityResetPassword#equals(Object)}
     */
    @Test
    void testEquals4() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword = new EntityResetPassword();
        entityResetPassword.setCode("Code");
        entityResetPassword.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setId(1);
        entityResetPassword.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");

        EntityResetPassword entityResetPassword1 = new EntityResetPassword();
        entityResetPassword1.setCode("Code");
        entityResetPassword1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setCreatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setId(1);
        entityResetPassword1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword1.setUser(user1);
        assertNotEquals(entityResetPassword, entityResetPassword1);
    }

    /**
     * Method under test: {@link EntityResetPassword#equals(Object)}
     */
    @Test
    void testEquals5() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword = new EntityResetPassword();
        entityResetPassword.setCode("Code");
        entityResetPassword.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setId(123);
        entityResetPassword.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");

        EntityResetPassword entityResetPassword1 = new EntityResetPassword();
        entityResetPassword1.setCode("Code");
        entityResetPassword1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setCreatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setId(1);
        entityResetPassword1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword1.setUser(user1);
        assertNotEquals(entityResetPassword, entityResetPassword1);
    }

    /**
     * Method under test: {@link EntityResetPassword#equals(Object)}
     */
    @Test
    void testEquals6() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword = new EntityResetPassword();
        entityResetPassword.setCode("Code");
        entityResetPassword.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setId(null);
        entityResetPassword.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");

        EntityResetPassword entityResetPassword1 = new EntityResetPassword();
        entityResetPassword1.setCode("Code");
        entityResetPassword1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setCreatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setId(1);
        entityResetPassword1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword1.setUser(user1);
        assertNotEquals(entityResetPassword, entityResetPassword1);
    }

    /**
     * Method under test: {@link EntityResetPassword#equals(Object)}
     */
    @Test
    void testEquals7() {
        User user = mock(User.class);
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRoles((java.util.Set<Role>) any());
        doNothing().when(user).setUsername((String) any());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");

        EntityResetPassword entityResetPassword = new EntityResetPassword();
        entityResetPassword.setCode("Code");
        entityResetPassword.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setId(1);
        entityResetPassword.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword.setLastModifiedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword.setUser(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");

        EntityResetPassword entityResetPassword1 = new EntityResetPassword();
        entityResetPassword1.setCode("Code");
        entityResetPassword1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setCreatedDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setId(1);
        entityResetPassword1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        entityResetPassword1.setLastModifiedDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        entityResetPassword1.setStatus(EnumResetPassword.AVAILABLE);
        entityResetPassword1.setUser(user1);
        assertNotEquals(entityResetPassword, entityResetPassword1);
    }
}

