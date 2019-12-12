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

public class Search_jobs extends JFrame
{
   private final int WINDOW_WIDTH = 400;   // Window width
   private final int WINDOW_HEIGHT = 200;  // Window height
   private static String query;
    @SuppressWarnings("OverridableMethodCallInConstructor")

   public Search_jobs(String user_search)
   {
       setTitle("Grid Layout");
       setLocation (400, 50);
       setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       JPanel jp = new JPanel();
       
       String[][] jobList = MySQL.getJobList(user_search);
       
       jp.setLayout(new GridLayout(jobList.length, 5));
       
       JLabel[] labelList = new JLabel[jobList.length*4];
       JButton[] btnList = new JButton[jobList.length];
       try{
           int j=0;
           for (int i = 0; i < jobList.length; ++i){
               labelList[j] = new JLabel(jobList[i][0]);
               jp.add(labelList[j]);
               ++j;

               labelList[j] = new JLabel(jobList[i][1]);
               jp.add(labelList[j]);
               ++j;

               labelList[j] = new JLabel(jobList[i][2]);
               jp.add(labelList[j]);
               ++j;

               labelList[j] = new JLabel(jobList[i][3]);
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
            
        }
    }
   
}