

public class HourlyEmployee extends Employee
{
    int hoursWorked, wagePerHour;

    public HourlyEmployee(String name, int wagePerHour)
    {
        super(name);
        this.wagePerHour = wagePerHour;
        benefits = true;
        fulltime = true;
    }
    
    @Override
    public double calculatePaycheck()
    {
        return hoursWorked * wagePerHour;
    }

    public void setHoursWorked(int hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }
}
