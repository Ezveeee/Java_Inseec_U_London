package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Register_choose extends JFrame
{
final private JButton bt1 = new JButton("Jobseeker");
    final private JButton bt2 = new JButton("Company");
    private final int HAUTEUR_SCREEN = 300;
    private final int LARGEUR_SCREEN = 400;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Register_choose()
    {
        setTitle("Register");
        setLocation(500,150);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        bt1.addActionListener(new bt1Listener());
        bt2.addActionListener(new bt2Listener());
        bt1.setBounds(LARGEUR_SCREEN/3-125/2, HAUTEUR_SCREEN/2-50/2, 125, 50);
        bt2.setBounds(2*LARGEUR_SCREEN/3-125/2, HAUTEUR_SCREEN/2-50/2, 125, 50);
        jp.add(bt1);
        jp.add(bt2);
        add(jp);
        setVisible(true);
        
    }

private class bt1Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        dispose();
        Register_JobSeeker rg = new Register_JobSeeker();
    }
}
  
private class bt2Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        dispose();
        Register_Company rc = new Register_Company();
    }
}
}
