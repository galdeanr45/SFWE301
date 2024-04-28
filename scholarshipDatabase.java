import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class scholarshipDatabase {
    private ArrayList <scholarship> database; //This is our arraylist mock database
    private String filename; // Name of the text file
    private int fileNumber;
    
    public scholarshipDatabase(String fileNumber) { // Constructor with filename
        this.database = new ArrayList<scholarship>();
        this.fileNumber = Integer.parseInt(fileNumber);
        this.filename = "scholarshipDatabase" + fileNumber + ".txt";
        readFromTextFile(); // Read data from text file
    }

    private void readFromTextFile() {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line!= null) {
                    String[] parts = line.split(","); // Assuming comma-separated values
                    // Create scholarship object from parts and add to the database
                    scholarship newScholarship = new scholarship(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
                    database.add(newScholarship);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
    }
    ///// Start Overloaded constructors for the scholarshipDatabase class /////
    public scholarshipDatabase(ArrayList <scholarship> database){
        this.database = database;
    }
    ///// End Overloaded constructors for the scholarshipDatabase class /////
    
    public void addToDatabase(scholarship newScholarship) { 
        database.add(newScholarship);
        saveToTextFile(); // Save changes to text file
    }

    public void removeFromDatabase(String inputScholarshipName) { 
        boolean deleted = false;
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getScholarshipName().equals(inputScholarshipName)) {
                database.remove(i);
                deleted = true;
                break; // Break after deleting to avoid ConcurrentModificationException
            }
        }
        if (deleted) {
            System.out.println("Scholarship '" + inputScholarshipName + "' removed from database");
            saveToTextFile(); // Save changes to text file
        } else {
            System.out.println("Scholarship '" + inputScholarshipName + "' not found in database. No scholarships removed.");
        }
    }

    public void editScholarshipInDatabase(String inputScholarshipName, Scanner input) { 
        for (scholarship schol : database) {
            if (schol.getScholarshipName().equals(inputScholarshipName)) {
                int choice = 1;
                while (choice != 0) {
                    updateScholarshipMenu();
                    choice = input.nextInt();
                    input.nextLine(); // Clear the buffer
                    switch (choice) {
                        case 1:
                            System.out.print("Enter new payout: ");
                            int newPayout = input.nextInt();
                            input.nextLine(); // Clear the buffer
                            schol.setPayout(newPayout);
                            break;
                        case 2:
                            System.out.print("Enter new deadline: ");
                            String newDeadline = input.nextLine();
                            schol.setDeadline(newDeadline);
                            break;
                        case 3:
                            System.out.print("Enter new custom required information: (CSV)");
                            String newCustomRequiredInfo = input.nextLine();
                            schol.setCustomRequiredInfo(newCustomRequiredInfo);
                            break;
                        case 4:
                            System.out.print("Enter new preferred majors: ");
                            String newPreferredMajors = input.nextLine();
                            schol.setPreferedMajors(newPreferredMajors);
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                }
                saveToTextFile(); // Save changes to text file
                System.out.println("Scholarship '" + inputScholarshipName + "' edited in database");
                return;
            }
        }
        System.out.println("Scholarship '" + inputScholarshipName + "' not found in database. No scholarships edited.");
    }

    private void saveToTextFile() {
        if (fileNumber >= 5) {
            this.fileNumber = 1;
        }
        else {
            this.fileNumber++;
        }
        this.filename = "scholarshipDatabase" + Integer.toString(fileNumber) + ".txt";
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (scholarship schol : database) {
                writer.println(schol.getScholarshipName() + "," + schol.getPayout() + "," + schol.getCustomRequiredInfo() + "," + schol.getDeadline() + "," + schol.getPreferedMajors()); // Write each scholarship as a line in the text file
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
        try (PrintWriter writer2 = new PrintWriter("uDatabaseLog.txt")) {
            writer2.print(Integer.toString(fileNumber));
        }
        catch (FileNotFoundException e){
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    public void printDatabase(){
        System.out.println("\nStart of scholarship database records");
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            database.get(i).printScholarshipInfo(); //This prints the scholarship info
        }
        System.out.println("End of scholarship database records\n");
    }
    
    public scholarship searchByName(String inputScholarship){ 
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if (database.get(i).getScholarshipName().equals(inputScholarship)) { //This checks if the scholarship is in the database
                return database.get(i); //This returns the scholarship
            }
        }
        return null; //This returns null if the scholarship is not found
    }


    private void updateScholarshipMenu(){
        System.out.println("What would you like to update?");
        System.out.println("0) Exit");
        System.out.println("1) Payout");
        System.out.println("2) Deadline");
        System.out.println("3) Custom Required Information");
        System.out.println("4) Preferred Majors");
    }
}
