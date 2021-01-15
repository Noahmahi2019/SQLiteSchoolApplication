import Model.ClassRoom;
import Model.Datasource;
import Model.Student;
import Model.Teacher;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("can't open datasource.");
            return;
        }
        for (ClassRoom classRoom : datasource.queryClassrooms()) {
            System.out.println("ID: " + classRoom.get_id() + "\tName: " + classRoom.getClassroomName());


            for (Teacher teacher : datasource.queryTeachers()) {
                System.out.println("ID: " + teacher.get_id() + "\tfirstName: " + teacher.getFirstName()
                        + "\tLastName: " + teacher.getLastName() + "\tclassroom: " + teacher.getClassroom());


                for (Student student : datasource.queryStudents()) {
                    System.out.println("ID: " + student.get_id() + "\tfirstName: " + student.getFirstName()
                            + "\tLastName:: " + student.getLastName() + "\tclassroom: " + student.getClassroom());
                }
            }
        }
    }

}