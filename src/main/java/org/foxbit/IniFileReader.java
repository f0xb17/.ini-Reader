//
//  IniFileReader.java
//  Class to read Ini Files without additional Frameworks
//
//  Created by f0xb17 on 12/21/2022.
//  Copyright © 2022 f0xb17. All rights reserved.
//

package org.foxbit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IniFileReader {

    private final String filePath;
    private Map<String, Map<String, String>> contents = new HashMap<>();

    /**
     * Constructor of the class which takes one argument.
     * @param filePath path/to/file
     */
    public IniFileReader(String filePath) {
        if (filePath.isBlank() || filePath == null) throw new NullPointerException();
        this.filePath = filePath;
    }

    /**
     * @return the file path entered by the user
     * @throws NullPointerException when filePath is blank or null.
     */
    public String getFilePath() throws NullPointerException {
        if (filePath.isBlank() || filePath == null) throw new NullPointerException();
        return this.filePath;
    }

    /**
     * This method is used to fetch the content from the .ini File. It separates the content by section, key and also the value of the key.
     * @throws IOException when something is wrong while reading.
     */
    public void fetchContent() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader((this.filePath)))) {
           String line, section = null;

           while ((line = bufferedReader.readLine()) != null) {
               line = line.trim();
               if (line.startsWith("[") && line.endsWith("]")) {
                   section = line.substring(1, line.length() - 1);
                   this.contents.put(section, new HashMap<>());
               } else if (section != null && line.contains("=")) {
                   int index = line.indexOf("=");
                   String key = line.substring(0, index).trim();
                   String value = line.substring(index + 1).trim();
                   this.contents.get(section).put(key, value);
               }
           }
           bufferedReader.close();
        } catch (Exception ex) {
            System.out.println("Error while fetching Contents: " + ex.getMessage());
        }
    }

    /**
     * This method returns the stored value in section x with key y.
     * @param section the section
     * @param key the key inside the section
     * @return the value of the key
     */
    public String getValue(String section, String key) {
        return contents.get(section).get(key);
    }

}
