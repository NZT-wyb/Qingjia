package abc;
 abstract class Person{

    private int id;

    private String name;

    private String sex;

    private int birthday;

    public static String nationality;

    public Person() {}

    public Person(int id,String name,String sex,int birthday,String nationality ) {
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.birthday=birthday;
        this.nationality=nationality;
    }

    public String saying(Person per,String msg) {
        return "说了一句话";
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + "]";
    }
    public abstract String working(String infomation);
}
class Student extends Person {
    private int studentid;
    private String classname;
    private int score;
    public static String schoolname;
    public Student() {}
    public Student(int id, String name, String sex, int birthday, String nationality, int studentid, String classname, int score, String schoolname) {
        super(id, name, sex, birthday, nationality);
        this.studentid = studentid;
        this.classname = classname;
        this.score = score;
        this.schoolname = schoolname;
    }

    @Override
    public String toString() {
        return "Student:" +
                ", classname='" + classname + '\'' +
                ", score=" + score +" "+super.toString();

    }

    public String takeLesson(String course){
        return "选修了"+course+"课";
    }
    public String working(String infomation){
        return "正在学习"+infomation;
    }
}
class Teacher extends Person{
    private int teacherid;
    private String department;
    private int salary;
    public static String schoolName;
    public Teacher(){}
    public Teacher(int teacherid,String department,int salary,String schoolName){
        this.department=department;
        this.teacherid=teacherid;
        this.salary=salary;
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherid=" + teacherid +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
    public String teaching(Student student,String course){
        return "教"+student+course;
    }
    public  String working(String infomation){
        return "老师正在准备"+infomation+"课程";
    }
}
public class Text2 {
    public static void main(String[] args) {
        Student stu=new Student(430,"王益斌","男",20010330,"中国",2019401284,"软件工程导论",95,"吉首大学");
        Teacher tec=new Teacher(001,"体育",3500,"吉首大学");
        System.out.println(tec.working("体育"));
        System.out.println(stu.toString());
        System.out.println(tec.toString());
    }
}



