import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JLabel codificadoLabel;
    private JLabel descodificadoLabel;
    private String textoOriginal = "";

    public Main() {
        Cifra cifra = new Cifra();
        criarTela(cifra);
    }

    public static void main(String[] args) {
        new Main();
    }

    public void criarTela(Cifra cifra) {
        JFrame frame = new JFrame("Cifra de César");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Campo de texto para a entrada original
        JTextField textoField = new JTextField();
        panel.add(new JLabel("Texto a ser processado:"));
        panel.add(textoField);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Campo de texto para o número de letras a serem puladas
        JTextField puloField = new JTextField();
        panel.add(new JLabel("Número de letras a serem puladas:"));
        panel.add(puloField);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Label para mostrar o texto codificado
        codificadoLabel = new JLabel("Texto codificado: ");
        panel.add(codificadoLabel);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Label para mostrar o texto descodificado
        descodificadoLabel = new JLabel("Texto descodificado: ");
        panel.add(descodificadoLabel);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Botão para criptografar
        JButton criptografarButton = new JButton("Criptografar");
        criptografarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String texto = textoField.getText();
                    int pulo = Integer.parseInt(puloField.getText());
                    String resultado = cifra.criptografar(texto, pulo);
                    codificadoLabel.setText("Texto codificado: " + resultado);
                } catch (NumberFormatException ex) {
                    codificadoLabel.setText("Número de letras inválido.");
                }
            }
        });
        panel.add(criptografarButton);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Botão para descriptografar
        JButton descriptografarButton = new JButton("Descriptografar");
        descriptografarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String textoCifrado = textoField.getText();
                    int pulo = Integer.parseInt(puloField.getText());
                    String resultado = cifra.descriptografar(textoCifrado, pulo);
                    descodificadoLabel.setText("Texto descodificado: " + resultado);
                } catch (NumberFormatException ex) {
                    descodificadoLabel.setText("Número de letras inválido.");
                }
            }
        });
        panel.add(descriptografarButton);

        // Adiciona o painel ao frame e exibe a janela
        frame.add(panel);
        frame.setVisible(true);
    }

}

