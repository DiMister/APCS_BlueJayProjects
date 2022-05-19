package LevelEditor;

 


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class WaterTile extends Tile
{
    
    public WaterTile()
    {
        super(new ImageIcon("/images/water.png").getImage());
    }

    public String toString(){return "v";}
}
