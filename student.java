import java.util.ArrayList;
import java.util.Scanner; //this will be used to read in test data
//This student class inherits from the user class
public class student extends user{
    private String major;
    private double gpa;
    private String studentID; 
    private String citizenship;
    private int unitsEnrolled; 
    private String expectedGraduation;
    private String essayResponses; 
    private String bursarAccountReference;
    private ArrayList <scholarship> awardedScholarships; //This will store the scholarship objects that each student is awarded
    private ArrayList <application> submittedApplications; //This will store the application objects that each student submits

    

    public student(){//This is the default constructor for the student class
        this.major = "None";
        this.gpa = 0.0;
        this.studentID = "None";
        this.citizenship = "None";
        this.unitsEnrolled = 0;
        this.expectedGraduation = "None";
        this.essayResponses = "None"; 
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }
    ////// Overloaded constructors for the student class //////
    public student(String major){
        this.major = major;
        this.gpa = 0.0;
        this.studentID = "None";
        this.citizenship = "None";
        this.unitsEnrolled = 0;
        this.expectedGraduation = "None";
        this.essayResponses = "None";
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }
    public student(String major, double gpa){
        this.major = major;
        this.gpa = gpa;
        this.studentID = "None";
        this.citizenship = "None";
        this.unitsEnrolled = 0;
        this.expectedGraduation = "None";
        this.essayResponses = "None";
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }   
    public student(String major, double gpa, String studentID){
        this.major = major;
        this.gpa = gpa;
        this.studentID = studentID;
        this.citizenship = "None";
        this.unitsEnrolled = 0;
        this.expectedGraduation = "None";
        this.essayResponses = "None"; 
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }
    public student(String major, double gpa, String studentID, String citizenship){
        this.major = major;
        this.gpa = gpa;
        this.studentID = studentID;
        this.citizenship = citizenship;
        this.unitsEnrolled = 0;
        this.expectedGraduation = "None";
        this.essayResponses = "None"; 
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }
    public student(String major, double gpa, String studentID, String citizenship, int unitsEnrolled){
        this.major = major;
        this.gpa = gpa;
        this.studentID = studentID;
        this.citizenship = citizenship;
        this.unitsEnrolled = unitsEnrolled;
        this.expectedGraduation = "None";
        this.essayResponses = "None"; 
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }
    public student(String major, double gpa, String studentID, String citizenship, int unitsEnrolled, String expectedGraduation){
        this.major = major;
        this.gpa = gpa;
        this.studentID = studentID;
        this.citizenship = citizenship;
        this.unitsEnrolled = unitsEnrolled;
        this.expectedGraduation = expectedGraduation;
        this.essayResponses = "None"; 
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }
    public student(String major, double gpa, String studentID, String citizenship, int unitsEnrolled, String expectedGraduation, String essayResponses){
        this.major = major;
        this.gpa = gpa;
        this.studentID = studentID;
        this.citizenship = citizenship;
        this.unitsEnrolled = unitsEnrolled;
        this.expectedGraduation = expectedGraduation;
        this.essayResponses = essayResponses; 
        this.bursarAccountReference = "None";
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }
    public student(String major, double gpa, String studentID, String citizenship, int unitsEnrolled, String expectedGraduation, String essayResponses, String bursarAccountReference){
        this.major = major;
        this.gpa = gpa;
        this.studentID = studentID;
        this.citizenship = citizenship;
        this.unitsEnrolled = unitsEnrolled;
        this.expectedGraduation = expectedGraduation;
        this.essayResponses = essayResponses; 
        this.bursarAccountReference = bursarAccountReference;
        awardedScholarships = new ArrayList<>(); //This will store the scholarship objects that each student is awarded
        submittedApplications = new ArrayList<>(); //This will store the application objects that each student submits
    }

    //// End overloaded constructors for the student class //////

    ////// Mututators and accessors for the student class //////
    public void setMajor(String major){
        this.major = major;
    }
    public String getMajor(){
        return major;
    }
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public double getGpa(){
        return gpa;
    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }
    public String getStudentID(){
        return studentID;
    }
    public void setCitizenship(String citizenship){
        this.citizenship = citizenship;
    }
    public String getCitizenship(){
        return citizenship;
    }
    public void setUnitsEnrolled(int unitsEnrolled){
        this.unitsEnrolled = unitsEnrolled;
    }
    public int getUnitsEnrolled(){
        return unitsEnrolled;
    }
    public void setExpectedGraduation(String expectedGraduation){
        this.expectedGraduation = expectedGraduation;
    }
    public String getExpectedGraduation(){
        return expectedGraduation;
    }
    public void setEssayResponses(String essayResponses){
        this.essayResponses = essayResponses;
    }
    public String getEssayResponses(){
        return essayResponses;
    }
    public void setBursarAccountReference(String bursarAccountReference){
        this.bursarAccountReference = bursarAccountReference;
    }
    public String getBursarAccountReference(){
        return bursarAccountReference;
    }
    ////// End mututators and accessors for the student class //////
    
    public void printInfo(){
        super.printInfo();
        System.out.println("Major: " + this.major); 
        System.out.println("GPA: " + this.gpa);
        System.out.println("Student ID: " + this.studentID);
        System.out.println("Citizenship: " + this.citizenship);
        System.out.println("Units Enrolled: " + this.unitsEnrolled);
        System.out.println("Expected Graduation: " + this.expectedGraduation);
        System.out.println("Essay Responses: " + this.essayResponses); 
        System.out.println("Bursar Account Reference: " + this.bursarAccountReference);
        System.out.println("Awarded Scholarships: ");
        for(int i = 0; i < this.awardedScholarships.size(); i++){
            System.out.println(this.awardedScholarships.get(i).getScholarshipName());
        }
        System.out.println(); //Print and extra new line for formatting
        System.out.println("Submitted Applications:");
        for(int i = 0; i < this.submittedApplications.size(); i++){
            System.out.println(this.submittedApplications.get(i).getScholarshipName());
        }
        System.out.println(); //Print and extra new line for formatting
    }

    public void archiveAwardedScholarship(scholarship inputScholarship){
        this.awardedScholarships.add(inputScholarship); //This adds the scholarship to the student's awarded scholarships
        System.out.println("Scholarship '" + inputScholarship.getScholarshipName() + "' archived for student '" + this.getName() + "' since the student was awarded the scholarship");
    }

    public void applyForScholarship(scholarship inputScholarship){ //Maybe archive this somewhere
        Scanner scnr = new Scanner(System.in);
        application newApplication = new application();
        newApplication.setScholarshipName(inputScholarship.getScholarshipName());
        newApplication.setStudentID(this.studentID);
        System.out.println("Please enter the academic year you are applying for (i.e 2023-2024): ");
        String academicYear = scnr.nextLine();
        newApplication.setAcademicYear(academicYear);
        System.out.println("Application for scholarship '" + inputScholarship.getScholarshipName());
        System.out.println(inputScholarship.getCustomRequiredInfo());
        System.out.println("Please enter your responses to the following questions (seperated by commas): ");
        String studentAnswers = scnr.nextLine();
        essayQuestions(inputScholarship);
        String scholarshipResponses = studentAnswers + this.essayResponses; //This concatinates both the student's responses to the scholarship questions and their essay responses as well
        newApplication.setScholarshipResponses(scholarshipResponses);
        System.out.println("Would you like to submit your application? (y/n)");
        String submitApplication = scnr.nextLine();
        if(submitApplication.equals("y")){
            this.submittedApplications.add(newApplication);
            System.out.println("Application submitted");
        }
        else{
            System.out.println("Application not submitted");
        }
        scnr.close();
    }

    public void updateSavedApplications(String scholarshipName){
        Scanner scnr = new Scanner(System.in);
        for(int i = 0; i < this.submittedApplications.size(); i++){
            if(this.submittedApplications.get(i).getScholarshipName() == scholarshipName){
                application toEdit = this.submittedApplications.get(i);
                System.out.println("Previously saved application for scholarship '" + scholarshipName + "': ");
                System.out.println(this.submittedApplications.get(i).getScholarshipResponses());
                System.out.println("Please enter your responses to the following questions (seperated by commas): ");
                String studentAnswers = scnr.nextLine();
                System.out.println("Would you like to save the changes to your application? (y/n)");
                String saveApplication = scnr.nextLine();
                if(saveApplication.equals("y")){
                    toEdit.setScholarshipResponses(studentAnswers);
                    System.out.println("Application saved");
                }
                else{
                    System.out.println("Application not saved");
                }
            }
        }
        scnr.close();
    }

    public void essayQuestions(scholarship inputScholarship){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your responses to the following essay questions (seperated by commas): ");
        System.out.println("****Only answer the essay questions for this section.****");
        System.out.println(inputScholarship.getCustomRequiredInfo());
        String studentAnswers = scnr.nextLine();
        this.essayResponses = studentAnswers;
        scnr.close();
    }

    public void cleanStoredApplications(String currentAcademicYear){
        for(int i = 0; i < this.submittedApplications.size(); i++){
            if(this.submittedApplications.get(i).getScholarshipResponses() != currentAcademicYear){
                this.submittedApplications.remove(i); //This will remove all students stored applications that do not match the current academic year (i.e. 2021-2022 or 2023-2024)
            }
        }
        System.out.println("Stored applications cleaned. Only applications for the academic year '" + currentAcademicYear + "' remain.");
    }

}
