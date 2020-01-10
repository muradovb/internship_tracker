import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by bmmuradov on 28/11/2018.
 */

//initiates datas& executes main
public class ExecMain {

    //main method
    public static void main(String[] args) {

        //initiate attribute lists
        initAttrLists();

        //initiate table lists
        initTableLists();

        //start
        pcon=new PopConnect(apply_list, student_list, company_list);
        pcon.createTables();
        pcon.populateTables();

    }



    //properties
    static PopConnect pcon;
    //attribute lists
    static ArrayList<String> sids; //keeps student ids
    static ArrayList<String> snames; //keeps student names
    static ArrayList<Date> bdates; //keeps birthday dates
    static ArrayList<String> telnos; //keeps phone numbers
    static ArrayList<String> cities; //keeps cities
    static ArrayList<String> years; //keeps years
    static ArrayList<Float> gpas; //keeps gpas
    static ArrayList<String> cids; //keeps company ids
    static ArrayList<String> cnames; //keeps company names
    static ArrayList<Integer> quotas; //keeps company quotas
    static ArrayList<String> sids_app; //keeps student ids in appy
    static ArrayList<String> cids_app; //keeps student names in apply
    //table lists
    static ArrayList<Apply> apply_list;
    static ArrayList<Student> student_list;
    static ArrayList<Company> company_list;
    //tuple counts in each table
    private static final int s_count = 4;
    private static final int c_count = 7;
    private static final int ap_count = 8;


    //initiates the table lists
    private static void initTableLists() {

        //initiate lists
        apply_list = new ArrayList<Apply>();
        student_list = new ArrayList<Student>();
        company_list = new ArrayList<Company>();

        //fill the lists

        //students
        for (int i=0; i<s_count;i++) {
            Student temp_std = new Student(sids.get(i), snames.get(i), bdates.get(i), telnos.get(i),
                                            cities.get(i), years.get(i), gpas.get(i));
            student_list.add(temp_std);
        }

        //companies
        for(int i=0; i<c_count; i++) {
            Company temp_cmp = new Company(cids.get(i), cnames.get(i), quotas.get(i));
            company_list.add(temp_cmp);
        }

        //applications
        for (int i=0; i<ap_count; i++) {
            Apply app = new Apply(sids_app.get(i), cids_app.get(i));
            apply_list.add(app);
        }

    }

    //initiates each attribute column
    private static void initAttrLists() {
        //init the attribute lists
        sids = new ArrayList<String>(); //keeps student ids
        snames=new ArrayList<String>(); //keeps student names
        bdates=new ArrayList<Date>(); //keeps birthday dates
        telnos=new ArrayList<String>(); //keeps phone numbers
        cities=new ArrayList<String>(); //keeps cities
        years=new ArrayList<String>(); //keeps years
        gpas=new ArrayList<Float>(); //keeps gpas
        cids=new ArrayList<String>(); //keeps company ids
        cnames=new ArrayList<String>(); //keeps company names
        quotas=new ArrayList<Integer>(); //keeps company quotas
        sids_app=new ArrayList<String>(); //keeps student ids in appy
        cids_app=new ArrayList<String>(); //keeps student names in apply

        //fill in the student datas
        sids.add("21000001");
        sids.add("21000002");
        sids.add("21000003");
        sids.add("21000004");

        snames.add("Ayse");
        snames.add("Ali");
        snames.add("Veli");
        snames.add("John");

        String str1="1995-05-10";
        Date date1=Date.valueOf(str1);//converting string into sql date
        bdates.add(date1);
        String str2="1997-05-10";
        Date date2=Date.valueOf(str2);//converting string into sql date
        bdates.add(date2);
        String str3="1998-10-25";
        Date date3=Date.valueOf(str3);//converting string into sql date
        bdates.add(date3);
        String str4="1999-01-15";
        Date date4=Date.valueOf(str4);//converting string into sql date
        bdates.add(date4);

        telnos.add("5321113333");
        telnos.add("5355361234");
        telnos.add("5553214455");
        telnos.add("5335336622");

        cities.add("Ankara");
        cities.add("Istanbul");
        cities.add("Istanbul");
        cities.add("Chicago");

        years.add("senior");
        years.add("junior");
        years.add("freshman");
        years.add("freshman");

        gpas.add((float) 2.75);
        gpas.add((float) 3.44);
        gpas.add((float) 2.36);
        gpas.add((float) 2.55);

        //fill in company datas
        cids.add("C101");
        cids.add("C102");
        cids.add("C103");
        cids.add("C104");
        cids.add("C105");
        cids.add("C106");
        cids.add("C107");

        cnames.add("tubitak");
        cnames.add("aselsan");
        cnames.add("havelsan");
        cnames.add("microsoft");
        cnames.add("merkez bankasi");
        cnames.add("tai");
        cnames.add("milsoft");

        quotas.add(2);
        quotas.add(5);
        quotas.add(3);
        quotas.add(5);
        quotas.add(3);
        quotas.add(4);
        quotas.add(2);

        //fill in apply datas
        cids_app.add("C101");
        cids_app.add("C102");
        cids_app.add("C103");
        cids_app.add("C101");
        cids_app.add("C105");
        cids_app.add("C104");
        cids_app.add("C105");
        cids_app.add("C107");

        sids_app.add("21000001");
        sids_app.add("21000001");
        sids_app.add("21000001");
        sids_app.add("21000002");
        sids_app.add("21000002");
        sids_app.add("21000003");
        sids_app.add("21000003");
        sids_app.add("21000004");

    }


}




