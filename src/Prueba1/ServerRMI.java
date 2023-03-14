package Prueba1;

import com.mysql.jdbc.Connection;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServerRMI extends UnicastRemoteObject implements Datos {

    Connection conexion; //generar la conexion
    private Statement sentencia; //escribir sentencia
    private ResultSet resultado; //mostrar resultado

    private String name, emm, cell, pass;

    emailSocket emailNotify = new emailSocket();

    private ServerRMI() throws Exception {
        super();
    }

    //método inicial de conexión con sql
    public void connectSql() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //especificar driver
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rmi", "root", "");//generar conexion
            if (conexion != null) {
                sentencia = conexion.createStatement(); //generar un enunciado sql
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión NO Establecida" + e);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Conexión No Establecida" + ex);
        }
    }

    @Override
    public boolean newUser(String nombre, String email, String telefono, String contra) throws RemoteException {
        //ArrayList<rmi1> datos = new ArrayList<>();
        boolean exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rmi", "root", "");
            //String snt = "insert into cliente (nombre, email, telefono, contra) values ('" + nombre + "','" + email + "','" + telefono + "','" + contra + "')";
            String snt = "insert into cliente (nombre, email, telefono, contra) values (?,?,?,?)";
            System.out.println(snt);
            PreparedStatement res = conn.prepareStatement(snt);
            //res.executeQuery();
            res.setString(1, nombre);
            res.setString(2, email);
            res.setString(3, telefono);
            res.setString(4, contra);
            res.executeUpdate();
            exito = true;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return exito;
    }

    @Override
    public ArrayList<rmi1> Consult(String nombre) throws RemoteException {

        ArrayList<rmi1> datos = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rmi", "root", "");
            String snt = ("Select * from cliente where nombre = '" + nombre + "'");
            Statement stm = (Statement) conn.createStatement();
            ResultSet res = stm.executeQuery(snt);

            if (res.next()) {
                name = res.getString(1);
                emm = res.getString(2);
                cell = res.getString(3);
                pass = res.getString(4);
                rmi1 client = new rmi1(name, emm, cell, pass);
                datos.add(client);
            }
            emailNotify.emailCorreo(name, emm);
            //conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return datos;
    }

    @Override
    public ArrayList<rmi1> Email(String nombre, String contra) throws RemoteException {
        //String name, emm, cell, pass;
        ArrayList<rmi1> datos = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rmi", "root", "");
            String snt = ("Select * from cliente where nombre = '" + nombre + "' AND contra = '" + contra + "'");
            System.out.println(snt);
            Statement stm = (Statement) conn.createStatement();
            ResultSet res = stm.executeQuery(snt);
            while (res.next()) {
                name = res.getString(1);
                emm = res.getString(2);
                cell = res.getString(3);
                pass = res.getString(4);
                rmi1 client = new rmi1(name, emm, cell, pass);
                datos.add(client);
            }
            //conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return datos;
    }

    @Override
    public String Cell(String nombre, String contra) throws RemoteException {
        return null;
    }

    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.createRegistry(1099);
            r.rebind("Datos", (Remote) new ServerRMI());
            System.out.println("Servidor en línea");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
