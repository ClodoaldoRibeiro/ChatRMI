package br.com.chat.client;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import br.com.chat.server.InterfaceServer;
import br.com.chat.server.InterfaceClient;
import br.com.chat.server.User;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;

public class Client
        extends UnicastRemoteObject implements InterfaceClient, Serializable {

    int idClient;
    Client cliente;

    public int startClient() throws IOException, NotBoundException {

        cliente = new Client();
        Naming.rebind("cliente", cliente);
        Remote remoteReference = Naming.lookup("Servidor");
        InterfaceServer remoteServer = (InterfaceServer) remoteReference;
        User user = new User("Teste", "192.168.254.107");
        idClient = remoteServer.estabeleceConexao(user);

        System.out.println("*** Cliente com a identificação é "
                + idClient + " ***");

        return idClient;
    }

    public Client() throws RemoteException {
        super();
    }

    @Override
    public void atribuiMensagem(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }

    public String[] usuariosConectados() throws RemoteException, MalformedURLException, NotBoundException {
//        cliente = new Client();
//        Naming.rebind("cliente", cliente);
//        Remote remoteReference = Naming.lookup("Servidor");
//        InterfaceServer remoteServer = (InterfaceServer) remoteReference;
//        return remoteServer.getUser();
        return null;
    }

    public static void main(String[] args) {
//        String message;
//        int idClient = 0;
//        try {
//
//            Client cliente = new Client();
//            Naming.rebind("cliente", cliente);
//
//            Remote remoteReference = Naming.lookup("Servidor");
//
//            InterfaceServer remoteServer = (InterfaceServer) remoteReference;
//
//            User user = new User("Clodoaldo", "192.168.254.107");
//            try {
//                idClient = remoteServer.estabeleceConexao(user);
//                System.out.println("*** Cliente com a identificação é "
//                        + idClient + " ***");
//
//            } catch (Exception e) {
//            }
//
//            BufferedReader teclado = new BufferedReader(
//                    new InputStreamReader(System.in));
//            System.out.print("Entre com o nome: ");
//            String nome = teclado.readLine();
//            System.out.print("Digite a mensagem: ");
//            message = teclado.readLine();
//
//            while (message.compareTo("end") != 0) {
//                System.out.print("Digite a mensagem: ");
//                remoteServer.sendToAll(message, idClient, nome);
//                message = teclado.readLine();
//            }
//            System.out.println("*** Saiu.. ***");
//
//            System.out.println(remoteServer.liberaConexao(idClient));
//            System.exit(0);
//        } catch (Exception e) {
//            System.err.println("Erro ao tentar obter o servidor:  \n"
//                    + e.toString());
//        }
    }
}
