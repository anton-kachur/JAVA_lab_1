
    public class Building
    {
        private String name_of_building;
        private String name_of_locality;

        private Building(String name, String loc_name) {
            name_of_building = name;
            name_of_locality = loc_name;
        }

        public void printAll() { System.out.println("Name of building: " + name_of_building + "\nName of locality: " + name_of_locality); }
    }
