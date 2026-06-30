package Controller;

import dao.krsDAO;
import view.InputNilai;
import datamahasiswa.KRS;
import java.util.List;

public class KRSController {
    private final krsDAO krsDao;

    public KRSController() {
        this.krsDao = new krsDAO();
    }
    public krsDAO getKrsDao() {
        return krsDao;
    }

    // CREATE
    public boolean tambahData(KRS krs) {
        return krsDao.simpan(krs);
    }

    // READ
    public List<KRS> tampilkanSemuaData() {
        return krsDao.ambilSemua();
    }

    // UPDATE
    public boolean ubahData(KRS krs) {
        return krsDao.update(krs);
    }

public boolean simpanDataNilai(InputNilai view, KRS krs) {
    return krsDao.simpan(krs);
}

public boolean updateDataNilai(InputNilai view, KRS krs) {
    return krsDao.update(krs);
}
public boolean hapusDataNilai(String nim, String kodeMk) {
    // Memanggil method hapus dari DAO dengan parameter yang benar
    return krsDao.hapus(nim, kodeMk);
}
}