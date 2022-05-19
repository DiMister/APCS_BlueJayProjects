package LevelEditor;

 


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class SpikeTile extends Tile
{
    int dam;
    public SpikeTile(int dam)
    {
        super(new ImageIcon("/images/spike.png").getImage());
        this.dam = dam;
    }

    public String toString(){return "s";}
}
