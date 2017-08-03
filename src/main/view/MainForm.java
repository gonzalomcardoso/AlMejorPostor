package main.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MainForm 
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame();
		app.setTitle("Creizi Records Reservas");
		app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		app.setSize(640, 480);
		app.setResizable(false);
		OptionsForm optionsForm = new OptionsForm("img/fondo.jpg");
		app.getContentPane().add(optionsForm);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
	}
}
