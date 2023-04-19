package interfaz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Image;


import uniandes.dpoo.taller4.modelo.Tablero;

public class LightsOut extends JPanel implements MouseListener {
    
    private int gridSize = 5; // Tamaño de la cuadrícula
    private int cellSize = 50; // Tamaño de cada celda
    private Tablero tablero = new Tablero(gridSize); // Estado de cada celda
    
    public LightsOut() {
        // Agrega el oyente del mouse para detectar clics en las celdas
        addMouseListener(this);
        // Configura el tamaño del panel
        setPreferredSize(new Dimension(gridSize * cellSize, gridSize * cellSize));
    }
    
    public void paint(Graphics g) {
        // Dibuja las celdas en el panel
    	Image imagen = cargarImagen();
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (tablero.darTablero()[row][col]) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                if (tablero.darTablero()[row][col]) {
                    g.drawImage(imagen, col * cellSize, row * cellSize, cellSize, cellSize, null);
                }
            }
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        // Obtiene la celda que se ha hecho clic
        Point p = e.getPoint();
        int row = p.y / cellSize;
        int col = p.x / cellSize;
        tablero.jugar(row, col);
        //System.out.println(tablero.darJugadas());
        // Vuelve a pintar el panel
        repaint();
    }
    
    // Cambia el estado de una celda
    private void toggleCell(int row, int col) {
        tablero.darTablero()[row][col] = !tablero.darTablero()[row][col];
    }
    
    // Inicializa la cuadrícula con un patrón aleatorio de celdas encendidas y apagadas
    public void initGrid() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
            	tablero.darTablero()[row][col] = Math.random() < 0.5;
            }
        }
    }
    
    
    public Image cargarImagen() {
        // Carga la imagen desde el archivo
        Image imagen = null;
        try {
            imagen = ImageIO.read(new File("data\\luz.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagen;
    }
        
 
    // Métodos de MouseListener no utilizados, pero requeridos por la interfaz
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}