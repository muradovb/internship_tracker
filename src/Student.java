import java.sql.Date;

/**
 * Created by bmmuradov on 28/11/2018.
 */
public class Student {
    //properties
    private String s_id;
    private String s_name;
    private Date b_date;
    private String tel_no;
    private String s_city;
    private String year;
    private float gpa;

    //constructor
    public Student (String s_id, String s_name, Date b_date, String tel_no, String s_city, String year, float gpa) {
        this.s_id=s_id;
        this.s_name=s_name;
        this.b_date=b_date;
        this.tel_no=tel_no;
        this.s_city=s_city;
        this.year=year;
        this.gpa=gpa;
    }

    //methods
    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Date getB_date() {
        return b_date;
    }

    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getS_city() {
        return s_city;
    }

    public void setS_city(String s_city) {
        this.s_city = s_city;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }


}
