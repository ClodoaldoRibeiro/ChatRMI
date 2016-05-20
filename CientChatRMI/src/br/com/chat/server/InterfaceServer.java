package br.com.chat.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServer extends Remote {

    public int estabeleceConexao(User user) throws RemoteException;

    public String liberaConexao(int idCliente) throws RemoteException;

    public void sendToAll(String mensagem, int idCliente, String nome) throws RemoteException;
}
