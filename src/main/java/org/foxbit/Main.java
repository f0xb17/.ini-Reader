package org.foxbit;

public class Main {
    public static void main(String[] args) {

        try {
            FetchINI fetchINI = new FetchINI("src/main/java/org/foxbit/sample.ini");

            fetchINI.fetchContent();

            System.out.println(fetchINI.getValue("owner", "name"));
            System.out.println(fetchINI.getValue("owner", "organization"));

            System.out.println(fetchINI.getValue("database", "server"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}