package beans;

public class QuanBai {
    private String name;
    private int point;
    private int exp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public QuanBai(String name, int point, int exp) {
        super();
        this.name = name;
        this.point = point;
        this.exp = exp;
    }

    public QuanBai(){
        super();
    }

    @Override
    public String toString() {
        if (this.name.length() >= 8) {
            return this.name + "\t" + this.point + "\t" + this.exp;
        }
        else {
            return this.name + "\t\t" + this.point + "\t" + this.exp;
        }
    }
}
