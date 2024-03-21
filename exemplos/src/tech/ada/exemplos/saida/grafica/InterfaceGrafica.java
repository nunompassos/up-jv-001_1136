package tech.ada.exemplos.saida.grafica;

import javax.swing.*;

public class InterfaceGrafica {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Interface Gráfica");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Olá, mundo!");
        JButton button = new JButton("Clique Aqui");

        panel.add(label);
        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
    }
}
