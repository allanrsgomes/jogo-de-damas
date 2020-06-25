import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Cadastro extends JDialog implements ActionListener {
    static Player jogador[] = new Player[2];

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    JButton btSalvar = new JButton("Salvar");
    JLabel lbNomeJogador = new JLabel("Nome do jogador:");

    JTextField tfNomeJogador = new JTextField(20);

    public Cadastro() {
        p1.setLayout(new GridLayout(2, 1));
        p1.setBorder(new TitledBorder("Cadastro"));
        p1.add(lbNomeJogador);
        p1.add(tfNomeJogador);

        tfNomeJogador.setText(jogador[0].getNome());

        p2.setLayout(new BorderLayout());
        p2.add(p1, BorderLayout.CENTER);
        p2.add(btSalvar, BorderLayout.SOUTH);

        add(p2);
        btSalvar.addActionListener(this);

        setUndecorated(true);
        setModal(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setTitle("Cadastro");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btSalvar) {
            jogador[0].setNome(tfNomeJogador.getText());
            if(jogador[0].getNome().length() == 0)
                jogador[0].setNome("Branco");
            dispose();
        }
    }
}
