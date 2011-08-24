/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.portugol.nucleo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.univali.portugol.nucleo.excecoes.ExcecaoArquivoContemErros;
import br.univali.portugol.nucleo.excecoes.ListaMensagens;
import br.univali.portugol.nucleo.excecoes.Mensagem;
import br.univali.portugol.nucleo.iu.Entrada;
import br.univali.portugol.nucleo.iu.Saida;

/**
 *
 * @author Luiz Fernando
 */
public class Teste
{
    public static void main(String[] args) throws ExcecaoArquivoContemErros 
    {
    	try
    	{
	    	JFrame testFrame = new JFrame();
	    	
	    	testFrame.setSize(640, 480);
	    	testFrame.setLocationRelativeTo(null);
	    	testFrame.setVisible(true);
	    	testFrame.setLayout(new BorderLayout());
	    	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	final JTextArea textArea = new JTextArea();
	    	textArea.setText(loadFromFile());
	    	
	    	JScrollPane textAreaScrollPane = new JScrollPane();
	    	textAreaScrollPane.setViewportView(textArea);
	    	
	    	JPanel editoPanel = new JPanel();    	
	    	editoPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
	    	editoPanel.setLayout(new GridLayout(1, 1));
	    	editoPanel.add(textAreaScrollPane);
	    	
	    	testFrame.add(editoPanel, BorderLayout.CENTER);
	    	
	    	JButton runButton = new JButton();	    	
	    	runButton.setSize(120, 25);
	    	runButton.setLocation(10, 0);
	    	
	    	JPanel buttonPanel = new JPanel();
	    	buttonPanel.setLayout(null);
	    	buttonPanel.add(runButton);
	    	buttonPanel.setPreferredSize(new Dimension(0, 25));
	    	buttonPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
	    	
	    	final JList errorList = new JList();
	    	errorList.setModel(new DefaultListModel());
	    	
	    	JScrollPane listScrollPane = new JScrollPane();
	    	listScrollPane.setViewportView(errorList);
	    	
	    	JPanel errorListPanel = new JPanel();
	    	errorListPanel.setLayout(new GridLayout(1, 1));
	    	errorListPanel.add(listScrollPane);
	    	errorListPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));	    	

	    	JPanel southPanel = new JPanel();
	    	southPanel.setPreferredSize(new Dimension(0, 180));
	    	southPanel.setLayout(new BorderLayout());
	    	southPanel.add(buttonPanel, BorderLayout.NORTH);
	    	southPanel.add(errorListPanel, BorderLayout.SOUTH);
	    	
	    	testFrame.add(southPanel, BorderLayout.SOUTH);
	    	
	    	runButton.setAction(new AbstractAction("Executar") 
	    	{			
				@Override
				public void actionPerformed(ActionEvent event) 
				{
					try
					{
						saveToFile(textArea.getText());					
						AnalizadorSemantico as = new AnalizadorSemantico(new File("examples/teste.por"));
					       
						ListaMensagens listaMensagens = as.analizar();
						DefaultListModel model = (DefaultListModel) errorList.getModel();
						model.clear();
						
						if (listaMensagens.getNumeroMensagens() > 0)
						{						       
							for (Mensagem mensagem : listaMensagens) 
							{
								model.addElement(mensagem.getMensagem() + ". Linha: " + mensagem.getLinha() + ", Coluna: " + mensagem.getColuna());
							}				
						}
						
						else
						{
							IO io = new IO();
							Interpretador interpretador = new Interpretador();
							interpretador.setEntrada(io);
							interpretador.setSaida(io);
							interpretador.interpretar(new File("./examples/teste.por"));
						}
					}
					catch (Exception e) 
					{
						JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
    	}
    	catch (Exception e) 
		{
    		JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    private static String loadFromFile() throws Exception
    {
    	String line = null;
    	StringBuilder stringBuilder = new StringBuilder();
    	BufferedReader br = new BufferedReader(new FileReader(new File("./examples/teste.por")));
    	
    	while ((line = br.readLine()) != null)
    	{
    		stringBuilder.append(line);
    		stringBuilder.append("\n");
    	}
    	
    	return stringBuilder.toString();
    }
    
    private static void saveToFile(String text) throws Exception
    {
    	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./examples/teste.por")));    	
    	bw.write(text);
    	bw.flush();
    	bw.close();
    }
    
    private static class IO implements Entrada, Saida
    {

		@Override
		public void limpar() 
		{
			for (int i = 0; i < 20; i++)
				System.out.println();
		}

		@Override
		public void imprimir(String valor) 
		{
			System.out.print(valor);
		}

		@Override
		public String ler() 
		{
			return JOptionPane.showInputDialog(null, "Digite um valor:");
		}    	
    }    
}
