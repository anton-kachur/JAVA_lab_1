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
