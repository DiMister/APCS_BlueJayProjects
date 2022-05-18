package LevelEditor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CreateLevel implements ActionListener, KeyListener, MouseListener
{
    JFrame f1;
    JPanel main, sub;
    JButton done;
    JComboBox<String> mapSelect, tilesSelect, brushSelect;
    CreateGraphics graph;

    String[] tiles = {"Normal", "Wall", "Water", "Lava", "Spike"};
    String[] brushes = {"1x1", "3x3", "5x5", "7x7"};
    String[] mapSize = {"Tiny", "Small", "Normal", "Huge", "Massive"};

    Tile[][] map = new Tile[10][10];
    
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
         main.addMouseListener(this);
         

        c1.add(main);
        f1.show();
    }

    public void actionPerformed (ActionEvent event)
    {
        if(event.getSource() == done) {

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

    @Override
    public void mouseClicked(MouseEvent evt) { 

    }

    @Override
    public void mouseEntered(MouseEvent evt) { }

    @Override
    public void mouseExited(MouseEvent evt) { }

    @Override
    public void mousePressed(MouseEvent evt) { 
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
            System.out.println("Left click detected" + (evt.getPoint()));
            Tile temp = null;
            if(tilesSelect.getSelectedItem() == "Normal")
                temp = new NormalTile();
            else if(tilesSelect.getSelectedItem() ==  "Wall")
                temp = new WallTile();
            else if(tilesSelect.getSelectedItem() ==  "Water")
                temp = new WaterTile();
            else if(tilesSelect.getSelectedItem() ==  "Lava")
                temp = new LavaTile();
            else if(tilesSelect.getSelectedItem() ==  "Spike")
                temp = new SpikeTile(1);
                
            int brushSize = 0;
            if(brushSelect.getSelectedItem() == "1x1")
                brushSize = 1;
            else if(brushSelect.getSelectedItem() ==  "3x3")
                brushSize = 3;
            else if(brushSelect.getSelectedItem() ==  "5x5")
                brushSize = 5;
            else if(brushSelect.getSelectedItem() ==  "7x7")
                brushSize = 7;
                
            int col = (int)(evt.getPoint().getY() / 30);
            int row = (int)(evt.getPoint().getX() / 30);
            
            //if(col < map[0].length && row < map.length)
            //    map[row][col] = temp;
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
    }

    @Override
    public void mouseReleased(MouseEvent evt) { }
}
