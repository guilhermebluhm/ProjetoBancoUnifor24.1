package Inteface;

import core.CoreLogic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class IntefaceGrafica {

    private static CoreLogic core;

    public void run(CoreLogic core) {
        this.core = core;

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

        // Cria os botões
        JButton addButton = new JButton("Buscar na Tabela");
        JButton tableScanButton = new JButton("Table Scan");

        // Cria a tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Word");
        JTable table = new JTable(model);


        // Adiciona um listener ao botão para adicionar o texto na tabela
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = textField.getText();
                if (!texto.isEmpty()) {
                    int page = core.search(texto);
                    model.setRowCount(0);
                    model.addRow(new Object[]{texto});
                    textField.setText("");

                    String label = "Palavra encontrada na pagina: " + page;

                    if(page == -1){
                        label = "Não foi possível encontrar a pagina";
                    }

                    final JDialog dialog = new JDialog(frame, "Resultado de Busca", true);
                    dialog.setLayout(new FlowLayout());
                    dialog.add(new JLabel(label));
                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(frame);
                    dialog.setVisible(true);

                }
            }
        });


        tableScanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                List<String> results = core.scan();
                model.setRowCount(0);

                for(String word: results) model.addRow(new Object[]{word});

                String label = results.size() + " Resultados encontrados.";

                final JDialog dialog = new JDialog(frame, "Busca Concluida", true);
                dialog.setLayout(new FlowLayout());
                dialog.add(new JLabel(label));
                dialog.setSize(300, 150);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });

        // Adiciona um listener ao botão de table scan
        tableScanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] res = core.tableScan();
            }
        });

        // Adiciona os componentes ao painel
        panel.add(addButton);
        panel.add(tableScanButton);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Configura o tamanho do frame e exibe-o
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

