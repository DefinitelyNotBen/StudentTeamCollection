/**
 * class used for student object
 *
 * The class was given getters and setters for all attributes as this was considered necessary for a class in
 * order to access the attributes of the object
 *
 * In addition to idNumber, firstName and lastName, Team name was stored as a string attribute with associated getters and setters
 *
 *
 *
 */
public class Student implements Comparable<Student>{
    private int idNumber;
    private String lastName;
    private String firstName;
    private String teamName;

    /**
     * constructor for student object
     *
     * @param idNumber = integer value for id of student
     * @param lastName = last name of student
     * @param firstName = first name of student
     * @param teamName = name of team
     */
    public Student(int idNumber, String lastName, String firstName, String teamName) {
        this.idNumber = idNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.teamName = teamName;
    }

    /**
     * getter for id number
     * @return returns id number of student
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * setter for id number
     * @param idNumber = given integer to set as id number
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * getter for last name of student
     * @return returns last name of student as a string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter for last name of student
     * @param lastName = string value to set as last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter for first name of student
     * @return string value of students first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for first name of student
     * @param firstName = string value to set as first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for team name of student
     * @return string value of team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * setter for team name of student
     * @param teamName = string value to be set as team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * the compareTo method that was described in the exam question
     *
     * NOTE: Because the comparator only looks at the firstName and lastName of each student, any students
     * with the same first and last name will be perceived as duplicates even if they have different attributes like
     * id number.
     *
     * @param s1 = student object that will be compared to this student
     * @return 0 if the students are equal and either 1 or -1 depending on the natural order of the names
     */
    @Override
    public int compareTo(Student s1){
        // if the last names are the same then compare first names
        if(this.lastName.compareTo(s1.getLastName()) == 0){
            return this.firstName.compareTo(s1.getFirstName());
        }
        // otherwise just compare last names
        else return this.lastName.compareTo(s1.getLastName());

    }

    /**
     * toString method that will return the information of the student in string format
     *
     * because of the scenario, this was written with the Teams object in mind. Thereore, the teamname
     * was not deemed necessary to include in this as that information will be displayed anytime the
     * team treemap is printed.
     *
     * @return the information of the student in string format
     */
    @Override
    public String toString() {
        return  firstName + " " + lastName + " (" +
                "ID = " + idNumber +")";
    }


}
