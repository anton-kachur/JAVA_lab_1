import java.lang.String;
import java.util.*;

//Anton Kachur TI-82
//Task: 7.Create a map using Java
//Patterns used: Builder

public class Java_lab1 {

    private static String [] road_types = {"Dirt", "Asphalt", "Paving stone"};
    private static String [] reservoir_types = {"Lake", "Sea", "Swamp", "River"};
    private static String [] locality_types = {"City", "Village", "Settlement"};
    private static String [] trees_types = {"Forest", "Steppe", "Forest-steppe"};
    private static String [] relief_types = {"Lowland", "Elevation", "Plateau", "Mountain", "Hollow"};
    private static Scanner input = new Scanner(System.in);


    //**************************Generates random name************************************************
    private static String generateName() {
        Random random = new Random();
        StringBuilder name = new StringBuilder("");

        for (int i=0; i<random.nextInt(50)+2; i++) {
            name.append(Character.toString((char)random.nextInt(25)+97));
        }

        System.out.println(name.toString());

        return name.toString().substring(0, 1).toUpperCase() + name.toString().substring(1);
    }


    //*************************************************************************************************
    //*******************All necessary classes*********************************************************
    //*************************************************************************************************
   
    private static class Reservoir
    {
        private String reservoir_type;
        private double depth;

        private Reservoir(String type, double d) {
            reservoir_type = type;
            depth = d;
        }

        private void printAll() {
            System.out.println("Reservoir type: " + reservoir_type + "\nDepth: " + depth);
        }
    }


    public static class Building
    {
        private String name_of_building;
        private String name_of_locality;

        private Building(String name, String loc_name) {
            name_of_building = name;
            name_of_locality = loc_name;
        }

        public void printAll() { System.out.println("Name of building: " + name_of_building + "\nName of locality: " + name_of_locality); }
    }


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


    private static class Trees
    {
        private String name;
        private String type;

        private Trees(String name, String type) {
            this.name = name;
            this.type = type;
        }

        private void printAll() {
            System.out.println("Name: " + name + "\nType: " + type);
        }
    }


    //*************************************************************************************************
    //************************Class which contains map and its properties******************************
    //*************************************************************************************************
    private static class Map
    {
        //*************************************************************************************************
        //**********************Nested class, because each map has its own relief**************************
        //*************************************************************************************************
        private static class Relief
        {
            private String name;
            private int height;

            //*********Sets name of relief based on its height above the sea level***************************
            private Relief(int h) {
                height = h;
                if (height > 0 && height < 200) name = relief_types[0];
                else if (height > 200 && height < 500) name = relief_types[1];
                else if (height > 500 && height < 2000) name = relief_types[2];
                else if (height > 2000) name = relief_types[3];
                else name = relief_types[4];
            }

            private void printAll() {
                System.out.println("Name of relief: " + name + "\nMeasure of relief: " + height);
            }

        }

        //***********************ArrayLists which contain map components**************************************
        private ArrayList<Road> roads = new ArrayList<>();
        private ArrayList<Reservoir> reservoirs = new ArrayList<>();
        private ArrayList<Building> buildings = new ArrayList<>();
        private ArrayList<Locality> localities = new ArrayList<>();
        private ArrayList<Trees> trees = new ArrayList<>();
        private ArrayList<Relief> reliefs = new ArrayList<>();

        //*************Function, that represents the list of localities on alphabetical order*****************
        private void listOfLocalities() {
            if (localities.size() < 1) {
                System.out.println("\nThere is no localities\n");
            } else {
                Collections.sort(localities, Comparator.comparing(Locality::getName));
                System.out.println("All localities in alphabetic order: ");

                for (int i=0; i<localities.size(); i++)
                    System.out.println(localities.get(i).locality_name);
            }
        }


        //**************Methods for setting map components and representing them*****************************
        private void printMap() {
            for (Road i: roads) i.printAll();
            for (Reservoir i: reservoirs) i.printAll();
            for (Building i: buildings) i.printAll();
            for (Locality i: localities) i.printAll();
            for (Trees i: trees) i.printAll();
            for (Relief i: reliefs) i.printAll();
        }

        private void setNewRoad(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                roads.add(new Road(road_types[random.nextInt(road_types.length)], random.nextInt(7)));
            }
        }

        private void setNewReservoir(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                reservoirs.add(new Reservoir(reservoir_types[random.nextInt(reservoir_types.length)], random.nextInt(1000)));
            }
        }

        private void setNewBuilding(int amount) {
            for (int i=0; i<amount; i++) {
                buildings.add(new Building("SomeBuilding", "SomeLocality"));
            }
        }

        private void setNewLocality(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                localities.add(new Locality(generateName(), locality_types[random.nextInt(locality_types.length)]));
            }
        }

        private void setNewTree(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                trees.add(new Trees("Something", trees_types[random.nextInt(trees_types.length)]));
            }
        }

        private void setNewRelief(int amount) {
            for (int i=0; i<amount; i++) {
                Random random = new Random();
                reliefs.add(new Relief(random.nextInt(5000)));
            }
        }

    }


    //*************************************************************************************************
    //***************Class which contains all functions for map generating*****************************
    //*************************************************************************************************
    public static abstract class Builder
    {
        public abstract void setRoads();
        public abstract void setReservoirs();
        public abstract void setBuildings();
        public abstract void setLocalities();
        public abstract void setLocalities(int number_of_localities);
        public abstract void setTrees();
        public abstract void setRelief();
        public abstract void setRoads(int n);
        public abstract void setReservoirs(int n);
        public abstract void setBuildings(int n);
        public abstract void setTrees(int n);
        public abstract void setRelief(int n);
    }


    //*************************************************************************************************
    //*****************************Class Builder extension*********************************************
    //*************************************************************************************************
    public static class MapBuilder extends Builder
    {
        private Map map = new Map();
        Random random = new Random();

        public void setRoads() {
            map.setNewRoad(random.nextInt(10));
        }
        public void setReservoirs() {
            map.setNewReservoir(random.nextInt(10));
        }
        public void setBuildings() {
            map.setNewBuilding(random.nextInt(10));
        }
        public void setLocalities() {
            map.setNewLocality(random.nextInt(10));
        }
        public void setTrees() {
            map.setNewTree(random.nextInt(10));
        }
        public void setRelief() {
            map.setNewRelief(random.nextInt(10));
        }

        public void setRoads(int n) {
            map.setNewRoad(n);
        }
        public void setReservoirs(int n) {
            map.setNewReservoir(random.nextInt(n));
        }
        public void setBuildings(int n) { map.setNewBuilding(random.nextInt(n)); }
        public void setLocalities(int number_of_localities) { map.setNewLocality(number_of_localities); }
        public void setTrees(int n) {
            map.setNewTree(random.nextInt(n));
        }
        public void setRelief(int n) {
            map.setNewRelief(random.nextInt(n));
        }

        private Map resultMap() { return map; }
    }


    //*************************************************************************************************
    //*****Class, responsible for defining type of map and set of instructions for its generation******
    //*************************************************************************************************
    private static class Director
    {
        //********************Creates random map*****************************************************
        private void createDefaultMap(Builder builder)
        {
            builder.setRoads();
            builder.setReservoirs();
            builder.setBuildings();
            builder.setLocalities();
            builder.setTrees();
            builder.setRelief();
        }

        //********************Creates map, customized by user****************************************
        private void createUserMap(Builder builder)
        {
            System.out.println("Enter the number of roads: ");
            builder.setRoads(input.nextInt());
            System.out.println("Enter the number of reservoirs: ");
            builder.setReservoirs(input.nextInt());
            System.out.println("Enter the number of buildings: ");
            builder.setBuildings(input.nextInt());
            System.out.println("Enter the number of localities: ");
            builder.setLocalities(input.nextInt());
            System.out.println("Enter the number of trees: ");
            builder.setTrees(input.nextInt());
            System.out.println("Enter the number of relief: ");
            builder.setRelief(input.nextInt());
        }
    }

    //*************************************************************************************************
    //**************************Creates application****************************************************
    //*************************************************************************************************
    private static class Application
    {
        private void makeMap(Choice choice)
        {
            Director director = new Director();
            MapBuilder builder = new MapBuilder();

            switch(choice) {
                case RANDOM: director.createDefaultMap(builder); break;
                case CUSTOM: director.createUserMap(builder); break;
            }

            Map map = builder.resultMap();
            map.printMap();
            map.listOfLocalities();
        }

    }


    public enum Choice {
        RANDOM,
        CUSTOM;
    };


    public static void main (String []args)
    {
        Application app = new Application();
        System.out.println("What kind of map do you want?\n1->Random map;\n2->Custom map;\nYour choice: ");

        switch (input.nextInt()) {
            case 1: app.makeMap(Choice.RANDOM); break;
            case 2: app.makeMap(Choice.CUSTOM); break;
            default: System.out.println("Invalid input"); break;
        }

    }
}
