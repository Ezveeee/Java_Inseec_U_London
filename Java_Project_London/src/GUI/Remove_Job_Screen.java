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

public class Remove_Job_Screen extends JFrame{
    final private JButton btn_yes = new JButton("Yes");
    final private JButton btn_no = new JButton("No");
    final private JLabel confirmation_txt = new JLabel("Are you sure?");
    private final int HAUTEUR_SCREEN = 300;
    private final int LARGEUR_SCREEN = 300;
    private int jobID = 0;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Remove_Job_Screen(int jobID){
        this.jobID = jobID;
        setTitle("Remove job");
        //this.setLocation(150,75);
        setLocation(50,50);
        setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        btn_yes.addActionListener(new bt1Listener());
        btn_no.addActionListener(new bt2Listener());
        
        btn_yes.setBounds(LARGEUR_SCREEN/2-60, HAUTEUR_SCREEN/2+10, 60, 20);
        btn_no.setBounds(LARGEUR_SCREEN/2, HAUTEUR_SCREEN/2+10, 60, 20);
        confirmation_txt.setBounds(LARGEUR_SCREEN/2-50, HAUTEUR_SCREEN/2-50, 100, 20);


        jp.add(btn_yes);
        jp.add(btn_no);
        jp.add(confirmation_txt);
        add(jp);
        setVisible(true);
    }
    
    
    private class bt1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Job.removeJob(jobID);
            setVisible(false);
            dispose();
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

