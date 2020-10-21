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
    


    //*************************************************************************************************
    //************************Class which contains map and its properties******************************
    //*************************************************************************************************
    


    //*************************************************************************************************
    //***************Class which contains all functions for map generating*****************************
    //*************************************************************************************************
    


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
