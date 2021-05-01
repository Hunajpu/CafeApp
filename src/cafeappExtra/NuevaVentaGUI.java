/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cafeappExtra;

import java.awt.FlowLayout;
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
 * @author Rodrigo Luna Reyes
 */
class NuevaVentaGUI extends JDialog implements ActionListener{
    //Atributos
    Venta venta;
    Cafeteria UPP;
    //Atributos de la GUI
    JButton cancelar;
    JButton comprar;
    JButton anadir;
    JPanel superior;GridLayout rejilla_s;
    JPanel inferior;FlowLayout rejilla_i;
    GridLayout rejilla_p;
    JLabel an_label;JLabel lista_label;JLabel cant_label;
    JTextField an_input;JTextField cant_input;
    
    public void init(Venta venta, Cafeteria UPP)
    {
        this.venta = venta;
        this.UPP = UPP;
        //Inicializar GUI
        rejilla_p = new GridLayout(2,1);
        this.setLayout(rejilla_p);
        superior = new JPanel();rejilla_s=new GridLayout(7,1);
        superior.setLayout(rejilla_s);
        inferior = new JPanel();rejilla_i=new FlowLayout();
        inferior.setLayout(rejilla_i);
        
        cancelar = new JButton("Cancel");
        comprar = new JButton("Buy");
        anadir = new JButton("Add");
        an_label = new JLabel("Add product");
        lista_label = new JLabel("Shopping Cart");
        an_input = new JTextField();
        cant_label = new JLabel("Quantity:");
        cant_input = new JTextField();
        //Agregar los elementos a la ventana
        this.add(lista_label);
        superior.add(an_label);
        superior.add(an_input);
        superior.add(cant_label);
        superior.add(cant_input);
        superior.add(anadir);
        superior.add(comprar);
        superior.add(cancelar);
        this.add(superior);
        //this.add(inferior);
        //Agragar actions listeners
        cancelar.addActionListener(this);
        comprar.addActionListener(this);
        anadir.addActionListener(this);
        //Settings de la ventana
        setSize(370,500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(anadir))
        {
            Producto p;
            int producto;
            int cantidad;
            producto=Integer.parseInt(this.an_input.getText());
            p=UPP.GetProducto(producto);
            cantidad=Integer.parseInt(this.cant_input.getText());
            if(cantidad>0)
            {
                venta.addVenta(p, cantidad);
            }
            //Actualizar carrito
            this.lista_label.setText("<html><body>Shopping cart<br>"+venta.ListarVenta()+"</body></html>");
        }
        if(ae.getSource().equals(comprar))
        {
            if(Integer.parseInt(this.cant_input.getText())<=0)
            {
                venta = null;
            }
            this.dispose();
        }
        if(ae.getSource().equals(cancelar))
        {
            venta = null;
            this.dispose();
        }
    }
    public NuevaVentaGUI(Frame frame, boolean bln)
    {
        //Llamando al constructor
        super(frame, bln);
    }

    Venta getVenta() {
        return venta;
    }
}
