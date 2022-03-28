
public class HighSchoolStudent extends Student  
{
    int ACTscore, APclassesTaken, MCAscore11, credits;
    double GPA;


    public HighSchoolStudent(String name, String address, String gender)
    {
        super(name,address,gender,9);
        credits = 0;
    }

    public HighSchoolStudent(String name, String address, String gender, int grade, int credits)
    {
        super(name,address,gender,grade);
        this.credits = credits;
    }
    
    public void updateCredits(int creditsOfQuarter, double GPAofQuarter) {
        GPA=((GPA*credits)+(GPAofQuarter*creditsOfQuarter))/(double)(credits+creditsOfQuarter);
        addCredits(creditsOfQuarter);
    }
    
    public void addCredits(int addedCredits) {
        credits+=addedCredits;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public double getGPA() {
        return GPA;
    }
    
}
