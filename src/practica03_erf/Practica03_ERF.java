
package practica03_erf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Practica03_ERF extends JFrame
{
    private List<Cliente> listaClientes;
    private int indiceActual = 0;
    // Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;

    // Text fields para visualizar los atributos del cliente
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField; 

    private JButton atrasButton;
    private JButton adelanteButton;
    private boolean focusIsSet = false;

    public Practica03_ERF() {
        super("Doble");

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarClientes();
        //Crea las etiquetas.
        numeroLabel = new JLabel("Numero: ");
        nombreLabel = new JLabel("Nombre: ");
        edadLabel = new JLabel("Edad: ");
        puntosLabel = new JLabel("Puntos: ");

        //Campo donde vamos a introducir el número
        numeroField = new JTextField(10);
        numeroField.setEditable(false);

        //Campo que nos muestra el doble del numero introducido
        nombreField = new JTextField(10);
        nombreField.setEditable(false);
        nombreField.setForeground(Color.red);

        numeroField = new JTextField(10);
        numeroField.setEditable(false);
        numeroField.setForeground(Color.red);
        
        edadField = new JTextField(10);
        edadField.setEditable(false);
        edadField.setForeground(Color.red);
        
        puntosField = new JTextField(10);
        puntosField.setEditable(false);
        puntosField.setForeground(Color.red);
        
        puntosField = new JTextField(10);
        puntosField.setEditable(false);
        puntosField.setForeground(Color.red);
        
        atrasButton = new JButton("atras");
        atrasButton.addActionListener((ActionEvent e) -> {
            System.out.println("atras");
        } // Evento de boton.
        );
        
        adelanteButton = new JButton("adelante");
        adelanteButton.addActionListener((ActionEvent e) -> {
            System.out.println("adelante");
        } // Evento de boton.
        );
        
        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);

        JPanel botonesPane = new JPanel();
        botonesPane.add(atrasButton);
        botonesPane.add(adelanteButton);
        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
               BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(botonesPane, BorderLayout.SOUTH);

        setContentPane(contentPane);  //this.setContentPane(contentPane);
          // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame

    }

    private void inicializarClientes() {
        listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1, "Ana Pérez", 28, 150));
        listaClientes.add(new Cliente(2, "Carlos Gómez", 35, 320));
        listaClientes.add(new Cliente(3, "María Rodríguez", 42, 90));
    }
    
    private void mostrarCliente(int indice) {
        if (indice >= 0 && indice < listaClientes.size()) {
            Cliente c = listaClientes.get(indice);
            
            numeroField.setText(String.valueOf(c.getNumero()));
            nombreField.setText(c.getNombre());
            edadField.setText(String.valueOf(c.getEdad()));
            puntosField.setText(String.valueOf(c.getPuntos()));

            // Desactiva "atrasButton" si estamos en el primer elemento, desactiva "adelanteButton" en el último
            atrasButton.setEnabled(indice > 0);
            adelanteButton.setEnabled(indice < listaClientes.size() - 1);
        }
    }
    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(() -> {
            final Practica03_ERF app = new Practica03_ERF();
            
            app.pack();
            app.setVisible(true);
        });
    }

}