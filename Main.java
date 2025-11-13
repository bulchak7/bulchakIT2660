public class Main {
    public static void main(String[] args) {
        // Step 3: create a map
        MyMap<String, Integer> creditHours = new MyHashMap<>();

        // Step 4: add all key-value pairs
        creditHours.put("IT-1025", 3);
        creditHours.put("IT-1050", 3);
        creditHours.put("IT-1150", 3);
        creditHours.put("IT-2310", 3);
        creditHours.put("IT-2320", 4);
        creditHours.put("IT-2351", 4);
        creditHours.put("IT-2650", 4);
        creditHours.put("IT-2660", 4);
        creditHours.put("IT-2030", 4);

        // Step 5: check if keys exist
        System.out.println("Has IT-1025? " + creditHours.containsKey("IT-1025"));
        System.out.println("Has IT-2110? " + creditHours.containsKey("IT-2110"));

        // Step 6: print all entries
        System.out.println("All entries: " + creditHours);

        // Step 7: remove two classes
        creditHours.remove("IT-2030");
        creditHours.remove("IT-1150");

        // Step 8: print all values
        System.out.println("All values: " + creditHours.values());
    }
}