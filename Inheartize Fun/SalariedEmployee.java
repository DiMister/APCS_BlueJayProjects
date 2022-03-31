
public class SalariedEmployee extends Employee
{
    int yearlySalary;

    public SalariedEmployee(String name, int yearlySalary)
    {
        super(name);
        this.yearlySalary = yearlySalary;
        benefits = true;
        fulltime = true;
    }

    @Override
    public double calculatePaycheck()
    {
        return yearlySalary / 52;
    }
    
    public String displayPaycheck()
    {
        return "" + yearlySalary + " / " + 52 + " = " + super.displayPaycheck();
    }
    
    public String getAllInfo()
    {
        return super.getAllInfo("Salaried", "" + yearlySalary, "nein"); 
    }
}
