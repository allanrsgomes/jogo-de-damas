import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Principal extends JFrame implements ActionListener {
    JPanel p1 = new JPanel();

    JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("img/wallpaper.png")));

    JButton jogar = new JButton("Jogar");

    public Principal() {
        setLayout(new BorderLayout());
        add(fundo);
        fundo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 225));
        fundo.add(p1);

        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
        p1.add(jogar);
        p1.setOpaque(false);

        jogar.setFocusPainted(false);
        jogar.addActionListener(this);
        jogar.setBackground(Color.WHITE);

        setVisible(true);
        setSize(450, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Jogo de Damas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Cadastro.jogador[0] = new Player("Branco");
        Cadastro.jogador[1] = new Player("Preto");
        new Principal();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jogar) {
            dispose();
            new Jogo();
        }
    }
}
