import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Aplicativo_de_notas {
    private JButton btn;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton CALCULARMEDIAButton;
    private JTextField textField2;
    private JLabel statusLabel;
    private List<Double> notas;

    public Aplicativo_de_notas() {
        notas = new ArrayList<>();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNota();
            }
        });

        CALCULARMEDIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
    }

    private void adicionarNota() {
        try {
            double nota = Double.parseDouble(textField1.getText());
            notas.add(nota);
            atualizarListaNotas();
            textField1.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
        }
    }

    private void atualizarListaNotas() {
        StringBuilder lista = new StringBuilder();
        for (Double nota : notas) {
            lista.append(nota).append("\n");
        }
        textArea1.setText(lista.toString());
    }

    private void calcularMedia() {
        if (notas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma nota adicionada.");
            return;
        }

        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.size();
        textField2.setText(String.format("%.2f", media));

        if (media >= 6.0) {
            statusLabel.setText("Aprovado");
        } else {
            statusLabel.setText("Reprovado");
        }
    }
}
//a