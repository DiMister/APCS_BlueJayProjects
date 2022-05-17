package LevelEditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class CreateLevel implements ActionListener, KeyListener
{
    JFrame f1;
    JPanel main, sub;
    JButton done;
    JComboBox<String> mapSelect, tilesSelect, brushSelect;
    CreateGraphics g1;
    
    String[] tiles = {"Normal", "Wall", "Water", "Lava", "Spike"};
    String[] brushes = {"1x1", "3x3", "5x5", "7x7", "circle"};
    String[] mapSize = {"Tiny", "Small", "Normal", "Huge", "Massive"};
    
    Tile[][] map = new Tile[1][1];
    public CreateLevel()
    {
        setPanel();
    }

    private void setPanel()
    {
        f1 = new JFrame("Lebel Edit");
         f1.setSize(600,600);
         f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f1.setResizable(false);
        
        Container c1 = f1.getContentPane();
        
        tilesSelect = new JComboBox<>(tiles);
        brushSelect = new JComboBox<>(brushes);
        mapSelect = new JComboBox<>(mapSize);
        done = new JButton("Done");
         done.addActionListener(this);

        g1 = new CreateGraphics(map);
         g1.addKeyListener(this);  

        sub = new JPanel(); 
         sub.add(tilesSelect);
         sub.add(brushSelect);
         sub.add(mapSelect);
         sub.add(done);
         


        main = new JPanel();
         main.setLayout(new BorderLayout());          
         main.setSize(500,500);
         main.add(g1,BorderLayout.CENTER);
         main.add(sub,BorderLayout.SOUTH);
        
        c1.add(main);
        f1.show();
        
    }

    public void actionPerformed (ActionEvent event)
    {
        if(event.getSource() == done) {
            
        }
    }

    public void keyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 38)
        {
            //up 

        }
        if(evt.getKeyCode() == 40)
        {
            //down

        }
        if(evt.getKeyCode() == 37)
        {
            //left

        }
        if(evt.getKeyCode() == 39)
        {
            //right

        }

    }

    public void keyReleased(KeyEvent evt)
    {}

    public void keyTyped(KeyEvent evt)
    {}
}
