/**
 * @(#)Proyecto.java
 * @author Garfia Pahua Jose G.
 * @version 1.00 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* Clase Node
 * Nodos utilizados en el arbol
 */
class Node {
 public Object element;
 public Object id;
 public Node left;
 public Node right;

 // Constructors 
 public Node(Object theElement,Object indice) {
  this(theElement, indice, null, null);
 }

 public Node(Object theElement,Object indice, Node lLink, Node rLink) {
  element    = theElement;
  id         = indice;
  this.left  = lLink;
  this.right = rLink;
 }
}//class node

/* Clase BST (Binary Sort Tree - Arbol de Ordenamiento Binario)
 */
class BST {
//Atributos de la clase
 public Node root;
 public ArrayList<Integer> indiceInt   = new ArrayList<Integer>();
 public ArrayList<Integer> indiceStr   = new ArrayList<Integer>();
 public ArrayList<Integer> indiceFloat = new ArrayList<Integer>();
 public ArrayList<Integer> indiceDate  = new ArrayList<Integer>();
 public ArrayList<Integer> camino  = new ArrayList<Integer>();
 public boolean encontrado=false;
 
 //Contructor de la clase
public BST(Object x, Object y) {
  root = new Node(x, y);
 }

 /* -- Metodo sobrecargado recursivo insert --
  * Metodo que inserta un elemento al arbol junto con el id de este
  * 
  * @param Node node: nodo actual
  * @param TipoDato x: Elemento a ser introducido en el arbol
  * @param Integer y: ID del dato introducido en el arbol
  **/
 public Node insert(Node node, Integer x, Integer y) {
  if (node == null) {
   return node = new Node(x,y);
  }
  if (x < (Integer) node.element) {
   node.left = insert(node.left, x,y);
  } else {
   node.right = insert(node.right, x,y);
  }
  return node;
 }
 
 public Node insert(Node node, String x, Integer y) {
  if (node == null) {
   return node = new Node(x,y);
  }
  if (x.compareToIgnoreCase((String) node.element)<0 ) {
   node.left = insert(node.left, x,y);
  } else {
   node.right = insert(node.right, x,y);
  }
  return node;
 }

 public Node insert(Node node, Float x,Integer y) {
  if (node == null) {
   return node = new Node(x,y);
  }
  if (x < (Float) node.element ) {
   node.left = insert(node.left, x,y);
  } else {
   node.right = insert(node.right, x,y);
  }
  return node;
 }
 
 public Node insert(Node node, Calendar x,Integer y) {
  if (node == null) {
   return node = new Node(x,y);
  }
  if (x.compareTo((Calendar) node.element)>0 ) {
   node.left = insert(node.left, x,y);
  } else {
   node.right = insert(node.right, x,y);
  }
  return node;
 }

 /* -- Familia de metodos inOrder --
  * Recursivos.
  * In-Order traversal(Left->Root->Right) of tree for getting elements in
  * ascending order depending in wich type of data you have in the tree.
  *
  * @param Node node: nodo actual en el arbol, se recomienda comenzar 
  * en la raiz al ser llamado.
  **/
 public void inOrder(Node node) {
  if (node != null) {
   inOrder(node.left);
   indiceInt.add((Integer)node.id);
   inOrder(node.right);
  }
 }
 
 public void inOrderString(Node node) {
  if (node != null) {
   inOrderString(node.left);
   indiceStr.add((Integer)node.id);
   inOrderString(node.right);
  }
 }
 
 public void inOrderFloat(Node node) {
  if (node != null) {
   inOrderFloat(node.left);
   indiceFloat.add((Integer)node.id);
   inOrderFloat(node.right);
  }
 }
 
 public void inOrderDate(Node node) {
  if (node != null) {
   inOrderDate(node.left);
   indiceDate.add((Integer)node.id);
   inOrderDate(node.right);
  }
 }
 
 /* -- Familia de metodos buscar --
  * Metodos recursivos para buscar que dependendiendo de 
  * el tipo de elementos agregados en el arbol es el que se usara
  *
  * @param Nodo node: El nodo actual en el arbol, se comienza desde
  * la raiz al ser llamado
  * 
  * @param TipoDato a: El elemento que se esta buscando en el arbol
  **/
 
 public void buscarInt(Node node,int a){
 	if(node == null)
 		return;
 	if( a == ((Integer) node.element)){
 		camino.add((Integer)node.id);
 		encontrado=true;
 	}
 	else{
 		if(a < ((Integer) node.element) ){
 			camino.add((Integer) node.id);
 			buscarInt(node.left,a);
 		}
 		else{
 			camino.add((Integer) node.id);
 			buscarInt(node.right,a);
 		}
 	}
 }
 
 public void buscarString(Node node,String a){
 	if(node == null)
 		return;
 	if( a.compareToIgnoreCase((String) node.element)== 0){
 		camino.add((Integer)node.id);
 		encontrado=true;
 	}
 	else{
 		if(a.compareToIgnoreCase((String) node.element)<0) {
 			camino.add((Integer) node.id);
 			buscarString(node.left,a);
 		}
 		else{
 			camino.add((Integer) node.id);
 			buscarString(node.right,a);
 		}
 	}
 }
 
 public void buscarFloat(Node node,float a){
 	if(node == null)
 		return;
 	if( a == ((Float) node.element)){
 		camino.add((Integer)node.id);
 		encontrado=true;
 	}
 	else{
 		if(a < ((Float) node.element) ){
 			camino.add((Integer) node.id);
 			buscarFloat(node.left,a);
 		}
 		else{
 			camino.add((Integer) node.id);
 			buscarFloat(node.right,a);
 		}
 	}
 }
 
 public void buscarDate(Node node,Calendar a){
 	if(node == null){
 		return;
 	}
 	if( a.compareTo((Calendar) node.element) == 0 ){
 		camino.add((Integer)node.id);
 		encontrado=true;
 	}
 	else{
 		if(a.compareTo((Calendar) node.element)<0 ){
 			camino.add((Integer) node.id);
 			buscarDate(node.left,a);
 		}
 		else{
 			camino.add((Integer) node.id);
 			buscarDate(node.right,a);
 		}
 	}
 }
 
 // Right->Root->Left traversal of tree for getting elements in descending
 // order//
 public void descOrder(Node node) {
  if (node != null) {
   descOrder(node.right);
   System.out.print(((Integer) node.element).intValue() + ",");
   descOrder(node.left);
  }
 }
}

class Vuelos {
    
    //atributos
    String CiudadOrigen, CiudadDestino, FechaSalida, FechaArribo; 
    float  DistanciaVuelo, CapacidadCarga;
    int    CapacidadPasajeros, AsientosDisponibles, IdVuelo;
     
    //constructor
    public Vuelos(String CiudadOrigen, String CiudadDestino, String FechaSalida, String FechaArribo,
    	          float DistanciaVuelo, float CapacidadCarga, int CapacidadPasajeros, int AsientosDisponibles,
    	          int IdVuelo) { //llave constructor
      
      this.CiudadOrigen        = CiudadOrigen;
      this.CiudadDestino       = CiudadDestino;
      this.FechaSalida         = FechaSalida;
      this.FechaArribo         = FechaArribo;
      this.DistanciaVuelo      = DistanciaVuelo;
      this.CapacidadCarga      = CapacidadCarga;
      this.CapacidadPasajeros  = CapacidadPasajeros;
      this.AsientosDisponibles = AsientosDisponibles;
      this.IdVuelo             = IdVuelo;
      
    }//fin constructor
    
//familia de métodos REGRESAR
public String regresarCiudadOrigen(){
	return CiudadOrigen;
}

public String regresarCiudadDestino(){
	return  CiudadDestino;
}

public String regresarFechaSalida(){
	return FechaSalida;
}

public String regresarFechaArribo(){
	return FechaArribo;
}

public float regresarDistanciaVuelo(){
	return DistanciaVuelo;
}

public float regresarCapacidadCarga(){
	return CapacidadCarga;
}

public int regresarCapacidadPasajeros(){
	return CapacidadPasajeros;
}

public int regresarAsientosDisponibles(){
	return AsientosDisponibles;
}

public int regresarIdvuelo(){
	return IdVuelo;
}

//familia de métodos MODIFICAR
public void modificarCiudadOrigen(String CO){
	CiudadOrigen=CO;
}

public void modificarCiudadDestino(String CD){
	CiudadDestino=CD;
}

public void modificarFechaSalida(String FS){
	FechaSalida=FS;
}

public void modificarFechaArribo(String FA){
	FechaArribo=FA;
}

public void modificarDistanciaVuelo(float DV){
	DistanciaVuelo=DV;
}

public void modificarCapacidadCarga(float CC){
	CapacidadCarga=CC;
}

public void modificarCapacidadPasajeros(int CP){
	CapacidadPasajeros=CP;
}

public void modificarAsientosDisponibles(int AS){
	AsientosDisponibles=AS;
}

public void modificarIdvuelo(int IDV){
	IdVuelo=IDV;
}
      
}//class Vuelos 


/**************************  CLASE PROYECTO  *****************************************/
public class Proyecto extends WindowAdapter implements ActionListener{
	
    //arreglo de referencia para capturar asientos, pasajeros, distancia etc......
    Vuelos V[]= new Vuelos[20];
    //contVuelos: variable que se utiliza para conocer cuantos vuelos se llevan registrados|||||||auxID: varible para obtener un ID momentaneo
    int contVuelos=0, auxID=0;
    /*Bandera para verificar que un vuelo no este repetido*/
    boolean vueloRepetido=false;
    /** Arboles Binarios de ordenamiento ( Binary Sort Tree)**/
    BST ordCP,ordFS,ordD,ordCO;
    
    //variables
    int    CapacidadPasajeros=0, AsientosDisponibles=0, Idvuelo=0;
    float  DistanciaVuelo=0, CapacidadCarga=0;
    String CiudadOrigen, CiudadDestino, FechaSalida, FechaArribo;
    //Arbol porFecha,porCO,porCP,porDistancia;
    
    //MENU PRINCIPAL
    Frame  Menuprincipal;
    Label  Captura, Muestra, Modifica;
    Button Bcapturar, Bmuestra, Bmodifica; 
    
    /******************AGREGAMOS NUEVOS ELEMENTOS A NUESTRO MENU "PRACTICA #2"************************/
    
    //nuevos elementos para practica #2
    Label  OrdenarVuelos;
    Button BordenarVuelos;
    
    //menu para ordenar los vuelos
    Frame  OrdenandoVuelos;
    Label  OrFechaSa, OrDistanciaVuelo, CapPasajeros, OrCiudadOrigen;
    Button BorFechaSa, BorDistanciaVuelo, BcapPasajeros, BorCiudadOrigen, MostrarOrdenandos, RegresarPrincipal;
    
    //ventana para mostrar los vuelos ordenados
    Frame    MostrarArbol;
    TextArea TMArbol; 
    
    /******************AGREGAMOS NUEVOS ELEMENTOS A NUESTRO MENU "PRACTICA #2"************************/
    
    //ventana MOSTRAR
    Frame    Mostrar;
    TextArea Mirar;	   
    
    //Ventana Capturar
    Frame     Capturar;
    Label     CiudadO, CiudadD, FechaS, FechaA, DistanciaV, CapacidadC, CapacidadP, AsientosD, IDVuelo;
    TextField TciudadO, TciudadD, TfechaS, TfechaA, TdistanciaV, TcapacidadC, TcapacidadP, TasientosD, Tidvuelo;
    Button    Bagregar, Bregresar;
    
    //ventana Buscar para modificar
    Frame     Modificar;
    Label     EtiquetaMod;
    TextField IDmodificar;
    Button    Encontrar, Retorno,Encontrar2;
    
    /*********************AGREGAMOS NUEVOS ELEMENTOS AL MENU "PRACTICA #3"*******************/
    Label     LaBuscar;
    Button    BuscArbol;
    Frame     BuscarV, BusFechaS, BusDistVue, BusCapPas, BusCiudOrig, MostVueArbol;
    Button    MOrFechaSa, MOrDistanciaVuelo, MCapPasajeros, MOrCiudadOrigen;
    Label     EtiqFecha, EtiqDist, EtiqCapPas, EtiqCiud;
    TextField IDfecha, IDdist, IDcappas, IDCiud;
    TextArea  MostrarNodo;
    //botones para los frames buscadores
    Button    BotFechaS, BotDistVue, BotCapPas, BotCiudOrig, RetorFechaS,RetorDistVue, RetorCapPas, RetorCiudOrig;
    
    //constructor inicio
    public Proyecto() {
    	
        //frame menu interfaz
    	Menuprincipal = new Frame("PAHUA Fly Emirates ");
    	Captura       = new Label("Capturar vuelo ");
    	Muestra       = new Label("Mostrar vuelos ");
    	Modifica      = new Label("Modificar vuelo ");
    	Bcapturar     = new Button("Aceptar");
    	Bmuestra      = new Button("Aceptar");
    	Bmodifica     = new Button("Aceptar");
    	
    	
	/******************AGREGAMOS NUEVOS ELEMENTOS A NUESTRO MENU "PRACTICA #2"************************/
    	
    	//nuevos elementos para el menu principal prcatica #2
    	OrdenarVuelos  = new Label("Ordenar vuelos ");
    	BordenarVuelos = new Button("Aceptar");
        	
    	//frame ordenar vuelos
    	OrdenandoVuelos   = new Frame("Ordenar vuelos por: ");
    	OrFechaSa         = new Label("Fecha de salida");
    	CapPasajeros      = new Label("Capacidad de pasajeros");
    	OrCiudadOrigen    = new Label("Ciudad de origen");
    	OrDistanciaVuelo  = new Label("Distancia de vuelo");
    	BorFechaSa        = new Button("Aceptar");
    	BcapPasajeros     = new Button("Aceptar");
    	BorCiudadOrigen   = new Button("Aceptar");
    	BorDistanciaVuelo = new Button("Aceptar");
    	
    	//frame para mostrar vuelos ordenados arbol
    	MostrarArbol = new Frame("Vuelos ordenados: ");
    	TMArbol      = new TextArea(40,4);
    	
    	/******************AGREGAMOS NUEVOS ELEMENTOS A NUESTRO MENU "PRACTICA #2"*************************/
    	
    	//frame mostrar
    	Mostrar       = new Frame("Mostrando vuelos ");
    	Mirar         = new TextArea(30,4);
    	
    	//frame Capturar
    	Capturar    = new Frame("Capturar Vuelo a: ");
    	IDVuelo     = new Label("Identificador de vuelo #");
    	CiudadO     = new Label("Ciudad de origen ");
    	CiudadD     = new Label("Ciudad de destino ");
    	FechaS      = new Label("Fecha de salida ");
    	FechaA      = new Label("Fecha de arribo ");
    	DistanciaV  = new Label("Distancia de vuelo ");
    	CapacidadC  = new Label("Capacidad de carga ");
    	CapacidadP  = new Label("Capacidad de pasajeros ");
    	AsientosD   = new Label("Asientos disponibles ");
    	Tidvuelo    = new TextField(30);
        TciudadO    = new TextField(30);
        TciudadD    = new TextField(30);
        TfechaS     = new TextField(30);
        TfechaA     = new TextField(30);
        TdistanciaV = new TextField(30);
        TcapacidadC = new TextField(30);
        TcapacidadP = new TextField(30);
        TasientosD  = new TextField(30);
        Bagregar    = new Button("Capturar ");
        Bregresar   = new Button("Regresar "); 
        
        //Modificar vuelo
        Modificar   = new Frame("Modificar vuelo");
        EtiquetaMod = new Label("Teclee id vuelo");
        IDmodificar = new TextField(30);
        Encontrar   = new Button("Buscar");
        Retorno     = new Button("Regresar");
        Encontrar2  = new Button("Guardar");
        
        /****************PRACTICA #3**********/
        //frames
        BuscarV      = new Frame("Buscar por: ");
        BusFechaS    = new Frame("Fecha salida ");
        BusDistVue   = new Frame("Distancia vuelo ");
        BusCapPas    = new Frame("Capacidad pasajeros ");
        BusCiudOrig  = new Frame("Ciudad origen ");
        MostVueArbol = new Frame("Mostrando los nodos: ");
        
        //Botones
        MOrFechaSa        = new Button("Fecha de salida ");
        MOrDistanciaVuelo = new Button("Distancia Vuelo ");
        MCapPasajeros     = new Button("Capacidad Pasajeros ");
        MOrCiudadOrigen   = new Button("Ciudad Origen ");
        
        //labels
        EtiqFecha  = new Label("Teclee: ");
        EtiqDist   = new Label("Teclee: ");
        EtiqCapPas = new Label("Teclee: ");
        EtiqCiud   = new Label("Teclee: ");
        
        //TextArea
        MostrarNodo = new TextArea(30,4);
        
        //TextFields
        IDfecha  = new TextField(30);
        IDdist   = new TextField(30);
        IDcappas = new TextField(30);
        IDCiud   = new TextField(30);
        
        //botones buscar y regresar para los frames
        BotFechaS     = new Button("Buscar ");
        BotCapPas     = new Button("Buscar ");
        BotCiudOrig   = new Button("Buscar ");
        BotDistVue    = new Button("Buscar ");
        RetorFechaS   = new Button("Regresar ");
        RetorCapPas   = new Button("Regresar ");
        RetorCiudOrig = new Button("Regresar ");
        RetorDistVue  = new Button("Regresar "); 
        
        //componentes para menu principal
        LaBuscar = new Label("Buscar vuelo Por: ");
        BuscArbol = new Button("Aceptar");
           	
  }//constructor
    
    public void mostrarFrame(){
    	
    	//menu interfaz
    	Menuprincipal.setLayout(new GridLayout(5,2));
    	Menuprincipal.add(Captura);
    	Menuprincipal.add(Bcapturar);
    	Menuprincipal.add(Muestra);
    	Menuprincipal.add(Bmuestra);
    	Menuprincipal.add(Modifica);
    	Menuprincipal.add(Bmodifica);
    	Menuprincipal.add(OrdenarVuelos);
    	Menuprincipal.add(BordenarVuelos);
    	Menuprincipal.add(LaBuscar);
    	Menuprincipal.add(BuscArbol);
    	Menuprincipal.addWindowListener(this);    //OREJA
    	Bcapturar.addActionListener(this);        //accion en boton
    	Bmuestra.addActionListener(this);         //accion en boton
    	Bmodifica.addActionListener(this);        //accion en boton
    	BordenarVuelos.addActionListener(this);   //acion en boton
    	BuscArbol.addActionListener(this);        //accion en boton
    	Menuprincipal.setBounds(400,250,300,200); //dimensiones de frame
    	Menuprincipal.setVisible(true);           //visible
    	
    	//mostrar interfaz
    	Mirar.setEditable(false);
    	Mirar.setBackground(Color.white);
    	Mostrar.setLayout(new GridLayout(1,1));
    	Mostrar.setBounds(400,250,300,400);
    	Mostrar.add(Mirar); 
    	Mostrar.addWindowListener(this); //OREJA
    	
    	//capturar interfaz
    	Capturar.setLayout(new GridLayout(10,2));
    	Capturar.add(IDVuelo);    Capturar.add(Tidvuelo);
    	Capturar.add(CiudadO);    Capturar.add(TciudadO);
    	Capturar.add(CiudadD);    Capturar.add(TciudadD);
    	Capturar.add(FechaS);     Capturar.add(TfechaS);
    	Capturar.add(FechaA);     Capturar.add(TfechaA);
    	Capturar.add(DistanciaV); Capturar.add(TdistanciaV);
    	Capturar.add(CapacidadC); Capturar.add(TcapacidadC);
    	Capturar.add(CapacidadP); Capturar.add(TcapacidadP);
    	Capturar.add(AsientosD);  Capturar.add(TasientosD);
    	Capturar.add(Bagregar);   Capturar.add(Bregresar); 
    	Capturar.setBounds(400,250,300,300);
    	Capturar.addWindowListener(this); //OREJA
    	Bagregar.addActionListener(this);   //accion en buton
    	Bregresar.addActionListener(this); //accione en buton
    	
    	//modificar vuelo interfaz
    	Modificar.setLayout(new GridLayout(2,2));
    	Modificar.setBounds(300,250,250,90);
    	Modificar.add(EtiquetaMod);
    	Modificar.add(IDmodificar);
    	Modificar.add(Encontrar);
    	Modificar.add(Retorno);
    	Modificar.addWindowListener(this);//OREJA
    	Encontrar.addActionListener(this);//accion en button
    	Retorno.addActionListener(this); //accion en buton
    	Encontrar2.addActionListener(this);//OREJA
    	
    	/******************AGREGAMOS NUEVOS ELEMENTOS A NUESTRO MENU "PRACTICA #2"*************************/
    	
    	//Ordenar vuelos interfaz
    	OrdenandoVuelos.setLayout(new GridLayout(4,2));
    	OrdenandoVuelos.setBounds(400,250,300,150);
    	OrdenandoVuelos.add(OrFechaSa);         OrdenandoVuelos.add(BorFechaSa);
    	OrdenandoVuelos.add(CapPasajeros);      OrdenandoVuelos.add(BcapPasajeros);
    	OrdenandoVuelos.add(OrCiudadOrigen);    OrdenandoVuelos.add(BorCiudadOrigen);
    	OrdenandoVuelos.add(OrDistanciaVuelo);  OrdenandoVuelos.add(BorDistanciaVuelo);
    	OrdenandoVuelos.addWindowListener(this);    //OREJA
    	BorFechaSa.addActionListener(this);         //accion en boton
    	BcapPasajeros.addActionListener(this);      //accion en boton
    	BorCiudadOrigen.addActionListener(this);    //accion en boton
    	BorDistanciaVuelo.addActionListener(this);  //accion en boton 
    	OrdenandoVuelos.setVisible(false);
    	
    	MostrarArbol.setLayout(new GridLayout(1,1));
    	MostrarArbol.setBounds(400,250,300,400);
    	MostrarArbol.add(TMArbol); 
    	MostrarArbol.addWindowListener(this); //OREJA
    	MostrarArbol.setVisible(false);
    	
    	/******************AGREGAMOS NUEVOS ELEMENTOS A NUESTRO MENU "PRACTICA #3"*************************/
    	
    	BuscarV.setLayout(new GridLayout(4,0));
    	BuscarV.setBounds(400,250,300,150);
    	BuscarV.add(MOrFechaSa);
    	BuscarV.add(MCapPasajeros);
    	BuscarV.add(MOrCiudadOrigen);
    	BuscarV.add(MOrDistanciaVuelo);
    	BuscarV.addWindowListener(this); //OREJA
    	MOrFechaSa.addActionListener(this);
    	MCapPasajeros.addActionListener(this);
    	MOrCiudadOrigen.addActionListener(this);
    	MOrDistanciaVuelo.addActionListener(this);
    	BuscarV.setVisible(false);
    	
    	BusFechaS.setLayout(new GridLayout(2,2));
    	BusFechaS.setBounds(300,250,250,90);
    	BusFechaS.add(EtiqFecha);
    	BusFechaS.add(IDfecha);
    	BusFechaS.add(BotFechaS);
    	BusFechaS.add(RetorFechaS);
    	BusFechaS.addWindowListener(this);//oreja
    	BotFechaS.addActionListener(this);
    	RetorFechaS.addActionListener(this);
        BusFechaS.setVisible(false);
        
        BusCapPas.setLayout(new GridLayout(2,2));
    	BusCapPas.setBounds(300,250,250,90);
    	BusCapPas.add(EtiqCapPas);
    	BusCapPas.add(IDcappas);
    	BusCapPas.add(BotCapPas);
    	BusCapPas.add(RetorCapPas);
    	BusCapPas.addWindowListener(this);//oreja
    	BotCapPas.addActionListener(this);
    	RetorCapPas.addActionListener(this);
    	BusCapPas.setVisible(false);
    	
    	BusCiudOrig.setLayout(new GridLayout(2,2));
    	BusCiudOrig.setBounds(300,250,250,90);
    	BusCiudOrig.add(EtiqCiud);
    	BusCiudOrig.add(IDCiud);
    	BusCiudOrig.add(BotCiudOrig);
    	BusCiudOrig.add(RetorCiudOrig);
    	BusCiudOrig.addWindowListener(this);//oreja
    	BotCiudOrig.addActionListener(this);
    	RetorCiudOrig.addActionListener(this);
    	BusCiudOrig.setVisible(false);
    	
    	BusDistVue.setLayout(new GridLayout(2,2));
    	BusDistVue.setBounds(300,250,250,90);
    	BusDistVue.add(EtiqDist);
    	BusDistVue.add(IDdist);
    	BusDistVue.add(BotDistVue);
    	BusDistVue.add(RetorDistVue);
    	BusDistVue.addWindowListener(this);//oreja
    	BotDistVue.addActionListener(this);
    	RetorDistVue.addActionListener(this);
    	BusDistVue.setVisible(false);
    	
    	MostVueArbol.setLayout(new GridLayout(1,1));
    	MostVueArbol.setBounds(400,250,300,400);
    	MostVueArbol.add(MostrarNodo);
    	MostVueArbol.addWindowListener(this);//oreja
    	MostVueArbol.setVisible(false);
   	
    }//mostrar frame
    
    
    /* Metodo: mostrarVuelos Este metodo obtiene los datos de los vuelos guarduados y los muestra en un text area*/
	public void mostrarVuelos(){
    	for (int i = 0; i<20; i++){
    		if(V[i].regresarIdvuelo()!=-1){
    			Mirar.setText(Mirar.getText()+"ID vuelo: "+V[i].regresarIdvuelo()+"\nCiudad Origen: "+V[i].regresarCiudadOrigen()+
    				"\nCiudad Destino: "+V[i].regresarCiudadDestino()+"\nFecha Arribo: "+V[i].regresarFechaArribo()+
    				"\nFecha Salida: "+V[i].regresarFechaSalida()+"\nDistancia del vuelo: "+V[i].regresarDistanciaVuelo()+
    				"\nCapacidad Carga: "+V[i].regresarCapacidadCarga()+"\nCapacidad Pasajeros: "+V[i].regresarCapacidadPasajeros()+
    				"\nAsientos disponibles: "+V[i].regresarAsientosDisponibles()+"\n\n");
    		}//if
    	}//for
    }//mostrar vuelos
    
    /* Metodo: initVuelos metodo para crear los objetos de los vuelos para su posterior uso */
	private void initVuelos(){
    	for (int i = 0; i<20; i++) {
    		V[i]=new Vuelos("","","","",0f,0f,0,0,-1);
    	}//for
    }//initvuelos
    
    /* Metodo: capturarVuelo metodo para obtener los datos de entrada para registrar un vuelo */
	private void capturarVuelo(){
    	if(contVuelos==20){
			/*Caso en el que se llegue al nuemro maximo de vuelos que se pueden registrar*/
			JOptionPane.showMessageDialog(null,"Numero de vuelos maximo alcanzado. :C","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				/*obtiene los datos de los textfields y los pone en variables locales*/
				Idvuelo             = Integer.parseInt(Tidvuelo.getText());
				CiudadOrigen        = TciudadO.getText();
				CiudadDestino       = TciudadD.getText();
				FechaSalida="";
				FechaSalida         = TfechaS.getText();
				try{
					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        			formatoFecha.setLenient(false);
        			formatoFecha.parse(FechaSalida);
				}catch(Exception e){
					FechaSalida="";
					TfechaS.setText("");
					JOptionPane.showMessageDialog(Capturar,"Formato de fecha no valido. El formato es : dd/mm/yyyy","Error de formato",JOptionPane.ERROR_MESSAGE );
					return;
				}
				FechaArribo         = TfechaA.getText();
				DistanciaVuelo      = Float.parseFloat(TdistanciaV.getText());
				CapacidadCarga      = Float.parseFloat(TcapacidadC.getText());
				CapacidadPasajeros  = Integer.parseInt(TcapacidadP.getText());
				AsientosDisponibles = Integer.parseInt(TasientosD.getText());
				
				 /*Se verifica que el nuemro de vuelo este disponible*/
				 for (int i = 0; i<19; i++)
				 	if(V[i].regresarIdvuelo()==Idvuelo)
				 		vueloRepetido=true;
				 
				 if(vueloRepetido==true){
				 	Tidvuelo.setText("");
				 	JOptionPane.showMessageDialog(null,"El id de vuelo ya esta registrado","Error de existencia",JOptionPane.ERROR_MESSAGE);
				 }
				 else{
					 //Se colocan los valores en el objeto
					 V[contVuelos].modificarIdvuelo(Idvuelo);
					 V[contVuelos].modificarCiudadOrigen(CiudadOrigen);
					 V[contVuelos].modificarCiudadDestino(CiudadDestino);
					 V[contVuelos].modificarFechaArribo(FechaArribo);
					 V[contVuelos].modificarFechaSalida(FechaSalida);
					 V[contVuelos].modificarDistanciaVuelo(DistanciaVuelo);
					 V[contVuelos].modificarCapacidadCarga(CapacidadCarga);
					 V[contVuelos].modificarCapacidadPasajeros(CapacidadPasajeros);
					 V[contVuelos].modificarAsientosDisponibles(AsientosDisponibles);
					 JOptionPane.showMessageDialog(null,"El vuelo ha sido guardado con exito.","Aceptado",JOptionPane.DEFAULT_OPTION);
					 contVuelos++; 
					 	
					 //Se limpian los campos para su posterior uso
					 Tidvuelo.setText("");
					 TciudadO.setText("");
					 TciudadD.setText("");
					 TfechaA.setText("");
					 TfechaS.setText("");
					 TdistanciaV.setText("");
					 TcapacidadC.setText("");
					 TcapacidadP.setText("");
					 TasientosD.setText("");
					 Modificar.setLayout(new GridLayout(2,2));
			     	 Modificar.setBounds(400,250,300,100);
			     	 Modificar.add(EtiquetaMod);
			       	 Modificar.add(IDmodificar);
			    	 Modificar.add(Encontrar);
			    	 Modificar.add(Retorno);
			    	 Tidvuelo.requestFocus();
				}
			}catch(Exception ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null,"Verifique los datos de entrada","Error en los datos de entrada",JOptionPane.ERROR_MESSAGE);
			}
		}
    }
    
    /* Metodo: encontrarVuelo
     * metodo que localiza un vuelo por su id y modifica la ventana de modificar
     *para que se paresca a la ventana de capturar y le asigna los valores del
     *vuelo (si se encontro) a los respectivos campos 
     **/
	private int encontrarVuelo(int idVueloAModificar){
    	IDmodificar.setText("");
    	int idv=0;
    	boolean vueloEncontrado=false;
    	/*Se busca el vuelo por el ID y se guarda la poscion en la variable idv*/
    	for (int i = 0; i<20; i++)
    		if(V[i].regresarIdvuelo()==idVueloAModificar){
    			vueloEncontrado=true;
    			idv=i;
    			break;
    		}//for
    		/*Si se encontro el vuelo, se prepara la ventana y la informacion*/
    	if(vueloEncontrado){
    		/*Modificando la ventana modificar*/
    		Modificar.setBounds(400,250,300,300);
    		Modificar.setLayout(new GridLayout(10,2));
    		Modificar.remove(EtiquetaMod);
    		Modificar.remove(IDmodificar);
    		Modificar.remove(Encontrar);
    		Modificar.remove(Retorno);
    		Modificar.add(IDVuelo);      Modificar.add(Tidvuelo);
	    	Modificar.add(CiudadO);      Modificar.add(TciudadO);
	    	Modificar.add(CiudadD);      Modificar.add(TciudadD);
	    	Modificar.add(FechaS);       Modificar.add(TfechaS);
	    	Modificar.add(FechaA);       Modificar.add(TfechaA);
	    	Modificar.add(DistanciaV);   Modificar.add(TdistanciaV);
	    	Modificar.add(CapacidadC);   Modificar.add(TcapacidadC);
	    	Modificar.add(CapacidadP);   Modificar.add(TcapacidadP);
	    	Modificar.add(AsientosD);    Modificar.add(TasientosD);
	    	Modificar.add(Encontrar2);   Modificar.add(Retorno);	
	  		Tidvuelo.setEditable(false);
	  		Tidvuelo.setBackground(Color.white);
	  		 
	  		/*Agregando al informacion del vuelo en especifico a los campos de texto correspondientes*/
	    	Tidvuelo.setText(Integer.toString(V[idv].regresarIdvuelo()));
	    	TciudadO.setText(V[idv].regresarCiudadOrigen());
	    	TciudadD.setText(V[idv].regresarCiudadDestino());
	    	TfechaA.setText(V[idv].regresarFechaArribo());
	    	TfechaS.setText(V[idv].regresarFechaSalida());
	    	TdistanciaV.setText(Float.toString(V[idv].regresarDistanciaVuelo()));
	    	TcapacidadC.setText(Float.toString(V[idv].regresarCapacidadCarga()));
	    	TcapacidadP.setText(Integer.toString(V[idv].regresarCapacidadPasajeros()));
	    	TasientosD.setText(Integer.toString(V[idv].regresarAsientosDisponibles()));
    	}
    	else{
    		JOptionPane.showMessageDialog(null,"No se encontro el vuelo solicitado, verifique el ID","Error, vuelo no encontrado",JOptionPane.ERROR_MESSAGE);
    	}
    	return idv;
    }//encontrar vuelo
    
    /* Metodo: modificarFrameModif
     * Metodo que retorna a su valor original el frame modificar y 
     * devuelve los botones y las etiquetas a la ventana capturar
     **/
	private void modificarFrameModif(){
    	Tidvuelo.setText("");
		TciudadO.setText("");
		TciudadD.setText("");
		TfechaA.setText("");
		TfechaS.setText("");
		TdistanciaV.setText("");
		TcapacidadC.setText("");
		TcapacidadP.setText("");
		TasientosD.setText("");
		Tidvuelo.setEditable(true);
    	Modificar.remove(IDVuelo);      Modificar.remove(Tidvuelo);
    	Modificar.remove(CiudadO);      Modificar.remove(TciudadO);
    	Modificar.remove(CiudadD);      Modificar.remove(TciudadD);
    	Modificar.remove(FechaS);       Modificar.remove(TfechaS);
    	Modificar.remove(FechaA);       Modificar.remove(TfechaA);
    	Modificar.remove(DistanciaV);   Modificar.remove(TdistanciaV);
    	Modificar.remove(CapacidadC);   Modificar.remove(TcapacidadC);
    	Modificar.remove(CapacidadP);   Modificar.remove(TcapacidadP);
    	Modificar.remove(AsientosD);    Modificar.remove(TasientosD);
    	Modificar.remove(Encontrar2);   Modificar.remove(Retorno);
    	Modificar.setLayout(new GridLayout(2,2));
    	Modificar.setBounds(400,250,300,100);
    	Modificar.add(EtiquetaMod);
    	Modificar.add(IDmodificar);
    	Modificar.add(Encontrar);
    	Modificar.add(Retorno);
    	
    	//capturar interfaz
    	Capturar.setLayout(new GridLayout(10,2));
    	Capturar.add(IDVuelo);    Capturar.add(Tidvuelo);
    	Capturar.add(CiudadO);    Capturar.add(TciudadO);
    	Capturar.add(CiudadD);    Capturar.add(TciudadD);
    	Capturar.add(FechaS);     Capturar.add(TfechaS);
    	Capturar.add(FechaA);     Capturar.add(TfechaA);
    	Capturar.add(DistanciaV); Capturar.add(TdistanciaV);
    	Capturar.add(CapacidadC); Capturar.add(TcapacidadC);
    	Capturar.add(CapacidadP); Capturar.add(TcapacidadP);
    	Capturar.add(AsientosD);  Capturar.add(TasientosD);
    	Capturar.add(Bagregar);   Capturar.add(Bregresar); 
    	Capturar.setBounds(400,250,300,300);
    	
    }//modificar frame 
    
    /* Metodo: modificarVuelo
     * metodo que obtiene los datos de los campos de texto y 
     * guarda los valores en el objeto con el id seleccionado
     * parametro idv: Identificador de Vuelo 
     **/
	private void modificarVuelo(int idv){
  		
  		Idvuelo = Integer.parseInt(Tidvuelo.getText());
		try{
			CiudadOrigen        = TciudadO.getText();
			CiudadDestino       = TciudadD.getText();
			FechaSalida         = TfechaS.getText();
			FechaArribo         = TfechaA.getText();
			DistanciaVuelo      = Float.parseFloat(TdistanciaV.getText());
			CapacidadCarga      = Float.parseFloat(TcapacidadC.getText());
			CapacidadPasajeros  = Integer.parseInt(TcapacidadP.getText());
			AsientosDisponibles = Integer.parseInt(TasientosD.getText());
			
			/*Se colocan los valores en el objeto*/
			V[idv].modificarIdvuelo(Idvuelo);
			V[idv].modificarCiudadOrigen(CiudadOrigen);
			V[idv].modificarCiudadDestino(CiudadDestino);
			V[idv].modificarFechaArribo(FechaArribo);
			V[idv].modificarFechaSalida(FechaSalida);
			V[idv].modificarDistanciaVuelo(DistanciaVuelo);
			V[idv].modificarCapacidadCarga(CapacidadCarga);
			V[idv].modificarCapacidadPasajeros(CapacidadPasajeros);
			V[idv].modificarAsientosDisponibles(AsientosDisponibles);
			JOptionPane.showMessageDialog(null,"Cambios realizados con exito.","Datos de vuelo Modificados",JOptionPane.DEFAULT_OPTION);
			modificarFrameModif();
  			}catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Verifique los datos de entrada","Error en los datos de entrada",JOptionPane.ERROR_MESSAGE);
		} 
    }//modificar vuelo

	/* --Familia de Metodos ordenar--
	* Estos metodos crean e insertan los elmentos en 
	* el arbol binario de ordenamiento que le 
	* corresponde a cada tipo de ordenamiento.
	**/
	private void ordenarPorFechaSalida(){
		String fecha="";
		Calendar auxF= Calendar.getInstance();
		int dia,mes,year;
		fecha=V[0].regresarFechaSalida();
		dia=Integer.parseInt(fecha.substring(0,2) );
		mes=Integer.parseInt(fecha.substring(3,5));
	    year=Integer.parseInt(fecha.substring(6,fecha.length()));
	    auxF.set(year,mes,dia);
		ordFS=new BST(auxF,new Integer( V[0].regresarIdvuelo() ) );
		for (int i = 1; i<contVuelos; i++){
			fecha=V[i].regresarFechaSalida();
			dia=Integer.parseInt( fecha.substring(0,2) );
			mes=Integer.parseInt(fecha.substring(3,5));
		    year=Integer.parseInt(fecha.substring(6,fecha.length()));
		    auxF.set(year,mes,dia);
			ordFS.insert(ordFS.root,auxF,new Integer( V[i].regresarIdvuelo() ) );
		}
		ordFS.inOrderDate(ordFS.root);
	}

	private void ordenarPorCapacidadPasajeros(){
		ordCP=new BST(new Integer( V[0].regresarCapacidadPasajeros() ),new Integer( V[0].regresarIdvuelo() ) );
		for (int i = 1; i<contVuelos; i++){
			ordCP.insert(ordCP.root,new Integer( V[i].regresarCapacidadPasajeros() ),new Integer( V[i].regresarIdvuelo() ) );
		}
		ordCP.inOrder(ordCP.root);
	}

	private void ordenarPorCiudadOrigen(){
		ordCO=new BST(new String( V[0].regresarCiudadOrigen() ),new Integer( V[0].regresarIdvuelo() ) );
		for (int i = 1; i<contVuelos; i++){
			ordCO.insert(ordCO.root,new String( V[i].regresarCiudadOrigen() ),new Integer( V[i].regresarIdvuelo() ) );
		}
		ordCO.inOrderString(ordCO.root);
	}

	private void ordenarPorDistanciaVuelo(){
		ordD=new BST(new Float( V[0].regresarDistanciaVuelo() ),new Integer( V[0].regresarIdvuelo() ) );
		for (int i = 1; i<contVuelos; i++){
			ordD.insert(ordD.root,new Float( V[i].regresarDistanciaVuelo() ),new Integer( V[i].regresarIdvuelo() ) );
		}
		ordD.inOrderFloat(ordD.root);
	}
	
	/* --Familia de metodos mostrarArbol--
	* Estos metodos obtienen los indices de los vuelos
	* ordenados por cierta categoria previamente elegida
	* y los muestra en un area de texto. 
	**/
	private void mostrarArbolFechaSalida(){
		ArrayList<Integer> index = new ArrayList<Integer>();
		int aux=0;
		if(contVuelos<=0){
			JOptionPane.showMessageDialog(null,"No hay vuelos registrados, introdusca un vuelo.","Error ", JOptionPane.ERROR_MESSAGE);
		}
		else{
			ordenarPorFechaSalida();
			index=ordFS.indiceDate;
			TMArbol.setText("");
			for (int i = 0; i < index.size(); i++){
				aux=index.get(i);//obtenemos el ID del vuelo
				for (int j = 0; j<contVuelos; j++){
					if(aux == V[j].regresarIdvuelo())
					{
						TMArbol.setText( TMArbol.getText() +
						"ID vuelo: " + V[j].regresarIdvuelo() +
						"\nCiudad Origen: " + V[j].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[j].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[j].regresarFechaArribo()+
						"\nFecha de Salida: " + V[j].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[j].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[j].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[j].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[j].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}//For
			
		}
	}//Mostrar
 
	private void mostrarArbolCapacidadPasajeros(){
		ArrayList<Integer> index = new ArrayList<Integer>();
		int aux=0;
		if(contVuelos<=0){
			JOptionPane.showMessageDialog(null,"No hay vuelos registrados, introdusca un vuelo.","Error ", JOptionPane.ERROR_MESSAGE);
		}
		else{
			ordenarPorCapacidadPasajeros();
			index=ordCP.indiceInt;
			TMArbol.setText("");
			for (int i = 0; i < index.size(); i++){
				aux=index.get(i);//obtenemos el ID del vuelo
				for (int j = 0; j<contVuelos; j++){
					if(aux == V[j].regresarIdvuelo())
					{
						TMArbol.setText( TMArbol.getText() +
						"ID vuelo: " + V[j].regresarIdvuelo() +
						"\nCiudad Origen: " + V[j].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[j].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[j].regresarFechaArribo()+
						"\nFecha de Salida: " + V[j].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[j].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[j].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[j].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[j].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}//For
			
		}
	}//Mostrar

	private void mostrarArbolCiudadOrigen(){
		ArrayList<Integer> index = new ArrayList<Integer>();
		int aux=0;
		if(contVuelos<=0){
			JOptionPane.showMessageDialog(null,"No hay vuelos registrados, introdusca un vuelo.","Error ", JOptionPane.ERROR_MESSAGE);
		}
		else{
			ordenarPorCiudadOrigen();
			index=ordCO.indiceStr;
			TMArbol.setText("");
			for (int i = 0; i < index.size(); i++){
				aux=index.get(i);//obtenemos el ID del vuelo
				for (int j = 0; j<contVuelos; j++){
					if(aux == V[j].regresarIdvuelo())
					{
						TMArbol.setText( TMArbol.getText() +
						"ID vuelo: " + V[j].regresarIdvuelo() +
						"\nCiudad Origen: " + V[j].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[j].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[j].regresarFechaArribo()+
						"\nFecha de Salida: " + V[j].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[j].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[j].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[j].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[j].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}//For
			
		}
	}//Mostrar

	private void mostrarArbolDistanciaVuelo(){
		ArrayList<Integer> index = new ArrayList<Integer>();
		int aux=0;
		if(contVuelos<=0){
			JOptionPane.showMessageDialog(null,"No hay vuelos registrados, introdusca un vuelo.","Error ", JOptionPane.ERROR_MESSAGE);
		}
		else{
			ordenarPorDistanciaVuelo();
			index=ordD.indiceFloat;
			TMArbol.setText("");
			for (int i = 0; i < index.size(); i++){
				aux=index.get(i);//obtenemos el ID del vuelo
				for (int j = 0; j<contVuelos; j++){
					if(aux == V[j].regresarIdvuelo())
					{
						TMArbol.setText( TMArbol.getText() +
						"ID vuelo: " + V[j].regresarIdvuelo() +
						"\nCiudad Origen: " + V[j].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[j].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[j].regresarFechaArribo()+
						"\nFecha de Salida: " + V[j].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[j].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[j].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[j].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[j].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}//For
			
		}
	}//Mostrar
	
	/* -- Familia de metodos busqueda --
	 * Buscan dentro del arbol el camino hasta encontrar el
	 * elemento deseado e imprime los datos en un TextField.
	 **/
	
	private void busquedaCapacidadPasajeros(int capPas){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int aux=0;//ID actual en el vector ids
		ordenarPorCapacidadPasajeros();
		ordCP.buscarInt(ordCP.root,capPas);
		if(ordCP.encontrado == true)
		{
			ids = ordCP.camino;
			for (int j = 0; j<ids.size(); j++){
				aux=ids.get(j);
				for (int i = 0; i<contVuelos; i++)
				{
					if( V[i].regresarIdvuelo() == aux )
					{
						MostrarNodo.setText(MostrarNodo.getText()+"ID vuelo: " + V[i].regresarIdvuelo() +
						"\nCiudad Origen: " + V[i].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[i].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[i].regresarFechaArribo()+
						"\nFecha de Salida: " + V[i].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[i].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[i].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[i].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[i].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No se encontro un vuelo con esa capacidad de pasajeros","Vuelo not Found",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void busquedaDistanciaVuelo(float distVuelo){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int aux=0;//ID actual en el vector ids
		MostrarNodo.setText("");
		ordenarPorDistanciaVuelo();
		ordD.buscarFloat(ordD.root,distVuelo);
		if(ordD.encontrado == true)
		{
			ids = ordD.camino;
			for (int j = 0; j<ids.size(); j++){
				aux=ids.get(j);
				for (int i = 0; i<contVuelos; i++)
				{
					if( V[i].regresarIdvuelo() == aux )
					{
						MostrarNodo.setText(MostrarNodo.getText()+"ID vuelo: " + V[i].regresarIdvuelo() +
						"\nCiudad Origen: " + V[i].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[i].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[i].regresarFechaArribo()+
						"\nFecha de Salida: " + V[i].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[i].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[i].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[i].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[i].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No se encontro un vuelo con esa capacidad de pasajeros","Vuelo not Found",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void busquedaCiudadOrigen(String cidOri){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int aux=0;//ID actual en el vector ids
		MostrarNodo.setText("Camino recorrido en el arbol: \n\n");
		ordenarPorCiudadOrigen();
		ordCO.buscarString(ordCO.root,cidOri);
		if(ordCO.encontrado == true)
		{
			ids = ordCO.camino;
			for (int j = 0; j<ids.size(); j++){
				aux=ids.get(j);
				for (int i = 0; i<contVuelos; i++)
				{
					if( V[i].regresarIdvuelo() == aux )
					{
						MostrarNodo.setText(MostrarNodo.getText()+"ID vuelo: " + V[i].regresarIdvuelo() +
						"\nCiudad Origen: " + V[i].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[i].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[i].regresarFechaArribo()+
						"\nFecha de Salida: " + V[i].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[i].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[i].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[i].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[i].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No se encontro un vuelo con esa capacidad de pasajeros","Vuelo not Found",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void busquedaFechaSalida(Calendar fechaSal){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int aux=0;//ID actual en el vector ids
		MostrarNodo.setText("Camino recorrido en el arbol: \n\n");
		ordenarPorFechaSalida();
		ordFS.buscarDate(ordFS.root,fechaSal);
		if(ordFS.encontrado == true)
		{
			ids = ordFS.camino;
			System.out.println (ids.size());
			for (int j = 0; j<ids.size(); j++){
				aux=ids.get(j);
				for (int i = 0; i<contVuelos; i++)
				{
					if( V[i].regresarIdvuelo() == aux )
					{
						MostrarNodo.setText(MostrarNodo.getText()+"ID vuelo: " + V[i].regresarIdvuelo() +
						"\nCiudad Origen: " + V[i].regresarCiudadOrigen()+
						"\nCiudad Destino:" + V[i].regresarCiudadDestino()+
						"\nFecha de Arribo: " + V[i].regresarFechaArribo()+
						"\nFecha de Salida: " + V[i].regresarFechaSalida()+
						"\nDistancia del vuelo: " + V[i].regresarDistanciaVuelo()+
						"\nCapacidad de Carga: " + V[i].regresarCapacidadCarga()+
						"\nCapacidad de Pasajeros: " + V[i].regresarCapacidadPasajeros()+
						"\nAsientos Disponibles: " + V[i].regresarAsientosDisponibles() + "\n\n" );
						break;
					}
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No se encontro un vuelo con esa capacidad de pasajeros","Vuelo not Found",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
//metodo para abrir y cerrar ventanas
public void windowClosing(WindowEvent e){
	
   if(e.getSource()== Menuprincipal){
   	System.exit(0);
   }
   if(e.getSource()== Mostrar){
   	Mostrar.dispose();
   	Mirar.setText("");
   	Menuprincipal.setVisible(true);
   }
   if(e.getSource()== Capturar){
   	Tidvuelo.setText("");
	TciudadO.setText("");
	TciudadD.setText("");
	TfechaA.setText("");
	TfechaS.setText("");
	TdistanciaV.setText("");
	TcapacidadC.setText("");
	TcapacidadP.setText("");
	TasientosD.setText("");
   	Capturar.dispose();
   	Menuprincipal.setVisible(true);
   }
   if(e.getSource()== Modificar){
   	Modificar.dispose();	
   	Menuprincipal.setVisible(true);
   }
   //practica #2 cerrar ventanas
   if(e.getSource() == MostrarArbol){
   	MostrarArbol.dispose();
   	Menuprincipal.setVisible(true);
   }
   if(e.getSource() == OrdenandoVuelos){
   	OrdenandoVuelos.dispose();
   	Menuprincipal.setVisible(true);
   }
   if(e.getSource() == MostrarArbol){
   	MostrarArbol.setVisible(false);
   	OrdenandoVuelos.setVisible(true);
   	Menuprincipal.setVisible(false);
   }
   //practica #3 cerrar ventanas
   if(e.getSource() == BuscarV){
   	BuscarV.dispose();
   	Menuprincipal.setVisible(true);
   }
   if(e.getSource() == BusFechaS){
   	BusFechaS.dispose();
   	BuscarV.setVisible(true);
   }
   if(e.getSource() == BusCapPas){
   	BusCapPas.dispose();
   	BuscarV.setVisible(true);
   }
   if(e.getSource() == BusCiudOrig){
   	BusCiudOrig.dispose();
   	BuscarV.setVisible(true);
   }
   if(e.getSource() == BusDistVue){
   	BusDistVue.dispose();
   	BuscarV.setVisible(true);
   }
   if(e.getSource() == MostVueArbol){
   	MostVueArbol.dispose();
   	MostrarNodo.setText("");
   	BuscarV.setVisible(true);
   }
   
}//fin cerrar ventanas 

//accion en boton
public void actionPerformed(ActionEvent e){
	if(e.getSource()== Bcapturar){ 
		Capturar.setVisible(true);
		Menuprincipal.setVisible(false);
  	}
  	if(e.getSource()== Bmodifica){
  		Encontrar.setLabel("Aceptar");
		Modificar.setVisible(true);	
		Menuprincipal.setVisible(false);
  	}
  	if(e.getSource()== Bmuestra){
  		mostrarVuelos();
		Mostrar.setVisible(true);
		Menuprincipal.setVisible(false);
  	}
  	if(e.getSource() == BordenarVuelos){
  		OrdenandoVuelos.setVisible(true);
  		Menuprincipal.setVisible(false);
  	}
  	if(e.getSource()== Retorno){ 
  		modificarFrameModif();
		Modificar.setVisible(false);
		Menuprincipal.setVisible(true);
  	}
  	if(e.getSource()== Bregresar){
  		Tidvuelo.setText("");
		TciudadO.setText("");
		TciudadD.setText("");
		TfechaA.setText("");
		TfechaS.setText("");
		TdistanciaV.setText("");
		TcapacidadC.setText("");
		TcapacidadP.setText("");
		TasientosD.setText("");
		Capturar.setVisible(false); 	
		Menuprincipal.setVisible(true);	
  	}
  	if(e.getSource()== Bagregar){ 	
		capturarVuelo();
  	}
  	if(e.getSource()== Encontrar){
		auxID = encontrarVuelo(Integer.parseInt(IDmodificar.getText()));
  	}
  	if(e.getSource() == Encontrar2){
  		modificarVuelo(auxID);
  	}
  	if(e.getSource() == BorFechaSa){
  		MostrarArbol.setVisible(true);
  		OrdenandoVuelos.setVisible(false);
  		mostrarArbolFechaSalida();
  	}
  	if(e.getSource() == BcapPasajeros){
  		MostrarArbol.setVisible(true);
  		OrdenandoVuelos.setVisible(false);
  		mostrarArbolCapacidadPasajeros();
  	}
  	if(e.getSource() == BorCiudadOrigen){
  		MostrarArbol.setVisible(true);
  		OrdenandoVuelos.setVisible(false);
  		mostrarArbolCiudadOrigen();
  	}
  	if(e.getSource() == BorDistanciaVuelo){
  		MostrarArbol.setVisible(true);
  		OrdenandoVuelos.setVisible(false);
  		mostrarArbolDistanciaVuelo();
  	}
  	//evento en boton practica #3
  	if(e.getSource() == BotFechaS){
  		if(contVuelos<=0)
  			JOptionPane.showMessageDialog(null,"No se han agregado vuelos.","No hay vuelos",JOptionPane.ERROR_MESSAGE);
  		else
  		{
	  		Calendar auxFS = Calendar.getInstance();
	  		int dia=0,mes=0,year=0;
	  		try{
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    			formatoFecha.setLenient(false);
    			formatoFecha.parse(IDfecha.getText());
	  			
			}catch(Exception ex){
				IDfecha.setText("");
				JOptionPane.showMessageDialog(Capturar,"Formato de fecha no valido. El formato es : dd/mm/yyyy","Error de formato",JOptionPane.ERROR_MESSAGE );
			}
			try{
				dia=Integer.parseInt( IDfecha.getText().substring(0,2) );
	  			mes=Integer.parseInt( IDfecha.getText().substring(3,5) );
	  			year=Integer.parseInt( IDfecha.getText().substring(6,IDfecha.getText().length()) );
	  			auxFS.set(year,mes,dia);
	  			busquedaFechaSalida(auxFS);
	  			if(ordFS.encontrado == true){
	  				MostVueArbol.setVisible(true);
	  				BusFechaS.setVisible(false);
	  			}
			}catch(Exception o){
				o.printStackTrace();
				System.out.println (dia+"  "+mes+"  "+year);
				JOptionPane.showMessageDialog(Capturar,o.toString(),"Error de formato",JOptionPane.ERROR_MESSAGE );
			}
  		}
  	}
  	if(e.getSource() == BotDistVue){
  		if(contVuelos<=0)
  			JOptionPane.showMessageDialog(null,"No se han agregado vuelos.","No hay vuelos",JOptionPane.ERROR_MESSAGE);	
  		else
  		{
  			busquedaDistanciaVuelo( Float.parseFloat( IDdist.getText() ) );
  			if(ordD.encontrado == true){
  				MostVueArbol.setVisible(true);
  				BusDistVue.setVisible(false);
  			}
  		}
  	}
  	if(e.getSource() == BotCiudOrig){
  		if(contVuelos<=0)
  			JOptionPane.showMessageDialog(null,"No se han agregado vuelos.","No hay vuelos",JOptionPane.ERROR_MESSAGE);
  		else
  		{
  			busquedaCiudadOrigen( IDCiud.getText() );
  			if(ordCO.encontrado == true){
  				MostVueArbol.setVisible(true);
  				BusCiudOrig.setVisible(false);
  			}
  		}
  	}
  	if(e.getSource() == BotCapPas){
        if(contVuelos<=0)
  			JOptionPane.showMessageDialog(null,"No se han agregado vuelos.","No hay vuelos",JOptionPane.ERROR_MESSAGE);
  		else
  		{
  			busquedaCapacidadPasajeros( Integer.parseInt(IDcappas.getText()) );
  			if(ordCP.encontrado == true){
  				MostVueArbol.setVisible(true);
  				BusCapPas.setVisible(false);
  			}
        }
  	}
  	if(e.getSource() == RetorFechaS){
  		BusFechaS.setVisible(false);
  		BuscarV.setVisible(true);
  	}
  	if(e.getSource() == RetorCiudOrig){
  		BusCiudOrig.setVisible(false);
  		BuscarV.setVisible(true);
  	}
  	if(e.getSource() == RetorCapPas){
  		BusCapPas.setVisible(false);
  		BuscarV.setVisible(true);
  	}
  	if(e.getSource() == RetorDistVue){
  		BusDistVue.setVisible(false);
  		BuscarV.setVisible(true);
  	}
  	if(e.getSource() == MOrFechaSa){
  		BusFechaS.setVisible(true);
  		BuscarV.setVisible(false);
  	}
  	if(e.getSource() == MOrDistanciaVuelo){
  		BusDistVue.setVisible(true);
  		BuscarV.setVisible(false);
  	}
  	if(e.getSource() == MOrCiudadOrigen){
  		BusCiudOrig.setVisible(true);
  		BuscarV.setVisible(false);
  	}
  	if(e.getSource() == MCapPasajeros){
  		BusCapPas.setVisible(true);
  		BuscarV.setVisible(false);
  	}
  	if(e.getSource() == BuscArbol){
  		BuscarV.setVisible(true);
  		Menuprincipal.setVisible(false);
  	}
    
}//fin accion en boton
    
/**************************  PRINCIPAL MAIN *****************************************/
    public static void main(String[] args) {
        Proyecto Z = new Proyecto();
        Z.initVuelos();
        Z.mostrarFrame();
    }//main
}//class proyecto
