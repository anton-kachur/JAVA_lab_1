 public static class Locality extends Building
    {
        private String locality_name;
        private String locality_type;

        private Locality(String name, String type) {
            super("Default name", name);

            locality_name = name;
            locality_type = type;
        }

        private String getName() { return locality_name; }

        public void printAll() { System.out.println("Name of locality: " + locality_name + "\nType of locality: " + locality_type); }
    }
