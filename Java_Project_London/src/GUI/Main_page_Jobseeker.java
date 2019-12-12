package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main_page_Jobseeker extends JFrame {
    
    final private JButton cv = new JButton("Modify my CV");
    final private JButton persInf = new JButton("Modify my personal information");
    final private JButton job = new JButton("View my job requests");
    final private JButton bt2 = new JButton("🔎");
    final private JTextField search = new JTextField(10);
    final private JLabel Search_txt = new JLabel("Search a Job");
    final private JButton logout = new JButton("Logout");
    private final int HAUTEUR_SCREEN = 600;
    private final int LARGEUR_SCREEN = 1200;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Main_page_Jobseeker()
    {
        setTitle("Paule en ploie");
        //this.setLocation(150,75);
        //setLocation(500,150);
        //setSize(LARGEUR_SCREEN,HAUTEUR_SCREEN);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        cv.addActionListener(new cvListener());
        persInf.addActionListener(new persInfListener());
        job.addActionListener(new jobListener());
        bt2.addActionListener(new bt2Listener());
        logout.addActionListener(new logoutListener());
        
        cv.setBounds(9*LARGEUR_SCREEN/10-100/2, HAUTEUR_SCREEN/10-50/2, 250, 50);
        persInf.setBounds(9*LARGEUR_SCREEN/10-100/2, HAUTEUR_SCREEN/10-50/2 + 75, 250, 50);
        job.setBounds(9*LARGEUR_SCREEN/10-100/2, HAUTEUR_SCREEN/10-50/2 + 150, 250, 50);
        bt2.setBounds(LARGEUR_SCREEN/2+100, 3*HAUTEUR_SCREEN/5-30, 70, 20);
        search.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-30, 200, 20);
        Search_txt.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-50, 200, 20);
        logout.setBounds(50, HAUTEUR_SCREEN - 25, 250, 50);
        
        jp.add(logout);
        jp.add(bt2);
        jp.add(Search_txt);
        jp.add(search);
        jp.add(cv);
        jp.add(persInf);
        jp.add(job);
        add(jp);
        setVisible(true);
    }
    
    
private class cvListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        CV_Screen cv = new CV_Screen();
        
    }
}

private class persInfListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Pers_Inf_Jobseeker persInf = new Pers_Inf_Jobseeker();
        
    }
}

private class jobListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
private class bt2Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (!search.getText().isEmpty()){
            Search_jobs S = new Search_jobs(search.getText());    
        }
          
        
    }
}

private class logoutListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        dispose();
        Login_screen lng = new Login_screen();
    }
}

}


