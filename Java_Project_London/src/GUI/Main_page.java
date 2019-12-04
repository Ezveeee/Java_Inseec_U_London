package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main_page extends JFrame {
    
    final private JButton profil = new JButton("Profile");
    final private JButton bt2 = new JButton("🔎");
    final private JTextField Search = new JTextField(10);
    final private JLabel Search_txt = new JLabel("Search a Job");
    private final int HAUTEUR_SCREEN = 600;
    private final int LARGEUR_SCREEN = 1200;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Main_page()
    {
        setTitle("Paule en ploie");
        //this.setLocation(150,75);
        //setLocation(500,150);
        //setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        profil.addActionListener(new bt1Listener());
        bt2.addActionListener(new bt2Listener());

        
        profil.setBounds(9*LARGEUR_SCREEN/10-100/2, HAUTEUR_SCREEN/10-50/2, 200, 50);
        bt2.setBounds(LARGEUR_SCREEN/2+100, 3*HAUTEUR_SCREEN/5-30, 70, 20);
        Search.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-30, 200, 20);
        Search_txt.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-50, 200, 20);
        
        jp.add(bt2);
        jp.add(Search_txt);
        jp.add(Search);
        jp.add(profil);
        add(jp);
        setVisible(true);
    }
    
    
private class bt1Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Profil p = new Profil();
        
    }
}
private class bt2Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        
        setVisible(false);
        dispose();
        
    }
}
}


