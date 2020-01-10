/**
 * Created by bmmuradov on 28/11/2018.
 */

public class Company {

    //properties
    private String c_id;
    private String c_name;
    int quota;

    //constructor
    public Company(String c_id, String c_name, int quota) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.quota = quota;
    }

    //methods
    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

}
