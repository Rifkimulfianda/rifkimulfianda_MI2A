/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rifki.DAO;
import rifki.model.Anggota;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class AnggotaDaoImp1 implements AnggotaDao{
    List<Anggota> data = new ArrayList<>();
    
    public AnggotaDaoImp1(){
        data.add(new Anggota("2028", "Zakki", "Rifki"));
        data.add(new Anggota("2029", "Andre", "Rifki"));
        data.add(new Anggota("2035", "Fajri", "Rifki"));
    }
    
    @Override
    public Anggota save(Anggota anggota){
        data.add(anggota);
        return anggota;
    }
    
    public Anggota update(int index, Anggota anggota){
        data.set(index, anggota);
        return anggota;
    }
    
    public Anggota delete(int index){
        return data.remove(index);
    }
    
    public Anggota getAnggota (int index){
        return data.get(index);
    }
    
    public List<Anggota> getAllAnggota(){
        return data;
    }
}
