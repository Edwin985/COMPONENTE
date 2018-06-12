import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mxrck.autocompleter.TextAutoCompleter;
//Autor: Edwin  Alejandro Cetina Contreras

//SET GLOBAL time_zone = '-5:00';

public class Principal extends JFrame implements ActionListener {
	ConexionMySQL Interfazmysql;
    java.sql.Connection conexion;
	private MiText nombre;
	private MiText direccion;
	private MiText celular;
	private JButton btnInsertar;
	private JButton btnConectar;
	private JButton btnConsultar;
    private DefaultTableModel modelo;
    private TextAutoCompleter ac;
	
public Principal (String titulo){
	Container contenedorPrincipal = this.getContentPane();
	this.setTitle(titulo);
    this.setResizable(true);
    this.setLayout(new GridBagLayout());
	getContentPane().setBackground(new Color(204,255,204));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  //restricciones
    GridBagConstraints restricciones = new GridBagConstraints();
    
  //campo nombre
    nombre = new MiText();
    restricciones.gridx = 1;//columna
	restricciones.gridy = 0;//fila
	restricciones.gridwidth = 1;
	restricciones.gridheight = 1;
	restricciones.weightx = 0.5;
	restricciones.weighty = 0.5;
	restricciones.fill=GridBagConstraints.CENTER;
	restricciones.anchor = GridBagConstraints.CENTER;
	contenedorPrincipal.add(nombre, restricciones);
	JLabel lblNombre = new JLabel("Nombre Completo: ");
	restricciones.gridx = 0;//columna
	restricciones.gridy = 0;//fila
	restricciones.gridwidth = 1;
	restricciones.gridheight = 1;
	restricciones.weightx = 0.5;
	restricciones.weighty = 0.5;
	restricciones.fill=GridBagConstraints.CENTER;
	restricciones.anchor = GridBagConstraints.CENTER;
	contenedorPrincipal.add(lblNombre, restricciones);
	
	//campo direccion
    direccion = new MiText();
    restricciones.gridx = 1;//columna
	restricciones.gridy = 1;//fila
	restricciones.gridwidth = 1;
	restricciones.gridheight = 1;
	restricciones.weightx = 0.5;
	restricciones.weighty = 0.5;
	restricciones.fill=GridBagConstraints.CENTER;
	restricciones.anchor = GridBagConstraints.CENTER;
	contenedorPrincipal.add(direccion, restricciones);
	JLabel lblDireccion = new JLabel("Dirección: ");
	restricciones.gridx = 0;//columna
	restricciones.gridy = 1;//fila
	restricciones.gridwidth = 1;
	restricciones.gridheight = 1;
	restricciones.weightx = 0.5;
	restricciones.weighty = 0.5;
	restricciones.fill=GridBagConstraints.CENTER;
	restricciones.anchor = GridBagConstraints.CENTER;
	contenedorPrincipal.add(lblDireccion, restricciones);
	
	//campo celular
    celular = new MiText();
    restricciones.gridx = 1;//columna
	restricciones.gridy = 2;//fila
	restricciones.gridwidth = 1;
	restricciones.gridheight = 1;
	restricciones.weightx = 0.5;
	restricciones.weighty = 0.5;
	restricciones.fill=GridBagConstraints.CENTER;
	restricciones.anchor = GridBagConstraints.CENTER;
	contenedorPrincipal.add(celular, restricciones);
	JLabel lblCelular = new JLabel("Celular: ");
	restricciones.gridx = 0;//columna
	restricciones.gridy = 2;//fila
	restricciones.gridwidth = 1;
	restricciones.gridheight = 1;
	restricciones.weightx = 0.5;
	restricciones.weighty = 0.5;
	restricciones.fill=GridBagConstraints.CENTER;
	restricciones.anchor = GridBagConstraints.CENTER;
	contenedorPrincipal.add(lblCelular, restricciones);
	
	//Campo Insertar
	 btnInsertar = new JButton("Insertar");
	 restricciones.gridx = 0;//columna
	 restricciones.gridy = 4;//fila
	 restricciones.gridwidth = 1;
	 restricciones.gridheight = 1;
	 restricciones.weightx = 0.5;
	 restricciones.weighty = 0.5;
	 restricciones.fill=GridBagConstraints.CENTER;
	 restricciones.anchor = GridBagConstraints.CENTER;
	 contenedorPrincipal.add(btnInsertar, restricciones);
	 btnInsertar.setActionCommand("actInsertar");
	 btnInsertar.addActionListener(this);
	 
	//Campo Conectar
		 btnConectar = new JButton("Conectar");
		 restricciones.gridx = 0;//columna
		 restricciones.gridy = 5;//fila
		 restricciones.gridwidth = 1;
		 restricciones.gridheight = 1;
		 restricciones.weightx = 0.5;
		 restricciones.weighty = 0.5;
		 restricciones.fill=GridBagConstraints.CENTER;
		 restricciones.anchor = GridBagConstraints.CENTER;
		 contenedorPrincipal.add(btnConectar, restricciones);
		 btnConectar.setActionCommand("actConectar");
		 btnConectar.addActionListener(this);
		 
		//Campo consultar
		 btnConsultar = new JButton("Consultar Datos");
		 restricciones.gridx = 0;//columna
		 restricciones.gridy = 6;//fila
		 restricciones.gridwidth = 1;
		 restricciones.gridheight = 1;
		 restricciones.weightx = 0.5;
		 restricciones.weighty = 0.5;
		 restricciones.fill=GridBagConstraints.CENTER;
		 restricciones.anchor = GridBagConstraints.CENTER;
		 contenedorPrincipal.add(btnConsultar, restricciones);
		 btnConsultar.setActionCommand("actConsultar");
		 btnConsultar.addActionListener(this);
		 
		 //Table
		 modelo = new DefaultTableModel();
		 JTable tabla = new JTable(modelo);
		 modelo.addColumn("NombreCompleto");
	     modelo.addColumn("Direccion");
		 modelo.addColumn("Celular");
		 restricciones.gridx = 1;//columna
		 restricciones.gridy = 4;//fila
		 restricciones.gridwidth = 1;
		 restricciones.gridheight = 1;
		 restricciones.fill=GridBagConstraints.CENTER;
		 restricciones.anchor = GridBagConstraints.CENTER;
		 tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		 contenedorPrincipal.add(tabla, restricciones);
		 
 }

public static void main(String[] args) {
    Principal ventana = new Principal("COMPONENTE Y BASE DE DATOS");
    ventana.setLocation(400,150);
    ventana.pack();
    ventana.setSize(450,450);
    ventana.setVisible(true);
    JOptionPane.showMessageDialog(null, "Asegurate de conectar primero, depués ingresa datos y podrás consultar");
 }

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("actConectar")){
		// TODO Auto-generated method stub	
		Interfazmysql = new ConexionMySQL();
		conexion = Interfazmysql.Conectar();
        java.sql.Connection cn = Interfazmysql.Conectar();
        if(conexion !=null){
                JOptionPane.showMessageDialog(null, "Conectado");
                
                /*try{
                    conexion.close();
                }catch(SQLException ex){
                    System.out.println("Error al desconectar "+ex);
    }*/
   }
        
  } else if (e.getActionCommand().equals("actInsertar")){
	  int nRegs = Interfazmysql.InsertarCliente(nombre.getText(),direccion.getText(),celular.getText());
	   ac = new TextAutoCompleter(nombre);
	   ac.addItem(nombre.getText());
	   ac = new TextAutoCompleter(direccion);
	   ac.addItem(direccion.getText());
	   ac = new TextAutoCompleter(celular);
	   ac.addItem(celular.getText());
	  JOptionPane.showMessageDialog(null, "Haz ingreaso nuevos campos a la base de datos", "Cantidad de datos que estas ingresando", JOptionPane.WARNING_MESSAGE);
    } 
  else if (e.getActionCommand().equals("actConsultar")){
		ResultSet regsClientes = Interfazmysql.consultarClientes();
		// Creamos las columnas.
		try {
			int cont=0;
			while (regsClientes.next()){
				cont ++;
							// Se crea un array que será una de las filas de la tabla.
							   Object [] fila = new Object[3]; // Hay tres columnas en la tabla							   
							// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
							   for (int i=0;i<3;i++)
							      fila[i] = regsClientes.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
							   // Se añade al modelo la fila completa.
							   modelo.addRow(fila);
			}
			JOptionPane.showMessageDialog(null, "Filas en la tabla: " + cont, "Cantidad de Filas", JOptionPane.WARNING_MESSAGE);			
			regsClientes.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  }
    }
}