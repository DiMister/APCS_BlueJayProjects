
public class Student
{
    public String name, gender, address;
    public int grade, studentID;

    public Student(String name, String address, String gender,int grade)
    {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.grade = grade;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void upGrade() {
        grade++;
    }

    public String getName() {
        return name;
    }
    
    public int getGrade() {
        return grade;
    }
    
}
