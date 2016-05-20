package br.com.chat.server;

import java.io.Serializable;

public class User implements Serializable {

    private int identification;
    private String name;
    private String IP;

    public User() {
    }

    public User(String nome, String IP) {
        this.name = nome;
        this.IP = IP;
    }

    public User(int id, String nome, String IP) {
        this.identification = id;
        this.name = nome;
        this.IP = IP;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

}
