package actions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import beans.HocVien;
import exceptions.IdException;
import exceptions.NumberException;

public class HocVienAction {
    private static Scanner sc = new Scanner(System.in);
    
    // Ham lay chuoi ky tu tu ban phim
    public static String enterString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

    // Ham lay gia tri nguyen trong pham vi [min .. max] tu ban phim
    public static int enterValueInRangeMinMax(int min, int max, String message, String err) {
        boolean check = true;
		int n = 0;
		do {
			try {
				System.out.print(message);
				n = Integer.parseInt(sc.nextLine());
				if (n < min|| n > max)
					throw new NumberException(err);
				check = false;
			} catch (NumberFormatException e) {
				System.out.println("The data you entered is not valid!");
			} catch (NumberException e) {
				System.out.println(e.getMessage());
			}
		} while (check);
		return n;
    }

    // Ham kiem tra hoc vien co trong db hay chua, neu co tra ve hoc vien do, neu khong tra ve null
	public static HocVien checkHocVien(ArrayList<HocVien> dsHocVien, String id){
        for (HocVien hocVien : dsHocVien) {
            if (hocVien.getMaHV().toLowerCase().equals(id.toLowerCase())){
                return hocVien;
            }
        }
        return null;
    }

    public static String enterId(ArrayList<HocVien> dsHocVien, String msg, String err){
        String tmp = "";
        boolean check = true;

        do {
            try {
                System.out.print(msg);
                tmp = sc.nextLine();
                if (checkHocVien(dsHocVien, tmp) != null) {
                        throw new IdException(err);
                }
                check = false;
            } catch (IdException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return tmp;
    }

    public static int renderAgeInRangeMinMax(int min, int max){
        Random generator = new Random();
        return generator.nextInt((max - min) + 1) + min;
    }

    public static ArrayList<HocVien> inputInfo() {
		ArrayList<HocVien> listHocVien = new ArrayList<>();
		int n = enterValueInRangeMinMax(1, 2147483647, "Nhap so luong hoc vien: ", "So luong hoc vien phai lon hon 0.");

		// Nhap thong tin cho moi hoc vien
		for (int i = 0; i < n; i++) {
			System.out.println("\nNhap thong tin hoc vien thu " + (i + 1) + ": ");
			String id = enterId(listHocVien, "Nhap ma hoc vien: ", "Ma hoc vien da ton tai!");
            String name = enterString("Nhap hoc ten cua hoc vien: ");
            String address = enterString("Nhap dia chi cua hoc vien: ");

            // Tuoi ngau nhien tu 18 - 25
            int age = renderAgeInRangeMinMax(18, 25);

			HocVien hocVien = new HocVien(id, name, address, age);
			listHocVien.add(hocVien);
		}

		return listHocVien;
	}

    public static void displayInfor(ArrayList<HocVien> listHocVien){
        if (listHocVien.size() > 0) {
            for (HocVien hocVien : listHocVien) {
                System.out.println(hocVien);
            }
        } else {
            System.out.println("Danh sach trong!");
        }
        
    }

    public static void searchInfor(ArrayList<HocVien> listHocVien){
        String id = enterString("Nhap ma so sinh vien can tim: ");
        HocVien hocVien = checkHocVien(listHocVien, id);

        if (hocVien != null){
            System.out.println(hocVien);
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public static ArrayList<HocVien> sort(ArrayList<HocVien> listHocVien, int mode){
        // Sap xep giam dan
        if (mode == 1) {
            listHocVien.sort(new Comparator<HocVien>() {
                @Override
                public int compare(HocVien o1, HocVien o2) {
                    if (o1.getTuoi() > o2.getTuoi()) {
                        return -1;
                    }
                    return 0;
                }
            });
        
        // Sap xem tang dan
        } else if (mode == -1) {
            listHocVien.sort(new Comparator<HocVien>() {
                @Override
                public int compare(HocVien o1, HocVien o2) {
                    if (o1.getTuoi() < o2.getTuoi()) {
                        return -1;
                    }
                    return 0;
                }
                
            });
        }
        return listHocVien;
    }

    public static void delete(ArrayList<HocVien> listHocVien){
        String id = enterString("Nhap ma so sinh vien can xoa: ");
        HocVien hocVien = checkHocVien(listHocVien, id);

        if (hocVien != null) {
            if (listHocVien.remove(hocVien)) {
                System.out.println("Xoa thanh cong!");
                System.out.println("========== DANH SACH HOC VIEN HIEN TAI ========");
                displayInfor(listHocVien);
            } else {
                System.out.println("Xoa khong thanh cong!");
            }
        } else {
            System.out.println("Khong tim thay hoc vien de xoa!");
        }
    }

    public static int menu(){
        System.out.println("=========== QUAN LY HOC VIEN ==========");
        System.out.println("1. Nhap du lieu");
        System.out.println("2. Xuat du lieu");
        System.out.println("3. Tim thong tin");
        System.out.println("4. Sap xep");
        System.out.println("5. Xoa thong tin hoc vien");
        System.out.println("6. Thoat");
        return enterValueInRangeMinMax(1, 6, "Moi ban chon: ", "Chuc nang ban chon khong co!");
    }

    public static int sapXep(){
        int tangDan = -1;
        int giamDan = 1;

        System.out.println("1. Sap xep tang dan");
        System.out.println("2. Sap xep giam dan");
        int chon = enterValueInRangeMinMax(1, 2, "Moi ban chon: ", "Chuc nang ban chon khong co!");
        if (chon == 1)
            return tangDan;
        else
            return giamDan;
    }   
}
