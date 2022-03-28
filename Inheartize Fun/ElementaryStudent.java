
public class ElementaryStudent extends Student
{
    public String teacher;
    public int MCAscore3, MCAscore5;

    public ElementaryStudent(String name, String address, String gender)
    {
        super(name,address,gender,1);
    }

    public ElementaryStudent(String name, String address, String gender, int grade)
    {
        super(name,address,gender,grade);
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    public void setMCAscore5(int MCAscore5) {
        this.MCAscore5 = MCAscore5;
    }

    public String getTeacher() {
        return teacher;
    }
    
    public int getMCAscore5() {
        return MCAscore5;
    }
}
