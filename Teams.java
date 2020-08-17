import java.util.*;

/**
 * This is the Teams program to define a Teams object, which is a TreeMap data structure that takes an array of students
 * to store their information and organise them by team name
 *
 * A number of decisions were made about the implementation of this data structure
 *
 * Firstly, a TreeMap implementation was picked to organise the teams as it would be easy to order the data by
 * team name. The key for the map is the teamname and each key will have teamInfo object that will contain all
 * the information relating to that specific team
 *
 * The tree map allows for O(log(n)) time complexity for get, remove, and put operations.
 * Which is much faster than any list operation operating typically O(n) time complexity.
 * The teams data will have to be printed out in sorted order so a
 * treemap was chosen over a hashmap (that has O(1) look up times)
 * because the complexity cost of extracting the contents of a hashmap and then
 * sorting it for printing in alphabetical order (which would be O((n^2)log(n)) time complexity),
 * far outweighed the other benefits of a hashmap.
 *
 * Therefore, because treemap is relatively fast across all necessary operations and retains a natural order,
 * it was selected to organise the teams  data.
 *
 * Additionally, we were not told the size of the data sets that we would be dealing with. If the class was online then
 * there is no limit to the number of students that are in the data set. Therefore, a Hashmap or HashTable would be even
 * more inappopriate as those implementations are incredible space inefficient and can lead to
 * collisions if not handled properly.
 *
 * To summarise, lookup, removing, and adding elements are all done in O(log(n)) time complexity for tree map
 * Printing all the elements is also done in linear time as the map is naturally ordered
 * Furthermore, the map is more space efficient than other Hash-based implementations
 *
 *
 *
 * ___________
 *
 * In order to make the data structure extensible and allow for other information relating to the teams to be added
 * at a later date, each key value is a TeamInfo object. This object currently only holds the information for
 * the collections of students for each team. However, by adding additional variables to the constructor and making
 * getter and setter methods for said variables, it is easy to add information such as Team Supervisor, marks, and
 * schedules. And also storing this information in an object will not affect the time complexity when accessing the
 * information from the treemap.
 *
 * ___________
 *
 * For the collection of students under each teamname, they had to be stored as an arraylist as
 * this was the only collection that would allow duplicate values
 *
 * Unfortunately, due to the implementation of the comparator in student (as stated in the question),
 * any students with the same names are treated as duplicate objects.
 * Therefore, any Sets would not work as you would overwrite data entries if students had the same name.
 *
 * Technically, a map COULD have stored duplicate values but it would have been too complicated to create a
 * unique key for each student and keep the collection sorted by Student names and NOT by the key.
 * Therefore, an arraylist seemed to be the easiest option as students could be easily added
 * and the arraylist can be sorted with O(nlog(n)) complexity every time a student is added.
 *
 * Therefore, adding an element to the list has O(nlog(n)) complexity
 * but printing the list, removing students from the list, or searching for students are all done in linear time
 * Plus there is no risk of losing student data
 *
 * In this scenario, data integrity far outweighs the need for slightly improved performance.
 *
 *
 *
 */
public class Teams {
    /**
     * this is the array of students that will be provided
     */
    private Student[] allStudents;
    /**
     * this is the tree map that will store all the student teams data
     */
    private TreeMap<String, TeamInfo> map;

    /**
     * constructor for the teams object
     *
     * once array of students is given, then map is created using createMap() method
     *
     * @param allStudents = array of students
     */
    public Teams(Student[] allStudents){
        this.allStudents = allStudents;
        this.map = createMap();
    }

    /**
     * method that reads the array of students fed into the constructor and stores the data in a treemap
     * @return a treemap of students, the key is teamnames, and the values is a TeamInfo object
     */
    public TreeMap<String, TeamInfo> createMap(){

        // first declare new TreeMap
        TreeMap<String, TeamInfo> map = new TreeMap<>();

        // initialise empty string value for teamname
        String teamName = "";
        // for loop over array of students given in constructor
        for(Student stud : this.allStudents){

            // read the teamname of every student
            teamName = stud.getTeamName();

            // if that team is already in the map
            if(map.containsKey(teamName)){
                // add this student to the list in the TeamInfo object
                // the add method in the TeamInfo class sorts the list after insertion
                map.get(teamName).add(stud);



            } else{
                // if that team hasn't been added yet, add the team with the student
                ArrayList<Student> list = new ArrayList<Student>();
                list.add(stud);

                TeamInfo team = new TeamInfo(list);

                map.put(teamName, team);
            }
        }
        // finally return completed map
        return map;
    }

    /**
     * method to add a student to the map
     * @param s1 = student object that you want to add to the map
     */
    public void add(Student s1){
        // created local variable for teamname to make code easier to read
        String teamName = s1.getTeamName();

        // if map already contains this team
        if(this.map.containsKey(teamName)){

            // add student to the list of members in that teaminfo object
            this.map.get(teamName).add(s1);


        } else{
            // if team isn't int the map then add them to the map along with the student
            ArrayList<Student> list = new ArrayList<Student>();
            list.add(s1);
            TeamInfo team = new TeamInfo(list);

            this.map.put(teamName, team);

        }

    }


    /**
     * method to delete student from the treemap
     * @param s1 = student object that is to be deleted from the treemap
     */
    public void delete(Student s1){

        this.map.get(s1.getTeamName()).remove(s1);

        // if that team now has no members then remove team from treemap
        if(this.map.get(s1.getTeamName()).getStudentList().isEmpty()){
            this.map.remove(s1.getTeamName());
        }

    }

    /**
     * this is the print method that will print out the teams and students in order
     *
     * The exact format for this method was based on the example given in the question:
     *
     * "Team Name: Member 1, Member 2, ......"
     *
     * The member data has been printed out as "Name (student ID)"
     *
     * This is for readability and so that members with the same name are not confused
     *
     */
    public void print(){
        // first create entryset from treemap
        Set<Map.Entry<String, TeamInfo>> entSet = this.map.entrySet();

        // then create string builder
        StringBuilder sb = new StringBuilder();

        // create iterator for entryset
        Iterator<Map.Entry<String, TeamInfo>> it = entSet.iterator();

        // initialise an entry item with null value
        Map.Entry<String, TeamInfo> item = null;

        // loop until there are no more items left in the entry set
        while(it.hasNext()){
            // variable is now next item
            item = it.next();

            // append the team name and list of the team members using list2string method
            sb.append(item.getKey() + ": " + list2String(item.getValue().getStudentList()));

            // if there's another team left in the entry set then add a line break
            if(it.hasNext()){
                sb.append("\n");
            }
        }
        // once done print out the string
        System.out.println(sb.toString());

    }

    /**
     * this method is used to convert the list of members into a format where it prints:
     *
     * "element, element, element"
     *
     * this is used for the print() method
     *
     * @param studList = list of students that will be converted into the desired string format
     * @return returns the students in the list in a suitable string format
     */
    public String list2String(ArrayList<Student> studList){
        // create string builder
        StringBuilder sb = new StringBuilder();

        // create iterator for list
        Iterator<Student> it = studList.iterator();
        Student s1 = null;

        // loop over all elements in the list
        while(it.hasNext()){

            s1 = it.next();
            // append element to string builder
            sb.append(s1.toString());

            // if there is another element in the list then add a space and a comma
            if(it.hasNext()){
                sb.append(", ");
            }
        }
        // once done then return the string
        return sb.toString();
    }

    public static void main(String[] args){
        Student s1 = new Student(123, "Irving", "Ben", "Aardvark");
        Student s2 = new Student(124, "James", "Duncan", "Aardvark");
        Student s3 = new Student(125, "Charles", "Russel", "Russia");
        Student s4 = new Student(126, "Rasputin", "RahRah", "Zimbabwe");
        Student s5 = new Student(127, "Aardvark", "Chocolate", "Russia");

        Teams t1 = new Teams(new Student[]{s1, s2, s3 ,s4});

        t1.print();
        System.out.println("\n");

        t1.add(s5);
        System.out.println("\n");
        t1.print();
        System.out.println("\n");
        t1.delete(s2);
        t1.print();
        System.out.println("\n");
        t1.delete(s1);
        t1.print();


    }



}
