public class StartUser extends user{
    private String sUserID;

    public StartUser(){ //Default constructor
        this.sUserID = "None";
    }

    ///// Start Overloaded constructors for the Start user class /////
    public StartUser(String sUserID){
        this.sUserID = sUserID;
    }
    ///// End Overloaded constructors for the Start user class /////

    ///// Start Getters and Setters for the Start user class /////
    public String getsUserID(){
        return sUserID;
    }
    public void setsUserID(String sUserID){
        this.sUserID = sUserID;
    }
    ///// End Getters and Setters for the Start user class /////
}
