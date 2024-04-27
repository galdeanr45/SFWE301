import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class userDatabase {
    private ArrayList <user> database; //This is our arraylist mock database
    private String fileName;

    public userDatabase(String file){ //This is the default constructor
        this.database = new ArrayList<>();
        this.fileName = file;

        readFromTextFile();
    }

    private void readFromTextFile() {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line!= null) {
                    String[] parts = line.split(","); // Assuming comma-separated values
                    String userName = parts[0];
                    String userEmail = parts[1];
                    String userSQuestion = parts[2];
                    String userSAnswer = parts[3];
                    String userPermissions = parts[4];
                    // Create scholarship object from parts and add to the database
                    if(userPermissions.equals("student")){
                        student newStudent = new student();
                        newStudent.setUserPermission(userPermissions); //Sets the user permission
                        newStudent.setName(userName);
                        newStudent.setEmailAddress(userEmail);
                        newStudent.setSecurityQuestion(userSQuestion);
                        newStudent.setSecurityQuestionAnswers(userSAnswer);
                        newStudent.setMajor(parts[5]);
                        newStudent.setGpa(Double.parseDouble(parts[6]));
                        newStudent.setStudentID(parts[7]);
                        newStudent.setCitizenship(parts[8]);
                        newStudent.setUnitsEnrolled(Integer.parseInt(parts[9]));
                        newStudent.setExpectedGraduation(parts[10]);
                        newStudent.setEssayResponses(parts[11]);
                        newStudent.setBursarAccountReference(parts[12]);
                        database.add(newStudent);
                        //Print a new line before the menu comes back up
                    }
                    else if(userPermissions.equals("admin")){
                        Admin newAdmin = new Admin();
                        newAdmin.setUserPermission(userPermissions); //Sets the user permission
                        newAdmin.setUserPermission(userPermissions); //Sets the user permission
                        newAdmin.setName(userName);
                        newAdmin.setEmailAddress(userEmail);
                        newAdmin.setSecurityQuestion(userSQuestion);
                        newAdmin.setSecurityQuestionAnswers(userSAnswer);
                        newAdmin.setAdminID(parts[5]);
                        database.add(newAdmin);
                    }
                    else if(userPermissions.equals("donor")){
                        donor newDonor = new donor();
                        newDonor.setUserPermission(userPermissions); //Sets the user permission
                        newDonor.setUserPermission(userPermissions); //Sets the user permission
                        newDonor.setName(userName);
                        newDonor.setEmailAddress(userEmail);
                        newDonor.setSecurityQuestion(userSQuestion);
                        newDonor.setSecurityQuestionAnswers(userSAnswer);
                        newDonor.setBursarAccountReference(parts[5]);
                        newDonor.setDonorID(parts[6]);
                        database.add(newDonor);
                    }
                    else if(userPermissions.equals("reviewer")){
                        reviewer newReviewer = new reviewer();
                        newReviewer.setUserPermission(userPermissions);  //Sets the user permission
                        newReviewer.setUserPermission(userPermissions); //Sets the user permission
                        newReviewer.setName(userName);
                        newReviewer.setEmailAddress(userEmail);
                        newReviewer.setSecurityQuestion(userSQuestion);
                        newReviewer.setSecurityQuestionAnswers(userSAnswer);
                        newReviewer.setReviewerID(parts[5]);
                        database.add(newReviewer);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }

    private void writeToFile() {
        try (PrintWriter bw = new PrintWriter(new FileWriter(fileName))) {
            for (user user : database) {
                if (user.getUserPermission().equals("student")) {
                    bw.println(
                        user.getName() + "," +
                        user.getEmailAddress() + "," + 
                        user.getSecurityQuestion() + "," + 
                        user.getSecurityQuestionAnswers() + "," + 
                        user.getUserPermission() + ","
                    );
                }
                else if (user.getUserPermission().equals("admin")) {
                    bw.println(
                        user.getName() + "," +
                        user.getEmailAddress() + "," + 
                        user.getSecurityQuestion() + "," + 
                        user.getSecurityQuestionAnswers() + "," + 
                        user.getUserPermission() + ","
                    );
                }
                else if (user.getUserPermission().equals("donor")) {
                    bw.println(
                        user.getName() + "," +
                        user.getEmailAddress() + "," + 
                        user.getSecurityQuestion() + "," + 
                        user.getSecurityQuestionAnswers() + "," + 
                        user.getUserPermission() + ","
                    );
                }
                else if (user.getUserPermission().equals("reviewer")) {
                    bw.println(
                        user.getName() + "," +
                        user.getEmailAddress() + "," + 
                        user.getSecurityQuestion() + "," + 
                        user.getSecurityQuestionAnswers() + "," + 
                        user.getUserPermission() + ","
                    );
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    ///// Start Overloaded constructors for the userDatabase class /////
    public userDatabase(ArrayList <user> database){
        this.database = database;
    }
    ///// End Overloaded constructors for the userDatabase class /////
    
    public void addToDatabase(user newUser){ 
        database.add(newUser); //This adds a new scholarship to the database
        writeToFile();
    }

    
    public void removeFromDatabase(String ID){
        boolean deleted = false; //This is a boolean to check if the user was deleted
        for (int i = 0; i < database.size(); i++) { //This loops through the database
            String userType = database.get(i).getUserPermission(); //This gets the user type
            user foundUser = database.get(i);  //This gets the user in the database
            if(userType.equals("admin")){
                Admin adminUser = (Admin) foundUser; //Typecast to admin child class
                if(adminUser.getAdminID().equals(ID)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else if(userType.equals("reviewer")){
                reviewer reviewerUser = (reviewer) foundUser; //Typecast to reviewer child class
                if(reviewerUser.getReviewerID().equals(ID)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else if(userType.equals("student")){
                student studentUser = (student) foundUser; //Typecast to student child class
                if(studentUser.getStudentID().equals(ID)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else if(userType.equals("donor")){
                donor donorUser = (donor) foundUser; //Typecast to donor child class
                if(donorUser.getDonorID().equals(ID)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else{
                //This should never execute just leaving in for sanity check
                System.out.println("Error: User type not found");
            }
        }
        if(deleted == false){ //This checks if the user was deleted
            System.out.println("User '" + ID + "' not found in database. No users removed.");
        }
        else{
            System.out.println("User '" + ID + "' removed from database");
            writeToFile();
        }
    }


    public void editUserInDatabase(String ID, Scanner input){ 
        boolean found = false; //This is a boolean to check if the user was found
        for(int i = 0; i < database.size(); i++){
            String userType = database.get(i).getUserPermission(); //This gets the user type
            user foundUser = database.get(i);  //This gets the user in the database
            if(userType.equals("admin")){
                Admin adminUser = (Admin) foundUser; //Typecast to admin child class
                if(adminUser.getAdminID().equals(ID)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateAdminMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateAdmin(adminUser, userChoice, input);
                    found = true;
                }
            }
            else if(userType.equals("reviewer")){
                reviewer reviewerUser = (reviewer) foundUser; //Typecast to reviewer child class
                if(reviewerUser.getReviewerID().equals(ID)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateReviewerMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateReviewer(reviewerUser, userChoice, input);
                    found = true;
                }
            }
            else if(userType.equals("student")){
                student studentUser = (student) foundUser; //Typecast to student child class
                if(studentUser.getStudentID().equals(ID)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateStudentMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateStudent(studentUser, userChoice, input);
                    found = true;
                }
            }
            else if(userType.equals("donor")){
                donor donorUser = (donor) foundUser; //Typecast to donor child class
                if(donorUser.getDonorID().equals(ID)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateDonorMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateDonor(donorUser, userChoice, input);
                    found = true;
                }
            }
            else{
                //This should never execute just leaving in for sanity check
                System.out.println("Error: User type not found");
            }
        }
        if(found == false){ //This checks if the user was found
            System.out.println("User '" + ID + "' not found in database. No users edited.");
        }
        else{
            System.out.println("User '" + ID + "' edited in database");
            writeToFile();
        }
    }


    public user searchByName(String inputUser){
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if (database.get(i).getName().equals(inputUser)){ //This checks if the user is in the database
                return database.get(i); //This returns the user
            }
        }
        return null; //This returns null if the user is not found
    }

    public void printDatabase(){
        System.out.println("\nStart of user database records");
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if(database.get(i).getUserPermission().equals("admin")){
                Admin foundAdmin = (Admin) database.get(i);
                foundAdmin.printInfo();
            }
            else if(database.get(i).getUserPermission().equals("donor")){
                donor foundDonor = (donor) database.get(i);
                foundDonor.printInfo();
            }
            else if(database.get(i).getUserPermission().equals("reviewer")){
                reviewer foundReviewer = (reviewer) database.get(i);
                foundReviewer.printInfo();
            }
            else if(database.get(i).getUserPermission().equals("student")){
                student foundStudent = (student) database.get(i);
                foundStudent.printInfo();
            }
            else{
                System.out.println("**** Error occured ****");
            }
        }
        System.out.println("End of user database records\n");
    }

    public user searchByID(String inputID){
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if(database.get(i).getUserPermission().equals("admin")){
                Admin adminUser = (Admin) database.get(i); //Typecast to admin child class
                if(adminUser.getAdminID().equals(inputID)){
                    return (user) adminUser;
                }
            }
            else if(database.get(i).getUserPermission().equals("reviewer")){
                reviewer reviewerUser = (reviewer) database.get(i); //Typecast to reviewer child class
                if(reviewerUser.getReviewerID().equals(inputID)){
                    return (user) reviewerUser;
                }
            }
            else if(database.get(i).getUserPermission().equals("student")){
                student studentUser = (student) database.get(i); //Typecast to student child class
                if(studentUser.getStudentID().equals(inputID)){
                    return (user) studentUser;
                }
            }
            else if(database.get(i).getUserPermission().equals("donor")){
                donor donorUser = (donor) database.get(i); //Typecast to donor child class
                if(donorUser.getDonorID().equals(inputID)){
                    return (user) donorUser;
                }
            }
            else{
                //This should never execute just leaving in for sanity check
                System.out.println("Error: User type not found");
            }
        }
        return null; //This returns null if the user is not found
    }
    

    private void updateUserMenu(){
        System.out.println("0) Exit");
        System.out.println("1) Update Name");
        System.out.println("2) Update Email");
        System.out.println("3) Update Security Question");
        System.out.println("4) Update Security Question Answers");
    }
    private void updateStudentMenu(){
        System.out.println("5) Update Major");
        System.out.println("6) Update GPA");
        System.out.println("7) Update Student ID");
        System.out.println("8) Update Citizenship");
        System.out.println("9) Update Units Enrolled");
        System.out.println("10) Update Expected Graduation");
        System.out.println("11) Update Essay Responses");
        System.out.println("12) Update Bursar Account Reference");
    }
    private void updateReviewerMenu(){
        System.out.println("5) Update Reviewer ID");
    }
    private void updateDonorMenu(){
        System.out.println("5) Update Bursar Account Reference");
        System.out.println("6) Update Donor ID");
    }
    private void updateAdminMenu(){
        System.out.println("5) Update Admin ID");
    }
     

    private void updateAdmin(Admin adminUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            adminUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            adminUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            adminUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            adminUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Admin ID
            System.out.print("Enter new admin ID: ");
            String newAdminID = input.nextLine();
            adminUser.setAdminID(newAdminID);
        }
        else{
            System.out.println("Invalid option. Please try again.");
        }
    }

    private void updateReviewer(reviewer reviewerUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            reviewerUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            reviewerUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            reviewerUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            reviewerUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Reviewer ID
            System.out.print("Enter new reviewer ID: ");
            String newReviewerID = input.nextLine();
            reviewerUser.setReviewerID(newReviewerID);
        }
        else{
            System.out.println("Invalid option. Please try again.");
        }
    }

    private void updateStudent(student studentUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            studentUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            studentUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            studentUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            studentUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Major
            System.out.print("Enter new major: ");
            String newMajor = input.nextLine();
            studentUser.setMajor(newMajor);
        }
        else if(userChoice == 6){ //GPA
            System.out.print("Enter new GPA: ");
            double newGPA = input.nextDouble();
            studentUser.setGpa(newGPA);
        }
        else if(userChoice == 7){ //Student ID
            System.out.print("Enter new student ID: ");
            String newStudentID = input.nextLine();
            studentUser.setStudentID(newStudentID);
        }
        else if(userChoice == 8){ //Citizenship
            System.out.print("Enter new citizenship: ");
            String newCitizenship = input.nextLine();
            studentUser.setCitizenship(newCitizenship);
        }
        else if(userChoice == 9){ //Units Enrolled
            System.out.print("Enter new units enrolled: ");
            int newUnitsEnrolled = input.nextInt();
            input.nextLine(); //This is to clear the buffer
            studentUser.setUnitsEnrolled(newUnitsEnrolled);
        }
        else if(userChoice == 10){ //Expected Graduation
            System.out.print("Enter new expected graduation: ");
            String newExpectedGraduation = input.nextLine();
            studentUser.setExpectedGraduation(newExpectedGraduation);
        }
        else if(userChoice == 11){ //Essay Responses
            System.out.print("Enter new essay responses: ");
            String newEssayResponses = input.nextLine();
            studentUser.setEssayResponses(newEssayResponses);
        }
    }

    private void updateDonor(donor donorUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            donorUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            donorUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            donorUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            donorUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Bursar Account Reference
            System.out.print("Enter new bursar account reference: ");
            String newBursarAccountReference = input.nextLine();
            donorUser.setBursarAccountReference(newBursarAccountReference);
        }
        else if(userChoice == 6){ //Donor ID
            System.out.print("Enter new donor ID: ");
            String newDonorID = input.nextLine();
            donorUser.setDonorID(newDonorID);
        }
        else{
            System.out.println("Invalid option. Please try again.");
        }
    }
}
