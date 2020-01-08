package mert;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mert Yacan
 */
public class Assignment11_2APP implements ActionListener {
    static JFrame window;
    static JShapesPanel sekilliPanel = new JShapesPanel();
    static JPanel screen, button;
    static JButton go;
    static ArrayList<Shape> sekillerr;
    
    public void Start(){
        window = new JFrame("Vowel-Consonant Counter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = new JPanel(new BorderLayout());
        sekilliPanel.setPreferredSize(new Dimension(800,800));
        screen.add(sekilliPanel, BorderLayout.NORTH);
        go = new JButton("Create shapes!");
        go.setPreferredSize(new Dimension(200,30));
	go.addActionListener(this);
        screen.add(go, BorderLayout.SOUTH);
        
        
        window.add(screen);
        
        window.pack();
	window.setVisible(true);
    }
    
    public static void main(String[] args){
        Assignment11_2APP program = new Assignment11_2APP();
        program.Start();
        
    }
    
    public void actionPerformed(ActionEvent event) {
        window.repaint();
    }
}
