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

        ImageIcon gifIcon = new ImageIcon("/Users/daniela/Desktop/ProyectoBD/ReadUp/src/img/Read Portico Library GIF.gif");
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

            // PANEL MENÚ 
            JPanel menuPanel = new JPanel();
            menuPanel.setBackground(Color.WHITE);
            menuPanel.setLayout(null); 


            JPanel recuadroGrande = new JPanel();
            recuadroGrande.setBackground(new Color(255, 214, 153));
            recuadroGrande.setBounds(20, 40, 300, 420); // x, y, ancho, alto
            menuPanel.add(recuadroGrande);


            JLabel titulo = new JLabel("Ve nuestro catalogo!");
            titulo.setForeground(new Color(255, 132, 132));
            titulo.setFont(new Font("Monospaced", Font.BOLD,25));
            titulo.setBounds(345, 40, 300, 30); // x, y, ancho, alto
            menuPanel.add(titulo);

            // Primer libro MENU
            JLabel titulo1 = new JLabel("Habitos Atomicos.");
            titulo1.setFont(new Font("Monospaced", Font.PLAIN, 17));
            titulo1.setBounds(475, 90, 300, 30); // x, y, ancho, alto
            menuPanel.add(titulo1);


            JLabel subtitulo1 = new JLabel("por James Clear");
            subtitulo1.setFont(new Font("Monospaced", Font.PLAIN, 16));
            subtitulo1.setBounds(475, 110, 300, 30); // x, y, ancho, alto
            menuPanel.add(subtitulo1);



            // Segundo libro MENU
            JLabel titulo2 = new JLabel("El dilema de la novia");
            titulo2.setFont(new Font("Monospaced", Font.PLAIN, 17));
            titulo2.setBounds(475, 290, 300, 30); // x, y, ancho, alto
            menuPanel.add(titulo2);

            JLabel subtitulo2 = new JLabel("por Elena Armas");
            subtitulo2.setFont(new Font("Monospaced", Font.PLAIN, 16));
            subtitulo2.setBounds(475, 310, 300, 30); // x, y, ancho, alto
            menuPanel.add(subtitulo2);



            JPanel recuadroPeque1 = new JPanel();
            recuadroPeque1.setBackground(new Color(255, 230, 128));
            recuadroPeque1.setBounds(340, 80, 120, 180);
            menuPanel.add(recuadroPeque1);


            JPanel recuadroPeque2 = new JPanel();
            recuadroPeque2.setBackground(new Color(255, 230, 128));
            recuadroPeque2.setBounds(340, 280, 120, 180);
            menuPanel.add(recuadroPeque2);


            // Imagen para recuadroPeque1
            ImageIcon icon1 = new ImageIcon("/Users/daniela/Desktop/ProyectoBD/ReadUp/src/img/WhatsApp Image 2025-09-27 at 00.04.01.jpeg");
            Image img1 = icon1.getImage().getScaledInstance(recuadroPeque1.getWidth() - 10, recuadroPeque1.getHeight() - 10, Image.SCALE_SMOOTH); // margen de 5px por lado
            icon1 = new ImageIcon(img1);
            JLabel labelImg1 = new JLabel(icon1);
            labelImg1.setHorizontalAlignment(JLabel.CENTER);
            labelImg1.setVerticalAlignment(JLabel.CENTER);

            // Poner el JLabel en el recuadro y usar BorderLayout para centrar
            recuadroPeque1.setLayout(new BorderLayout());
            recuadroPeque1.add(labelImg1, BorderLayout.CENTER);

            // Imagen para recuadroPeque2
            ImageIcon icon2 = new ImageIcon("/Users/daniela/Desktop/ProyectoBD/ReadUp/src/img/WhatsApp Image 2025-09-27 at 00.02.58.jpeg");
            Image img2 = icon2.getImage().getScaledInstance(recuadroPeque2.getWidth() - 10, recuadroPeque2.getHeight() - 10, Image.SCALE_SMOOTH);
            icon2 = new ImageIcon(img2);
            JLabel labelImg2 = new JLabel(icon2);
            labelImg2.setHorizontalAlignment(JLabel.CENTER);
            labelImg2.setVerticalAlignment(JLabel.CENTER);

            recuadroPeque2.setLayout(new BorderLayout());
            recuadroPeque2.add(labelImg2, BorderLayout.CENTER);




            // Agregar al CardLayout
            panelDerecho.add(menuPanel, "Menú");






            // PANEL LIBROS/TABLAS
            String[] columnas = {"ID","Título", "Autor", "Año"};
            Object[][] datos = {
                {"1","Call Me By Your Name", "André Aciman","2010"},
                {"2","Hábitos Atómicos", "James Clear","2016"},
                {"3","El dilema de la novia", "Elena Armas","2020"},
                {"4","Happy Place", "Emily Henry","2019"}
            };

            // Crear JTable
            JTable tablaLibros = new JTable(datos, columnas);
            tablaLibros.setFillsViewportHeight(true);
            tablaLibros.setRowHeight(25);
            tablaLibros.setFont(new Font("Monospaced", Font.PLAIN, 13));

            // Encabezado sencillo
            tablaLibros.getTableHeader().setBackground(new Color(247, 144, 6)); // naranja
            tablaLibros.getTableHeader().setForeground(Color.WHITE);              // texto blanco
            tablaLibros.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 20));

            // Mostrar líneas de la tabla
            tablaLibros.setShowGrid(true);                  // activa las líneas
            tablaLibros.setGridColor(Color.GRAY);          // color de las líneas


            JScrollPane scrollPane = new JScrollPane(tablaLibros);

            // Panel “Libros”
            JPanel panelLibros = new JPanel(new BorderLayout());
            panelLibros.add(scrollPane, BorderLayout.CENTER);

            // Añadir al CardLayout
            panelDerecho.add(panelLibros, "Libros");






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
