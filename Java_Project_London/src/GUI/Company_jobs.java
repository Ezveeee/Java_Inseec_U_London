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
import java.awt.GridLayout; 
import java.util.ArrayList;

/**
   This class demonstrates the GridLayout manager.
*/

public class Company_jobs extends JFrame
{
   private final int WINDOW_WIDTH = 800;   // Window width
   private final int WINDOW_HEIGHT = 400;  // Window height
   private final String[][] jobListID;
   private final JButton[] btnList; 
   private static String query;
    @SuppressWarnings("OverridableMethodCallInConstructor")

   public Company_jobs()
   {
       setTitle("Grid Layout");
       setLocation (400, 50);
       setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       JPanel jp = new JPanel();
       
       jobListID = MySQL.getCompanyJobList();
       
       
       jp.setLayout(new GridLayout(jobListID.length, 5));
       
       JLabel[] labelList = new JLabel[jobListID.length*4];
       btnList = new JButton[jobListID.length];
       try{
           int j=0;
           for (int i = 0; i < jobListID.length; ++i){
             //  labelList[j] = new JLabel(Integer.toString(jobListID[i]));
               jp.add(labelList[j]);
               ++j;

               //labelList[j] = new JLabel(jobListCompany[i]);
               jp.add(labelList[j]);
               ++j;

               //labelList[j] = new JLabel(jobListCity[i]);
               jp.add(labelList[j]);
               ++j;

               //labelList[j] = new JLabel(jobListCountry[i]);
               jp.add(labelList[j]);
               ++j;

               btnList[i] = new JButton("Details");
               jp.add(btnList[i]);
               btnList[i].addActionListener(new bt1Listener());
           }
       }
       catch(Exception e){
           System.out.println("Can't loop through jobList :" + e);
       }
       this.add(jp);
       setVisible(true);
   }
   
   /**
      The main method creates an instance of the GridWindow
      class, causing it to display its window.
   */
   private class bt1Listener implements ActionListener 
    {
       
       
        public void actionPerformed(ActionEvent e)
        {
            for (int i=0; i < jobListID.length; ++i)
            {
                if (e.getSource() == btnList[i])
                {
                   // Job_Details JB = new Job_Details(jobListID[i]);
                }
            }
        }
    }
   
}