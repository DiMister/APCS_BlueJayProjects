
public class runner2
{
    String[][] draft;
    String[] players = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","16","17","18","19","20"};
    public runner2() {
        setupdraft();
        print();

    }
    
    private void print() {
        for(int index = 0; index < draft[0].length; index++){
            System.out.println();
            for(int i = 0; i < draft.length; i++){
                System.out.print(draft[i][index] + ", ");
            }
        }
        System.out.println();
    }
    
    private void setupdraft(String[] players) {
        draft = new String[5][players.length/5];
        for(int index = 0; index < players.length; index++){
            String[][]
        }
    }
    


}
