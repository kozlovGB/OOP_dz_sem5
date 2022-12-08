package OOP_dz_sem5.service.data;

public class User {
    private String fname;
    private String sname;
    private String number;
    public User(String fname,String sname, String number) {
        this.fname = fname;

        this.sname = sname;
        this.number = number;
    }

    public String getFirstName() {
        return fname;
    }

    public void setFirstName(String fname) {
        this.fname = fname;
    }

    public String getSecondName() {
        return sname;
    }

    public void setSecondName(String sname) {
        this.sname = sname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void rename(String newName){
        this.sname = newName;
    }

    public void changeNumber(String newNumber) {
        this.number = newNumber;
    }

    @Override
    public String toString() {
        return  "fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", number='" + number + '\'';
    }
}