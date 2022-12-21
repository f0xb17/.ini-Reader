//
//  JUnitTests.java
//  Class to test the whole Process.
//
//  Created by f0xb17 on 12/21/2022.
//  Copyright © 2022 f0xb17. All rights reserved.
//

package org.foxbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class JUnitTests {

    @Test
    public void testFilePath() {
        try {
            final FetchINI fetchINI = new FetchINI("src/main/java/org/foxbit/sample.ini");
            assertDoesNotThrow(() -> fetchINI.getFilePath());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testFetchContents() {
        try {
            final FetchINI fetchINI = new FetchINI("src/main/java/org/foxbit/sample.ini");
            assertDoesNotThrow(() -> fetchINI.fetchContent());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testContents() {
        try {
            final FetchINI fetchINI = new FetchINI("src/main/java/org/foxbit/sample.ini");
            fetchINI.fetchContent();

            assertEquals("John Doe", fetchINI.getValue("owner", "name"));
            assertEquals("Acme Widgets Inc.", fetchINI.getValue("owner", "organization"));
            assertEquals("192.0.2.62", fetchINI.getValue("database", "server"));

            assertNotEquals("John Doe", fetchINI.getValue("database", "server"));
            assertNotEquals("192.0.2.62", fetchINI.getValue("owner", "name"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
