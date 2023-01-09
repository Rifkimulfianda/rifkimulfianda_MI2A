/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rifki.controller;

import rifki.DAO.MahasiswaDao;
import rifki.DAO.MahasiswaDaoImp1;
import rifki.model.Mahasiswa;
import rifki.view.FormMahasiswa;
import rifki.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class MahasiswaController {
    private FormMahasiswa formMahasiswa;
    private MahasiswaDao mahasiswaDao;
    private Mahasiswa mahasiswa;
    
    public MahasiswaController(FormMahasiswa formMahasiswa){
        this.formMahasiswa = formMahasiswa;
        mahasiswaDao = new MahasiswaDaoImp1();
    }
    
    public void bersihForm(){
        formMahasiswa.getTxtNobp().setText("");
        formMahasiswa.getTxtNama().setText("");
        formMahasiswa.getTxtAlamat().setText("");
        formMahasiswa.getTxtJenkel().setText("");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel = (DefaultTableModel) formMahasiswa.getTblMahasiswa().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Mahasiswa> listMahasiswa = mahasiswaDao.getAllMahasiswa();
        for(Mahasiswa mahasiswa : listMahasiswa){
            Object[] data={
                mahasiswa.getNobp(),
                mahasiswa.getNama(),
                mahasiswa.getAlamat(),
                mahasiswa.getJenkel()
            };
            tabelModel.addRow(data);
        }
    }
    
    public void save(){
        mahasiswa = new Mahasiswa();
        mahasiswa.setNobp(formMahasiswa.getTxtNobp().getText());
        mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
        mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
        mahasiswa.setJenkel(formMahasiswa.getTxtJenkel().getText());
        mahasiswaDao.save(mahasiswa);
        JOptionPane.showMessageDialog(formMahasiswa, "Entri Data Ok!");
    }
}
