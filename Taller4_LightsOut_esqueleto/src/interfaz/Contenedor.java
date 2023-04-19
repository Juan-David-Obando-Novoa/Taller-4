package interfaz;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

public class Contenedor extends JFrame {
	
	private JLabel jugadas;
	private  LightsOut gamePanel = new LightsOut();
	private JTable table;
    private DefaultTableModel model;
	
    public Contenedor() {
        // Crear el panel del juego
        gamePanel.initGrid();

        // Crear paneles adicionales a los lados
        JPanel upperpanel = new JPanel();
        upperpanel.setBackground(Color.LIGHT_GRAY);
        upperpanel.setPreferredSize(new Dimension(100, 50));
        upperpanel.setLayout(new BoxLayout(upperpanel, BoxLayout.X_AXIS));
        ButtonGroup group = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("Fácil");
        JRadioButton radioButton2 = new JRadioButton("Medio");
        JRadioButton radioButton3 = new JRadioButton( "Dificil");
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        JLabel Dificultad = new JLabel("Dificultad: ");
        upperpanel.add(Dificultad);
        upperpanel.add(radioButton1);
        upperpanel.add(radioButton2);
        upperpanel.add(radioButton3);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setPreferredSize(new Dimension(200, 0));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // Crear los botones
        JButton btn1 = new JButton("           Nuevo          ");
        JButton btn2 = new JButton("        Reiniciar        ");
        JButton btn3 = new JButton("         Top 10           ");
        JButton btn4 = new JButton("Cambiar Jugador");
        
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelTop10 dialog = new PanelTop10();
                dialog.mostrar();
            }
        });
        rightPanel.add(Box.createVerticalStrut(50));
        rightPanel.add(btn1);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(btn2);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(btn3);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(btn4);

        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setPreferredSize(new Dimension(100, 50));
        System.out.println(gamePanel.getTablero().darJugadas());
        JLabel jugadas = new JLabel("jugadas: " + gamePanel.getTablero().darJugadas() +"       "+ "Jugador: ");
        bottomPanel.add(jugadas);
        


        // Establecer el diseño del contenedor principal
        setLayout(new BorderLayout());

        // Agregar los paneles adicionales a los lados y el panel del juego en el centro
        add(upperpanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(gamePanel, BorderLayout.CENTER);
        //System.out.println(gamePanel.mouseClicked(null).);

        // Configurar el marco principal
        setTitle("LightsOut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Contenedor::new);
     

    }
}
