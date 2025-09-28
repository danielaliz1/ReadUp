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
            recuadroGrande.setBounds(20, 20, 300, 440); // x, y, ancho, alto
            menuPanel.add(recuadroGrande);



            // Imagen para recuadroPeque1
            ImageIcon icon3 = new ImageIcon("/Users/daniela/Desktop/ProyectoBD/ReadUp/src/img/71sOSrd+JxL._UF894,1000_QL80_.jpg");
            Image img3 = icon3.getImage().getScaledInstance(recuadroGrande.getWidth() - 15, recuadroGrande.getHeight() - 15, Image.SCALE_SMOOTH); // margen de 5px por lado
            icon3 = new ImageIcon(img3);
            JLabel labelImg3 = new JLabel(icon3);
            labelImg3.setHorizontalAlignment(JLabel.CENTER);
            labelImg3.setVerticalAlignment(JLabel.CENTER);
            labelImg3.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Poner el JLabel en el recuadro y usar BorderLayout para centrar
            recuadroGrande.setLayout(new BorderLayout());
            recuadroGrande.add(labelImg3, BorderLayout.CENTER);



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
            labelImg1.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
            labelImg2.setCursor(new Cursor(Cursor.HAND_CURSOR));

            recuadroPeque2.setLayout(new BorderLayout());
            recuadroPeque2.add(labelImg2, BorderLayout.CENTER);


            // Agregar al CardLayout
            panelDerecho.add(menuPanel, "Menú");








            // PANEL LIBROS/TABLAS
            String[] columnas = {"ID","Título", "Autor", "Año", "Género"};
            Object[][] datos = {
                {"1","Call Me By Your Name", "André Aciman","2010", "Romance"},
                {"2","Hábitos Atómicos", "James Clear","2016", "Motivacional"},
                {"3","El dilema de la novia", "Elena Armas","2020", "Romance"},
                {"4","Happy Place", "Emily Henry","2019", "Romance"},
                {"5","It Ends with Us", "Colleen Hoover","2016", "Romance"},
                {"6","Verity", "Colleen Hoover","2018", "Thriller"},
                {"7","The Silent Patient", "Alex Michaelides","2019", "Thriller"},
                {"8","Where the Crawdads Sing", "Delia Owens","2018", "Mystery"},
                {"9","The Midnight Library", "Matt Haig","2020", "Fantasy"},
                {"10","Project Hail Mary", "Andy Weir","2021", "Science Fiction"},
                {"11","Dune", "Frank Herbert","1965", "Science Fiction"},
                {"12","Neuromancer", "William Gibson","1984", "Cyberpunk"},
                {"13","The Hobbit", "J.R.R. Tolkien","1937", "Fantasy"},
                {"14","1984", "George Orwell","1949", "Dystopian"},
                {"15","Brave New World", "Aldous Huxley","1932", "Dystopian"},
                {"16","Fahrenheit 451", "Ray Bradbury","1953", "Dystopian"},
                {"17","The Catcher in the Rye", "J.D. Salinger","1951", "Fiction"},
                {"18","To Kill a Mockingbird", "Harper Lee","1960", "Fiction"},
                {"19","Pride and Prejudice", "Jane Austen","1813", "Romance"},
                {"20","The Great Gatsby", "F. Scott Fitzgerald","1925", "Fiction"}
            };

            // Crear JTable no editable
            JTable tablaLibros = new JTable(datos, columnas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // ninguna celda será editable
                }
            };
            tablaLibros.setFillsViewportHeight(true);
            tablaLibros.setRowHeight(25);
            tablaLibros.setFont(new Font("Monospaced", Font.PLAIN, 13));
            

            // Encabezado sencillo
            tablaLibros.getTableHeader().setBackground(new Color(247, 144, 6)); // naranja
            tablaLibros.getTableHeader().setForeground(Color.WHITE);              // texto blanco
            tablaLibros.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 20));
            tablaLibros.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Mostrar líneas de la tabla
            tablaLibros.setShowGrid(true);                  // activa las líneas
            tablaLibros.setGridColor(Color.GRAY);          // color de las líneas


            JScrollPane scrollPane = new JScrollPane(tablaLibros);

            // Panel “Libros”
            JPanel panelLibros = new JPanel(new BorderLayout());
            panelLibros.add(scrollPane, BorderLayout.CENTER);

            // Añadir al CardLayout
            panelDerecho.add(panelLibros, "Libros");






        panelDerecho.add(new JLabel("Catalogo", JLabel.CENTER), "Catalogo");


                    // PANEL SUGERENCIAS
            JPanel panelSugerencias = new JPanel();
            panelSugerencias.setBackground(Color.WHITE);
            panelSugerencias.setLayout(new BorderLayout(10, 10));

            // Texto motivador
            JLabel tituloSugerencias = new JLabel("Nos encanta saber tu opinión!", JLabel.CENTER);
            tituloSugerencias.setFont(new Font("Monospaced", Font.BOLD, 28));
            tituloSugerencias.setForeground(new Color(56, 7, 13));
            panelSugerencias.add(tituloSugerencias, BorderLayout.NORTH);

            // Cuadro de texto (para sugerencias)
            JTextArea areaTexto = new JTextArea("Escribe aquí tus sugerencias y comentarios...");
            areaTexto.setLineWrap(true);
            areaTexto.setWrapStyleWord(true);
            areaTexto.setFont(new Font("Arial", Font.PLAIN, 18));
            JScrollPane scroll = new JScrollPane(areaTexto);
            scroll.setBorder(BorderFactory.createLineBorder(new Color(204, 153, 0), 2, true));
            panelSugerencias.add(scroll, BorderLayout.CENTER);

            // Botón de enviar
            JButton btnEnviar = new JButton("Mandar");
            btnEnviar.setBackground(new Color(0, 168, 107));
            btnEnviar.setForeground(Color.ORANGE);
            btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
            btnEnviar.setFocusPainted(false);
            btnEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnEnviar.addActionListener(e -> {
                String sugerencia = areaTexto.getText().trim();
                if (!sugerencia.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                        "¡Gracias por tu comentario!\n\n",
                        "Sugerencia enviada",
                        JOptionPane.INFORMATION_MESSAGE);
                    areaTexto.setText(""); // limpia después de mandar
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "Por favor escribe algo antes de mandar.",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE);
                }
            });

            JPanel bottomPanel = new JPanel();
            bottomPanel.add(btnEnviar);
            panelSugerencias.add(bottomPanel, BorderLayout.SOUTH);

            // Lo agregas al CardLayout con el nombre "Sugerencias"
            panelDerecho.add(panelSugerencias, "Sugerencias");



            // PANEL AYUDA
        JPanel panelAyuda = new JPanel();
        panelAyuda.setBackground(Color.WHITE); 
        panelAyuda.setLayout(null); // Para ubicar con coordenadas absolutas

        Color ayudaColor = new Color(56, 7, 13); 

        // Etiqueta mensaje (arriba)
        JLabel mensaje = new JLabel("¡Estamos felices de ayudarte!", JLabel.CENTER);
        mensaje.setForeground(ayudaColor);
        mensaje.setBounds(200, 150, 300, 30);
        panelAyuda.add(mensaje);

        // Etiqueta teléfono (debajo)
        JLabel telefono = new JLabel("Llama a Soporte al 33-2053-7345", JLabel.CENTER);
        telefono.setForeground(ayudaColor);
        telefono.setBounds(200, 170, 300, 30);
        panelAyuda.add(telefono);


        // Cargar imagen original
        ImageIcon icon4 = new ImageIcon("/Users/daniela/Desktop/ProyectoBD/ReadUp/src/img/WhatsApp Image 2025-09-20 at 23.38.23-2.png");

        // Escalar al tamaño del recuadro
        Image img4 = icon4.getImage().getScaledInstance(
                recuadroPeque2.getWidth() - 10, 
                recuadroPeque2.getHeight() - 10, 
                Image.SCALE_SMOOTH
        );
        icon4 = new ImageIcon(img4);

        // Crear JLabel con el icono escalado
        JLabel labelImg4 = new JLabel(icon4);
        labelImg4.setHorizontalAlignment(JLabel.CENTER);
        labelImg4.setVerticalAlignment(JLabel.CENTER);
        labelImg4.setBounds(280, 180, 150, 150); // posición y tamaño del recuadro

        // Agregar al panel
        panelAyuda.add(labelImg4);


                // Agregar al CardLayout
                panelDerecho.add(panelAyuda, "Ayuda");





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
        String[] nombres = {"Menú", "Libros", "Catalogo", "Sugerencias", "Ayuda"};

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
