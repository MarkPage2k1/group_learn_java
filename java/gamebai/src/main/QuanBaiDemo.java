package main;

import java.util.ArrayList;

import actions.QuanBaiActions;
import beans.QuanBai;

public class QuanBaiDemo {
    public static void main(String[] args) {
        ArrayList<QuanBai> dsQuanBai = new ArrayList<QuanBai>();

        System.out.println("======= NHAP DANH SACH QUAN BAI ========");
        dsQuanBai = QuanBaiActions.inputInfo();

        System.out.println("======= DANH SACH QUAN BAI HIEN CO =======");
        QuanBaiActions.displayInfor(dsQuanBai);

        System.out.println("========== FINISH ========");
    }
}
