package main.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OptionsForm extends JPanel {
	private static final long serialVersionUID = 1L;
	Image imagen;
	String rutaImagen;

	public OptionsForm(String nombre) 
	{
		this.rutaImagen = nombre;
		this.setLayout(null);

		JButton btnCargarOfertas = new JButton("Cargar Ofertas");
		btnCargarOfertas.setBounds(238, 51, 160, 23);
		btnCargarOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarOfertas();
			}
		});
		this.add(btnCargarOfertas);

		JButton btnVerOfertas = new JButton("Ver Ofertas");
		btnVerOfertas.setBounds(238, 85, 160, 23);
		btnVerOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verOfertas();
				JOptionPane.showMessageDialog(null, "Puede seleccionar una fecha para Ver las Ofertas de ese dia o simplemente Ver Todas");	
			}
		});
		add(btnVerOfertas);
		
		JButton btnVerMejoresOfertas = new JButton("Ver  Mejores Ofertas");
		btnVerMejoresOfertas.setBounds(238, 120, 160, 23);
		btnVerMejoresOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verMejoresOfertas();
				JOptionPane.showMessageDialog(null, "Seleccione una fecha para ver las Mejores Ofertas de ese dia");
			}
		});
		add(btnVerMejoresOfertas);
	}
	   
	private void cargarOfertas() 
	{
		new CargarOfertasForm().setVisible(true);
	}
	
	private void verOfertas()
	{
		new VerOfertasForm().setVisible(true);
	}
	
	private void verMejoresOfertas() 
	{
		new VerMejoresOfertasForm().setVisible(true);
	}

	public void paint(Graphics g)
	{
		imagen = new ImageIcon(rutaImagen).getImage();
		g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paint(g);
	} 
}