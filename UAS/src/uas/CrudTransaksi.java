package uas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CrudTransaksi extends JFrame {
    private JTextField txtIdTransaksi, txtIdKonsumen, txtIdBarang, txtQuantity, txtTotalBiaya;
    private JTable tableTransaksi;
    private DefaultTableModel modelTransaksi;

    public CrudTransaksi() {
        setTitle("CRUD Transaksi");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Label dan TextField
        JLabel lblIdTransaksi = new JLabel("ID Transaksi:");
        lblIdTransaksi.setBounds(20, 20, 100, 30);
        add(lblIdTransaksi);
        txtIdTransaksi = new JTextField();
        txtIdTransaksi.setBounds(120, 20, 150, 30);
        add(txtIdTransaksi);

        JLabel lblIdKonsumen = new JLabel("ID Konsumen:");
        lblIdKonsumen.setBounds(20, 60, 100, 30);
        add(lblIdKonsumen);
        txtIdKonsumen = new JTextField();
        txtIdKonsumen.setBounds(120, 60, 150, 30);
        add(txtIdKonsumen);

        JLabel lblIdBarang = new JLabel("ID Barang:");
        lblIdBarang.setBounds(20, 100, 100, 30);
        add(lblIdBarang);
        txtIdBarang = new JTextField();
        txtIdBarang.setBounds(120, 100, 150, 30);
        add(txtIdBarang);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(20, 140, 100, 30);
        add(lblQuantity);
        txtQuantity = new JTextField();
        txtQuantity.setBounds(120, 140, 150, 30);
        add(txtQuantity);

        JLabel lblTotalBiaya = new JLabel("Total Biaya:");
        lblTotalBiaya.setBounds(20, 180, 100, 30);
        add(lblTotalBiaya);
        txtTotalBiaya = new JTextField();
        txtTotalBiaya.setBounds(120, 180, 150, 30);
        add(txtTotalBiaya);

        // Tombol
        JButton btnTambah = new JButton("Tambah");
        btnTambah.setBounds(20, 220, 100, 30);
        add(btnTambah);

        JButton btnUbah = new JButton("Ubah");
        btnUbah.setBounds(130, 220, 100, 30);
        add(btnUbah);

        JButton btnHapus = new JButton("Hapus");
        btnHapus.setBounds(240, 220, 100, 30);
        add(btnHapus);

        // Tabel
        modelTransaksi = new DefaultTableModel(new String[]{"ID Transaksi", "ID Konsumen", "ID Barang", "Quantity", "Total Biaya"}, 0);
        tableTransaksi = new JTable(modelTransaksi);
        JScrollPane sp = new JScrollPane(tableTransaksi);
        sp.setBounds(20, 270, 650, 150);
        add(sp);

        // Event Listener
        btnTambah.addActionListener(e -> tambahTransaksi());
        btnUbah.addActionListener(e -> ubahTransaksi());
        btnHapus.addActionListener(e -> hapusTransaksi());
    }

    private void tambahTransaksi() {
        String idTransaksi = txtIdTransaksi.getText();
        String idKonsumen = txtIdKonsumen.getText();
        String idBarang = txtIdBarang.getText();
        String quantity = txtQuantity.getText();
        String totalBiaya = txtTotalBiaya.getText();

        if (idTransaksi.isEmpty() || idKonsumen.isEmpty() || idBarang.isEmpty() || quantity.isEmpty() || totalBiaya.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        modelTransaksi.addRow(new Object[]{idTransaksi, idKonsumen, idBarang, quantity, totalBiaya});
        clearFields();
    }

    private void ubahTransaksi() {
        int selectedRow = tableTransaksi.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah!");
            return;
        }

        modelTransaksi.setValueAt(txtIdTransaksi.getText(), selectedRow, 0);
        modelTransaksi.setValueAt(txtIdKonsumen.getText(), selectedRow, 1);
        modelTransaksi.setValueAt(txtIdBarang.getText(), selectedRow, 2);
        modelTransaksi.setValueAt(txtQuantity.getText(), selectedRow, 3);
        modelTransaksi.setValueAt(txtTotalBiaya.getText(), selectedRow, 4);
        clearFields();
    }

    private void hapusTransaksi() {
        int selectedRow = tableTransaksi.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
            return;
        }

        modelTransaksi.removeRow(selectedRow);
    }

    private void clearFields() {
        txtIdTransaksi.setText("");
        txtIdKonsumen.setText("");
        txtIdBarang.setText("");
        txtQuantity.setText("");
        txtTotalBiaya.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CrudTransaksi().setVisible(true));
    }
}