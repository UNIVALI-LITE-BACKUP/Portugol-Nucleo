package br.univali.portugol.nucleo.bibliotecas.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Luiz Fernando
 */
final class Testador
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run()
            {
                try
                {
                    JFrame janela = new JFrame("Testar biblioteca");
                    janela.setSize(350, 250);
                    janela.setLocationRelativeTo(null);
                    janela.setResizable(false);
                    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    final JLabel rotuloResultado = new JLabel("Selecione uma biblioteca para testar");
                    rotuloResultado.setBorder(new CompoundBorder(new EmptyBorder(15, 0, 0, 0), rotuloResultado.getBorder()));
                    rotuloResultado.setVerticalAlignment(JLabel.TOP);
                    rotuloResultado.setOpaque(true);
                    
                    final JComboBox comboBox = new JComboBox(GerenciadorBibliotecas.getInstance().listarBibliotecasDisponiveis().toArray());
                    comboBox.setPreferredSize(new Dimension(10, 30));
                    comboBox.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            try
                            {
                                GerenciadorBibliotecas.getInstance().obterMetaDadosBiblioteca((String) comboBox.getSelectedItem());
                                rotuloResultado.setText(String.format("A biblioteca '%s' não possui erros!", (String) comboBox.getSelectedItem()));
                                rotuloResultado.setForeground(Color.BLACK);
                            }
                            catch(Exception excecao)
                            {
                                rotuloResultado.setText(String.format("<html><p style='text-align: justify;'>%s</p></html>", excecao.getMessage()));
                                rotuloResultado.setForeground(Color.RED);
                            }
                        }
                    });
                    
                    comboBox.setSelectedIndex(0);

                    JPanel painelConteudo = new JPanel(new BorderLayout());
                    painelConteudo.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), painelConteudo.getBorder()));
                    painelConteudo.add(comboBox, BorderLayout.NORTH);
                    painelConteudo.add(rotuloResultado, BorderLayout.CENTER);

                    janela.getContentPane().setLayout(new GridLayout(1, 1));
                    janela.getContentPane().add(painelConteudo);

                    janela.setVisible(true);
                }
                catch(Exception excecao)
                {
                    JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    excecao.printStackTrace(System.out);
                }
            }
        });
    }
}
