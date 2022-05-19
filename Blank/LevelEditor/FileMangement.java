package LevelEditor;

import java.io.*;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
            for(Tile[] row : map){
                String line = "";
                for(Tile tile : row){
                    if(tile != null){
                        line+= tile;
                    }else
                        line+= "-";

                }
                bwriter.write(line);
                bwriter.newLine();
            }

            bwriter.close();                       //Must always close the file when finished writing to it.  
        }
        catch(IOException ex) {}
    }

    public static Tile[][] readMapFile(String fileName) {
        ArrayList<String> lines = new ArrayList<String>();
            
        try{
            FileInputStream fstream = new FileInputStream(fileName+".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            br.close();
        }
        catch (IOException ex){}
        
        System.out.println(lines);
        Tile[][] map = new Tile[lines.size()][lines.get(0).length()];
        
        for(int index = 0; index < map.length; index++){
          for(int i = 0; i < map[0].length; i++){
                map[index][i] = findTile(lines.get(index).charAt(i));
            }
        }
        
        return map;
    }
    
    private static Tile findTile(char car) {
        if(car == 'n') return new NormalTile();
        if(car == 'w') return new WallTile();
        if(car == 'l') return new LavaTile();
        if(car == 'v') return new WaterTile();
        if(car == 's') return new SpikeTile(1);
        return null;
    }
    
    public static Image findImage(String fileName) {

        File directory = new File("C:/Users/theis/OneDrive/Documents/GitHub/APCS_BlueJayProjects/Blank/LevelEditor/images");
  

        MyFilenameFilter filter = new MyFilenameFilter(fileName);
  
        // store all names with same name 
        // with/without extension
        String[] flist = directory.list(filter);
  
        // Empty array
        if (flist == null) {
            System.out.println("Empty directory or directory does not exists.");
            return null;
        }
        else {
  
            // Print all files with same name in directory
            // as provided in object of MyFilenameFilter
            // class
            for (int i = 0; i < flist.length; i++) {
                System.out.println(flist[i]+" found");
                return Toolkit.getDefaultToolkit().getImage(flist[i]);
            }
        }
        return null;
    }
}
