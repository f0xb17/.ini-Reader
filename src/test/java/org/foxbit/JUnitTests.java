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

    final IniFileReader iniFileReader = new IniFileReader("src/main/java/org/foxbit/sample.ini");

    @Test
    public void testFilePath() {
        assertDoesNotThrow(() -> iniFileReader.getFilePath());
    }

    @Test
    public void testFetchContents() {
        assertDoesNotThrow(() -> iniFileReader.fetchContent());
    }

    @Test
    public void testContents() {
        try {
            iniFileReader.fetchContent();
        } catch (Exception ex) {
            System.out.println("Error while Test fetch: " + ex.getMessage());
        }
        assertEquals("John Doe", iniFileReader.getValue("owner", "name"));
        assertEquals("Acme Widgets Inc.", iniFileReader.getValue("owner", "organization"));
        assertEquals("192.0.2.62", iniFileReader.getValue("database", "server"));

        assertNotEquals("John Doe", iniFileReader.getValue("database", "server"));
        assertNotEquals("192.0.2.62", iniFileReader.getValue("owner", "name"));
    }
}
