/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cafeappExtra;

/**
 *
 * @author Rodrigo Luna Reyes
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CafeAppGUI extends JFrame implements ActionListener
{
    /* Aquí se desarrolla la parte principal de la GUI y el funcionamiento de la
    /* app.
    */
    //Distribución de la barra de opciones
    private final JMenuBar menuBar;
    private final JMenu archivo;
    private final JMenuItem salir;
    private final JMenu producto;
    private final JMenuItem agregar;
    private final JMenuItem eliminar;
    private final JMenu ventas;
    private final JMenuItem nueva_venta;
    //Elementos de la ventana principal
    //Utlilizar html para desplegar los elementos si no puedo pues ya uso un  JTextArea, y poniendole setOpaque(false)
    private final BorderLayout borde;
    private final GridLayout rejilla;
    JPanel output_pane;
    private JLabel ventas_display;
    private JLabel productos_display;
    //Elementos del motor de ejecución
    private Cafeteria UPP;
    private int ID=1;
    //@Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource().equals(agregar))
        {
            //Agregar un nuevo producto si es posible
            String nombre_p,informacion;
            int cantidad;
            
            AgregarProductoGUI window = new AgregarProductoGUI(this,true);
            window.init();
            if(window.datosCorrectos())
            {
                nombre_p=window.getNombre();
                informacion=window.getInfo();
                cantidad = window.getCantidad();
                ProductoCantidad Aux; //agregado
                Aux=new ProductoCantidad(ID,nombre_p,informacion,cantidad); //agregado
                UPP.AddProducto(Aux);
                ID++;
                //Actualizar ventana principal    
                this.actualizarProductos();
            }
        }
        if(ae.getSource().equals(eliminar))
        {
            String inputValue = JOptionPane.showInputDialog("Ingrese el producto que desea eliminar");
            if(!inputValue.isEmpty())
            {
                UPP.removeProducto(Integer.parseInt(inputValue)-1);
                //Actualizar ventana principal
                this.actualizarProductos();
                
            }
        }
        if(ae.getSource().equals(nueva_venta))
        {
            //Hacer una nueva venta
            Venta V=UPP.CrearNuevaVenta();
            NuevaVentaGUI window = new NuevaVentaGUI(this,true);
            window.init(V,UPP);
            V = window.getVenta();
            if(V!=null)
            {
                UPP.AddVenta(V);
                //Actualizar ventas
                int tam,i,j;
                int NumProVenta;
                Vector <Venta> Aux;
                VentaProducto VP;
                String texto="";
                Aux=UPP.ListarVentas();
                tam=Aux.size();
                for(i=0;i<tam;i++)
                {
                    V=Aux.get(i);
                    texto= "<html><body>----Sales----<br>Sale: "+V.IDVenta+"<br>";
                    NumProVenta=V.getNumProductosVenta();
                    for(j=0;j<NumProVenta;j++)
                    {
                        VP=V.GetVenta(j);
                        texto=texto+VP.GetVenta()+"<br>";
                    }
                }
                texto = texto+"</body></html>";
                this.ventas_display.setText(texto);
                this.actualizarProductos();
            }
        }
        if(ae.getSource().equals(salir))
        {
            this.dispose();
        }
    }
    //Inicializar la ventana
    public CafeAppGUI()
    {
        //Inicializar variables
        UPP=new Cafeteria(1);
        //Inicializar Layouts
        borde = new BorderLayout();
        this.setLayout(borde);
        rejilla = new GridLayout(1,2);
        output_pane = new JPanel();
        output_pane.setLayout(rejilla);
        //Inicializar Menus
        menuBar = new JMenuBar();
        archivo = new JMenu("File");
        salir = new JMenuItem("Exit");
        producto = new JMenu("Product");
        agregar = new JMenuItem("New Product");
        eliminar = new JMenuItem("Delete product");
        ventas = new JMenu("Sales");
        nueva_venta = new JMenuItem("New sale");
        //Inicializar elementos
        ventas_display = new JLabel("<html><body>----- Sales list -----</body></html>");
        productos_display = new JLabel("<html><body><br>----- Products -----<br>Product ID  |  Product name  |  Description  |  Quantity</body></html>");
        //Añadir menus a la barra principal
        menuBar.add(archivo);
        menuBar.add(producto);
        menuBar.add(ventas);
        //Añadir submenus a sus correspondientes menus
        //Archivo
        archivo.add(salir);
        //Productos
        producto.add(agregar);
        producto.add(eliminar);
        //Ventas
        ventas.add(nueva_venta);
        //Añadir ActionsListeners
        salir.addActionListener(this);
        agregar.addActionListener(this);
        eliminar.addActionListener(this);
        nueva_venta.addActionListener(this);
        //Añadir elementos al JPanel
        output_pane.add(ventas_display);
        output_pane.add(productos_display);
        //Añadir elementos al borderlayout
        this.add(menuBar,BorderLayout.NORTH);
        this.add(output_pane,BorderLayout.CENTER);
        //Settings de la ventana
        this.setSize(550,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void actualizarProductos() {
        int size;
        Vector<Producto> Lista;
        int i;
        Lista=UPP.ListarProductos();
        size=Lista.size();
        String outText = "<html><body><br>----- Product List -----<br>Product ID  |  Product name  |  Description  |  Quantity";
        for(i=0;i<size;i++)
        {
            outText = outText + "<br>   "+(i+1) +".-  |" + Lista.get(i).getNombre() + " | " + Lista.get(i).getDescripcion() + " | " + ((ProductoCantidad)Lista.get(i)).getCantidad();
        }
        this.productos_display.setText(outText+"</body></html>");
    }
}
