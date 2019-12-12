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
import javax.swing.JTextArea;
import london.recruitmentsystem.CV;

public class CV_Screen extends JFrame {
    
    final private JPanel jp = new JPanel();
    final private JButton Save = new JButton("Save");
    final private JTextArea overview;
    final private JTextArea education;
    final private JTextArea workExperience;
    final private JTextArea skills;
    private static String query;
    final private JLabel overview_txt = new JLabel("Overview");
    final private JLabel education_txt = new JLabel("Education");
    final private JLabel workExperience_txt = new JLabel("Work Experience");
    final private JLabel skills_txt = new JLabel("Skills");
    private final int HAUTEUR_SCREEN = 550;
    private final int LARGEUR_SCREEN = 800;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public CV_Screen()
    {
        String[] infos = MySQL.getLoggedInCVInfo();
        overview = new JTextArea(infos[0]);
        education = new JTextArea(infos[1]);
        workExperience = new JTextArea(infos[2]);
        skills = new JTextArea(infos[3]);
        setTitle("Modify Your CV");
        //this.setLocation(150,75);
        setLocation(300,50);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container frame = getContentPane();
        jp.setLayout(null);
        overview.setLineWrap(true);
        overview.setWrapStyleWord(true);
        education.setLineWrap(true);
        education.setWrapStyleWord(true);
        workExperience.setLineWrap(true);
        workExperience.setWrapStyleWord(true);
        skills.setLineWrap(true);
        skills.setWrapStyleWord(true);
        Save.addActionListener(new bt1Listener());
        
        Save.setBounds(LARGEUR_SCREEN/2-125/2, 9*HAUTEUR_SCREEN/10 - 20, 125, 20);
        overview_txt.setBounds(50, 10, 200, 20);
        overview.setBounds(50, 30, 300, 200);
        education.setBounds(50, 260, 300, 200);
        education_txt.setBounds(50, 240, 200, 20);
        workExperience.setBounds(450, 30, 300, 200);
        workExperience_txt.setBounds(450, 10, 200, 20);
        skills.setBounds(450, 260, 300, 200);
        skills_txt.setBounds(450, 240, 200, 20);
        
        jp.add(overview);
        jp.add(education);
        jp.add(workExperience);
        jp.add(skills);
        jp.add(overview_txt);
        jp.add(education_txt);
        jp.add(workExperience_txt);
        jp.add(skills_txt);
        jp.add(Save);
        add(jp);
        setVisible(true);
    }
    
    
    private class bt1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            setVisible(false);
            dispose();

            CV.modifyCV(overview.getText(), education.getText(), workExperience.getText(), skills.getText());
        }
    }
    
}


