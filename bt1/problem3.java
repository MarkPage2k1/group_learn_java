import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class TuDien{
    private String word;
    private String meaning;
    private String pronunciation;

    TuDien() {
        this.word = "unknown";
        this.meaning = "unknown";
        this.pronunciation = "unknown";
    }

    public String getWord() {
        return word;
    }

    public void EnterDictionary(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==========================");
        System.out.print("Enter word: ");
        this.word = scanner.nextLine();
        System.out.print("Enter meaning: ");
        this.meaning = scanner.nextLine();
        System.out.print("Enter pronunciation: ");
        this.pronunciation = scanner.nextLine();
        System.out.println("==========================\n");
    }

    public void Show(){
        System.out.println("========= Information of word =========");
        System.out.println("Word: " + this.word);
        System.out.println("Meaning: " + this.meaning);
        System.out.println("Pronunciation: " + this.pronunciation);
        System.out.println("======================================\n");
    }
}

public class problem3 {
    public static void main(String[] args) throws IOException {
        byte choice = 0;

        ArrayList<TuDien> dictionary = new ArrayList<TuDien>();

        do
        {
            System.out.println("============ TU DIEN ANH VIET ============");
            System.out.println("1. Nhap du lieu");
            System.out.println("2. Xuat du lieu");
            System.out.println("3. Dich tu");
            System.out.println("4. Thoat");
            
            choice = getByteDataFromKeyboard("Moi ban chon chuc nang: ");
            switch (choice) {
                case 1:
                    System.out.print("\033[H\033[2J");  // Clear screen command line
                    System.out.flush();
                    dictionary = NhapDuLieu();
                    break;
                case 2:
                    XuatDuLieu(dictionary);
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    TraTuDien(dictionary);
                    break;
                case 4:
                    System.out.println("Cam on da su dung tu dien!");
                    break;
            
                default: 
                    System.out.println("Chuc nang ban chon khong co!\nVui long chon lai!");
                    break;
            }

            System.out.print("Press any key to continue!");
            char ch = (char) System.in.read();
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        } while(choice != 4);
    }

    private static ArrayList<TuDien> NhapDuLieu(){
        ArrayList<TuDien> list = new ArrayList<TuDien>();
        int n = getPositiveIntegerFromKeyboard("Enter the number of words you want to add: ");

        for(int i = 0; i < n; i++) { 
            TuDien word = new TuDien();
            word.EnterDictionary();
            list.add(word);
        }
        return list;
    }

    private static void XuatDuLieu(ArrayList<TuDien> list){
        System.out.println("========== DANH SACH TU CO TRONG TU DIEN ============");

        for (TuDien word : list) {
            word.Show();
            System.out.println();
        }
    }

    private static void TraTuDien(ArrayList<TuDien> list) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== TRA TU DIEN ============");
        System.out.print("Enter the word you want to look up: ");
        String wordSearch = scanner.nextLine();
        boolean check = false;

        for (TuDien word : list) {
            if (wordSearch.toLowerCase().equals(word.getWord().toLowerCase())) {
                check = true;
                System.out.println();
                word.Show();
                System.out.println();
                break;
            }
        }

        if (check == false) {
            System.out.println("The word you look up is not in the dictionary!\n");
        }
    }

    private static byte getByteDataFromKeyboard(String message) {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                byte number = scanner.nextByte();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("The data you entered is not valid!!!");
            } catch (Exception e) {
                System.out.println("ERROR!!!");
            }
        }
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
}
