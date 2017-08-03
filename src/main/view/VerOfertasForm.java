package main.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePickerImpl;

import main.controller.Application;

import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class VerOfertasForm extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private final JMenuBar menuBar = new JMenuBar();
	private JDatePickerImpl datePicker;
	private final JButton btnBuscar = new JButton("Buscar por fecha");
	private final JButton btnVerTodas = new JButton("Ver Todas");
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try {
			VerOfertasForm dialog = new VerOfertasForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerOfertasForm()
	{
		setTitle("Ver Ofertas");
			
		
		setBounds(100, 300, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		table = new JTable();
		table.setBounds(365, 37, -320, 134);
		contentPanel.add(table);

		scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);

		setJMenuBar(menuBar);
		JPanel pnlDatePicker = new JPanel();
		pnlDatePicker.setBounds(0, 0, 200, 50);

		datePicker = CalendarioForm.getPickerToday();
		pnlDatePicker.add(datePicker);
		menuBar.add(pnlDatePicker);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTablaPorFecha();
			}
		});
		menuBar.add(btnBuscar);
		
		btnVerTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		menuBar.add(btnVerTodas);
	}
	
	public void cargarTabla()
	{
		table.setModel(Application.mostrarTablaOfertas());
	}
	
	public void cargarTablaPorFecha()
	{
		String textoFecha = datePicker.getJFormattedTextField().getText().trim();
		if (textoFecha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha");
			return;
		}
		LocalDate.parse(textoFecha);
		table.setModel(Application.mostrarTablaOfertas(textoFecha));
	}
}
