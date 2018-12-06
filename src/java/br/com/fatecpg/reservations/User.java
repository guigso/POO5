/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.reservations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public static ArrayList<User> getList() throws Exception{
        ArrayList<User> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app", pass = "app";
        Connection sampleCon = DriverManager.getConnection(url, user, pass);
        Statement usuarioStmt = sampleCon.createStatement();
        String SQL = "SELECT * FROM USUARIO";
        ResultSet usuarioRs = usuarioStmt.executeQuery(SQL);
        while (usuarioRs.next()){
            int idusuario = usuarioRs.getInt("IDUSUARIO");
            String cpf = usuarioRs.getString("CPF");
            String nome = usuarioRs.getString("NOME");
            String telefone = usuarioRs.getString("TELEFONE");
            
            User u = new User(idusuario, cpf, nome, telefone);
            list.add(u);
        }
        usuarioRs.close();
        usuarioStmt.close();
        sampleCon.close();
        return list;
    }
    
    public User(int idusuario, String cpf, String nome, String telefone) {
        this.idusuario = idusuario;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
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
    
}
