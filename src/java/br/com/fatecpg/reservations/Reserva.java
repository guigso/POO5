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
 * @author thais.lopes
 */
public class Reserva {
    private int idreserva;
    private int idusuario;
    private int mesa;
    private int qtdcadeira;
    private int reservado;

    public static ArrayList<Reserva> getList() throws Exception{
        ArrayList<Reserva> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app", pass = "app";
        Connection sampleCon = DriverManager.getConnection(url, user, pass);
        Statement reservaStmt = sampleCon.createStatement();
        String SQL = "SELECT * FROM RESERVA";
        ResultSet reservaRs = reservaStmt.executeQuery(SQL);
        while (reservaRs.next()){
            int idreserva = reservaRs.getInt("IDRESERVA");
            int idusuario = reservaRs.getInt("IDUSUARIO");
            int mesa = reservaRs.getInt("MESA");
            int qtdcadeira = reservaRs.getInt("QTDCADEIRA");
            int reservado = reservaRs.getInt("RESERVADO");
            
            Reserva r = new Reserva(idreserva, idusuario, mesa, qtdcadeira, reservado);
            list.add(r);
        }
        reservaRs.close();
        reservaStmt.close();
        sampleCon.close();
        return list;
    }
    
    public Reserva(int idreserva, int idusuario, int mesa, int qtdcadeira, int reservado) {
        this.idreserva = idreserva;
        this.idusuario = idusuario;
        this.mesa = mesa;
        this.qtdcadeira = qtdcadeira;
        this.reservado = reservado;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getQtdcadeira() {
        return qtdcadeira;
    }

    public void setQtdcadeira(int qtdcadeira) {
        this.qtdcadeira = qtdcadeira;
    }

    public int getReservado() {
        return reservado;
    }

    public void setReservado(int reservado) {
        this.reservado = reservado;
    }
    
}
