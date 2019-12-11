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
    
    final private JButton persInf = new JButton("Modify my personnal information");
    final private JButton removeAJob = new JButton("Remove a job");
    final private JButton viewJob = new JButton("View my job");
    final private JButton postAJob = new JButton("Post a job");
    final private JButton bt2 = new JButton("🔎");
    final private JTextField Search = new JTextField(10);
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
        postAJob.addActionListener(new addJobListener());
        removeAJob.addActionListener(new removeJobListener());
        viewJob.addActionListener(new viewJobListener());
        
        persInf.setBounds(9*LARGEUR_SCREEN/10-250/2, HAUTEUR_SCREEN/10-50/2, 250, 50);
        postAJob.setBounds(9*LARGEUR_SCREEN/10-250/2, HAUTEUR_SCREEN/10-50/2+75, 250, 50);
        removeAJob.setBounds(9*LARGEUR_SCREEN/10-250/2, HAUTEUR_SCREEN/10-50/2+150, 250, 50);
        viewJob.setBounds(9*LARGEUR_SCREEN/10-250/2, HAUTEUR_SCREEN/10-50/2+225, 250, 50);
        bt2.setBounds(LARGEUR_SCREEN/2+100, 3*HAUTEUR_SCREEN/5-30, 70, 20);
        Search.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-30, 200, 20);
        Search_txt.setBounds(LARGEUR_SCREEN/2-200/2, 3*HAUTEUR_SCREEN/5-50, 200, 20);
        
        jp.add(postAJob);
        jp.add(removeAJob);
        jp.add(viewJob);
        jp.add(bt2);
        jp.add(Search_txt);
        jp.add(Search);
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
        
       Search S = new Search();       
        
    }
}

private class addJobListener implements ActionListener
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
        
        
    }
}

private class viewJobListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        
        
    }
}

}


