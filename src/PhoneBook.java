public class PhoneBook {
private long phoneNumber;
private String group;
private String name;
private String sex;
private String address;
private String email;

    public PhoneBook(long phoneNumber, String group, String name, String sex, String address) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public PhoneBook(long phoneNumber, String group, String name, String sex, String address, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneNumber=" + phoneNumber +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
