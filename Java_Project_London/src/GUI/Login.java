package GUI;

import london.recruitmentsystem.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Login extends JFrame {
    
    final private JPanel jp = new JPanel();
    final private JButton lgn = new JButton("Login");
    final private JTextField e_mail = new JTextField(10);
    final private JTextField password = new JTextField(10);
    final private JLabel e_mail_txt = new JLabel("E-mail");
    final private JLabel password_txt = new JLabel("Password");
    private final int HAUTEUR_SCREEN = 300;
    private final int LARGEUR_SCREEN = 400;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Login()
    {
        setTitle("Paule en ploie");
        //this.setLocation(150,75);
        setLocation(500,150);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        jp.setLayout(null);
        
        lgn.addActionListener(new Login.bt1Listener());
        
        lgn.setBounds(LARGEUR_SCREEN/2-125/2, 2*HAUTEUR_SCREEN/3-35/2, 125, 35);
        e_mail.setBounds(LARGEUR_SCREEN/2-200/2, HAUTEUR_SCREEN/3-60/2, 200, 20);
        e_mail_txt.setBounds(LARGEUR_SCREEN/2-200/2, HAUTEUR_SCREEN/3-50, 200, 20);
        password.setBounds(LARGEUR_SCREEN/2-200/2, HAUTEUR_SCREEN/3 +20, 200, 20);
        password_txt.setBounds(LARGEUR_SCREEN/2-200/2, HAUTEUR_SCREEN/3, 200, 20);
        
        jp.add(password_txt);
        jp.add(e_mail_txt);
        jp.add(e_mail);
        jp.add(password);
        jp.add(lgn);
        add(jp);
        setVisible(true);
    }
    
    
    private class bt1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean jobseeker;

            if(Account.checkLogin(e_mail.getText(), password.getText()))
            {
                jobseeker = Account.getAccountType(e_mail.getText());
                if (jobseeker){
                     Main_page_Jobseeker mainJS = new Main_page_Jobseeker();
                }
                else {
                    Main_page_Company mainCP = new Main_page_Company();
                }
                setVisible(false);
                dispose();

            }



        }
    }
}


