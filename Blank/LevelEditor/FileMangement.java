package LevelEditor;

import java.io.*;

public class FileMangement
{

    public static void saveFile(Tile[][] map, String fileName) {
        FileWriter fwriter; 
        BufferedWriter bwriter;
        
        File thefile = new File(fileName+".txt");  
        try
        {
            fwriter = new FileWriter(thefile);
            bwriter = new BufferedWriter(fwriter); 
            for(Tile[] x : map){
                String line = "";
                for(Tile y : x){
                    line = line + x;
                    
                    
                }
                bwriter.write(line);
                bwriter.newLine();
            }
            bwriter.newLine();
            bwriter.write(" ");

            bwriter.close();                       //Must always close the file when finished writing to it.  
        }
        catch(IOException ex) {}
    }
    
    public static Tile[][] getFile() {
        return null;
    }
}
