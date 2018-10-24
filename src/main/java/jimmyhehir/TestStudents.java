package jimmyhehir;

import java.util.ArrayList;

public class TestStudents 
{

    public static void main( String[] args ) {
        Module EE443 = new Module("BE Project","EE443"); 
        Module CT417 = new Module("Software Engineering III", "CT417"); 
        Module CT475 = new Module("Machine Learning & Data Mining", "CT475");
        Module EE451 = new Module("System on Chip Design", "EE451"); 
        
        Course CS = new Course("Computer Science"); //1, 7
        Course ECE = new Course("Electronic & Computer Engineering"); // 3, 4, 5, 6, 8, 9
        Course EEE = new Course("Electrical and Electronic Engineering"); //0, 2
        
    	ArrayList<Student> allstudents = new ArrayList<Student>();
        allstudents = createlistofStudents(allstudents); 
        EE443.addStudent(allstudents.get(0)); EE443.addStudent(allstudents.get(2)); 
        EE443.addStudent(allstudents.get(3)); EE443.addStudent(allstudents.get(4)); 
        EE443.addStudent(allstudents.get(5)); EE443.addStudent(allstudents.get(6)); 
        EE443.addStudent(allstudents.get(8)); EE443.addStudent(allstudents.get(9)); 
        
        EE451.addStudent(allstudents.get(0)); EE451.addStudent(allstudents.get(2)); 
        EE451.addStudent(allstudents.get(3)); EE451.addStudent(allstudents.get(4)); 
        EE451.addStudent(allstudents.get(5)); EE451.addStudent(allstudents.get(6)); 
        EE451.addStudent(allstudents.get(8)); EE451.addStudent(allstudents.get(9)); 
        
        CT417.addStudent(allstudents.get(3)); CT417.addStudent(allstudents.get(4)); 
        CT417.addStudent(allstudents.get(5)); CT417.addStudent(allstudents.get(6)); 
        CT417.addStudent(allstudents.get(8)); CT417.addStudent(allstudents.get(9)); 
        CT417.addStudent(allstudents.get(1)); CT417.addStudent(allstudents.get(7)); 
        
        CT475.addStudent(allstudents.get(3)); CT475.addStudent(allstudents.get(4)); 
        CT475.addStudent(allstudents.get(5)); CT475.addStudent(allstudents.get(6)); 
        CT475.addStudent(allstudents.get(8)); CT475.addStudent(allstudents.get(9)); 
        CT475.addStudent(allstudents.get(1)); CT475.addStudent(allstudents.get(7));

        CS.addModule(CT475); CS.addModule(CT417); 
        ECE.addModule(EE451); ECE.addModule(CT475); ECE.addModule(CT417); ECE.addModule(EE443);
        EEE.addModule(EE451); EEE.addModule(EE443);
    	
        ArrayList<Course> allCourses = new ArrayList<Course>();
        allCourses.add(EEE); allCourses.add(ECE); allCourses.add(CS);
    	
        System.out.println("List of students: \n");
        
        ArrayList<Student> checkedStudents = new ArrayList<Student>(); 
        
    	for(Course course : allCourses) { 
    		for(Module module : course.listModules()) { 
    			for(Student student : module.listStudents()) { 
        			if(!checkedStudents.contains(student)) { 
        				checkedStudents.add(student); 
    				ArrayList<Module> listofmods  = new ArrayList<Module>(); 
    				for(Course cc : allCourses) {
    					for(Module mod : cc.listModules()){
    						if((mod.listStudents().contains(student)) && !(listofmods.contains(mod))) listofmods.add(mod);
    					}
    				}
    				if( listofmods.contains(EE443) && listofmods.contains(CT475) ) 
    					System.out.println(student.getUsername() + ": " + ECE.getName());
    				if( listofmods.contains(EE443) && !listofmods.contains(CT475) ) 
    					System.out.println(student.getUsername() + ": " + EEE.getName());
    				if( listofmods.contains(CT475) && !listofmods.contains(EE443) ) 
    					System.out.println(student.getUsername() + ": " + CS.getName());
    				for(Module m : listofmods) {
    					System.out.print(m.getName() + ". "); 
    					}
    				System.out.println("");
    				}
    				}
    			}
    		}
    }

	private static ArrayList<Student> createlistofStudents(ArrayList<Student> list) {
		list.add(new Student("Jimmy Hehir", 13, 9, 1995));
		list.add(new Student("Mac Macfold", 18, 06, 1997));
		list.add(new Student("Brendan Dunne", 5, 11, 1998));
		list.add(new Student("Jeff Dunham", 13, 9, 1998));
		list.add(new Student("John Corridon", 1, 12, 1996));
		list.add(new Student("Jack Barry", 4, 9, 1997));
		list.add(new Student("John Doe", 14, 05, 1994));	
		
		return list;
	}
}