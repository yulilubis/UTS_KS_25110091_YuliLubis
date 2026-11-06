package dao;

import model.Barang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BarangDAO {
    
    // Method untuk Menambah Data
    public boolean tambahBarang(Barang b) {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, kategori, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_inventori", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getKodeBarang());
            ps.setString(2, b.getNamaBarang());
            ps.setString(3, b.getKategori());
            ps.setInt(4, b.getStok());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
            return false;
        }
    }

    // Method untuk Mengubah Data
    public boolean ubahBarang(Barang b) {
        String sql = "UPDATE barang SET nama_barang=?, kategori=?, stok=? WHERE kode_barang=?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_inventori", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNamaBarang());
            ps.setString(2, b.getKategori());
            ps.setInt(3, b.getStok());
            ps.setString(4, b.getKodeBarang());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error Ubah: " + e.getMessage());
            return false;
        }
    }

    // Method untuk Menghapus Data
    public boolean hapusBarang(String kodeBarang) {
        String sql = "DELETE FROM barang WHERE kode_barang=?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_inventori", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeBarang);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error Hapus: " + e.getMessage());
            return false;
        }
    }
}