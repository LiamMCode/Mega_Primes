package megaPrimes;

import javax.swing.*;

public class Prime 
{
	public static void main(String[] args) 
	{			   
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
				public void run()
				{
					popUP();
				}
		});
	}
	private static void popUP()
	{
		JFrame window = new JFrame("Mega Prime Number Generator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.add(new numberInput());
        //Display the window.
        window.pack();
        window.setLocation(850,450);
        window.setVisible(true);
	}
}