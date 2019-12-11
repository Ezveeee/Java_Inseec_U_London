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

/**
   This class demonstrates the GridLayout manager.
*/

public class Search_jobs extends JFrame
{
   private final int WINDOW_WIDTH = 400;   // Window width
   private final int WINDOW_HEIGHT = 200;  // Window height
   private JLabel[] jobName;
   private JLabel[] companyName;
   private JLabel[] cityName;
   private JLabel[] countryName;
   private final JButton[] btn;
   private int NB_ROW_MAX;
   private static String query;
    @SuppressWarnings("OverridableMethodCallInConstructor")

   public Search_jobs(String user_search)
   {
       int i = 0;
       
      // Set the title bar text.
      setTitle("Grid Layout");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      System.out.print(user_search);
      JPanel jp = new JPanel();
      jp.setLayout(new GridLayout(NB_ROW_MAX, 5));
     jobName = new JLabel[NB_ROW_MAX];
     companyName = new JLabel[NB_ROW_MAX];
     cityName = new JLabel[NB_ROW_MAX];
     countryName = new JLabel[NB_ROW_MAX];
     btn = new JButton[NB_ROW_MAX];
         
    try {     
     while (MySQL.rs.next())
        {
            jobName[i] = new JLabel(MySQL.rs.getString(2));
            query = "SELECT name from company where id = "+MySQL.rs.getInt(9)+";";
            companyName[i] = new JLabel(MySQL.getStringAndExceptionHandling(query));
            query = "SELECT city from address where id ="+MySQL.rs.getInt(10) +";";
            cityName[i] = new JLabel(MySQL.getStringAndExceptionHandling(query));
            query = "SELECT country from address where id ="+MySQL.rs.getInt(10) +";";
            countryName[i] = new JLabel(MySQL.getStringAndExceptionHandling(query));
            btn[i] = new JButton ("More Detail");
            add(jobName[i]);
            add(companyName[i]);
            add(cityName[i]);
            add(countryName[i]);
            add(btn[i]);
            btn[i].addActionListener(new bt1Listener());
            ++i;
        }
     }
     catch (Exception e)
     {
         System.out.println(e);
     }

      // Display the window.
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
                for (int i = 0; i < NB_ROW_MAX; ++i)
                {
                    if (e.getSource() == btn[i])
                    {
                        System.out.print(i);
                    }
                }
        }
    }
   
}