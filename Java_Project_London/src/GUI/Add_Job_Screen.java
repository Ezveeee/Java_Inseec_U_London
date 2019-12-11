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

public class Add_Job_Screen extends JFrame{
    final private JButton lgn = new JButton("Post");
    final private JTextField nameJob = new JTextField(10);
    final private JComboBox <String> contractType;
    final private JComboBox <String> partFull;
    final private JLabel contractType_txt = new JLabel("Type of contract");
    final private JLabel partFull_txt = new JLabel("Hours");
    final private JTextField street = new JTextField(10);
    final private JTextField postcode = new JTextField(10);
    final private JTextField city = new JTextField(10);
    final private JTextField country = new JTextField(10);
    final private JTextField startingDay = new JTextField(10);
    final private JTextField startingMonth = new JTextField(10);
    final private JTextField startingYear = new JTextField(10);
    final private JTextField endingDay = new JTextField(10);
    final private JTextField endingMonth = new JTextField(10);
    final private JTextField endingYear = new JTextField(10);    
    final private JLabel startingDate_txt = new JLabel("Starting Date (jj/mm/yyyy)");
    final private JLabel endingDate_txt = new JLabel("Ending Date (jj/mm/yyyy)");
    final private JLabel street_txt = new JLabel("Street");
    final private JLabel postcode_txt = new JLabel("Postcode");
    final private JLabel city_txt = new JLabel("City");
    final private JLabel country_txt = new JLabel("Country");
    final private JLabel nameJob_txt = new JLabel("Name of the Job");
    final private JLabel description_txt = new JLabel("Description");
    final private JTextArea description = new JTextArea();
    final private JLabel salary_txt = new JLabel("Salary");
    final private JTextArea salary = new JTextArea();
    private final int HAUTEUR_SCREEN = 600;
    private final int LARGEUR_SCREEN = 1200;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Add_Job_Screen()
    {
        String [] contractTypeNames = {"Permanent", "Fixed-term", "Internship", "Temporary", "Other"};
        String [] partFullTime = {" ", "Part time", "Full time", "Paid hourly"};
        setTitle("Post a Job");
        //this.setLocation(150,75);
        setLocation(50,50);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        contractType = new JComboBox<>(contractTypeNames);
        partFull = new JComboBox<>(partFullTime);
        
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        
        lgn.addActionListener(new bt1Listener());
        
        
            nameJob.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5-30, 200, 20);
            nameJob_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5-50, 200, 20);
            contractType_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 , 200, 20);
            contractType.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 20, 200, 20);
            description_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 100, 200, 20);
            description.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 120, 300, 200);
            partFull_txt.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 50, 200, 20);
            partFull.setBounds(3*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 70, 200, 20);
            street_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 - 50, 200, 20);
            street.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 -30, 200, 20);
            postcode_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 , 200, 20);
            postcode.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +20, 200, 20);
            city_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +50 , 200, 20);
            city.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 +70, 200, 20);
            country_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 100, 200, 20);
            country.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 120, 200, 20);
            startingDate_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 180, 200, 20);
            startingDay.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 200, 20, 20);
            startingMonth.setBounds(7*LARGEUR_SCREEN/10-200/2 + 20, HAUTEUR_SCREEN/5 + 200, 20, 20);
            startingYear.setBounds(7*LARGEUR_SCREEN/10-200/2 + 40, HAUTEUR_SCREEN/5 + 200, 35, 20);
            endingDate_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 230, 200, 20);
            endingDay.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 250, 20, 20);
            endingMonth.setBounds(7*LARGEUR_SCREEN/10-200/2 + 20, HAUTEUR_SCREEN/5 + 250, 20, 20);
            endingYear.setBounds(7*LARGEUR_SCREEN/10-200/2 + 40, HAUTEUR_SCREEN/5 + 250, 35, 20);
            salary_txt.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 280, 200, 20);
            salary.setBounds(7*LARGEUR_SCREEN/10-200/2, HAUTEUR_SCREEN/5 + 300, 200, 20);

            jp.add(salary);
            jp.add(salary_txt);
            jp.add(endingDay);
            jp.add(endingMonth);
            jp.add(endingYear);
            jp.add(endingDate_txt);
            jp.add(startingDay);
            jp.add(startingMonth);
            jp.add(startingYear);
            jp.add(startingDate_txt);
            jp.add(city_txt);
            jp.add(city);
            jp.add(country_txt);
            jp.add(country);
            jp.add(postcode_txt);
            jp.add(postcode);
            jp.add(street_txt);
            jp.add(street);           
            jp.add(partFull_txt);
            jp.add(partFull);
            jp.add(description_txt);
            jp.add(description);
            jp.add(contractType);
            jp.add(contractType_txt);
            jp.add(nameJob_txt);
            jp.add(nameJob);
            
            
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

