package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main_page_Company extends JFrame {
    
    final private JButton persInf = new JButton("Modify my personal information");
    final private JButton viewJob = new JButton("View posted jobs");
    final private JButton postAJob = new JButton("Post a job");
    final private JButton removeAJob = new JButton("Remove a job");
    final private JButton logout = new JButton("Logout");
    final private JButton bt2 = new JButton("🔎");
    final private JTextField search = new JTextField(10);
    final private JLabel Search_txt = new JLabel("Search a CV");
    private final int HAUTEUR_SCREEN = 600;
    private final int LARGEUR_SCREEN = 1200;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Main_page_Company()
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
        
        persInf.addActionListener(new bt1Listener());
        bt2.addActionListener(new bt2Listener());
        postAJob.addActionListener(new postJobListener());
        removeAJob.addActionListener(new removeJobListener());
        viewJob.addActionListener(new viewJobListener());
        logout.addActionListener(new logoutListener());
        
        persInf.setBounds(9*LARGEUR_SCREEN/10-250/2, HAUTEUR_SCREEN/10-50/2, 250, 50);
        postAJob.setBounds(9*LARGEUR_SCREEN/10-250/2, HAUTEUR_SCREEN/10-50/2+75, 250, 50);
        viewJob.setBounds(9*LARGEUR_SCREEN/10-250/2, HAUTEUR_SCREEN/10-50/2+150, 250, 50);
        bt2.setBounds(LARGEUR_SCREEN/2+100, 3*HAUTEUR_SCREEN/5-30, 70, 20);
        search.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-30, 200, 20);
        Search_txt.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-50, 200, 20);
        logout.setBounds(50, HAUTEUR_SCREEN - 25, 250, 50);
        
        jp.add(logout);
        jp.add(postAJob);
        jp.add(viewJob);
        jp.add(bt2);
        jp.add(Search_txt);
        jp.add(search);
        jp.add(persInf);
        add(jp);
        setVisible(true);
    }
    
    
private class bt1Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Pers_Inf_Company perInf = new Pers_Inf_Company();
        
    }
}
private class bt2Listener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (!search.getText().isEmpty()){
            Search_CV S = new Search_CV(search.getText());       
        }
       
        
    }
}

private class postJobListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Add_Job_Screen addJob = new Add_Job_Screen();
    }
}

private class removeJobListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        //Remove_Job_Screen removeJob = new Remove_Job_Screen();
    }
}

private class viewJobListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Company_jobs CJ =new Company_jobs();
    }
}

private class logoutListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        dispose();
        Login lng = new Login();
    }
}


}


