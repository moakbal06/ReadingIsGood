package com.onur.reading.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EnumResetPasswordTest {
    /**
     * Method under test: {@link EnumResetPassword#valueOf(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValueOf() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.onur.reading.models.EnumResetPassword.Name
        //       at java.lang.Enum.valueOf(Enum.java:240)
        //       at com.onur.reading.models.EnumResetPassword.valueOf(EnumResetPassword.java:3)
        //   In order to prevent valueOf(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   valueOf(String).
        //   See https://diff.blue/R013 to resolve this issue.

        EnumResetPassword.valueOf("Name");
    }

    /**
     * Method under test: {@link EnumResetPassword#valueOf(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValueOf2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.onur.reading.models.EnumResetPassword.foo
        //       at java.lang.Enum.valueOf(Enum.java:240)
        //       at com.onur.reading.models.EnumResetPassword.valueOf(EnumResetPassword.java:3)
        //   In order to prevent valueOf(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   valueOf(String).
        //   See https://diff.blue/R013 to resolve this issue.

        EnumResetPassword.valueOf("foo");
    }

    /**
     * Method under test: {@link EnumResetPassword#valueOf(String)}
     */
    @Test
    void testValueOf3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        EnumResetPassword.valueOf("AVAILABLE");
    }

    /**
     * Method under test: {@link EnumResetPassword#valueOf(String)}
     */
    @Test
    void testValueOf4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        EnumResetPassword.valueOf("EXPIRED");
    }

    /**
     * Method under test: {@link EnumResetPassword#valueOf(String)}
     */
    @Test
    void testValueOf5() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        EnumResetPassword.valueOf("USED");
    }

    /**
     * Method under test: {@link EnumResetPassword#values()}
     */
    @Test
    void testValues() {
        EnumResetPassword[] actualValuesResult = EnumResetPassword.values();
        assertEquals(3, actualValuesResult.length);
        assertEquals(EnumResetPassword.AVAILABLE, actualValuesResult[0]);
        assertEquals(EnumResetPassword.USED, actualValuesResult[1]);
        assertEquals(EnumResetPassword.EXPIRED, actualValuesResult[2]);
    }
}

