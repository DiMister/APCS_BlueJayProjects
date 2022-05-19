package LevelEditor;

 


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class WallTile extends Tile
{
    
    public WallTile()
    {
       super(new ImageIcon("/images/wall.png").getImage());
    }

    public String toString(){return "w";}
}
