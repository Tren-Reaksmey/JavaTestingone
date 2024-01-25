

public class Student extends Person{
    private int numcourse;

    public int getNumcourse() {
        return numcourse;
    }

    public void setNumcourse(int numcourse) {
        this.numcourse = numcourse;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public int[] getGrade() {
        return Grade;
    }

    public void setGrade(int[] grade) {
        Grade = grade;
    }

    private String []course;
    private int []Grade;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

    public Student(String name, String Address, int numcourse) {
        super(name, Address);
        this.numcourse= numcourse;
        this.course=new String[numcourse];
        this.Grade=new int[numcourse];
        this.count=0;

    }

    public void addCourseGrade(String course,int Grade){
       if(count<numcourse) {
           this.course[count] = course;
           this.Grade[count]=Grade;
           count++;
       }else{
           System.out.println("Overflow Array");
       }
    }
    public void printinfo(){
         System.out.println("Course and Grade");
         for(int i=0;i<count;i++){
             System.out.println(course[i]+"  and  "+Grade[i]);
         }
    }
}
