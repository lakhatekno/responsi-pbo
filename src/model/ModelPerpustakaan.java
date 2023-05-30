/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ModelPerpustakaan extends AbstractTableModel {
    List<Perpustakaan> p;
    
    public ModelPerpustakaan(List<Perpustakaan> p ) {
        this.p = p;
    }
    @Override
    public int getRowCount() {
        return p.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0: return "id";
            case 1: return "Judul";
            case 2: return "Genre";
            case 3: return "Penulis";
            case 4: return "Penerbit";
            case 5: return "Lokasi";
            case 6: return "Stock";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col) {
            case 0: return p.get(row).getId();
            case 1: return p.get(row).getJudul();
            case 2: return p.get(row).getGenre();
            case 3: return p.get(row).getPenulis();
            case 4: return p.get(row).getPenerbit();
            case 5: return p.get(row).getLokasi();
            case 6: return p.get(row).getStock();
            default: return null;
        }
    }
    
}
