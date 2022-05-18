package LevelEditor;

 


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class WallTile extends Tile
{
    
    public WallTile()
    {
       super(new Color(210,105,30));
    }

    public String toString(){return "wall";}
}
