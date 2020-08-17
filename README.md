# StudentTeamCollection
Task to create efficient data structure for teams of students and individual student data

This task was an exam set by my university and has been put on here with the permission of the lecturer. I received full marks for my submission. 

You are asked to design and implement a solution for a lecturer for managing team projects for their class. A Student class is already available, which stores, for each student, the ID number, last name and ﬁrst name. It has a toString method and implements the Comparable interface for comparing students by their last name-ﬁrst name combination. The class also has a ﬁeld for storing the team name for each student, which is a string unique to the team. 

You need to deﬁne a class Teams in which the information pertaining to each team can be stored. It should store at a minimum the students who are members of the team. It should be extensible so that, in future, other information can be added such as the team supervisor, meeting schedules, marks etc. Frequent operations include updating information about individual teams, and tabulating all teams in an alphabetical order. Describe what data structure you would use to store the teams and discuss its eﬃciency considerations.  

Deﬁne the Teams class along with: 
• a constructor that takes an array of Student objects. 
• methods to add and delete students. 
• a print method that prints all the teams along with their members in the format team : 
        member 1, member 2, ... 
  where the teams as well as members appear in sorted order.
