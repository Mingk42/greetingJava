package shop.samdul.hellojava;

public class People {
    int num;
    String name;

    public People(int num, String name) {
        this.num = num;
        this.name = capitalize(name);
    }

    public void setNum(int num) {
        this.num = num;
    }
    public void setName(String name) {
        this.name = capitalize(name);
    }
    public int getNum() {
        return num;
    }
    public String getName() {
        return name;
    }

    public String capitalize(String str) {
        String tmp;

        tmp=str.substring(0,1).toUpperCase();
        tmp+=str.substring(1).toLowerCase();

        return tmp;
    }
}
