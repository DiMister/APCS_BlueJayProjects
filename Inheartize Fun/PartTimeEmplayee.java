

public class PartTimeEmplayee extends HourlyEmployee
{


    public PartTimeEmplayee(String name, int wagePerHour)
    {
        super(name,wagePerHour);
        benefits = false;
        fulltime = false;
    }

    public String getAllInfo()
    {
        return super.getAllInfo("PartTime"); 
    }
}
