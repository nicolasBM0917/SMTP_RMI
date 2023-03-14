package Prueba1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Datos extends Remote {

    public boolean newUser(String nombre, String email, String telefono, String contra) throws RemoteException;

    public ArrayList<rmi1> Consult(String nombre) throws RemoteException;

    public ArrayList<rmi1> Email(String nombre, String contra) throws RemoteException;

    public String Cell(String nombre, String contra) throws RemoteException;
}
