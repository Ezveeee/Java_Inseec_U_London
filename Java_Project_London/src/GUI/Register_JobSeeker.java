package GUI;
import london.recruitmentsystem.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register_JobSeeker extends JFrame{
    final private JButton lgn = new JButton("Register");
    final private JTextField lastName = new JTextField(10);
    final private JTextField firstName = new JTextField(10);
    final private JTextField e_mail = new JTextField(10);
    final private JTextField password = new JTextField(10);
    final private JTextField phone = new JTextField(10);
    final private JTextField birthDay = new JTextField(2);
    final private JTextField birthMonth = new JTextField(2);
    final private JTextField birthYear = new JTextField(4);
    final private JLabel lastName_txt = new JLabel("Last Name");
    final private JLabel e_mail_txt = new JLabel("E-mail");
    final private JLabel password_txt = new JLabel("Password");
    final private JLabel phone_txt = new JLabel("Phone Number");
    final private JLabel birthDate_txt = new JLabel("Birth Date (dd/mm/yyyy)");
    final private JTextField street = new JTextField(10);
    final private JTextField postcode = new JTextField(10);
    final private JTextField city = new JTextField(10);
    final private JTextField country = new JTextField(10);
    final private JLabel street_txt = new JLabel("Street");
    final private JLabel postcode_txt = new JLabel("Postcode");
    final private JLabel city_txt = new JLabel("City");
    final private JLabel country_txt = new JLabel("Country");

    final private JLabel firstName_txt = new JLabel("First Name");
    private final int HAUTEUR_SCREEN = 600;
    private final int LARGEUR_SCREEN = 1200;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Register_JobSeeker()
    {
        setTitle("Register");
        //this.setLocation(150,75);
        setLocation(50,50);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        lgn.addActionListener(new Register_JobSeeker.bt1Listener());
        
        
            firstName.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5-30, 200, 20);
            firstName_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5-50, 200, 20);
            lastName.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +20, 200, 20);
            lastName_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5, 200, 20);
            birthDate_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 50, 200, 20);
            birthDay.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 70, 20, 20);
            birthMonth.setBounds(3*LARGEUR_SCREEN/10-80, HAUTEUR_SCREEN/5 + 70, 20, 20);
            birthYear.setBounds(3*LARGEUR_SCREEN/10-60, HAUTEUR_SCREEN/5 + 70, 35, 20);
            e_mail_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 150, 200, 20);
            e_mail.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 170, 200, 20);
            password_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 200, 200, 20);
            password.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 220, 200, 20);
            phone_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 250, 200, 20);
            phone.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 270, 200, 20);
            street_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 - 50, 200, 20);
            street.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 -30, 200, 20);
            postcode_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 , 200, 20);
            postcode.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +20, 200, 20);
            city_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +50 , 200, 20);
            city.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +70, 200, 20);
            country_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 100, 200, 20);
            country.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 120, 200, 20);
           
            jp.add(city_txt);
            jp.add(city);
            jp.add(country_txt);
            jp.add(country);
            jp.add(postcode_txt);
            jp.add(postcode);
            jp.add(street_txt);
            jp.add(street);           
            jp.add(phone_txt);
            jp.add(phone);
            jp.add(password_txt);
            jp.add(password);
            jp.add(e_mail);
            jp.add(e_mail_txt);
            jp.add(birthYear);
            jp.add(birthMonth);
            jp.add(birthDay);
            jp.add(birthDate_txt);
            jp.add(lastName_txt);
            jp.add(firstName_txt);
            jp.add(lastName);
            jp.add(firstName);
            
            
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
        
        Address jobseeker_address = new Address(street.getText(), postcode.getText(), city.getText(), country.getText());
        Account jobseeker_account = new Account(e_mail.getText(), password.getText(), phone.getText(), jobseeker_address);
        //Date birthDate = new Date(birthYear.getText(), birthMonth.getText(), birthDay.getText());
        //CV jobseeker_cv = new CV()
        //Jobseeker jobseeker = new Jobseeker (jobseeker_account, jobseeker_cv);
        
        Main_page main = new Main_page();

        
    }
}
}

