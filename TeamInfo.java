import java.util.ArrayList;
import java.util.Collections;

/**
 * object for storing the info of each individual team
 */
public class TeamInfo {
    /**
     * arraylist of students
     */
    private ArrayList<Student> studentList;



    /**
     * constructor for TeamInfo Object
     * @param studentList
     */
    public TeamInfo(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * getter for arraylist of students
     * @return returns arraylist of students
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * setter for arraylist of students
     * @param studentList
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * this method is called to add a student to the Arraylist of students in the Teaminfo object
     * @param s1 = student that will be added to this.studentList
     */
    public void add(Student s1){
        // add student object to list
        this.studentList.add(s1);
        // then sort list
        Collections.sort(this.studentList);
    }

    /**
     * this method will remove a student object from this.studentList
     * @param s1 = student object that will be removed from the studentList
     */
    public void remove(Student s1){
        this.studentList.remove(s1);
    }

}
