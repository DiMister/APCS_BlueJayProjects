package LevelEditor;

 


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class LavaTile extends Tile
{
    
    public LavaTile()
    {
        super(new ImageIcon("/images/lava.png").getImage());
    }

    public String toString(){return "l";}
}
