package main.view;

import java.awt.BorderLayout;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePickerImpl;

import main.controller.Application;
import main.model.Oferta;
import main.service.OfertaService;
import main.util.Comparador;
import main.util.ExpReg;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargarOfertasForm extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreBanda;
	private JTextField txtTelefono;
	private JTextArea txtFacilidades;
	private JSpinner spnPrecio;
	private JSpinner spnDesde;
	private JSpinner spnHasta;
	private JDatePickerImpl datePicker;
	
	/**
	 * Launch the application.

	 */
	public static void main(String[] args) 
	{
		try {
			CargarOfertasForm dialog = new CargarOfertasForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CargarOfertasForm() 
	{
		setTitle("Cargar Oferta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreBanda = new JLabel("Banda");
		lblNombreBanda.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNombreBanda);
		
		txtNombreBanda = new JTextField();
		txtNombreBanda.setBounds(66, 8, 145, 20);
		contentPanel.add(txtNombreBanda);
		txtNombreBanda.setColumns(10);
		
		JLabel lblTelefno = new JLabel("Telef\u00F3no");
		lblTelefno.setBounds(221, 11, 72, 14);
		contentPanel.add(lblTelefno);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(316, 8, 108, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 36, 46, 14);
		contentPanel.add(lblPrecio);
		
		JLabel lblFacilidadesSolicitadas = new JLabel("Facilidades Solicitadas");
		lblFacilidadesSolicitadas.setBounds(10, 61, 132, 14);
		contentPanel.add(lblFacilidadesSolicitadas);
		
		txtFacilidades = new JTextArea();
		txtFacilidades.setBounds(10, 84, 200, 73);
		txtFacilidades.setLineWrap(true);
		contentPanel.add(txtFacilidades);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(221, 36, 46, 14);
		contentPanel.add(lblDesde);
		
		spnDesde = new JSpinner();
		spnDesde.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spnDesde.setBounds(277, 33, 42, 20);
		contentPanel.add(spnDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(339, 36, 46, 14);
		contentPanel.add(lblHasta);
		
		spnHasta = new JSpinner();
		spnHasta.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		spnHasta.setBounds(382, 33, 42, 20);
		contentPanel.add(spnHasta);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(220, 61, 46, 14);
		contentPanel.add(lblFecha);
		
		JPanel pnlDatePicker = new JPanel();
		pnlDatePicker.setBounds(220, 84, 204, 73);
		contentPanel.add(pnlDatePicker);
		datePicker = CalendarioForm.getPickerToday();
		pnlDatePicker.add(datePicker);
		
		spnPrecio = new JSpinner();
		spnPrecio.setModel(new SpinnerNumberModel(new Integer(100), new Integer(100), null, new Integer(100)));
		spnPrecio.setBounds(66, 33, 139, 20);
		contentPanel.add(spnPrecio);
		
		JButton btnAgregarOferta = new JButton("Agregar Oferta");
		btnAgregarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				agregarOferta();
			}
		});
		btnAgregarOferta.setBounds(10, 168, 414, 44);
		ImageIcon icon = new ImageIcon("img/add.png");
		btnAgregarOferta.setIcon(icon);
		contentPanel.add(btnAgregarOferta);
		
		reiniciarCampos();
	}
	
	private void agregarOferta()
	{
		txtNombreBanda.setText(txtNombreBanda.getText().trim());
		txtTelefono.setText(txtTelefono.getText().trim());
		
		if (!camposValidos())
			JOptionPane.showMessageDialog(null, "Algunos campos son Invalidos");
		if (OfertaService.getOfertasRecibidas().contains(getCampos()))
			JOptionPane.showMessageDialog(null, "ERROR! Oferta cargada anteriormente");
		
		else {
			Application.agregarOferta(getCampos());
			JOptionPane.showMessageDialog(null, "Su oferta ha sido cargada correctamente");
			reiniciarCampos();
		}
	}
	
	private boolean camposValidos()
	{
		if (txtNombreBanda.getText() == "") return false;
		if (txtTelefono.getText() == "") return false;
		if (!ExpReg.containOnlyNumbers(txtTelefono.getText())) return false;
		if (!horarioCorrecto()) return false;
		if (!fechaCorrecta()) return false;
		
		return true;
	}
	
	private void reiniciarCampos()
	{
		txtNombreBanda.setText("");
		txtTelefono.setText("");
		txtFacilidades.setText("");
		spnDesde.setValue(new Integer(0));
		spnHasta.setValue(new Integer(1));
		spnPrecio.setModel(new SpinnerNumberModel(new Integer(100), new Integer(100), null, new Integer(100)));
	}
	
	private boolean horarioCorrecto()
	{
		int desde = (Integer) spnDesde.getValue();
		int hasta = (Integer) spnHasta.getValue();
		
		if(desde >= hasta)
			return false;
		
		return true;
	}
	
	private boolean fechaCorrecta()
	{
		String textoFecha = datePicker.getJFormattedTextField().getText().trim();
		if (textoFecha.isEmpty()) return false;
		int valor = Comparador.compareFecha(LocalDate.now(), LocalDate.parse(textoFecha));
		if (valor > 0) return false;
		
		return true;
	}
	
	private Oferta getCampos()
	{
		String textoFecha = datePicker.getJFormattedTextField().getText().trim();
		int desde = (Integer) spnDesde.getValue();
		int hasta = (Integer) spnHasta.getValue();
		int precio = (Integer) spnPrecio.getValue();
		Oferta o = new Oferta(LocalDate.parse(textoFecha), desde, hasta, precio, txtNombreBanda.getText(),
				txtTelefono.getText(), txtFacilidades.getText());
		
		return o;
	}
	
}
