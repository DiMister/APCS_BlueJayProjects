import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class graphics extends JPanel
{
    int[] array;
    int baseline = 700;
    boolean fixed;


    
    public graphics(int[] aarray)
    {
        setBackground(new Color(0,0,0));     
        array = aarray;
    }

    public void updateArray(int[] aarray,boolean ffixed)
    {
        array = aarray;
        fixed = ffixed;
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        if(fixed){
            g.setColor(Color.red);
            g.setFont(new Font("ZapfDingbats",Font.PLAIN,80));
            g.drawString("Stonks", 50, 100);
        }
        
        for(int index = 0; index < array.length; index++){
            //I am very hurting from getting rainbow going
            // WHAT THE HELL IS HSBColor?????
            Color pain = Color.getHSBColor((float)remap(array[index],1,array.length,0,360)/360, 1.0f, 1.0f);
            g.setColor(pain);
            g.fillRect(remap(index,0,array.length,20,960), baseline-remap(array[index],1,array.length,20,600), 940/array.length+1, remap(array[index],1,array.length,20,600));
        }
    }

    private int remap(int num, int a1, int a2, int b1, int b2)
    {
        return (int)(b1 + ((num-a1)*(b2-b1)/(float)(a2-a1)));
    }
}
