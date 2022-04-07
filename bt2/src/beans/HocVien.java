package beans;

public class HocVien {
    private String maHV;
    private String hoTen;
    private String diaChi;
    private int tuoi;

    public HocVien() {
    }

    public HocVien(String maHV, String hoTen, String diaChi, int tuoi) {
        this.maHV = maHV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "MaHV: " + this.maHV 
            + "\t\tHo va ten: " + this.hoTen 
            + "\t\tDia chi: " + this.diaChi 
            + "\t\tTuoi: " + this.tuoi;
    }
}