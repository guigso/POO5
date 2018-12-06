/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.reservations;

import java.util.ArrayList;

/**
 *
 * @author and_h
 */
public class User {
    private int idusuario;
    private String cpf;
    private String nome;
    private String telefone;
    private String login;
    private String senha;

    public User(int idusuario, String cpf, String nome, String telefone, String login, String senha) {
        this.idusuario = idusuario;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static User getUser(String login, String senha) 
            throws Exception{
        String SQL = "SELECT * FROM USUARIO "
                + "WHERE login = ? AND senha = ?";
        Object parameters[] = {login, senha.hashCode()};
        ArrayList<Object[]> list = DatabaseConnector.getQuery(SQL, parameters);
        if(list.isEmpty()){
            return null;
        } else {
            Object row[] = list.get(0);
            User u = new User(
                    (int)row[0]
                    ,(String) row[1]
                    ,(String) row[2]
                    ,(String) row[3]
                    ,(String) row[4]
                    ,(String) row[5]);
            return u;
        }
    }
}
