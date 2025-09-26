import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ReadUp {

    int boardWidth = 700;

    JFrame frame = new JFrame("ReadUp!");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    // --- NUEVO: CardLayout y panel central ---
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

        ImageIcon gifIcon = new ImageIcon("/Users/daniela/Desktop/ProyectoBD/ReadUp/src/Read Portico Library GIF.gif");
        Image img = gifIcon.getImage().getScaledInstance(frame.getWidth(), 100, Image.SCALE_DEFAULT);
        gifIcon = new ImageIcon(img);

        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        bannerPanel.add(gifLabel, BorderLayout.CENTER);

        // PANEL BOTONES (Horizontal)
        buttonPanel.setLayout(new GridLayout(1, 5, 10, 10)); // 5 botones en una fila
        buttonPanel.setBackground(Color.ORANGE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inicializa botones
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

        // Aquí agregas tus paneles (usa tus clases reales si ya las tienes)
        panelDerecho.add(new JLabel("Panel de Menú/Inicio", JLabel.CENTER), "Menú");
        panelDerecho.add(new JLabel("Panel de Libros", JLabel.CENTER), "Libros");
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

        // Fondo general
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
    }

    void setupButtons() {
        // Nombres de botones (coinciden con los paneles en CardLayout)
        String[] nombres = {"Menú", "Libros", "A definir1", "A definir2", "Ayuda"};

        // Colores base
        Color originalBackground = Color.WHITE;
        Color originalForeground = Color.ORANGE;
        Color changeBackgroundColor = new Color(0, 168, 107); // verde activo
        Color changeBorderColor = new Color(1, 121, 111); // borde activo

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

            // --- ACCIÓN: cambia panel central según botón y actualiza colores ---
            button.addActionListener(e -> {
                // 1. Cambiar el panel central
                cardLayout.show(panelDerecho, nombre);

                // 2. Resetear todos los botones a su estado original
                for (Component comp : buttonPanel.getComponents()) {
                    if (comp instanceof JButton) {
                        JButton b = (JButton) comp;
                        b.setBackground(originalBackground);
                        b.setForeground(originalForeground);
                        b.setBorder(new LineBorder(borderButtonEastColor, 3, true));
                    }
                }

                // 3. Marcar este botón como activo
                button.setBackground(changeBackgroundColor);
                button.setForeground(Color.WHITE);
                button.setBorder(new LineBorder(changeBorderColor, 3, true));
            });

            buttonPanel.add(button);
        }
    }

    public static void main(String[] args) {
        new ReadUp();
    }
}
