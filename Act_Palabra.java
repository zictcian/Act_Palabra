package MedinaFlores;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JOptionPane;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Act_Palabra extends JFrame implements ActionListener{
	private JFrame ventana;
	private JButton botonValidar;
	private JTextField cajaingresar;
	private JLabel palabraText,palindromoText,LongitudText,inversaText,repetidaText;
	public Act_Palabra() {
		super();
		configurarVentana();
		crearComponentes();
	}
	
	private void configurarVentana(){
		this.setTitle("Palabra.exe");
		this.setSize(500,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setCursor(Cursor.HAND_CURSOR);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void crearComponentes() {
		botonValidar = new JButton();
		botonValidar.setText(" Validar ");
		botonValidar.setBounds(200,80, 100, 30);
		botonValidar.addActionListener(this);
		this.add(botonValidar);
		
		cajaingresar = new JTextField();
		cajaingresar.setBounds(200,40,200,30);
		cajaingresar.setBorder(null);
		this.add(cajaingresar);
		
		palabraText = new JLabel();
		palabraText.setText("Ingrese su palabra");
		palabraText.setBounds(10,35, 150, 50);
		palabraText.setForeground(Color.darkGray);
		this.add(palabraText);
		
		palindromoText = new JLabel();
		palindromoText.setText("palindromo:");
		palindromoText.setBounds(50,100, 150, 50);
		palindromoText.setForeground(Color.darkGray);
		this.add(palindromoText);
		
		LongitudText = new JLabel();
		LongitudText.setText("Longitud:");
		LongitudText.setBounds(50,150, 150, 50);
		LongitudText.setForeground(Color.darkGray);
		this.add(LongitudText);
		
		inversaText = new JLabel();
		inversaText.setText("inversa:");
		inversaText.setBounds(50,200, 150, 50);
		inversaText.setForeground(Color.darkGray);
		this.add(inversaText);
		
		repetidaText = new JLabel();
		repetidaText.setText("repetida:");
		repetidaText.setBounds(50,250, 150, 50);
		repetidaText.setForeground(Color.darkGray);
		this.add(repetidaText);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Act_Palabra ventana = new Act_Palabra();
		ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String valor = cajaingresar.getText();
		valor=valor.toLowerCase();
		String espacios[]=valor.split(" ");
		String espacio="";
		for(int i=0;i<espacios.length;i++) {
			espacio=espacio+espacios[i];
		}
		valor=espacio;
		
		String longitud=String.valueOf(valor.length());
		LongitudText.setText("Longitud: "+longitud);
		String valorAux = "";
		for(int i=0;i<valor.length();i++) {
			char valorAuxiliar=valor.charAt(i);
			if(i==valor.length()) {
				valorAux=String.valueOf(valorAuxiliar);
			}else {
				valorAux =String.valueOf(valorAuxiliar)+valorAux;
			}
		}
		System.out.println(valorAux);
		inversaText.setText("Inversa: "+valorAux);
		
		if(valor.equals(valorAux)) {
			palindromoText.setText("palindromo: Si");
		}else {
			palindromoText.setText("palindromo: No");
		}
		
		palabraText.setText("Palabra es "+valor);
		
		String[] repetidos=new String[valor.length()];
		int[] contadorRepetidos=new int[valor.length()];
		int contador=0;
		for(int i=0;i<valor.length();i++) {
			for(int j=0;j<valor.length();j++) {
				if(valor.charAt(i)==valor.charAt(j)) {
					contadorRepetidos[i]+=1;
					repetidos[i]=String.valueOf(valor.charAt(i));
				}
			}
		}
		int mayor=0,aux=0;
		for(int i=0;i<valor.length();i++) {
			if(i==0) {
				mayor=contadorRepetidos[0];
			}else {
				if(mayor<=contadorRepetidos[i]) {
					mayor=contadorRepetidos[i];
					aux=i;
				}
			}
		}
		repetidaText.setText("Repetida: "+repetidos[aux]);
	}
	
	
	
}
