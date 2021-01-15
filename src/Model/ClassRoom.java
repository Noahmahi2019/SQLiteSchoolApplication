package Model;

public class ClassRoom {
      private int _id;
      private String classroomName;
       private int primaryTeacher;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public int getPrimaryTeacher() {
        return primaryTeacher;
    }

    public void setPrimaryTeacher(int primaryTeacher) {
        this.primaryTeacher = primaryTeacher;
    }
}
