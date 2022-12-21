package org.foxbit;

public class Main {
    public static void main(String[] args) {

        try {
            IniFileReader iniFileReader = new IniFileReader("src/main/java/org/foxbit/sample.ini");

            iniFileReader.fetchContent();

            System.out.println(iniFileReader.getValue("owner", "name"));
            System.out.println(iniFileReader.getValue("owner", "organization"));

            System.out.println(iniFileReader.getValue("database", "server"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}