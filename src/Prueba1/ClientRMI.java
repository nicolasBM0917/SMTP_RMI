package Prueba1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientRMI {

    public ClientRMI() throws MalformedURLException, RemoteException, NotBoundException {
        //Registry r = LocateRegistry.createRegistry("localhost", 1099);
        Datos o = (Datos) Naming.lookup("//localhost/Datos");
        Scanner keyboard = new Scanner(System.in);
        

    }

    public static void main(String[] args) {
        try {
            new ClientRMI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
