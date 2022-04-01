import java.util.ArrayList;
import java.util.Random;
import java.nio.charset.Charset;

public class runTheIMP
{
    ArrayList<Employee> employees = new ArrayList<Employee>();
    public runTheIMP()
    {
        System.out.print('\u000C');
        for(int index = 0; index < 2; index++) {
            employees.add(new HourlyEmployee(randomStringBound((int)(Math.random()*10+1)),(int)(Math.random()*20+1)));
            employees.add(new PartTimeEmplayee(randomStringBound((int)(Math.random()*10+1)),(int)(Math.random()*25+1)));
            employees.add(new SalariedEmployee(randomString((int)(Math.random()*10+1)),(int)(Math.random()*10000+1)));
        }
        print();
        System.out.println();
        printWage();
    }

    private String randomString(int length) 
    {
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        
        return generatedString;
    }
    
    private String randomStringBound(int length) {
     
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
    
        return generatedString;
    }   
    
    private void print()
    {
        for(int index =0; index < employees.size(); index++){
            if(employees.get(index) instanceof HourlyEmployee){
                HourlyEmployee why = (HourlyEmployee)employees.get(index);
                System.out.println(why.getAllInfo());
            }
            else if(employees.get(index) instanceof PartTimeEmplayee){
                PartTimeEmplayee why = (PartTimeEmplayee)employees.get(index);
                System.out.println(why.getAllInfo());
            }
            else if(employees.get(index) instanceof SalariedEmployee){
                SalariedEmployee why = (SalariedEmployee)employees.get(index);
                System.out.println(why.getAllInfo());
            }
        }
    }
    
    private void printWage()
    {
        for(int index = 0; index < employees.size(); index++){
            if(employees.get(index) instanceof HourlyEmployee){
                HourlyEmployee why = (HourlyEmployee)employees.get(index);
                System.out.println(why.getName() + index + " monze: " + why.calculatePaycheck() + ", " + why.displayPaycheck());
            }
            else if(employees.get(index) instanceof PartTimeEmplayee){
                PartTimeEmplayee why = (PartTimeEmplayee)employees.get(index);
                System.out.println(why.getName() + index + " monze: " + why.calculatePaycheck() + ", " + why.displayPaycheck());
            }
            else if(employees.get(index) instanceof SalariedEmployee){
                SalariedEmployee why = (SalariedEmployee)employees.get(index);
                System.out.println(why.getName() + index + " monze: " + why.calculatePaycheck() + ", " + why.displayPaycheck());
            }
        }
    }
}
