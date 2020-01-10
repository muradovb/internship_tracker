
/**
 * Created by bmmuradov on 28/11/2018.
 */
public class Apply {


    //properties
    private String s_id;
    private String c_id;

    //constructor
    public Apply(String s_id, String c_id) {
        this.s_id = s_id;
        this.c_id = c_id;
    }


    //methods
    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
}
