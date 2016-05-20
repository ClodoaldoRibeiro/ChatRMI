package br.com.chat.server;

import br.com.chat.client.Client;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject
        implements InterfaceServer, Serializable {

    private final int MAXIMUMSIZECLIENT = 20;

    public SituationServer situationServer;
    private String logServer = "";
    private User[] user;

    private int idClient;
    private InterfaceClient[] connectedClient;

    public Server() throws RemoteException {
        super();
        idClient = 0;
        situationServer = SituationServer.STOP;
        connectedClient = new InterfaceClient[MAXIMUMSIZECLIENT];
        for (int i = 0; i < connectedClient.length; i++) {
            connectedClient[i] = new Client();
        }
    }

    public static void main(String[] args) throws RemoteException {
        Server server = new Server();
        server.startServer();
    }

    @Override
    public int estabeleceConexao(User user) throws RemoteException {
        idClient++;
        int resultado = 0;
        User UserLogar = new User();

        try {
            if (dataValidUser(user) && (idClient < MAXIMUMSIZECLIENT)) {
                connectedClient[idClient] = (InterfaceClient) Naming.lookup("cliente");
                UserLogar.setIdentification(idClient);
                UserLogar.setIP(user.getIP());
                user.setName(user.getName());
                logServer = logServer + " *** Cliente registrado com o codigo " + idClient + " *** \n";
                System.out.println(" *** Cliente registrado com o codigo " + idClient + " *** \n");
                resultado = idClient;
            } else {
                System.err.println("Não foi possivel obter uma conexao");
            }
        } catch (RemoteException e) {
            logServer = logServer + "Não foi possivel registrar o usuário. \n";
            System.err.println("Erro ao tentar parar o servidor. \n");
        } catch (NotBoundException e) {
            logServer = logServer + "Serviço do servidor não registrado, ;) \n";
            System.err.println("Erro ao tentar parar o servidor. \n");
        } catch (MalformedURLException e) {
            logServer = logServer + " Nome ou URL do servidor inivalido, ;)\n";
            System.err.println(" Nome do Servidor Inivalido, ;)\n");
        }
        return resultado;
    }

    private boolean dataValidUser(User user) {
        boolean retorno = true;
        if ("".equals(user.getName())) {
            retorno = false;
        }

        if ("".equals(user.getIP())) {
            retorno = false;
        }
        return retorno;
    }

    @Override
    public String liberaConexao(int idCliente) throws RemoteException {
        //Loop para remover o usuário
        for (int i = 0; i < connectedClient.length; i++) {
            if (i == idCliente) {
                connectedClient[this.idClient] = null;
            }
        }
        this.idClient--;
        logServer = logServer + " *** Conexão liberada *** \n";
        System.out.println(" *** Conexão liberada *** \n");
        return logServer;
    }

    @Override
    public void sendToAll(String mensagem, int idCliente, String nome) throws RemoteException {

        for (int i = 0; i < connectedClient.length; i++) {
            if ((connectedClient[i] != null) && (i != idCliente)) {
                connectedClient[i].atribuiMensagem("> " + nome + " disse: " + mensagem);
            }
        }
    }

    public void stopServer() {
        try {
            Naming.unbind("Servidor");
            logServer = logServer + " *** Servidor Finalizado... *** \n";
            System.out.println(" *** Servidor Finalizado... *** \n");
        } catch (RemoteException e) {
//            logServer = logServer + "Erro ao tentar parar o servidor.";
            System.err.println("Erro ao tentar parar o servidor. \n");
        } catch (NotBoundException e) {
            logServer = logServer + "Serviço do servidor não registrado, ;) \n";
            System.err.println("Erro ao tentar parar o servidor. \n");
        } catch (MalformedURLException e) {
            logServer = logServer + " Nome ou URL do servidor inivalido, ;)\n";
            System.err.println(" Nome do Servidor Inivalido, ;)\n");
        }
    }

    public void startServer() {
        try {
            logServer = logServer + " *** Construinda a aplicação do servidor *** \n";
            System.out.println(" *** Construinda a aplicação do servido *** \n");
            Server servidor = new Server();
            logServer = logServer + " *** Registrando o servidor *** \n";
            System.out.println(" *** Registrando o servidor *** \n");
            Naming.rebind("Servidor", servidor);
            logServer = logServer + " *** Servidor iniciado com sucesso *** \n \n";
            System.out.println(" *** Servidor iniciado com sucesso *** \n");
            situationServer = situationServer.START;
        } catch (RemoteException e) {
            logServer = logServer + " É necessário primeiramente iniciar o arquivo registrarServer.cmd \n"
                    + " que encontra na pasta do projeto em "
                    + "( ..\\ChatRMI\\build\\classes) \n";
            System.err.println(" É necessário primeiramente iniciar o RMI Registry \n");
        } catch (MalformedURLException e) {
            logServer = logServer + " Nome ou URL do servidor inivalido, ;)\n";
            System.err.println(" Nome do Servidor Inivalido, ;)\n");
        }
    }

    public String getLogServer() {
        return logServer;
    }

    public InterfaceClient[] getConnectedClient() {

        return connectedClient;
    }

    public void setConnectedClient(InterfaceClient[] connectedClient) {
        this.connectedClient = connectedClient;
    }

    public String[] getUser() {
        int i = 0;
        String[] retorno = new String[this.MAXIMUMSIZECLIENT];

        while (this.user != null) {
            retorno[i] = this.user[i].getName() + "  : " + this.user[i].getIP();
            i += 1;
        }
        return retorno;
    }

    public void setUser(User[] user) {
        this.user = user;
    }
}
