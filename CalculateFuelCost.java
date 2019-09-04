package calculatefuelcost;

import javax.swing.JFrame;

/**
 *
 * @author Andrew
 */
public class CalculateFuelCost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame myF = new JFrame();
        Overview ov = new Overview();
        myF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myF.setVisible(true);
        myF.setSize(400,600);
        myF.add(ov);
    }
    
}
