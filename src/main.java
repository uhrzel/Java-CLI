// Main.java
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static ArrayList<Driver_22033701> drivers = new ArrayList<>();

    public static void main(String[] args) {
        readDriverData();
        displayMainMenu();
    }
    private static void readDriverData() {
        try {
            File file = new File("src/read_Driver.txt");
            if (!file.exists() || file.length() == 0) {
                System.out.println("Driver file is empty or not found.");
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                Driver_22033701 driver = new Driver_22033701(
                        data[0], data[1], data[2], data[3],
                        data[4], data[5], data[6], Integer.parseInt(data[7]), data[8]);
                drivers.add(driver);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Driver file not found.");
        }
    }



    private static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Main Menu");
            System.out.println("1. Display Drivers");
            System.out.println("2. Import Infringement File");
            System.out.println("3. Generate Suspension Report");
            System.out.println("4. Save Driver Records");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayDrivers();
                    break;
                case 2:
                    importInfringementFile();
                    break;
                case 3:
                    generateSuspensionReport();
                    break;
                case 4:
                    saveDriverRecords();
                    break;
                case 5:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void displayDrivers() {
        // Display drivers based on user preference
        System.out.println("Driver List:");
        for (Driver_22033701 driver : drivers) {
            System.out.println(driver);
        }
    }

    private static void importInfringementFile() {
        // Same as before
        // ...
    }

    private static void generateSuspensionReport() {
        // Same as before
        // ...
    }

    private static void saveDriverRecords() {
  
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/driver.txt"));
            for (Driver_22033701 driver : drivers) {
                writer.write(driver.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("Driver records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving driver records.");
        }
    }

    private static void exitProgram() {
       
    }
}
