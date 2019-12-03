package london.Screen;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JFrame{
    final private JButton lgn = new JButton("Register");
    final private JTextField lastName = new JTextField(10);
    final private JTextField firstName = new JTextField(10);
    final private JTextField birthDate = new JTextField(2);
    final private JTextField birthMonth = new JTextField(2);
    final private JTextField birthYear = new JTextField(4);
    final private JLabel lastName_txt = new JLabel("Last Name");
    final private JLabel birthDate_txt = new JLabel("Birth Date");
    final private JLabel Name_txt = new JLabel("Name of the Company");
    final private JLabel firstName_txt = new JLabel("First Name");
    private final int HAUTEUR_SCREEN = 600;
    private final int LARGEUR_SCREEN = 1200;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Register(boolean JobSeeker)
    {
        setTitle("Register");
        //this.setLocation(150,75);
        setLocation(50,50);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        lgn.addActionListener(new Register.bt1Listener());
        
        if (JobSeeker)
        {
            firstName.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5-30, 200, 20);
            firstName_txt.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5-50, 200, 20);
            lastName.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5 +20, 200, 20);
            lastName_txt.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5, 200, 20);
            birthDate_txt.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5 + 50, 200, 20);
            birthDate.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5 + 70, 20, 20);
            birthMonth.setBounds(LARGEUR_SCREEN/5-80, HAUTEUR_SCREEN/5 + 70, 20, 20);
            birthYear.setBounds(LARGEUR_SCREEN/5-60, HAUTEUR_SCREEN/5 + 70, 35, 20);
            
            jp.add(birthYear);
            jp.add(birthMonth);
            jp.add(birthDate);
            jp.add(birthDate_txt);
            jp.add(lastName_txt);
            jp.add(firstName_txt);
            jp.add(lastName);
            jp.add(firstName);
        }
        else 
        {
            firstName.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5-30, 200, 20);
            Name_txt.setBounds(LARGEUR_SCREEN/5-200/2, HAUTEUR_SCREEN/5-50, 200, 20);  
            
             jp.add(Name_txt);
             jp.add(firstName);
        }
        
        
        
        
        
        lgn.setBounds(LARGEUR_SCREEN/2-125/2, 4*HAUTEUR_SCREEN/5-35/2, 125, 35);
        
       
        
        
        jp.add(lgn);
        add(jp);
        setVisible(true);
    }
    
    
private class bt1Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        
        setVisible(false);
        dispose();
        
    }
}
}

