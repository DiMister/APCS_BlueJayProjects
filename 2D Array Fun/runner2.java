import java.util.ArrayList;

public class runner2
{
    String[][] draft;
    ArrayList<String> players = new ArrayList<String>();
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
    
    private void setupdraft() {
        for(int index = 0; index < 20; index++) {
            players.add("Guy" + (index+1));
        }
        draft = new String[5][players.size()/5];
        for(int index = 0; index < draft[0].length; index++){
            if(index % 2 == 0)
                for(int i = 0; i < draft.length; i++){
                    String temp = players.remove(0);
                    draft[i][index] = temp;
                    System.out.println("Pick " + (index*5+i+1) + ", Owner " + (i+1) + ", Player " + temp);
                }
            else
                for(int i = draft.length-1; i >= 0; i--){
                    String temp = players.remove(0);
                    draft[i][index] = temp;
                    System.out.println("Pick " + (index*5-i+draft.length) + ", Owner " + (i+1) + ", Player " + temp);
                }
        }
    }
    


}
