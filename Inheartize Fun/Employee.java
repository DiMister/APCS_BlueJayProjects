

public abstract class Employee 
{
    String name;
    int weeklySalary, yearToDateSalary;
    boolean fulltime, benefits;

    public Employee(String name)
    {
        this.name = name;
    }
    
    public abstract double calculatePaycheck();
    
    public String displayPaycheck()
    {
        return
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setBenefits(boolean benefits)
    {
        this.benefits = benefits;
    }
    
    public void setFulltime(boolean fulltime)
    {
        this.fulltime = fulltime;
    }
    
    public String getName()
    {
        return name;
    }
}
