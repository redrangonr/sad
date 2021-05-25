import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerPhoneBook {
    public static final String DANH_SÁCH_SAU_KHI_XÓA = "Danh sách sau khi xóa";
    public static final String DANH_SÁCH_SAU_KHI_SỬA = "Danh sách sau khi sửa";
    public static final String KHÔNG_TÌM_THẤY_TÊN = "không tìm thấy tên";
    public static final String KHÔNG_TÌM_THẤY_SỐ_ĐIỆN_THOẠI = "Không tìm thấy số điện thoại ";
    public static final String NHẬP_ĐIỆN_CHỈ_EMAIL = "Nhập điện chỉ email";
    public static final String NHẬP_ĐIỆN_CHỈ = "Nhập điện chỉ";
    public static final String NHẬP_TÊN_ = "Nhập tên ";
    public static final String NHẬP_TÊN_GROUP = "Nhập tên group";
    public static final String NHẬP_SỐ_ĐIỆN_THOẠI = "Nhập số điện thoại";
    Scanner scanner = new Scanner(System.in);
    List<PhoneBook> phoneBookList = new ArrayList<>();
    private long phone;
    private String group;
    private String name;
    private String address;
    private String email;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String COMMA_DELIMITER = ",";

    public ManagerPhoneBook() {
        phoneBookList.add(new PhoneBook(167423443, "công dân thâm niên", "Nguyễn Văn A", "Nam", "số 8 Lý Thường Kiệt"));
        phoneBookList.add(new PhoneBook(122322335, "teenager", "Nguyễn Văn B", "Nam", " số 1 Đống Đa"));
        phoneBookList.add(new PhoneBook(121121549, "người già", "Trần Mai", "Nữ", "số 4 Hoàn kiếm "));
        phoneBookList.add(new PhoneBook(123909940, "Baby", "Nguễn Hoa", "Nữ", "số 5 Nguyễn Khánh Toàn"));
        phoneBookList.add(new PhoneBook(128834309, "senior", "Trần Nam", "Nam", "số 1 Cầu Giấy"));
        phoneBookList.add(new PhoneBook(1212132325,"người ","Trần Anh","nam","số 1 TRần Phú"));

    }
    int count = 0;
    public  void show(){
        for (int i =0 ;i<2;i++){
            if (count < phoneBookList.size()) {
                System.out.println(phoneBookList.get(count));
                count++;
            }

        }

    }

    public void showDisplay() {
        do{
            show();
        }while (scanner.nextLine() != null);

    }

    public boolean checkEmail() {
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        if (email.matches(EMAIL_REGEX)){
           return true;
        } else {
            System.out.println("nhập lại");
            return false;
        }
    }

    public void getInfo() {
        System.out.println(NHẬP_SỐ_ĐIỆN_THOẠI);
        phone = scanner.nextLong();
        System.out.println(NHẬP_TÊN_GROUP);
        group = scanner.nextLine();
        System.out.println(NHẬP_TÊN_);
        name = scanner.nextLine();
        System.out.println(NHẬP_ĐIỆN_CHỈ);
        address = scanner.nextLine();
        System.out.println(NHẬP_ĐIỆN_CHỈ_EMAIL);
        email = scanner.nextLine();
    }

    public PhoneBook addInfo() {
        getInfo();
        PhoneBook phoneBook = new PhoneBook(phone, group, name, address, email);
        phoneBookList.add(phoneBook);
        return phoneBook;
    }

    public int findPhoneNumber(long input) {
        int index = -1;
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumber() == (input)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println(KHÔNG_TÌM_THẤY_SỐ_ĐIỆN_THOẠI);
        }
        return index;
    }

    public void chagePhone(long input) {
        int index = findPhoneNumber(input);
        if (index != -1) {
            phoneBookList.set(index, addInfo());
            System.out.println(DANH_SÁCH_SAU_KHI_SỬA);
            showDisplay();
        }
    }

    public void removePhoneNumber(long input) {
        int index = findPhoneNumber(input);
        if (index != -1) {
            System.out.println("Nhập Phím Y để xóa");
            String y = scanner.nextLine();
            if(y.equals("Y")){
                phoneBookList.remove(index);
                System.out.println(DANH_SÁCH_SAU_KHI_XÓA);
                showDisplay();
            }
            }
    }
    public void findName(String input) {
        int index = -1;
        for (PhoneBook list : phoneBookList) {
            if (list.getName().equals(input)) {
                System.out.println(list.getName().equals(input));
                index = 1;
            }
        }
        if (index == -1) {
            System.out.println(KHÔNG_TÌM_THẤY_TÊN);
        }
    }
public void csvRead(){

}

    public void csvSave(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("data/contacts.csv");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneBookList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


