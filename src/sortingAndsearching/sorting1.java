package sortingAndsearching;
//Given a list of student information: ID, FirstName, and CGPA. 
//Your task is to rearrange them according to their CGPA in decreasing order. 
//If two student have the same CGPA, then arrange them according to their first name in alphabetical order.
// If those two students also have the same first name, then order them according to their ID. 
import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class sorting1 {
    public static void main(String[] args){		
		List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student(33, "Rumpa", 3.68));
        studentList.add(new Student(85, "Ashis", 3.85));
        studentList.add(new Student(56, "Samiha", 3.75));
        studentList.add(new Student(19, "Samara", 3.75));
        studentList.add(new Student(22, "Fahim", 3.76));
		
        //Collection.sort(studentList.getCgpa());
        Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed()
                .thenComparing(Student::getFname)
                .thenComparing(Student::getId));
    
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
