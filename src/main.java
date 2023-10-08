import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main{
	private static ArrayList<Driver_22033701> drivers = new ArrayList<>();
	public static void main(String[] args){
        readDriverData();
        dispLayMenu();
    }
        private static void readDriverData(){
            try{
                File file = new File("src/read_Driver.txt");
                if(!file.exists() || file.length() == 0){
                    System.out.print("Driver file is empty Not Found");
                    return;
                }
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    String[] data = scanner.nextLine().split(",");
                    Driver_22033701 driver = new Driver_22033701(data[0],data[1],data[2],data[3],data[4],data[5],data[6],Integer.parseInt(data[7]), data[8]);
                    drivers.add(driver);
                }
                scanner.close();
            }catch(FileNotFoundException e){
                System.out.print("Driver file not found");
            }
        }
        private static void dispLayMenu(){
            Scanner scanner = new Scanner(System.in);
            int picker;
            do{
                System.out.println("╔════════════════════════════════╗");
                System.out.println("║           Main Menu            ║");
                System.out.println("╠════════════════════════════════╣");
                System.out.println("║ 1. Display Drivers             ║");
                System.out.println("║ 2. Import Infringement File    ║");
                System.out.println("║ 3. Generate Suspension Report  ║");
                System.out.println("║ 4. Save Driver Records         ║");
                System.out.println("║ 5. Exit Program                ║");
                System.out.println("╚════════════════════════════════╝");
                System.out.print("Enter your choices: ");

                picker = scanner.nextInt();
                if(picker == 1){
                    displayDrivers();
                }
                else if(picker == 2){
                    importInfringementFile();
                }
                else if(picker == 3){
                    generateSuspensionReport();
                }
                else if(picker == 4){
                    saveDriverRecord();
                }
                else if(picker == 5){
                    exitProgram();
                }
                else{
                    System.out.println("Invalid Choice! Please Try Again!");
                }
            }while(picker!=5);
            scanner.close();
        }
        private static void displayDrivers(){
            System.out.println("Driver List: ");
            for(Driver_22033701 driver : drivers){
                System.out.println(driver);
            }
        }
        private static Driver_22033701 findDriverByLicenceNumber(String licenceNumber){
            for(Driver_22033701 driver : drivers){
                if(driver.getlicenceNumber().equals(licenceNumber)){
                    return driver;
                }
            }
            return null;
        }
        private static void importInfringementFile(){
            Scanner scanner = new Scanner(System.in);
            int totalInfringements = 0;
            int totalRevenue = 0;
            int totalLicenceSupended = 0;

            try{
                File file = new File("src/infringements.txt");
                Scanner infringementScanner = new Scanner(file);

                while(infringementScanner.hasNextLine()){
                    String[] infringementData = infringementScanner.nextLine().split(",");
                    String licenceNumber = infringementData[1];
                    int excessSpeed = Integer.parseInt(infringementData[3]);

                    Driver_22033701 driver = findDriverByLicenceNumber(licenceNumber);

                    if(driver != null){
                        int demeritPoints = SpeedingPenalty_22033701.getDemeritPoints(excessSpeed);
                        int fine = SpeedingPenalty_22033701.getFine(excessSpeed);
                        boolean suspension = SpeedingPenalty_22033701.requiresAutomaticSuspension(excessSpeed);

                        driver.setDemeritPoints(driver.getDemeritPoints() + demeritPoints);
                        totalRevenue += fine;

                        if(suspension){
                            driver.setLicenceStatus("Suspended");
                            totalLicenceSupended++;
                        }
                        totalInfringements++;
                    }
                }
                infringementScanner.close();
            }catch(FileNotFoundException e){
                System.out.print("Infringement file not found");
            }
            System.out.println("Summary Report:");
            System.out.println("Total Infringements: " + totalInfringements);
            System.out.println("Total Revenue: " + totalRevenue);
            System.out.println("Total Lincences Suspended: " + totalLicenceSupended);
        }

        private static void generateSuspensionReport(){
            boolean suspendedDriversCounter = false;

            for(Driver_22033701 driver : drivers){
                if("Suspended".equals(driver.getlicenceStatus())){
                    if(!suspendedDriversCounter){
                        System.out.println("Suspended Drivers: ");
                        System.out.printf("%-15s%-15s%-15s%-30s%-20s\n", "Lincene Number", "First Name", "Last Name", "Address", "Demerit Points");
                        suspendedDriversCounter = true;
                    }
                    //print result
                    System.out.printf("%-15s%-15s%-15s%-30s%-20s\n",
                        driver.getlicenceNumber(), driver.getfirstName(),driver.getLastName(),driver.getAddress(),driver.getDemeritPoints());
                }
            }
            if(!suspendedDriversCounter){
                System.out.println("No Suspended Drivers");
            }
            if(suspendedDriversCounter){
                System.out.println("End of Suspended Drivers Report");
            }
        }
        private static void saveDriverRecord(){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/driver.txt"));
                for(Driver_22033701 driver: drivers){
                    writer.write(driver.toString());
                    writer.newLine();
                }
                writer.close();
                System.out.println("Driver records saved successfully");
            }catch(IOException e){
                System.out.println("Error saving driver records. ");
            }
        }

        private static boolean hasUnsavedChanges = false;
        private static void exitProgram(){
            if(hasUnsavedChanges){
                System.out.println("Warning: There are unsaved changes in the driver records.");
                System.out.print("Do you want to save changes before exiting? (yes/no): ");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine().toLowerCase();

                if(response.equals("yes")){
                    saveDriverRecord();
                }
                else if(!response.equals("no")){
                    System.out.println("Invalid response. Returning to the Main Menu. ");
                    return;
                }
            }
            System.out.print("Are you sure you want to exit the program? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().toLowerCase();
            
            if(response.equals("yes")){
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            }
            else if(response.equals("no")){
                System.out.println("Returning to the Main Menu.");
                dispLayMenu();
            }
            else{
                System.out.println("Invalid Input, Returning to Main Menu");
                dispLayMenu();
            }
        }
}