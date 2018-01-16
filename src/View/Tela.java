package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Controller.Proc;
public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField txtExecute;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		Proc p = new Proc();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtExecute = new JTextField();
		txtExecute.setBounds(68, 66, 326, 20);
		contentPane.add(txtExecute);
		txtExecute.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(97, 130, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(196, 130, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnProcurar = new JButton("Procurar...");
		btnProcurar.setBounds(294, 130, 100, 23);
		contentPane.add(btnProcurar);
		
		JLabel lblAbrir = new JLabel("Abrir:");
		lblAbrir.setBounds(12, 69, 46, 14);
		contentPane.add(lblAbrir);
		
		ActionListener Executa = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.chamaProcesso(txtExecute.getText(), Tela.this);
			}
		};		
		btnOk.addActionListener(Executa);
		txtExecute.addActionListener(Executa);
		
		ActionListener Procurar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtExecute.setText(p.procuraArquivo());
			}
		};
		btnProcurar.addActionListener(Procurar);
		
		ActionListener Cancela = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p.Sair(Tela.this);
			}
		};
		btnCancelar.addActionListener(Cancela);
	}
}
