
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
}
