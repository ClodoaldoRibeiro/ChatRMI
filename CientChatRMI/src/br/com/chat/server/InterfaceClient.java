package br.com.chat.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceClient extends Remote {

    public void atribuiMensagem(String mensagem) throws RemoteException;
}
