package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "database.db";
    public static final String DB_PATH = "Jdbc:sqlite:C:\\Users\\Noah\\repos\\SQLiteSchoolApplication\\database.db";

    public static final String TABLE_CLASSROOMS = "classrooms";
    public static final String COLUMN_CLASSROOM_ID = "_id";
    public static final String COLUMN_CLASSROOM_NAME = "classroomName";
    public static final String COLUMN_CLASSROOM_TEACHER = "Teacher";

    public static final String TABLE_TEACHERS = "teachers";
    public static final String COLUMN_TEACHER_ID = "_id";
    public static final String COLUMN_TEACHER_FIRSTNAME = "firstName";
    public static final String COLUMN_TEACHER_LASTNAME = "lastName";
    public static final String COLUMN_TEACHER_CLASSROOM = "classroom";


    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_STUDENT_ID = "_id";
    public static final String COLUMN_STUDENT_FIRSTNAME = "firstName";
    public static final String COLUMN_STUDENT_LASTNAME = "lastName";
    public static final String COLUMN_STUDENT_CLASSROOM = "classroom";

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(DB_PATH);
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR connecting to db: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) ;
            conn.close();
        } catch (SQLException e) {
            System.out.println("ERROR closing connecting to db: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<ClassRoom> queryClassrooms() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CLASSROOMS)) {


            List<ClassRoom> classRooms = new ArrayList<>();

            while (results.next()) {
                ClassRoom classRoom = new ClassRoom();
                classRoom.set_id(results.getInt(COLUMN_CLASSROOM_ID));
                classRoom.setClassroomName(results.getString(COLUMN_CLASSROOM_NAME));
                classRoom.setPrimaryTeacher(results.getInt(COLUMN_CLASSROOM_TEACHER));
                classRooms.add(classRoom);
            }
            return classRooms;

        } catch (Exception e) {
            System.out.println("ERROR  classroom query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Teacher> queryTeachers() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_TEACHERS)) {


            List<Teacher> teachers = new ArrayList<>();

            while (results.next()) {
                Teacher teacher = new Teacher();
                teacher.set_id(results.getInt(COLUMN_TEACHER_ID));
                teacher.setFirstName(results.getString(COLUMN_TEACHER_FIRSTNAME));
                teacher.setLastName(results.getString(COLUMN_TEACHER_LASTNAME));
                teacher.setClassroom(results.getInt(COLUMN_TEACHER_CLASSROOM));
                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> queryStudents() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_STUDENTS)) {


            List<Student> students = new ArrayList<>();

            while (results.next()) {
                Student student = new Student();
                student.set_id(results.getInt(COLUMN_STUDENT_ID));
                student.setFirstName(results.getString(COLUMN_STUDENT_FIRSTNAME));
                student.setLastName(results.getString(COLUMN_STUDENT_LASTNAME));
                student.setClassroom(results.getInt(COLUMN_STUDENT_CLASSROOM));
                students.add(student);
            }
            return students;

        } catch (Exception e) {
            System.out.println("ERROR  classroom query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
