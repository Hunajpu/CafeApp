/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cafeappExtra;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Rodrigo Luna
 */
class AgregarProductoGUI extends JDialog implements ActionListener
{
    //Atributos
    private boolean aceptar_b;
    //Atributos de la GUI
    JButton cancelar;
    JButton agregar;
    JPanel superior;GridLayout rejilla_s;
    JPanel inferior;GridLayout rejilla_i;
    GridLayout rejilla_p;
    JLabel nom_label; JLabel des_label;JLabel cant_label;
    JTextField nom_input;JTextField cant_input;
    JTextArea des_input;

    public AgregarProductoGUI(Frame frame, boolean bln)
    {
        //Llamando al constructor
        super(frame, bln);
        //Boton aceptar
        aceptar_b = false;
    }
    
    public void init()
    {
        //Inicializar GUI
        rejilla_p = new GridLayout(3,1);
        this.setLayout(rejilla_p);
        superior = new JPanel();rejilla_s=new GridLayout(1,2);
        superior.setLayout(rejilla_s);
        inferior = new JPanel();rejilla_i=new GridLayout(1,2);
        inferior.setLayout(rejilla_i);
        
        cancelar = new JButton("Cancel");
        agregar = new JButton("Add");
        nom_label = new JLabel("Product Name");
        des_label = new JLabel("Description");
        nom_input = new JTextField();
        des_input = new JTextArea();
        cant_label = new JLabel("Quantity: ");
        cant_input = new JTextField();
        //Agregar los elementos a la ventana
        this.add(nom_label);
        this.add(nom_input);
        this.add(des_label);
        this.add(des_input);
        superior.add(cant_label);
        superior.add(cant_input);
        inferior.add(cancelar);
        inferior.add(agregar);
        this.add(superior);
        this.add(inferior);
        //Agragar actions listeners
        cancelar.addActionListener(this);
        agregar.addActionListener(this);
        //Settings de la ventana
        setSize(350,160);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(agregar))
        {
            this.aceptar_b = true;
            this.dispose();
        }
        if(ae.getSource().equals(cancelar))
        {
            this.dispose();
        }
    }

    boolean datosCorrectos() {
        return !(this.nom_input.getText().isEmpty() && this.des_input.getText().isEmpty() && this.cant_input.getText().isEmpty() && !aceptar_b);
    }

    String getNombre() {
        return this.nom_input.getText();
    }

    String getInfo() {
        return this.des_input.getText();
    }

    int getCantidad() {
        return Integer.parseInt(this.cant_input.getText());
    }
}
