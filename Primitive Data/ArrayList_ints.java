public class ArrayList_ints
{
    private int[] x = new int[0];

    public int set(int index, int object)
    {
        int[] y = new int[index+1];
        for(int i = 0; i < x.length; i++)
        {
            y[i] = x[i];
        }
        y[index] = object;
        x = y;
        try{
            int OG = x[index];
            return OG;
        }catch(ArrayIndexOutOfBoundsException e){
            return -1;
        }
    }
    
    public int get(int index)
    {
        try{
            return x[index];
        }catch(ArrayIndexOutOfBoundsException e){
            return -1;
        }
    }
    
    public int remove(int index)
    {
        int OG = x[index];
        int[] y = new int[x.length -1];
        for(int i = 0; i < index-1; i++){
            y[i] = x[i];
        }
        for(int i = x.length-1; i >= index; i--){
            y[i-1] = x[i];
        }
        x = y;
        return OG;
    }
    
    public int size()
    {
        return x.length;
    }
    
    public boolean add(int object)
    {
        int[] y = new int[x.length +1];
        for(int i = 0; i < x.length; i++){
            y[i] = x[i];
        }
        y[x.length] = object;
        x = y;
        return true;
    }
    
    public void add(int index, int object)
    {
        int[] y = new int[x.length +1];
        for(int i = 0; i < index; i++){
            y[i] = x[i];
        }
        for(int i = x.length-1; i >= index; i--){
            y[i+1] = x[i];
        }
        y[index] = object;
        x = y;
    }
}

