package LevelEditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CreateGraphics extends JPanel
{
    Tile[][] map;

    public CreateGraphics(Tile[][] tiles)
    {
        map = tiles;
        setBackground(Color.red);
    }

    public void paint (Graphics g)         
    {
        super.paint(g); 
        for(Tile[] h : map){
          for(Tile d : h){
            g.setColor(d.c);
            g.fillRect(d.x,d.y,d.xsiz,d.ysiz);
            g.setColor(Color.black);
            g.drawRect(d.x,d.y,d.xsiz,d.ysiz);
            }
        }
    }
}
