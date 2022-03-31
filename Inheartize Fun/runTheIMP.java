import java.util.ArrayList;
import java.util.Random;
import java.nio.charset.Charset;

public class runTheIMP
{
    ArrayList<Employee> employees = new ArrayList<Employee>();
    public runTheIMP()
    {
        for(int index = 0; index < 2; index++) {
            employees.add(new HourlyEmployee());
            employees.add(new PartTimeEmplayee());
            employees.add(new SalariedEmployee());
    
        }
    }

    public String randomString(int length) 
    {
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        
        return generatedString;
    }
}
