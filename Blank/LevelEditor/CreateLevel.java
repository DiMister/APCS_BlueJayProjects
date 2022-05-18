package LevelEditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public class CreateLevel implements ActionListener, KeyListener, MouseMotionListener
{
    JFrame f1;
    JPanel main, sub;
    JButton done;
    JComboBox<String> mapSelect, tilesSelect, brushSelect;
    CreateGraphics graph;

    String[] tiles = {"Normal", "Wall", "Water", "Lava", "Spike"};
    String[] brushes = {"1x1", "3x3", "5x5", "7x7"};
    String[] mapSize = {"Tiny", "Small", "Normal", "Huge", "Massive"};

    Tile[][] map = new Tile[18][18];

    int disX = 0;
    int disY = 0;
    public CreateLevel()
    {
        //setMap();
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

        Tile temp = getTile();

        int brushSize = getBrushSize();

        int col = (int)(p.getY() / 30);
        int row = (int)(p.getX() / 30);

        if(col < map[0].length && row < map.length)
            for(int index = -brushSize/2; index < brushSize/2+1; index++){
                if(row+index < map.length && row+index >= 0){
                    for(int i = -brushSize/2; i < brushSize/2+1; i++){
                        if(col+i < map[0].length && col+i >= 0)
                            map[row+index][col+i] = temp;
                    }
                }
            }
    }

    private void setMap() 
    {
        for(int index = 0; index < map.length; index++){
            for(int i = 0; i < map[0].length; i++){
                map[index][i] = new NormalTile();
            }
        }
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
        brushSelect = new JComboBox<>(brushes);
        mapSelect = new JComboBox<>(mapSize);
        mapSelect.addActionListener(this);

        done = new JButton("Done");
        done.addActionListener(this);

        sub = new JPanel(); 
        sub.add(tilesSelect);
        sub.add(brushSelect);
        sub.add(mapSelect);
        sub.add(done);

        main = new JPanel();
        main.setLayout(new BorderLayout());          
        main.setSize(500,500);
        main.add(graph,BorderLayout.CENTER);
        main.add(sub,BorderLayout.SOUTH);
        main.addMouseMotionListener(this);

        c1.add(main);
        f1.show();
    }

    public void saveLevel()
    {
        /**JOptionPane to get name of level*/
        String name = (String)JOptionPane.showInputDialog(f1,"Enter name of level","Save",JOptionPane.INFORMATION_MESSAGE);
        
        FileMangement.saveFile(map,name);
    }

    private Tile getTile() {
        if(tilesSelect.getSelectedItem() == "Normal")
            return new NormalTile();
        if(tilesSelect.getSelectedItem() ==  "Wall")
            return new WallTile();
        if(tilesSelect.getSelectedItem() ==  "Water")
            return new WaterTile();
        if(tilesSelect.getSelectedItem() ==  "Lava")
            return new LavaTile();
        if(tilesSelect.getSelectedItem() ==  "Spike")
            return new SpikeTile(1);

        return null;
    }

    private int getBrushSize() {
        if(brushSelect.getSelectedItem() == "1x1")
            return 1;
        if(brushSelect.getSelectedItem() ==  "3x3")
            return 3;
        if(brushSelect.getSelectedItem() ==  "5x5")
            return 5;
        if(brushSelect.getSelectedItem() ==  "7x7")
            return 7;

        return -1;
    }

    public void actionPerformed (ActionEvent event)
    {
        if(event.getSource() == done) {
            saveLevel();
        }
        if(event.getSource() == mapSelect) {
            if(mapSelect.getSelectedItem() == "Tiny")
                map = new Tile[10][10];
            else if(mapSelect.getSelectedItem() ==  "Small")
                map = new Tile[20][20];
            else if(mapSelect.getSelectedItem() ==  "Normal")
                map = new Tile[30][30];
            else if(mapSelect.getSelectedItem() ==  "Huge")
                map = new Tile[40][40];
            else if(mapSelect.getSelectedItem() ==  "Massive")
                map = new Tile[50][50];
        }
    }

    public void keyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 87)
        {
            //up 
            disY+=10;
        }
        if(evt.getKeyCode() == 83)
        {
            //down
            disY-=10;
        }
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            //left
            System.out.println("Left key pressed");
            disX-=10;
        }
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
            //right
            System.out.println("Right key pressed");
            disX+=10;
        }

    }

    public void keyReleased(KeyEvent evt)
    {}

    public void keyTyped(KeyEvent evt)
    {}
    
    public void mouseMoved(MouseEvent evt) {
        
    }
    
    public void mouseDragged(MouseEvent evt) {
        drawTiles(evt.getPoint());
    }
}
