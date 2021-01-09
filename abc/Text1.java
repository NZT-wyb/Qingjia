package abc;
class Chang{
    private int length;
    private int width;
    public void show(){
        System.out.println("长方形长为："+getLength()+"长方形宽为："+getWidth());
    }
    public int getLength(){
        return length;
    }

    public void setLength(int n) {
        this.length = n;
    }
    public  int getWidth(){
        return width;
    }

    public void setWidth(int m) {
        this.width = m;
    }
}
public class Text1 {
    public static void main(String[] args) {
        Chang per=new Chang();
        per.setLength(20);
        per.setWidth(40);
        per.show();
        int area=Area(20,40);
        int perimeter=Perimeter(20,40);
        System.out.println("长方形面积为："+area+"长方形周长为："+perimeter);
    }
    public static int Area(int n,int m){
        int t=n*m;
        return t;
    }
    public static int Perimeter (int n,int m){
        int t=2*n+2*m;
        return t;
    }
}
