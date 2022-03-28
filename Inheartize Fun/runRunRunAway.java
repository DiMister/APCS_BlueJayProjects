import java.util.ArrayList;


public class runRunRunAway
{
    ArrayList<Student> districtRoster = new ArrayList<Student>();


    public runRunRunAway()
    {
        for(int index = 0; index < 2; index++) {
            districtRoster.add(new ElementaryStudent("mike"+index,"6 road","toster"));
            districtRoster.add(new MiddleSchoolStudent("brain"+index, "death ave", "mouse"));
            districtRoster.add(new HighSchoolStudent("who"+index,"first","based"));
            districtRoster.add(new ElementaryStudent("mike"+index,"6 road","toster",4));
            districtRoster.add(new MiddleSchoolStudent("brain"+index, "death ave", "mouse",7));
            districtRoster.add(new HighSchoolStudent("who"+index,"first","based",11,20));
    
        }
        
        gradeStuff(districtRoster.get(0));
        gradeStuff(districtRoster.get(1));
        GPAstuff((HighSchoolStudent)districtRoster.get(2),3.2,4);
        GPAstuff((HighSchoolStudent)districtRoster.get(2),3.6,4);
        GPAstuff((HighSchoolStudent)districtRoster.get(2),4.0,3);
    }

    private void gradeStuff(Student bruh) {
        System.out.println(bruh.getGrade());
        bruh.upGrade();
        System.out.println(bruh.getGrade());
    }
    
    private void GPAstuff(HighSchoolStudent bruh, double newGPA, int newCredits) {
        bruh.updateCredits(newCredits, newGPA);
        System.out.println(bruh.getGrade() + ", " + bruh.getCredits());
    }
    
}
