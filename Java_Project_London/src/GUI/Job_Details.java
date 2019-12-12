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
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Job_Details extends JFrame{
    final private JButton lgn = new JButton("Post");
    final private JLabel contractType_txt;
    final private JLabel partFull_txt;
    final private JLabel startingDate_txt;
    final private JLabel endingDate_txt;
    final private JLabel street_txt;
    final private JLabel postcode_txt;
    final private JLabel city_txt;
    final private JLabel country_txt;
    final private JLabel nameJob_txt;
    final private JLabel description_txt;
    final private JLabel salary_txt;
    private final int HAUTEUR_SCREEN = 600;
    private final int LARGEUR_SCREEN = 1200;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Job_Details()
    {
        setTitle("Post a Job");
        //this.setLocation(150,75);
        setLocation(50,50);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        
        
        
        lgn.addActionListener(new bt1Listener());
        
        
            nameJob_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5-50, 200, 20);
            contractType_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 , 200, 20);
            description_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 100, 200, 20);
            partFull_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 50, 200, 20);
            street_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 - 50, 200, 20);
            postcode_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 , 200, 20);
            city_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +50 , 200, 20);
            country_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 100, 200, 20);
            startingDate_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 180, 200, 20);
            endingDate_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 230, 200, 20);
            salary_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 280, 200, 20);

            jp.add(salary_txt);
            jp.add(endingDate_txt);
            jp.add(startingDate_txt);
            jp.add(city_txt);
            jp.add(country_txt);
            jp.add(postcode_txt);
            jp.add(street_txt);
            jp.add(partFull_txt);
            jp.add(description_txt);
            jp.add(contractType_txt);
            jp.add(nameJob_txt);
            
            
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

            String query = "SELECT name FROM Company WHERE id=" + Account.getLoggedID() + ";";
            String companyName = MySQL.getStringAndExceptionHandling(query);
            Address job_address = new Address(street.getText(), postcode.getText(), city.getText(), country.getText());
            DMY startingDate = new DMY(startingDay.getText(), startingMonth.getText(), startingYear.getText());
            DMY endingDate = new DMY(endingDay.getText(), endingMonth.getText(), endingYear.getText());
            Job job = new Job(companyName, nameJob.getText(), contractType.getSelectedItem().toString(), job_address,
                                                description.getText(), salary.getText(), startingDate, endingDate, partFull.getSelectedItem().toString());

            job_address.registerAddress();
            job.registerJob();
        }
    }
}

