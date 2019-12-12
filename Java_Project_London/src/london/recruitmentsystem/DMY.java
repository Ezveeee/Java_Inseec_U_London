package london.recruitmentsystem;

public class DMY{

    // Attributes
    private String day;
    private String month;
    private String year;
    //______________________________
    
    
    // Constructors
    public DMY(String day, String month, String year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public DMY(DMY date){
        this.day = date.getDay();
        this.month = date.getMonth();
        this.year = date.getYear();
    }
    //______________________________
    
    
    // Methods
    public String getDay(){
        return this.day;
    }
    
    public String getMonth(){
        return this.month;
    }
    
    public String getYear(){
        return this.year;
    }
    //______________________________
}