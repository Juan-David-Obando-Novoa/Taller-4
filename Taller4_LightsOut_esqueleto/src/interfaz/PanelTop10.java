package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uniandes.dpoo.taller4.modelo.Top10;

public class PanelTop10 extends JDialog {
    private Top10 top10 = new Top10();
    private JTable table;
    private DefaultTableModel model;
    
    public PanelTop10() {
        super();
        setTitle("Top 10");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);
        
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        cargarDatos();
    }
    
    private void cargarDatos() {
        // Leer los datos del archivo CSV
    	File archivo = new File("data/top10.csv");
    	top10.cargarRecords(archivo);
    }
    
    public void mostrar() {
        setVisible(true);
    }
}
