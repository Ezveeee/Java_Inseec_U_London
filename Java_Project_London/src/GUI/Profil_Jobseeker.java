package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Profil_Jobseeker extends JFrame {
    
    final private JButton CV_Screen = new JButton("Modify CV");
    final private JButton personnal_information = new JButton("Modify Personnal Information");
    final private JButton JobsRequest = new JButton("View my Job Requests");
    private final int HAUTEUR_SCREEN = 300;
    private final int LARGEUR_SCREEN = 250;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Profil_Jobseeker()
    {
        setTitle("Profile");
        setLocation(500,150);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        CV_Screen.addActionListener(new bt1Listener());
        personnal_information.addActionListener(new persInfBtn());
        
        CV_Screen.setBounds(LARGEUR_SCREEN/2-119,HAUTEUR_SCREEN/5 - 50, 225, 75);
        personnal_information.setBounds(LARGEUR_SCREEN/2-119, HAUTEUR_SCREEN/5+30, 225, 75);
        JobsRequest.setBounds(LARGEUR_SCREEN/2-119, HAUTEUR_SCREEN/5+110, 225, 75);
        
        jp.add(CV_Screen);
        jp.add(personnal_information);
        jp.add(JobsRequest);
        add(jp);
        setVisible(true);
    }
    
    
private class bt1Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        CV_Screen cv = new CV_Screen();
        
        
    }
}

private class persInfBtn implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Pers_Inf_Jobseeker perInf = new Pers_Inf_Jobseeker();
        
        
    }
}
}


