/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cafeappExtra;

import java.util.Scanner;
public class CafeAppExtra {

 /**
     * @param args the command line arguments
     */
    static Cafeteria UPP;
    static int ID=1;    
    static Scanner Teclado;
    
    
    public static void main(String[] args) {
        //Implementación gráfica
        CafeAppGUI gui = new CafeAppGUI();
        //Implementación del motor de ejecución
//        UPP=new Cafeteria(1);
//        Teclado=new Scanner(System.in);
//        
//        int Opc=0;
//        while (Opc!=10)
//        {
//            System.out.println("Cafeteria UPP");
//            System.out.println("1. Agregar Producto");
//            System.out.println("2. Remover Producto");
//            System.out.println("3. Listar Productos");
//            System.out.println("4. Nueva Venta");          
//            System.out.println("5. Listar Ventas");
//            System.out.println("10. Salir");
//            System.out.println("Seleccione una opcion (1-5)");
//            
//            Opc=Teclado.nextInt();
//            
//            switch (Opc)
//            {
//                case 1: AgregarProductos();break;
//                case 2: RemoverProducto();break;
//                case 3: ListarProductos();break;
//                case 4: NuevaVenta();break;
//                case 5: ListarVentas();break;
//            }
//            
//        }
//        
//    }
//    
//    protected static void AgregarProductos()
//    {
//        int cantidad;
//        int opc=1;
//        String P;
//        String D;
//        String resp=Teclado.nextLine();
//        System.out.println("----- Agregar Productos -----");
//        
//        while (opc!=0)
//        {
//            System.out.println("Ingresa Nombre del Producto");
//            P=Teclado.nextLine();
//            System.out.println(P);
//            System.out.println("Ingresa Descripción del Producto");
//            D=Teclado.nextLine();
//            System.out.println("Ingresa la cantidad del producto"); //Agregado
//            cantidad=Teclado.nextInt(); // agregado
//            resp=Teclado.nextLine(); //agregado
//            System.out.println("Agregar producto 0=No 1=Si");
//            opc=Teclado.nextInt();
//            resp=Teclado.nextLine();
//            if (opc==1)
//            {
//                ProductoCantidad Aux; //agregado
//                Aux=new ProductoCantidad(ID,P,D,cantidad); //agregado
//                UPP.AddProducto(Aux);
//                ID++;
//            }
//            System.out.println("Agregar otro producto 0=No 1=Si");
//            opc=Teclado.nextInt();
//            resp=Teclado.nextLine();
//        }
//    }
//    
//    static void ListarProductos()
//    {
//        Vector<Producto> Lista;
//        Lista=UPP.ListarProductos();
//        int size=Lista.size();
//        int i;
//        System.out.println("----- Listar Productos -----");
//        for(i=0;i<size;i++)
//        {
//            System.out.println( (i+1) +" " + Lista.get(i).getNombre() + " " + Lista.get(i).getDescripcion() + ((ProductoCantidad)Lista.get(i)).getCantidad());
//        }
//    }
//    
//    static void RemoverProducto()
//    {
//        int opc;
//        String resp;
//        ListarProductos();
//        System.out.println("----- Remover Producto -----");
//        System.out.println("Selecciona un producto");
//        opc=Teclado.nextInt();
//        resp=Teclado.nextLine();
//        UPP.removeProducto(opc-1);
//        ListarProductos();
//    }
//    
//    static void NuevaVenta()
//    {
//        int opc=0;
//        String resp;
//        System.out.println("----- Nueva Venta -----");
//        Venta V=UPP.CrearNuevaVenta();
//        while ((opc!=6) && (opc!=9))
//        {
//            System.out.println("1. Listar Productos");
//            System.out.println("2. Adicionar Producto");
//            System.out.println("3. Carrito Actual");   
//            System.out.println("6. Realizar Venta");
//            System.out.println("9. Cancelar Venta");
//            opc=Teclado.nextInt();
//            resp=Teclado.nextLine();
//            switch (opc)
//            {
//                case 1: ListarProductos();break;
//                case 2: AdicionarProductos(V);break;
//                case 3: Carrito(V);break;
//                case 6: RealizarVenta(V);break;
//                case 9: V=null;break;
//            }
//        }      
//    }
//    
//    static void AdicionarProductos(Venta V)
//    {
//        Producto p;
//        int producto;
//        int cantidad;
//        String resp;
//        System.out.println("Ingresa número de producto");
//        producto=Teclado.nextInt();
//        resp=Teclado.nextLine();
//        p=UPP.GetProducto(producto);
//        System.out.println(p.getNombre()+" "+p.getDescripcion());
//        System.out.println("Ingresa Cantidad");
//        cantidad=Teclado.nextInt();
//        resp=Teclado.nextLine();
//        if(cantidad>0)
//        {
//            V.addVenta(p, cantidad);
//        }
//    }
//    
//    static void Carrito(Venta V)
//    {
//        System.out.println(V.ListarVenta());
//    }
//    
//    static void RealizarVenta(Venta V)
//    {
//        UPP.AddVenta(V);
//    }
//    
//    static void ListarVentas()
//    {
//        int tam,i,j;
//        int NumProVenta;
//        Vector <Venta> Aux;
//        Venta V;
//        VentaProducto VP;
//        Aux=UPP.ListarVentas();
//        tam=Aux.size();
//        for(i=0;i<tam;i++)
//        {
//            V=Aux.get(i);
//            System.out.println("Venta:"+V.IDVenta+"\n");
//            NumProVenta=V.getNumProductosVenta();
//            for(j=0;j<NumProVenta;j++)
//            {
//                VP=V.GetVenta(j);
//                System.out.println(VP.GetVenta()+"\n");
//            }
//        }
//    }
    }
}
