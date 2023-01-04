import javax.persistence.Embeddable;

@Embeddable
public class FullName {
    private String fname;
    private String lname;
    private String mname;

    public FullName(String fname, String lname, String mname) {
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
    }

    public FullName() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        if (mname == null)
            return fname + " " + lname;
        else
            return fname + " " + mname + " " + lname;

    }
}
