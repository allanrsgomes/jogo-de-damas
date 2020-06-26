import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Principal extends JFrame implements ActionListener {
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("img/wallpaper.png")));

    JButton btCadastro = new JButton("Cadastre-se");
    JButton btJogar = new JButton("Jogar");
    JButton btResultados = new JButton("Resultados");

    public Principal() {

        //Configura e adiciona os componentes na tela
        setLayout(new BorderLayout());
        add(fundo);
        fundo.setLayout(new FlowLayout(FlowLayout.CENTER));
        fundo.add(p1);

        p1.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botão cadastro
        p1.add(btCadastro);
        btCadastro.setFocusPainted(false);
        btCadastro.addActionListener(this);
        btCadastro.setBackground(Color.WHITE);

        // Botão Jogar
        p1.add(btJogar);
        btJogar.setFocusPainted(false);
        btJogar.addActionListener(this);
        btJogar.setBackground(Color.WHITE);

        //Botão Resultados
        p1.add(btResultados);
        btResultados.setFocusPainted(false);
        btResultados.addActionListener(this);
        btResultados.setBackground(Color.WHITE);

        p1.setOpaque(false);
        setVisible(true); // Mostra o conteudo da tela
        setSize(450, 450); //Tamanho da tela
        setResizable(false); // Deixa o botão de maximizar desativado
        setLocationRelativeTo(null); //Abre a janela no centro da tela
        setTitle("Jogo de Damas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa quando a janela é fechada
    }

    public static void main(String[] args) {
        Cadastro.jogador[0] = new Player("Branco");
        Cadastro.jogador[1] = new Player("PC");
        new Principal();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btCadastro) {
            new Cadastro(); // inicia o cadastro
        }
        else if(e.getSource() == btJogar) {
            dispose(); //Liberar a memória que a janela está utilizando
            new Jogo(); // inicia o jogo
        }
        else if(e.getSource() == btResultados) {
            new Placar(); // mostra resultados anteriores
        }
    }
}
