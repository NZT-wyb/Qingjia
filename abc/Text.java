package abc;
class Book{
    private String bookname;
    private String outname;
    private String writename;
    private int price;
    private int page;
    public Book(String bookname,String outname,String writename){
        this.setBookname(bookname);
        this.setOutname(outname);
        this.setWritename(writename);
    }
    public String getBookname(){
        return bookname;
    }
    public void setBookname(String n){
        this.bookname=n;
    }
    public String getOutname(){
        return outname;
    }
    public void setOutname(String n){
        this.outname=n;
    }
    public String getWritename(){
        return writename;
    }
    public void setWritename(String n){
        this.writename=n;
    }
    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public void show(){
        System.out.println("书名："+getBookname()+'\n'+"出版社："+getOutname());
        System.out.println("------作者------"+'\n'+getWritename());
        System.out.println("页数："+getPage());
        System.out.println("价格："+getPrice());
        System.out.println("****************");
    }
}


public class Text {
    public static  void main(String[]args){
        Book per1=new Book("白夜行","日本和田出版","东野圭吾");
        Book per2=new Book("黑夜","日本憨憨出版","村上村树");
        Book per3=new Book("国境以南 太阳以西","中国裂开出版","村上春树");
        per1.setPage(1000);
        per1.setPrice(68);
        per1.show();
        per2.setPage(1500);
        per2.setPrice(65);
        per2.show();
        per3.setPage(1200);
        per3.setPrice(50);
        per3.show();
    }

}
