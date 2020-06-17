import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Casa extends JButton {
    private int casaI = 0;
    private int casaJ = 0;
    private String cor;
    private Peca pecaAtual;
    private boolean casaVazia = true;
    private boolean casaMarcada = false;

    public Casa(int i, int j) {
        casaI = i;
        casaJ = j;
        if(i % 2 == 0)
            if(j % 2 == 0)
                cor = "#363230";
            else
                cor = "#f7f2f0";
        else
        if(j % 2 == 0)
            cor = "#f7f2f0";
        else
            cor = "#363230";

        setBackground(Color.decode(cor));
        setBorder(new LineBorder(Color.black, 1));
        setFocusPainted(false);
    }

    public void atualizarPeca(Peca peca) {
        pecaAtual = peca;
        setIcon(peca.getPeca());
    }

    public void removerPeca() {
        casaVazia = true;
        pecaAtual = null;
        setIcon(null);
    }

    public void setVazia(boolean res) {
        casaVazia = res;
    }

    public int getPosI() {
        return casaI;
    }

    public int getPosJ() {
        return casaJ;
    }

    public boolean vazia() {
        return casaVazia;
    }

    public void setMarcada(boolean res) {
        casaMarcada = res;

        if(casaMarcada)
            setBackground(Color.decode("#09eb79"));
        else if(!vazia() && pecaAtual.jogavel())
            setBackground(Color.decode("#d4f518"));
        else
            setBackground(Color.decode(cor));
    }

    public boolean marcada() {
        return casaMarcada;
    }

    public Peca pecaAtual() {
        return pecaAtual;
    }
}
