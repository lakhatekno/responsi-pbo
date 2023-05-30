/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.Connector;
import model.Perpustakaan;

/**
 *
 * @author Lab Informatika
 */
public class PerpustakaanDAO {
    Connection con;
    private static String select = "SELECT * FROM dataperpus";
    private static String insert = "INSERT INTO `dataperpus` (`id`, `judul`, `genre`, `penulis`, `penerbit`, `lokasi`, `stock`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static String update = "UPDATE `dataperpus` SET `judul` = ?, `genre` = ?, `penulis` = ?, `penerbit` = ?, `lokasi` = ?, `stock` = ? WHERE `dataperpus`.`id` = ?";
    private static String delete = "DELETE FROM dataperpus WHERE `id` = ?";
    private static String query;
    
    public PerpustakaanDAO() {
        con = Connector.connection();
    }
    
    public void insert(Perpustakaan p) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public List<Perpustakaan> getAll() {
        List<Perpustakaan> p = null;
        try {
            p = new ArrayList<Perpustakaan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
                Perpustakaan data = new Perpustakaan();
                data.setId(rs.getInt("id"));
                data.setJudul(rs.getString("judul"));
                data.setGenre(rs.getString("genre"));
                data.setPenulis(rs.getString("penulis"));
                data.setPenerbit(rs.getString("penerbit"));
                data.setLokasi(rs.getString("lokasi"));
                data.setStock(rs.getInt("stock"));
                p.add(data);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return p;
    }
    
    public List<Perpustakaan> getJudul(String keyword) {
        List<Perpustakaan> p = null;
        query = "SELECT * FROM dataperpus WHERE judul like \"" + keyword + "\"";
        try {
            p = new ArrayList<Perpustakaan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Perpustakaan data = new Perpustakaan();
                data.setId(rs.getInt("id"));
                data.setJudul(rs.getString("judul"));
                data.setGenre(rs.getString("genre"));
                data.setPenulis(rs.getString("penulis"));
                data.setPenerbit(rs.getString("penerbit"));
                data.setLokasi(rs.getString("lokasi"));
                data.setStock(rs.getInt("stock"));
                p.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return p;
    }
    
    public List<Perpustakaan> getGenre(String keyword) {
        List<Perpustakaan> p = null;
        query = "SELECT * FROM dataperpus WHERE genre like \"" + keyword + "\"";
        try {
            p = new ArrayList<Perpustakaan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Perpustakaan data = new Perpustakaan();
                data.setId(rs.getInt("id"));
                data.setJudul(rs.getString("judul"));
                data.setGenre(rs.getString("genre"));
                data.setPenulis(rs.getString("penulis"));
                data.setPenerbit(rs.getString("penerbit"));
                data.setLokasi(rs.getString("lokasi"));
                data.setStock(rs.getInt("stock"));
                p.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return p;
    }
    
    public List<Perpustakaan> getPenulis(String keyword) {
        List<Perpustakaan> p = null;
        query = "SELECT * FROM dataperpus WHERE penulis like \"" + keyword + "\"";
        try {
            p = new ArrayList<Perpustakaan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Perpustakaan data = new Perpustakaan();
                data.setId(rs.getInt("id"));
                data.setJudul(rs.getString("judul"));
                data.setGenre(rs.getString("genre"));
                data.setPenulis(rs.getString("penulis"));
                data.setPenerbit(rs.getString("penerbit"));
                data.setLokasi(rs.getString("lokasi"));
                data.setStock(rs.getInt("stock"));
                p.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return p;
    }
    
    public List<Perpustakaan> getPenerbit(String keyword) {
        List<Perpustakaan> p = null;
        query = "SELECT * FROM dataperpus WHERE penerbit like \"" + keyword + "\"";
        try {
            p = new ArrayList<Perpustakaan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Perpustakaan data = new Perpustakaan();
                data.setId(rs.getInt("id"));
                data.setJudul(rs.getString("judul"));
                data.setGenre(rs.getString("genre"));
                data.setPenulis(rs.getString("penulis"));
                data.setPenerbit(rs.getString("penerbit"));
                data.setLokasi(rs.getString("lokasi"));
                data.setStock(rs.getInt("stock"));
                p.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return p;
    }

    public void update(Perpustakaan p) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.setInt(7, p.getId());
            statement.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
