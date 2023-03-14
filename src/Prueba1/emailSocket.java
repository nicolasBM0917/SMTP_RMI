//Programa del funcionamiento de SMTP
package Prueba1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class emailSocket {

    //Correo

    public void emailCorreo(String nombre, String email) throws UnknownHostException, IOException {
        Socket smtpSocket = new Socket("localhost", 25);
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(smtpSocket.getOutputStream(), true);

        if (smtpSocket != null && out_socket != null && in_socket != null) {
            try {
                //paso 1: obtener un saludo del servidor
                String responseLine;
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_01: " + responseLine);
                    if (responseLine.indexOf("220") != -1) {
                        break;
                    }
                }

                //paso 2: se empieza el dialogo enviando un comando HELO
                out_socket.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                System.out.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_02: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 3: El cliente notifica al receptor la dirección de correo del mensaje en un
                out_socket.println("MAIL From: mytest@s6j.com");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_03: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 4: 
                out_socket.println("RCPT TO: user0@s6j.com");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_04: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 5: se envía el cuerpo del mensaje
                out_socket.println("DATA");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_05: " + responseLine);
                    if (responseLine.indexOf("354") != -1) {
                        break;
                    }
                }

                //paso 6: envío del correo electrónico
                out_socket.println("From: mytest@s6j.com");
                out_socket.println("To: user0@s6j.com");
                out_socket.println("Subject: Acceso");
                out_socket.println();
                out_socket.println("Nueva Consulta");
                out_socket.println("El usuario " + nombre + " ha accedido al servidor");
                out_socket.println("Datos: " + email);
                out_socket.println("Consulta de Datos Generales");
                out_socket.println();
                out_socket.println(".");

                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_06: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 7: terminar la comunicación
                out_socket.println("QUIT");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_07: " + responseLine);
                    if (responseLine.indexOf("221") != -1) {
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
//----------
    public void celTelefono(String nombre, String telefono) throws UnknownHostException, IOException {
        Socket smtpSocket = new Socket("localhost", 25);
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(smtpSocket.getOutputStream(), true);

        if (smtpSocket != null && out_socket != null && in_socket != null) {
            try {
                //paso 1: obtener un saludo del servidor
                String responseLine;
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_01: " + responseLine);
                    if (responseLine.indexOf("220") != -1) {
                        break;
                    }
                }

                //paso 2: se empieza el dialogo enviando un comando HELO
                out_socket.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                System.out.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_02: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 3: El cliente notifica al receptor la dirección de correo del mensaje en un
                out_socket.println("MAIL From: mytest@s6j.com");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_03: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 4: 
                out_socket.println("RCPT TO: user0@s6j.com");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_04: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 5: se envía el cuerpo del mensaje
                out_socket.println("DATA");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_05: " + responseLine);
                    if (responseLine.indexOf("354") != -1) {
                        break;
                    }
                }

                //paso 6: envío del correo electrónico
                out_socket.println("From: mytest@s6j.com");
                out_socket.println("To: user0@s6j.com");
                out_socket.println("Subject: Acceso");
                out_socket.println();
                out_socket.println("Nueva Consulta");
                out_socket.println("El usuario " + nombre + " ha accedido al servidor");
                out_socket.println("Datos: " + telefono);
                out_socket.println("Consulta de Datos Generales");
                out_socket.println();
                out_socket.println(".");

                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_06: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 7: terminar la comunicación
                out_socket.println("QUIT");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_07: " + responseLine);
                    if (responseLine.indexOf("221") != -1) {
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
//------
    public void userNew(String nombre, String email, String telefono, String contra) throws UnknownHostException, IOException {
        Socket smtpSocket = new Socket("localhost", 25);
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(smtpSocket.getOutputStream(), true);

        if (smtpSocket != null && out_socket != null && in_socket != null) {
            try {
                //paso 1: obtener un saludo del servidor
                String responseLine;
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_01: " + responseLine);
                    if (responseLine.indexOf("220") != -1) {
                        break;
                    }
                }

                //paso 2: se empieza el dialogo enviando un comando HELO
                out_socket.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                System.out.println("HELO " + InetAddress.getLocalHost().getHostAddress());
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_02: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 3: El cliente notifica al receptor la dirección de correo del mensaje en un
                out_socket.println("MAIL From: mytest@s6j.com");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_03: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 4: 
                out_socket.println("RCPT TO: user0@s6j.com");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_04: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 5: se envía el cuerpo del mensaje
                out_socket.println("DATA");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_05: " + responseLine);
                    if (responseLine.indexOf("354") != -1) {
                        break;
                    }
                }

                //paso 6: envío del correo electrónico
                out_socket.println("From: mytest@s6j.com");
                out_socket.println("To: user0@s6j.com");
                out_socket.println("Subject: Acceso");
                out_socket.println();
                out_socket.println("Nueva Consulta");
                out_socket.println("Nuevo usuario: ");
                out_socket.println("Datos: \n"  + nombre + "\n" +  email + "\n" +  telefono + "\n" +  contra);
                out_socket.println("Consulta de Datos Generales");
                out_socket.println();
                out_socket.println(".");

                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_06: " + responseLine);
                    if (responseLine.indexOf("250") != -1) {
                        break;
                    }
                }

                //paso 7: terminar la comunicación
                out_socket.println("QUIT");
                while ((responseLine = in_socket.readLine()) != null) {
                    System.out.println("Server_07: " + responseLine);
                    if (responseLine.indexOf("221") != -1) {
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            new emailSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
