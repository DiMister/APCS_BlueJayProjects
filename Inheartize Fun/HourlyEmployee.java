

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
    
    public String displayPaycheck()
    {
        return "" + hoursWorked + " * " + wagePerHour + " = " + super.displayPaycheck();
    }
    
    public String getAllInfo()
    {
        return super.getAllInfo("Hourly", "" + wagePerHour, "" + hoursWorked); 
    }
    
    public String getAllInfo(String type)
    {
        return super.getAllInfo(type, "" + wagePerHour, "" + hoursWorked); 
    }
}
