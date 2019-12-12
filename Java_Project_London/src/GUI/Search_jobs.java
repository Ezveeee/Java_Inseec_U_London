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
   private ArrayList<JButton> btn = new ArrayList<JButton>();
   private static String query;
    @SuppressWarnings("OverridableMethodCallInConstructor")

   public Search_jobs(String user_search)
   {
       setTitle("Grid Layout");
       setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       JPanel jp = new JPanel();
       
       String[][] jobList = MySQL.getJobList(user_search);

       setLayout(new GridLayout(jobList[0].length, 5));
       
       int i = 0;
       int j = 0;
       JLabel[] labelList = new JLabel[jobList.length*4];
       JButton btnDescription = new JButton("Details");
       try{
           while (i < jobList.length)
           {
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

               btn.add(btnDescription);
               jp.add(btn.get(i));
               btn.get(i).addActionListener(new bt1Listener());

               ++i;
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