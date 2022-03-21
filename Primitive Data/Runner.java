
public class Runner
{
    private ArrayList_ints bruh= new ArrayList_ints();

    public Runner()
    {
        System.out.print('\u000C');
        for(int index = 0; index < 10; index++){
            bruh.set(index,index+1);
            print();
        }
        bruh.remove(5);
        bruh.remove(6);
        print();
        bruh.add(21);
        print();
        bruh.add(4,-1);
        print();
    }

    private void print()
    {
        System.out.println();
        System.out.print(bruh.get(0));
        for(int index = 1; index < bruh.size(); index++) {
            System.out.print(", " + bruh.get(index));
        }
    }
}
