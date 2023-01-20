package JDBCSorusu.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final String mysqlDriver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/sirket_calisan?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false";
    private final String userName="root";
    private final String userPass="vzznqrdqk4";
    public Connection connection=null;
    public DB(){
        try{
            Class.forName(mysqlDriver);
            connection= DriverManager.getConnection(url,userName,userPass);
            if(!connection.isClosed()){
                System.out.println("Connection success");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
