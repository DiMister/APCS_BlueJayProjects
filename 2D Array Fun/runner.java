
public class runner
{
    int[][] array2D = new int[4][3];
    
    public runner() {
        setuparray2D();
        print();
        horizontalFlip();
        print();
        rotate90();
        //rotate90();
        print();
    }
    
    private void print() {
        for(int index = 0; index < array2D[0].length; index++){
            System.out.println();
            for(int i = 0; i < array2D.length; i++){
                System.out.print(array2D[i][index] + ", ");
            }
        }
        System.out.println();
    }
    
    private void setuparray2D() {
        for(int index = 0; index < array2D.length; index++){
            for(int i = 0; i < array2D[0].length; i++){
                array2D[index][i] = (int)(Math.random()*10+1);
            }
        }
    }
    
    private void horizontalFlip() {
        for(int index = 0; index < array2D.length/2; index++){
            for(int i = 0; i < array2D[0].length; i++){
                int temp = array2D[index][i];
                array2D[index][i] = array2D[array2D.length-index-1][i];
                array2D[array2D.length-index-1][i] = temp;
            }
        }
    }
    
    private void rotate90() {
        int[][] tempArray = new int[array2D[0].length][array2D.length];
        for(int index = 0; index < array2D.length; index++){
            for(int i = 0; i < array2D[0].length; i++){
               tempArray[i][index] = array2D[index][array2D[0].length-i-1];
            }
        }
        array2D = tempArray;
    }

}
