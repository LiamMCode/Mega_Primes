package megaPrimes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class numberInput extends JPanel
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2123073909258643723L;

    private int i;
    private JLabel inputLabel;
 
    //Fields for data entry
    private JFormattedTextField inputField;
 
    //Formats to format and parse numbers
    private NumberFormat number;
 
    public numberInput() 
    {
    	super(new BorderLayout());
 
        //Create the labels & the text fields.
		inputLabel = new JLabel("Enter a Maximum Number: ");
		JPanel labelPane = new JPanel(new GridLayout(0,1));
		labelPane.add(inputLabel);
		
		inputField = new JFormattedTextField(number);
		inputField.setValue(i);
		inputField.setColumns(10);
		
        inputLabel.setLabelFor(inputField);
		
		// For the key listener to work it requires a focus such as a button
		JPanel buttonPane = new JPanel(new GridLayout(0,1));
		JButton enter = new JButton("Find Mega Prime Numbers");
		JButton exit = new JButton("Exit");
		buttonPane.add(enter);
		buttonPane.add(exit);
		
		enter.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int min = 1;
				int max = (int) inputField.getValue();
				// checks if number is a 32 bit number
				if (max < min || max > 4294967295l)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid integer, not a long i.e. 1 - 4294967295");
				}
				else
				{
					ArrayList<Integer> primes = new ArrayList<Integer>();
					// Finds mega Prime Numbers & adds to the ArrayList
					for (int i = min; i <= max; i++)
					{
						if (isMegaPrime(i))
						{
							primes.add(i);
						}
					}
					// displays the arraylist to a dialog box
					JOptionPane.showMessageDialog(null, primes);
					
				}
			}
        });
		// exits program upon button press
		exit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
        // Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(inputField);
 
        // Sets up window, labels on left, text fields on right.
	    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    add(labelPane, BorderLayout.LINE_START);
	    add(fieldPane, BorderLayout.LINE_END);
	    add(buttonPane, BorderLayout.SOUTH);
	}
    
    // Calls the functions to check if the number is prime and its digits are prime too
    public static boolean isMegaPrime(int n)
    {
    	return (checkDigits(n) && isPrime(n));
    }
    
    // checks if the number is prime
    public static boolean isPrime(int n)
    {
    	if (n <= 1)
    	{
    		return false;
    	}
    	
    	for (int i = 2; i <= Math.sqrt(n); i++)
    	{
    		if (n % i == 0)
    		{
    			return false;
    		}
    	}
		return true;
    }
    
    // function to check digits if prime
    public static boolean checkDigits(int n)
    {
        // check all digits are prime or not
        while (n > 0) 
        {
            int dig = n % 10;
  
            // check if digits are prime or not
            if (dig != 2 && dig != 3 && dig != 5 && dig != 7)
                return false;
  
            n /= 10;
        }
  
        return true;
    }
}