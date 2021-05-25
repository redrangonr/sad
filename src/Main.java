import java.util.Scanner;

public class Main {
  static   Scanner scanner = new Scanner(System.in);
  static  ManagerPhoneBook managerPhoneBook = new ManagerPhoneBook();
    public static void main(String[] args) {
        choiceMenu();

    }
    public static void showMenu(){
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ ANH BẠ----");
        System.out.println("chọn chức năng theo số để tiếp tục");
        System.out.println("1. Xem danh sách");
        System.out.println("2 . Thêm mới ");
        System.out.println("3 . Cập Nhập");
        System.out.println("4 . Xóa");
        System.out.println("5 . Tìm kiếm ");
        System.out.println("6 . Đọc từ file");
        System.out.println("7 . Ghi từ file");
        System.out.println("8 . Thoát");
        System.out.println("Chọn chức năng");
    }
    public static void choiceMenu(){
        int choice;
        do{
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    managerPhoneBook.showDisplay();
                    break;
                }
                case 2: {
                    managerPhoneBook.addInfo();
                    break;
                }
                case 3: {
                    System.out.println("Nhập số điện thoại cần sửa");
                    long num = scanner.nextLong();
                   managerPhoneBook.chagePhone(num);
                    break;
                }
                case 4: {
                  System.out.println("Nhập số điện thoại cần xóa");
                  long phone = scanner.nextLong();
                  managerPhoneBook.removePhoneNumber(phone);
                    break;
                }
                case 5: {
                    System.out.println("Nhập tên cần tìm");
                    scanner.nextLine();
                    String name =scanner.nextLine();
                    managerPhoneBook.findName(name);
                    break;
                }
                case 6: {


                    break;
                }
                case 7:{
                    managerPhoneBook.csvSave();
                    break;
                }

                case 8: {
                    System.out.println("Tạm biệt");
                    System.exit(0);
                }

            }
        }while (choice!=8);
    }

}
