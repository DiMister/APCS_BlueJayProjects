import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**Need these imports for Music*/
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

public class Runner  implements ActionListener
{
    int arraySize = 100000;
    int[] array = new int[arraySize];
    JFrame frame;
    graphics graph;
    JPanel main, sub;
    JButton b1,b2,b3,b4;
    boolean iSort = false, sSort = false, fixed = false, cSort = false;

    Clip blip, backMusic, win;
    
    public Runner()
    {
        resetArray();
        setupAudio();
        //changeBitrate(new File("back_music.wav"),new File("broken.wav"));
        
        frame = new JFrame("Stonks");
         frame.setSize(1000,1000);
         frame.setResizable(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        Container c = frame.getContentPane();
         
        graph = new graphics(array);
        
        b1 =  new JButton("Selection Sort");
         b1.addActionListener(this);
        
        b2 =  new JButton("Insertio Sort");
         b2.addActionListener(this);
         
        b4 =  new JButton("CockTail Sort");
         b4.addActionListener(this);
         
        b3 =  new JButton("Shuffle");
         b3.addActionListener(this);
        
        sub = new JPanel(); 
          sub.add(b1);
          sub.add(b2);
          sub.add(b4);
          sub.add(b3);
        
        main = new JPanel();
         main.setLayout(new BorderLayout());
         main.setSize(1000,1000);
         main.add(graph,BorderLayout.CENTER);
         main.add(sub,BorderLayout.SOUTH);
        
        c.add(main);
        frame.show();
        
        update();
    }

    private void update()
    {
        Thread runner = new Thread();
        Thread sort = new Thread(){
            public void run(){
                while(true){
                    /** Need this section of code to slow computer down.*/  
                    try 
                    { 
                        runner.sleep(1); 
                    }
                    catch(InterruptedException e) {} 
                    
                    graph.updateArray(array,fixed);
                    graph.repaint();
                    resetAudio();
                }
            }
        };
        
        sort.start();
        backMusic.start();
        
        while(true){
            /** Need this section of code to slow computer down.*/  
            try 
            { 
                runner.sleep(5); 
            }
            catch(InterruptedException e) {} 
            
            if(sSort) {
                selectionSort(runner);
                sSort = false;
                fixed = true;
                win.start();
            }
            if(iSort) {
                insertioSort(runner);
                iSort = false;
                fixed = true;
                win.start();
            }
            if(cSort) {
                cocktailSort(runner);
                cSort = false;
                fixed = true;
                win.start();
            }
            
            blip.stop();
        }
    }
    
    public void actionPerformed (ActionEvent event)
    {
        //buttons
        if (event.getSource() == b1)
        {
            sSort = true;
        }
         
        if (event.getSource() == b2)
        {
            iSort = true;
        }
        
        if (event.getSource() == b4)
        {
            cSort = true;
        }
         
        if (event.getSource() == b3 && !iSort && !sSort && !cSort)
        {
            resetArray();
            fixed = false;
        }
    }
    
    private void resetArray()
    {
        
        ArrayList<Integer> temp = new ArrayList();
        for(int index = 0; index < array.length; index++){
            temp.add(index,index+1);
        }
        for(int index = 0; index < array.length; index++){
            array[index] = temp.remove((int)(Math.random() * temp.size()));
        }
        /*
        System.out.println();
        for(int index = 0; index < array.length; index++){
            System.out.print("," + array[index]);
        }*/
    }
    
    private void selectionSort(Thread runner)
    {
        int largest;
        int place;
        for(int index = 0; index < array.length-1; index++){
            largest = array[index];
            place = index;
            blip.setMicrosecondPosition(0);
            blip.start();
            
            for(int i = index+1; i < array.length; i++)
                if(array[i] < largest){
                    largest = array[i];
                    place = i;
                    try { 
                        runner.sleep(25); 
                    }catch(InterruptedException e) {}
                }
                
            int temp = array[index];
            array[index] = largest;
            array[place] = temp;
            
        }
    }

    private void insertioSort(Thread runner)
    {
        for(int index = 1; index < array.length; index++){
            int key = array[index];
            int place = index;
            blip.setMicrosecondPosition(0);
            blip.start();
            
            while(place > 0 && array[place-1] > key){
                array[place] = array[place-1];
                place--;
                try { 
                    runner.sleep(10); 
                }catch(InterruptedException e) {} 
            }   
            array[place] = key;
            
        }
    }
    
    private void cocktailSort(Thread runner){
        boolean swapped;
        do {
          swapped = false;
          blip.setMicrosecondPosition(0);
           blip.start();
          for (int i =0; i<=  array.length  - 2;i++) {
            if (array[ i ] > array[ i + 1 ]) {
              
              //test whether the two elements are in the wrong order
              int temp = array[i];
              array[i] = array[i+1];
              array[i+1]=temp;
              swapped = true;
              try { 
                    runner.sleep(0); 
              }catch(InterruptedException e) {} 
            }
          }
          if (!swapped) {
            //we can exit the outer loop here if no swaps occurred.
            break;
          }
          swapped = false;
          for (int i= array.length - 2;i>=0;i--) {
            if (array[ i ] > array[ i + 1 ]) {
              int temp = array[i];
              array[i] = array[i+1];
              array[i+1]=temp;
              swapped = true;
              try { 
                    runner.sleep(0); 
                }catch(InterruptedException e) {}
            }
          }
        //if no elements have been swapped, then the list is sorted
        } while (swapped);
    }
    
    private void setupAudio()
    {
        /** need this entire section in constructor for sound files.*/
        try {
            AudioInputStream audioIn1 = AudioSystem.getAudioInputStream(new File("arcade_beep.wav"));
            blip = AudioSystem.getClip();
            blip.open(audioIn1);
            
            AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(new File("syth2.wav"));
            backMusic = AudioSystem.getClip();
            backMusic.open(audioIn2);
            
            AudioInputStream audioIn3 = AudioSystem.getAudioInputStream(new File("win.wav"));
            win = AudioSystem.getClip();
            win.open(audioIn3);
            
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        /** need this entire section in constructor for sound files.*/
    }  
    
        private void resetAudio()
    {
        /**Checks to see if audioclip is to the end. If so resets to beginning. */
        if(backMusic.getMicrosecondPosition() >= backMusic.getMicrosecondLength())
        {
               backMusic.setMicrosecondPosition(0);
        }
        if(win.getMicrosecondPosition() >= win.getMicrosecondLength())
        {
               win.setMicrosecondPosition(0);
        }
    }
    
    //change bit rate of sound file
    //java windows doesn't support 24 bit files
    /*
    public void changeBitrate(File source,File output){
        try{
            AudioFormat format=new AudioFormat(44100,16,1,true,true);
            AudioInputStream in=AudioSystem.getAudioInputStream(source);
            AudioInputStream convert=AudioSystem.getAudioInputStream(format,in);
            AudioSystem.write(convert,AudioFileFormat.Type.WAVE,output);
        } catch(Exception ex) {}
    }*/
}
