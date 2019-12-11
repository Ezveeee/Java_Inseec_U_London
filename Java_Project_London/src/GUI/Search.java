package GUI;

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

public class Search extends JFrame
{
   private final int WINDOW_WIDTH = 400;   // Window width
   private final int WINDOW_HEIGHT = 200;  // Window height
   private final JLabel[] e_mail = new JLabel[8];
   private final JButton[] btn = new JButton[8];
   
    @SuppressWarnings("OverridableMethodCallInConstructor")

   public Search()
   {
      // Set the title bar text.
      setTitle("Grid Layout");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      // Add a GridLayout manager to the content pane.
      setLayout(new GridLayout(8, 2));

     for (int i = 0; i < e_mail.length; ++i)
        {
            e_mail[i] = new JLabel("bite" + i);
            btn[i] = new JButton ("bite" + i);
            add(e_mail[i]);
            add(btn[i]);
            btn[i].addActionListener(new bt1Listener());
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
                for (int i = 0; i < e_mail.length; ++i)
                {
                    if (e.getSource() == btn[i])
                    {
                        System.out.print(i);
                    }
                }
        }
    }
   
}