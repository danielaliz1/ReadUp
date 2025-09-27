// Archivo: ReadUp.java
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel; // --- NUEVO ---
import java.sql.*;                       // --- NUEVO ---

public class ReadUp {

    int boardWidth = 700;

    JFrame frame = new JFrame("ReadUp!");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    
    CardLayout cardLayout;
    JPanel panelDerecho;

    Color borderButtonEastColor = new Color(204, 153, 0);

    ReadUp() {
        // CONFIGURACIÓN GENERAL DE LA VENTANA
        frame.setSize(boardWidth, boardWidth + 100);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // PANEL SUPERIOR (Texto principal)
        textLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Bienvenido a ReadUp!");
        textPanel.setBackground(Color.ORANGE);
        textPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        textPanel.add(textLabel);

        // PANEL BANNER (GIF)
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.setPreferredSize(new Dimension(frame.getWidth(), 100));

        // --- NOTA: Asegúrate de que esta ruta al GIF sea correcta en tu computadora ---
        ImageIcon gifIcon = new ImageIcon("/Users/daniela/Desktop/ProyectoBD/ReadUp/src/Read Portico Library GIF.gif");
        Image img = gifIcon.getImage().getScaledInstance(frame.getWidth(), 100, Image.SCALE_DEFAULT);
        gifIcon = new ImageIcon(img);

        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        bannerPanel.add(gifLabel, BorderLayout.CENTER);

        // PANEL BOTONES (Horizontal)
        buttonPanel.setLayout(new GridLayout(1, 5, 10, 10));
        buttonPanel.setBackground(Color.ORANGE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setupButtons();

        // PANEL SUPERIOR COMPLETO (Texto + Banner + Botones)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(textPanel, BorderLayout.NORTH);
        topPanel.add(bannerPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);

        // --- PANEL CENTRAL con CardLayout ---
        cardLayout = new CardLayout();
        panelDerecho = new JPanel(cardLayout);
        panelDerecho.setOpaque(false);

        // --- MODIFICADO: Agregamos los paneles, incluyendo el de la tabla de libros ---
        panelDerecho.add(new JLabel("Panel de Menú/Inicio", JLabel.CENTER), "Menú");
        panelDerecho.add(crearPanelLibros(), "Libros"); // <-- ¡AQUÍ ESTÁ EL CAMBIO!
        panelDerecho.add(new JLabel("Panel de definir1", JLabel.CENTER), "A definir1");
        panelDerecho.add(new JLabel("Panel de definir2", JLabel.CENTER), "A definir2");
        panelDerecho.add(new JLabel("Llamar a Soporte 33-2053-7345", JLabel.CENTER), "Ayuda");

        frame.add(panelDerecho, BorderLayout.CENTER);

        // PANEL INFERIOR (Footer)
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.GRAY);
        footerPanel.setPreferredSize(new Dimension(frame.getWidth(), 25));
        JLabel footerLabel = new JLabel("© 2025 ReadUp");
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setHorizontalAlignment(JLabel.CENTER);
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
    }
    
    // --- MÉTODO TOTALMENTE NUEVO ---
    // Este método crea el panel que contiene la tabla de libros
    private JPanel crearPanelLibros() {
        // 1. Definir las columnas para la tabla
        String[] columnas = {"Título del Libro", "Género"};
        
        // 2. Crear un modelo de tabla que no permita editar las celdas
        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que la tabla no sea editable
            }
        };

        // 3. Consultar la base de datos y llenar el modelo
        String sql = "SELECT nombre, genero FROM libros ORDER BY nombre ASC";
        
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String genero = rs.getString("genero");
                // Agregar cada libro como una nueva fila en el modelo
                tableModel.addRow(new Object[]{nombre, genero});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Si hay un error, mostrarlo en un diálogo
            JOptionPane.showMessageDialog(frame, "Error al conectar o consultar la base de datos.", "Error de BD", JOptionPane.ERROR_MESSAGE);
        }

        // 4. Crear la JTable con el modelo lleno de datos
        JTable tablaLibros = new JTable(tableModel);
        tablaLibros.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaLibros.setRowHeight(25);
        tablaLibros.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        // 5. Crear el panel contenedor y añadir la tabla dentro de un JScrollPane
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen
        panel.add(new JScrollPane(tablaLibros), BorderLayout.CENTER); // ¡Importante! JScrollPane permite ver los encabezados y hacer scroll.

        return panel;
    }


    void setupButtons() {
        String[] nombres = {"Menú", "Libros", "A definir1", "A definir2", "Ayuda"};
        Color originalBackground = Color.WHITE;
        Color originalForeground = Color.ORANGE;
        Color changeBackgroundColor = new Color(0, 168, 107);
        Color changeBorderColor = new Color(1, 121, 111);

        for (String nombre : nombres) {
            JButton button = new JButton(nombre);
            button.setFont(new Font("Monospaced", Font.BOLD, 18));
            button.setFocusable(false);
            button.setBackground(originalBackground);
            button.setForeground(originalForeground);
            button.setBorder(new LineBorder(borderButtonEastColor, 3, true));
            button.setContentAreaFilled(false);
            button.setOpaque(true);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setPreferredSize(new Dimension(140, 40));

            button.addActionListener(e -> {
                cardLayout.show(panelDerecho, nombre);
                for (Component comp : buttonPanel.getComponents()) {
                    if (comp instanceof JButton) {
                        JButton b = (JButton) comp;
                        b.setBackground(originalBackground);
                        b.setForeground(originalForeground);
                        b.setBorder(new LineBorder(borderButtonEastColor, 3, true));
                    }
                }
                button.setBackground(changeBackgroundColor);
                button.setForeground(Color.WHITE);
                button.setBorder(new LineBorder(changeBorderColor, 3, true));
            });
            buttonPanel.add(button);
        }
    }
    
    // Para poder ejecutar la clase
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReadUp());
    }
}
