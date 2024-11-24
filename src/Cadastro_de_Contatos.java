import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastro_de_Contatos {
    private JPanel panelMain;
    private JTextField txtnome;
    private JTextField txttelefone;
    private JTextField txtemail;
    private JButton btnadicionarcontato;
    private JButton btnlimpar;
    private JList liscontatos;
    private JLabel lblnomes;
    private JLabel lbltelefone;
    private JLabel lblemail;
    private JTextArea txtAstatus;

    private String nomes = "";
    private String telefones = "";
    private String email = "";
    private String informacoes = ""; // informacoes variavel que adiciona as outras tres variaves nome telefone e e-mail tudo em uma.
    private ArrayList contatos = new ArrayList();
    private int i = 0;

    // ele permite que eu selecone os dados dentro da Jlist e também armazena os dados e gerencia eles
    DefaultListModel<String> contatinhos = new DefaultListModel<>();

    public Cadastro_de_Contatos() {
        liscontatos.setModel(contatinhos);
        btnadicionarcontato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nomes = txtnome.getText();
                telefones = txttelefone.getText();
                email = txtemail.getText();

                if (nomes.isEmpty() || telefones.isEmpty() || email.isEmpty()) {
                    txtAstatus.setText("Preencha todos os campos acima"); // txtAstatus é o local feio que mostra as strings
                } else {
                    i++;
                    informacoes = +i + "° Contato Nome: " + nomes + ", Telefone:  " + telefones + " ,E-mail: " + email;
                    contatos.add(informacoes);
                    contatinhos.addElement(informacoes);
                }
            }
        });
        btnlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // excluir para pegar a posião dos elementps
                int excluir = liscontatos.getSelectedIndex(); // quando eu clicar no qual eu desejo excluir ele irá retornar a posição dele

                // fazer a verificão pois se não selecionar nada não terá posição assim não excluirá nada e pedira para selecionar algo
                if (excluir != -1) {
                    contatos.remove(excluir); // excluir o que foi selecionado
                    contatinhos.removeElement(excluir); // usam o excluir para remover pelo indice
                    txtAstatus.setText("Contato removido com sucesso!");
                } else {
                    txtAstatus.setText("Selecione um contato para remover.");
                }
            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new Cadastro_de_Contatos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
