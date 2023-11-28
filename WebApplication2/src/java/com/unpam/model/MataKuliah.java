/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unpam.model;

/**
 *
 * @author mr_tech
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MataKuliah {
    private String kodeMataKuliah, namaMataKuliah;
    private int jumlahSks;
    private String pesan;
    private Object[][] list;
    private final Koneksi koneksi = new Koneksi();
    private final PesanDialog pesanDialog = new PesanDialog();
    public String getKodeMataKuliah() {
    return kodeMataKuliah;
    }
    public void setKodeMataKuliah(String kodeMataKuliah) {
        this.kodeMataKuliah = kodeMataKuliah;
    }
    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }
    public void setNamaMataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }
    public int getJumlahSks() {
        return jumlahSks;
    }
    public void setJumlahSks(int jumlahSks) {
        this.jumlahSks = jumlahSks;
    }
    public String getPesan() {
        return pesan;
    }
    public Object[][] getList() {
        return list;
    }
    public void setList(Object[][] list) {
        this.list = list;
    }
    public boolean simpan() throws SQLException{
        boolean adaKesalahan = false;
        Connection connection;
        if ((connection = koneksi.getConnection()) != null){
            int jumlahSimpan = 0;
            boolean simpan = false;
            Statement sta;
            ResultSet rset;
            try {
                simpan = true;
                String SQLStatemen = "insert into tbmatakuliah values ('"+ kodeMataKuliah +"','"+namaMataKuliah+"','"+ jumlahSks +"')";
                sta = connection.createStatement();
                jumlahSimpan = sta.executeUpdate(SQLStatemen);
            }catch(SQLException ex){}
            if (simpan) {
                if (jumlahSimpan < 1){
                    adaKesalahan = true;
                    pesan = "Gagal menyimpan data mata kuliah";
                }
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }
}