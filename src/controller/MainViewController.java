/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PerpustakaanDAO;
import java.util.List;
import javax.swing.JFrame;
import mainView.MainView;
import model.ModelPerpustakaan;
import model.Perpustakaan;

/**
 *
 * @author Lab Informatika
 */
public class MainViewController {
    MainView mv;
    PerpustakaanDAO pd;
    List<Perpustakaan> data;
    String query;

    public MainViewController(MainView mv) {
        this.mv = mv;
        pd = new PerpustakaanDAO();
        data = pd.getAll();
    }
    
    public void isiTabel() {
       data = pd.getAll();
       ModelPerpustakaan model = new ModelPerpustakaan(data);
       mv.getTabel().setModel(model);
    }
    
    public void insert() {
        Perpustakaan p = new Perpustakaan();
        p.setJudul(mv.getLabelJudul().getText());
        p.setGenre(mv.getLabelGenre().getText());
        p.setPenulis(mv.getLabelPenulis().getText());
        p.setPenerbit(mv.getLabelPenerbit().getText());
        p.setLokasi(mv.getLabelLokasi().getText());
        p.setStock(Integer.parseInt(mv.getLabelStock().getText()));
        pd.insert(p);
    }
    
    public void update() {
        Perpustakaan p = new Perpustakaan();
        p.setJudul(mv.getLabelJudul().getText());
        p.setGenre(mv.getLabelGenre().getText());
        p.setPenulis(mv.getLabelPenulis().getText());
        p.setPenerbit(mv.getLabelPenerbit().getText());
        p.setLokasi(mv.getLabelLokasi().getText());
        p.setStock(Integer.parseInt(mv.getLabelStock().getText()));
        p.setId(Integer.parseInt(mv.getLabelId().getText()));
        pd.update(p);
    }
    
    public void hapus() {
        int id = Integer.parseInt(mv.getLabelId().getText());
        pd.delete(id);
    }
    
    public void clear() {
        mv.getLabelId().setText("");
        mv.getLabelJudul().setText("");
        mv.getLabelGenre().setText("");
        mv.getLabelPenerbit().setText("");
        mv.getLabelPenulis().setText("");
        mv.getLabelLokasi().setText("");
        mv.getLabelStock().setText("");
    }
    
    public void cariJudul() {
        query = mv.getCari().getText();
        data = pd.getJudul(query);
        ModelPerpustakaan model = new ModelPerpustakaan(data);
        mv.getTabel().setModel(model);
    }
    
    public void cariGenre() {
        query = mv.getCari().getText();
        data = pd.getGenre(query);
        ModelPerpustakaan model = new ModelPerpustakaan(data);
        mv.getTabel().setModel(model);
    }
    
    public void cariPenulis() {
        query = mv.getCari().getText();
        data = pd.getPenulis(query);
        ModelPerpustakaan model = new ModelPerpustakaan(data);
        mv.getTabel().setModel(model);
    }
    
    public void cariPenerbit() {
       query = mv.getCari().getText();
       data = pd.getPenerbit(query);
       ModelPerpustakaan model = new ModelPerpustakaan(data);
       mv.getTabel().setModel(model);
    }
}
