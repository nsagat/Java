import javax.swing.JFrame;
 
 
public class Level2 {
   
    public void level2() {
    	
 
        JFrame frame = new JFrame("Shooting Game");
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create panel and add it to the frame
        Screen sc = new Screen();
         
        frame.add(sc);
        frame.pack();
        frame.setVisible(true);
        
        
        //sc.animate();
        sc.animate(2);
        
 
    }
}