package actions;

import java.util.ArrayList;
import java.util.Scanner;

import beans.QuanBai;
import exception.NumberException;

public class QuanBaiActions {
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

    public static ArrayList<QuanBai> inputInfo() {
		ArrayList<QuanBai> listTS = new ArrayList<>();
		int n = enterValueInRangeMinMax(1, 52, "Nhap so luong quan bai: ", "So luong quan bai phai lon hon 0 va nho hon hoac bang 52");

		// Nhap thong tin cho moi quan bai
		for (int i = 0; i < n; i++) {
			System.out.println("\nNhap thong tin quan bai thu " + (i + 1) + ": ");
			String name = enterString("Nhap ten quan bai: ");
			// Nhap diem cua quan bai
			int point = enterValueInRangeMinMax(1, 4, "Nhap diem cua quan bai [1-4]: ", "Diem cua quan bai chi duoc nam trong pham vi tu 1 den 4!");
			// Nhap he so quan bai
			int exp = enterValueInRangeMinMax(1, 13, "Nhap he so cua quan bai [1-13]: ", "He so cua quan bai chi duoc nam trong pham vi tu 1 den 13!");

			QuanBai bai = new QuanBai(name, point, exp);
			listTS.add(bai);
		}

		return listTS;

	}

    public static void displayInfor(ArrayList<QuanBai> listQB){
        for (QuanBai quanBai : listQB) {
            System.out.println(quanBai);
        }
    }

}
