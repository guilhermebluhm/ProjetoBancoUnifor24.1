package Inteface;

import core.CoreLogic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IntefaceGrafica {

        public static void main(String[] args) {
            CoreLogic core = new CoreLogic();
            core.behavior();

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    criarGUI();
                }
            });
        }

        public static void criarGUI() {
            JFrame frame = new JFrame("Tabela com Input");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());


            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            // Cria o input de texto
            JTextField textField = new JTextField(40);
            panel.add(textField);

            // Cria o botão
            JButton addButton = new JButton("Buscar na Tabela");

            // Cria a tabela
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Word");
            JTable table = new JTable(model);


            // Adiciona um listener ao botão para adicionar o texto na tabela
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String texto = textField.getText();
                    if (!texto.isEmpty()) {
                        model.addRow(new Object[]{texto});
                        textField.setText(""); // Limpa o campo de entrada após adicionar
                    }
                }
            });

            // Adiciona os componentes ao painel
            panel.add(addButton);
            frame.add(panel, BorderLayout.NORTH);
            frame.add(new JScrollPane(table), BorderLayout.CENTER);

            // Configura o tamanho do frame e exibe-o
            frame.setSize(1000, 600);
            frame.setVisible(true);
        }
}

