package LevelEditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CreateGraphics extends JPanel
{
    Tile[][] map;
    int disX, disY;

    public CreateGraphics(Tile[][] tiles, int x, int y)
    {
        map = tiles;
        disX = x;
        disY = y;
        setBackground(Color.gray);
    }
    
    public void updateDis(Tile[][] tiles, int x, int y)
    {
        map = tiles;
        disX = x;
        disY = y;
    }

    public void paint (Graphics g)         
    {
        super.paint(g); 
        for(int index = 0; index < map.length; index++){
          for(int i = 0; i < map[0].length; i++){
                Tile temp = map[index][i];
                if(temp != null) {
                    g.setColor(temp.c);
                    g.fillRect(30*index+disX,30*i+disY,30,30);
                }
            }
        }
        
        for(int index = 0; index < map.length; index++){
          for(int i = 0; i < map[0].length; i++){
                g.setColor(Color.black);
                g.drawRect(30*index+disX,30*i+disY,30,30);
            }
        }
    }
}
