package main;

import java.util.ArrayList;

import actions.HocVienAction;
import beans.HocVien;

public class HocVienMain {
    public static void main(String[] args) {
        ArrayList<HocVien> dsHocVien = new ArrayList<HocVien>();
        int chon;
        boolean check = true;
        do {
            chon = HocVienAction.menu();
            switch(chon) {
                case 1:
                    clearScreen();
                    System.out.println("========== NHAP DANH SACH HOC VIEN ========");
                    dsHocVien = HocVienAction.inputInfo();
                    break;
                case 2:
                    clearScreen();
                    System.out.println("========== DANH SACH HOC VIEN ========");
                    HocVienAction.displayInfor(dsHocVien);
                    break;
                case 3:
                    clearScreen();
                    System.out.println("========== TIM KIEM HOC VIEN ========");
                    HocVienAction.searchInfor(dsHocVien);
                    break;
                case 4:
                    clearScreen();
                    System.out.println("========== SAP XEP DANH SACH HOC VIEN ========");
                    HocVienAction.sort(dsHocVien, HocVienAction.sapXep());
                    System.out.println("========== DANH SACH HOC VIEN DA SAP XEP ========");
                    HocVienAction.displayInfor(dsHocVien);
                    break;
                case 5:
                    clearScreen();
                    System.out.println("========== XOA HOC VIEN ========");
                    HocVienAction.delete(dsHocVien);
                    break;
                case 6:
                    clearScreen();
                    System.out.println("Goodbye!");
                    check = false;
                    break;
            }

        } while (check);

        

        System.out.println("========== FINISH ========");
    }  

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
