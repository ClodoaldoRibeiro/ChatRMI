package br.com.chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import br.com.chat.server.InterfaceServer;
import br.com.chat.server.InterfaceClient;
import br.com.chat.server.Server;
import br.com.chat.server.User;
import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

public class Client
        extends UnicastRemoteObject implements InterfaceClient, Serializable {

    public Client() throws RemoteException {
        super();
    }

    @Override
    public void atribuiMensagem(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }

    public static void main(String[] args) {
        int idClient;
        String message;

        try {
            // Dispinibilizar o cliente!
//            System.setSecurityManager(new SecurityManager());
            Client cliente = new Client();
            Naming.rebind("cliente", cliente);

            //Busca a referencia do serviço do servidor
            Remote remoteReference = Naming.lookup("Servidor");

//            InterfaceServer remoteServer = (InterfaceServer) remoteReference;
//            remoteServer = (InterfaceServer) remoteReference;
            InterfaceServer remoteServer = new Server();
            remoteServer = (Server) remoteReference;

            User user = new User("Clodoaldo", "192.168.254.107");
            idClient = remoteServer.estabeleceConexao(user);
            System.out.println("*** Cliente com a identificação é "
                    + idClient + " ***");

            BufferedReader teclado = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.print("Entre com o nome: ");
            String nome = teclado.readLine();
            System.out.print("Digite a mensagem: ");
            message = teclado.readLine();

            while (message.compareTo("end") != 0) {
                System.out.print("Digite a mensagem: ");
                remoteServer.sendToAll(message, idClient, nome);
                message = teclado.readLine();
            }
            System.out.println("*** Saiu.. ***");

            System.out.println(remoteServer.liberaConexao(idClient));
            System.exit(0);

        } catch (Exception e) {
            System.err.println("Erro ao tentar obter o servidor:  \n"
                    + e.toString());
        }
    }
}
