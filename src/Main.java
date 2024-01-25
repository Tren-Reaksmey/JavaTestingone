
public class Main {
    public static void main(String[] args) {
        Student obj= new Student("Reaksmey","PhnomPenh",5);
        try{
            obj.addCourseGrade("Java",100);
            obj.addCourseGrade("Network",90);
            obj.addCourseGrade("C#",95);
            obj.addCourseGrade("STA",97);
            obj.addCourseGrade("ISAD",93);
            obj.addCourseGrade("CPP",89);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error"+e.getMessage());
        }
        System.out.println("=======================");
        obj.printinfo();

    }
}