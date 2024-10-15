import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Simulacion extends JFrame {
    private Torre torreA, torreB, torreC;
    private JTextField discosField;
    private JButton iniciarButton, volverButton;
    private Lab3 lab3Frame;
    private int delay = 300; // Delay para la animación

    public Simulacion(Lab3 lab3Frame) {
        this.lab3Frame = lab3Frame;
        inicializarSimulacion();
    }

    private void inicializarSimulacion() {
        setTitle("Simulación - Torre de Hanoi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBackground(new Color(240, 240, 240)); // Color de fondo

        // Panel superior
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelSuperior.setBackground(new Color(220, 220, 220));

        JLabel discosLabel = new JLabel("Número de discos:");
        discosField = new JTextField(10);
        iniciarButton = new JButton("Iniciar Simulación");

        // Estilo de los botones
        iniciarButton.setBackground(new Color(100, 150, 250));
        iniciarButton.setForeground(Color.WHITE);
        iniciarButton.setFocusPainted(false);
        iniciarButton.setBorder(BorderFactory.createEtchedBorder());

        // Estilo del campo de texto
        discosField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        discosField.setPreferredSize(new Dimension(150, 30));

        panelSuperior.add(discosLabel);
        panelSuperior.add(discosField);
        panelSuperior.add(iniciarButton);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Panel de las torres
        JPanel panelTorres = new JPanel(new GridLayout(1, 3, 15, 0));
        torreA = new Torre("Torre A");
        torreB = new Torre("Torre B");
        torreC = new Torre("Torre C");

        panelTorres.add(torreA);
        panelTorres.add(torreB);
        panelTorres.add(torreC);

        panelPrincipal.add(panelTorres, BorderLayout.CENTER);

        // Panel inferior con el botón volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.setBackground(new Color(220, 220, 220));

        volverButton = new JButton("Volver");
        volverButton.setBackground(new Color(220, 50, 50));
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setBorder(BorderFactory.createEtchedBorder());

        panelBotones.add(volverButton);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSimulacion();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab3Frame.setVisible(true); // Regresa a Lab3
                dispose();  // Cierra esta ventana
            }
        });
    }

    private void iniciarSimulacion() {
        try {
            int numDiscos = Integer.parseInt(discosField.getText());
            if (numDiscos >= 1) {
                resetearTorres();
                for (int i = numDiscos; i >= 1; i--) {
                    torreA.agregarDisco(new Disco(i));
                }
                // Usamos SwingWorker para mover los discos paso a paso
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        moverDiscos(numDiscos, torreA, torreC, torreB);
                        return null;
                    }
                };
                worker.execute();
            } else {
                mostrarMensaje("Por favor ingresa un número válido.");
            }
        } catch (NumberFormatException ex) {
            mostrarMensaje("Por favor ingresa un número válido.");
        }
    }

    private void resetearTorres() {
        torreA.removerDiscos();
        torreB.removerDiscos();
        torreC.removerDiscos();
    }

    private void moverDiscos(int n, Torre origen, Torre destino, Torre auxiliar) {
        if (n == 1) {
            moverDisco(origen, destino);
        } else {
            moverDiscos(n - 1, origen, auxiliar, destino);
            moverDisco(origen, destino);
            moverDiscos(n - 1, auxiliar, destino, origen);
        }
    }

    private void moverDisco(Torre origen, Torre destino) {
        Disco disco = origen.removerDisco();
        destino.agregarDisco(disco);
        repaint();
        try {
            Thread.sleep(delay); // Pequeño delay para la animación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    // Clase interna para representar las torres
    private class Torre extends JPanel {
        private Stack<Disco> discos;
        private String nombre;

        public Torre(String nombre) {
            this.nombre = nombre;
            this.discos = new Stack<>();
            setBorder(BorderFactory.createTitledBorder(nombre));
            setBackground(Color.WHITE);
        }

        public void agregarDisco(Disco disco) {
            discos.push(disco);
            repaint();
        }

        public Disco removerDisco() {
            return discos.isEmpty() ? null : discos.pop();
        }

        public void removerDiscos() {
            discos.clear();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = getWidth() / 2 - 10;
            int y = getHeight() - 30;

            for (Disco disco : discos) {
                int discoWidth = disco.getWidth();
                g.setColor(disco.getColor());
                g.fillRect(x - discoWidth / 2, y - 20, discoWidth, 20);
                y -= 25;
            }
        }
    }

    // Clase interna para representar los discos
    private class Disco {
        private int size;
        private Color color;

        public Disco(int size) {
            this.size = size;
            this.color = new Color((int) (Math.random() * 0x1000000)); // Color aleatorio
        }

        public int getWidth() {
            return size * 30;
        }

        public Color getColor() {
            return color;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Simulacion(null).setVisible(true);
            }
        });
    }
}
