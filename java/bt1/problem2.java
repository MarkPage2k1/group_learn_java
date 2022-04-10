import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class ThiSinh {
    private String ten;
    private Float diemToan;
    private Float diemLy;
    private Float diemHoa;

    public ThiSinh() {
        this.ten = "anonym";
        this.diemToan = 0.0f;
        this.diemLy = 0.0f;
        this.diemHoa = 0.0f;
    }

    public void NhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================");
        System.out.print("Nhap ho ten: ");
        this.ten = scanner.nextLine();
        this.diemToan = nhapDiem("Nhap diem mon toan: ");
        this.diemLy = nhapDiem("Nhap diem mon ly: ");
        this.diemHoa = nhapDiem("Nhap diem mon hoa: ");
        System.out.println("==========================\n");
    }

    public float TinhDiemThi(){
        return this.diemToan + this.diemLy + this.diemHoa;
    }

    public void InThongTin(){
        System.out.println("========= Thong tin thi sinh =========");
        System.out.println("Ten: " + this.ten);
        System.out.println("Diem toan: " + this.diemToan);
        System.out.println("Diem ly: " + this.diemLy);
        System.out.println("Diem hoa: " + this.diemHoa);
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println("Tong diem: " + f.format(this.TinhDiemThi()));
        System.out.println("======================================\n");
    }

    private static Float getFloatDataFromKeyboard(String message) {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                Float number = scanner.nextFloat();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("The data you entered is not valid!!!");
            } catch (Exception e) {
                System.out.println("ERROR!!!");
            }
        }
    } 

    private static Float nhapDiem(String message) {
        while (true){
            Float number = getFloatDataFromKeyboard(message);
            if (number >= 0 && number <= 10) {
                return number;
            } else {
                System.out.println("Diem ban nhap khong hop le!!!");
            }
        }
    }
}

public class problem2 {
    public static void main(String[] args) {
        int number = getPositiveIntegerFromKeyboard("Nhap so thi sinh tham du: ");
        ArrayList<ThiSinh> dsThiSinh = NhapDSThiSinh(number);
        ArrayList<ThiSinh> dsTSTrungTuyen = DSThiSinhTrungTuyen(dsThiSinh, 17.0f);
        xuatDSThiSinh(dsTSTrungTuyen, "danh sach thi sinh trung tuyen");
        xuatDSThiSinh(sapXepGiamDanTheoDiem(dsTSTrungTuyen), "DSTS trung tuyen sap xep giam dan");    
    }

    private static int getIntegerDataFromKeyboard(String message) {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                int number = scanner.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("The data you entered is not valid!!!");
            } catch (Exception e) {
                System.out.println("ERROR!!!");
            }
        }
    }

    private static int getPositiveIntegerFromKeyboard(String message) {
        while (true){
            int number = getIntegerDataFromKeyboard(message);
            if (number > 0) {
                return number;
            } else {
                System.out.println("The number of elements of the array must be greater than 0 !!!");
            }
        }
    }

    private static ArrayList<ThiSinh> NhapDSThiSinh(int length) {
        ArrayList<ThiSinh> list = new ArrayList<ThiSinh>();

        for (int i = 0; i < length; i++) {
            ThiSinh thiSinh = new ThiSinh();
            thiSinh.NhapThongTin();
            list.add(thiSinh);  
        }
        return list;
    }

    private static void xuatDSThiSinh(ArrayList<ThiSinh> dsThiSinh, String message) {
        System.out.println("========= " + message.toUpperCase() + " =========");
        if (dsThiSinh.size() > 0) {
            for (ThiSinh thiSinh : dsThiSinh) {
                thiSinh.InThongTin();
            }
        } else {
            System.out.println("Danh sach trong!!!");
        }  
        System.out.println("======================================");
    }

    private static ArrayList<ThiSinh> DSThiSinhTrungTuyen(ArrayList<ThiSinh> dsThiSinh, float diemChuan) {
        ArrayList<ThiSinh> dsTSTrungTuyen = new ArrayList<ThiSinh>();

        for (ThiSinh thiSinh : dsThiSinh) {
            if (thiSinh.TinhDiemThi() >= diemChuan) {
                dsTSTrungTuyen.add(thiSinh);
            }
        }
        return dsTSTrungTuyen;
    }

    private static ArrayList<ThiSinh> sapXepGiamDanTheoDiem(ArrayList<ThiSinh> list) {
        ArrayList<ThiSinh> dsThiSinh = list;
        dsThiSinh.sort(new Comparator<ThiSinh>() {
                        @Override
                        public int compare(ThiSinh o1, ThiSinh o2) {
                            if (o1.TinhDiemThi() > o2.TinhDiemThi()) return -1;
                            return 0;
                        }});
        return dsThiSinh;
    }
}