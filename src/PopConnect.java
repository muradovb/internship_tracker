import java.sql.*;
import java.util.ArrayList;


/**
 * Created by bmmuradov on 28/11/2018.
 */
//populates the tables; if not created, creates them.
public class PopConnect {

    //properties
    ArrayList<Apply> apply_list;
    ArrayList<Student> student_list;
    ArrayList<Company> company_list;


    //constructor
    public PopConnect(ArrayList <Apply> apply_list, ArrayList<Student> student_list, ArrayList<Company> company_list) {
        this.apply_list=apply_list;
        this.company_list=company_list;
        this.student_list=student_list;
    }



    //methods

    //creates tables when they don't exist
    public void createTables() {
        try {

            //get connection to db
            Connection connection = getConnection();

            //statement for student table creation
            PreparedStatement create_student = connection.prepareStatement("CREATE TABLE IF NOT EXISTS student(sid CHAR(12) NOT NULL, " +
                                                                                                            "sname VARCHAR(50), " +
                                                                                                            "bdate DATE, " +
                                                                                                            "telno CHAR(10), " +
                                                                                                            "scity VARCHAR(20), " +
                                                                                                            "year CHAR(20), " +
                                                                                                            "gpa FLOAT, " +
                                                                                                            "PRIMARY KEY(sid))" );
            //statement for company table creation
            PreparedStatement create_company = connection.prepareStatement("CREATE TABLE IF NOT EXISTS company(cid CHAR(12) NOT NULL, " +
                                                                                                            "cname VARCHAR(20), "+
                                                                                                            "quota INT, " +
                                                                                                            "PRIMARY KEY(cid))");
            //statement for apply table creation
            PreparedStatement create_apply = connection.prepareStatement("CREATE TABLE IF NOT EXISTS apply(" +
                                                                                                        "sid CHAR(12) NOT NULL, "+
                                                                                                        "cid CHAR(12) NOT NULL, " +
                                                                                                        //"PRIMARY KEY(sid, cid), "+
                                                                                                        "FOREIGN KEY(sid) " +
                                                                                                        "references student(sid), " +
                                                                                                        "FOREIGN KEY(cid) " +
                                                                                                        "references company(cid))");
            //statements to drop each table in case they exist
            PreparedStatement drop_student = connection.prepareStatement("DROP TABLE IF EXISTS student");
            PreparedStatement drop_company = connection.prepareStatement("DROP TABLE IF EXISTS company");
            PreparedStatement drop_apply = connection.prepareStatement("DROP TABLE IF EXISTS apply");

            //execute the statements

            //drop tables if they exist
            drop_apply.execute();
            drop_student.execute();
            drop_company.execute();
            //(re)create them
            create_company.execute();
            create_student.execute();
            create_apply.execute();
        }
        catch (Exception e) {
            //print the exception
            System.out.println(e);
        }

    }//end of createTables

    //establishes connection to the db
    public static Connection getConnection() throws Exception {
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://dijkstra.ug.bcc.bilkent.edu.tr/bayram_muradov";
            String username="bayram.muradov";
            String password="s2YadJ5B";
            Class.forName(driver);
            Connection connection =DriverManager.getConnection(url, username, password);
            System.out.println("getConnection() status: connected");
            return  connection;
        }
        catch (Exception e) {
            //print status
            System.out.println("getConnection() status: failed to connect");
            //print the exception
            System.out.println(e);
        }
        return null;  //r.v for failed
    }//end of getConnection

    //populates the tables in db
    public void populateTables() {
        try {
            Connection connection;
            connection = getConnection();

            //populating STUDENT table

            int sz_students = student_list.size(); //size of entries in student tbl.
            for (int i = 0; i < sz_students; i++) {
                //attribute values
                String sid = student_list.get(i).getS_id();
                String sname = student_list.get(i).getS_name();
                Date bdate = student_list.get(i).getB_date();
                String telno = student_list.get(i).getTel_no();
                String scity = student_list.get(i).getS_city();
                String year = student_list.get(i).getYear();
                float gpa = student_list.get(i).getGpa();

                //prepared insert->student query
                String query = "INSERT INTO student(sid, sname, bdate, telno, scity, year, gpa) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?)";

                // create the mysql insert prepared statement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, sid);
                preparedStmt.setString (2, sname);
                preparedStmt.setDate   (3, bdate);
                preparedStmt.setString (4, telno);
                preparedStmt.setString (5, scity);
                preparedStmt.setString (6, year);
                preparedStmt.setFloat  (7, gpa);

                //execute prep. statement
                preparedStmt.execute();
            }

            //populating COMPANY table

            int sz_companies = company_list.size(); //size of entries in company tbl.
            for (int i = 0; i < sz_companies; i++) {
                //attribute values
                String cid = company_list.get(i).getC_id();
                String cname =company_list.get(i).getC_name();
                int quota = company_list.get(i).getQuota();

                //prepared insert->company query
                String query = "INSERT INTO company(cid, cname, quota) "
                        + "VALUES(?, ?, ?)";

                // create the mysql insert prepared statement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, cid);
                preparedStmt.setString (2, cname);
                preparedStmt.setInt    (3, quota);

                //execute prep. statement
                preparedStmt.execute();


            }


            //populating APPLY table

            int sz_apply = apply_list.size(); //size of entries in apply tbl.
            for (int i = 0; i < sz_apply; i++) {
                //attribute values
                String sid =apply_list.get(i).getS_id();
                String cid = apply_list.get(i).getC_id();

                //prepared insert->company query
                String query = "INSERT INTO apply(sid, cid) "
                             + "VALUES(?, ?)";

                // create the mysql insert prepared statement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, sid);
                preparedStmt.setString (2, cid);

                //execute prep. statement
                preparedStmt.execute();

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }//end of populateTables



}//end of class
