import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMySQL {

    public String db = "bdcomponenete";
    public String url = "jdbc:mysql://localhost/" + db + "?useServerPrepStmts=true";
    public String user = "root";
    public String pass = "Gearsxboxpvv985";
    Connection link;
   public Connection Conectar(){
      try{
           //Class.forName("org.gjt.mm.mysql.Driver");
           Class.forName("com.mysql.cj.jdbc.Driver");
           link = DriverManager.getConnection(this.url, this.user, this.pass);
           link.getMetaData();
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
       return link;
   }
   public ResultSet consultarClientes(){
	   ResultSet rsClientes = null;
	   try{
		   PreparedStatement stConsultar = link.prepareStatement("Select NombreCompleto, direccion, Celular from clientes");
		  rsClientes = stConsultar.executeQuery();
		  //stConsultar.close();
	   }catch (Exception e){
		   System.out.println("Error" + e);
	   }
	return rsClientes;
}
   public int InsertarCliente(String nom, String dir, String cel){
	   int numRegs = 0;
		  try {
			  PreparedStatement stInsertar = link.prepareStatement("insert into clientes(NombreCompleto, Direccion, Celular)" 
					 + "values(?,?,?)");
			  stInsertar.setString(1, nom);
			  stInsertar.setString(2, dir);
			  stInsertar.setString(3, cel);
			  numRegs = stInsertar.executeUpdate();
			  stInsertar.close();
		  }catch(Exception e){
			  System.out.println("Error: " + e);
		  }
		  return numRegs;
   }
}