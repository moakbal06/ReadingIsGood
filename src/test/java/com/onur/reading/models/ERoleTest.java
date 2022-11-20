package com.onur.reading.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ERoleTest {
    /**
     * Method under test: {@link ERole#valueOf(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValueOf() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.onur.reading.models.ERole.Name
        //       at java.lang.Enum.valueOf(Enum.java:240)
        //       at com.onur.reading.models.ERole.valueOf(ERole.java:3)
        //   In order to prevent valueOf(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   valueOf(String).
        //   See https://diff.blue/R013 to resolve this issue.

        ERole.valueOf("Name");
    }

    /**
     * Method under test: {@link ERole#valueOf(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValueOf2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.onur.reading.models.ERole.foo
        //       at java.lang.Enum.valueOf(Enum.java:240)
        //       at com.onur.reading.models.ERole.valueOf(ERole.java:3)
        //   In order to prevent valueOf(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   valueOf(String).
        //   See https://diff.blue/R013 to resolve this issue.

        ERole.valueOf("foo");
    }

    /**
     * Method under test: {@link ERole#valueOf(String)}
     */
    @Test
    void testValueOf3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        ERole.valueOf("ROLE_ADMIN");
    }

    /**
     * Method under test: {@link ERole#valueOf(String)}
     */
    @Test
    void testValueOf4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        ERole.valueOf("ROLE_MODERATOR");
    }

    /**
     * Method under test: {@link ERole#valueOf(String)}
     */
    @Test
    void testValueOf5() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        ERole.valueOf("ROLE_USER");
    }

    /**
     * Method under test: {@link ERole#values()}
     */
    @Test
    void testValues() {
        ERole[] actualValuesResult = ERole.values();
        assertEquals(3, actualValuesResult.length);
        assertEquals(ERole.ROLE_USER, actualValuesResult[0]);
        assertEquals(ERole.ROLE_MODERATOR, actualValuesResult[1]);
        assertEquals(ERole.ROLE_ADMIN, actualValuesResult[2]);
    }
}

