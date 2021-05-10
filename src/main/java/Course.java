public class Course {
    private int  cID;
    private String cName,cInstructorName;

    public Course(int cID, String cName, String cInstructorName) {
        this.cID = cID;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}
