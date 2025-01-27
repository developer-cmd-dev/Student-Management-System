public class Student {
    private String name;
    private int rollNo;
    private int age;
    private String stream;
    private String section;

    public Student(String name, int rollNo, int age, String stream, String section){
        this.name=name;
        this.rollNo = rollNo;
        this.age = age;
        this.stream = stream;
        this.section = section;
    }


    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }

    public String getStream() {
        return stream;
    }

    public String getSection() {
        return section;
    }
}
