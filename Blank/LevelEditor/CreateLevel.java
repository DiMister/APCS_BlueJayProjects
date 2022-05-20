package LevelEditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.event.*;

//you do not want to see how many methods I override
public class CreateLevel implements ActionListener, KeyListener, MouseMotionListener, ChangeListener
{
    JFrame f1;
    JPanel main, sub;
    JButton done, importFile;
    JComboBox<String> mapSelect, tilesSelect;
    JSlider brushSelect;
    CreateGraphics graph;

    String[] tiles = {"Normal", "Wall", "Water", "Lava", "Spike"};
    String[] mapSize = {"Tiny", "Small", "Normal", "Huge", "Massive"};

    Tile[][] map = new Tile[18][18];
    Tile selectedTile = new NormalTile();

    int disX = 0;
    int disY = 0;
    int brushSize = 1;
    
    public CreateLevel()
    {
        //big, large, huge, massive, girthy
        setPanel();
        update();
    }

    private void update()
    {
        Thread runner = new Thread();
        while(true){
            /** Need this section of code to slow computer down.*/  
            try 
            { 
                runner.sleep(5); 
            }
            catch(InterruptedException e) {} 

            graph.updateDis(map,disX,disY);
            graph.repaint();
        }
    }

    private void drawTiles(Point p) {

        //set location based on the index value of grid and dispalcment
        p.setLocation((int)((p.getX()-disX) / 30),(int)((p.getY()-disY) / 30));
        //int rounding caused a lot of pain
        int row = (int)p.getX();
        int col = (int)p.getY();
        int radius = brushSize/2;
        
        if(col < map[0].length && row < map.length)
            for(int index = -radius; index < radius+1; index++){
                if(row+index < map.length && row+index >= 0){
                    for(int i = -radius; i < radius+1; i++){
                        if(col+i < map[0].length && col+i >= 0)
                            if(inside_circle(p,new Point(row+index,col+i),radius))
                                map[row+index][col+i] = selectedTile;
                    }
                }
            }
    }
    
    private boolean inside_circle(Point center, Point tile, float radius) {
        //from https://www.redblobgames.com/grids/circle-drawing/
        //really fancy math to find if tile distance from center of circle in radius
        float dx = center.x - tile.x,
              dy = center.y - tile.y;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance <= radius+0.5;
    }

    private void setPanel()
    {

        f1 = new JFrame("Lebel Edit");
        f1.setSize(1000,1000);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(true);

        graph = new CreateGraphics(map,disX,disY);
        graph.addKeyListener(this);

        Container c1 = f1.getContentPane();

        tilesSelect = new JComboBox<>(tiles);
        tilesSelect.addActionListener(this);
        mapSelect = new JComboBox<>(mapSize);
        mapSelect.addActionListener(this);

        //sliders suck they need their own changeLister cuz their *special*
        brushSelect = new JSlider(JSlider.HORIZONTAL,1,10,1);
        brushSelect.addChangeListener(this);

        done = new JButton("Done");
        done.addActionListener(this);
        importFile = new JButton("Import File");
        importFile.addActionListener(this);

        sub = new JPanel(); 
        sub.add(tilesSelect);
        sub.add(brushSelect);
        sub.add(mapSelect);
        sub.add(importFile);
        sub.add(done);

        main = new JPanel();
        main.setLayout(new BorderLayout());          
        main.setSize(500,500);
        main.add(graph,BorderLayout.CENTER);
        main.add(sub,BorderLayout.SOUTH);
        main.addMouseMotionListener(this);

        c1.add(main);
        f1.show();
        graph.requestFocus();
    }

    @Override
    public void actionPerformed (ActionEvent event)
    {
        if(event.getSource() == done) {
            //save level
            /**JOptionPane to get name of level*/
            String name = (String)JOptionPane.showInputDialog(f1,"Enter name of level","Save",JOptionPane.INFORMATION_MESSAGE);

            FileMangement.saveFile(map,name);
        }
        if(event.getSource() == importFile) {
            //import level
            /**JOptionPane to get name of file*/
            String name = (String)JOptionPane.showInputDialog(f1,"Enter name of file","Import",JOptionPane.INFORMATION_MESSAGE);

            map = FileMangement.readMapFile(name);
        }
        if(event.getSource() == mapSelect) {
            //wipes map and makes new size
            if(mapSelect.getSelectedItem() == "Tiny")
                map = new Tile[10][10];
            else if(mapSelect.getSelectedItem() ==  "Small")
                map = new Tile[20][20];
            else if(mapSelect.getSelectedItem() ==  "Normal")
                map = new Tile[40][30];
            else if(mapSelect.getSelectedItem() ==  "Huge")
                map = new Tile[80][80];
            else if(mapSelect.getSelectedItem() ==  "Massive")
                map = new Tile[160][160];

            graph.requestFocus();
        }
        if(event.getSource() == brushSelect) {
            //this if f*** stubid
            graph.requestFocus();
        }
        if(event.getSource() == tilesSelect) {
            if(tilesSelect.getSelectedItem() == "Normal")
                selectedTile = new NormalTile();
            if(tilesSelect.getSelectedItem() ==  "Wall")
                selectedTile = new WallTile();
            if(tilesSelect.getSelectedItem() ==  "Water")
                selectedTile = new WaterTile();
            if(tilesSelect.getSelectedItem() ==  "Lava")
                selectedTile = new LavaTile();
            if(tilesSelect.getSelectedItem() ==  "Spike")
                selectedTile = new SpikeTile(1);
            
            graph.requestFocus();
        }
    }

    @Override
    public void keyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 87)
        {
            //up 
            disY-=10;
        }
        if(evt.getKeyCode() == 83)
        {
            //down
            disY+=10;
        }
        if(evt.getKeyCode() == KeyEvent.VK_A)
        {
            //left
            disX-=10;
        }
        if(evt.getKeyCode() == KeyEvent.VK_D)
        {
            //right
            disX+=10;
        }

    }

    @Override
    public void keyReleased(KeyEvent evt)
    {}

    @Override
    public void keyTyped(KeyEvent evt)
    {}

    @Override
    public void mouseMoved(MouseEvent evt) 
    {}
    
    @Override
    public void mouseDragged(MouseEvent evt) {
        drawTiles(evt.getPoint());
    }

    @Override
    public void stateChanged(ChangeEvent event){
        //do weird math to make number always odd
        brushSize = brushSelect.getValue() + brushSelect.getValue() -1;
        graph.requestFocus();
    }

}
