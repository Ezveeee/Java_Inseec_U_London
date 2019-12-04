package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class Login_screen extends JFrame
{
    final private JButton bt1 = new JButton("Login account");
    final private JButton bt2 = new JButton("Create account");
    private final int HAUTEUR_SCREEN = 300;
    private final int LARGEUR_SCREEN = 400;

    public Login_screen()
    {
        setTitle("Paule en ploie");
        //this.setLocation(150,75);
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
        Login lng = new Login();
    }
}
  
private class bt2Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        dispose();
        Register_choose rg = new Register_choose();
    }
}
}
