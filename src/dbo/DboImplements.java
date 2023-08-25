package dbo;


import Therapy.Evaluations;

import java.sql.*;

public class DboImplements implements DBOHelper {

    private static final String CONNECTION_STRING ="jdbc:derby://localhost:1527/C:/Apache/db-derby-10.16.1.1-bin/db-derby-10.16.1.1-bin/bin/MentalHealthSwingDB";
    private static final String CLIENTDRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    public DboImplements() {
    }

    public int selectAll (String table, String columnName){
        try{
            DBOHelper.loadDriver(CLIENTDRIVER);
            Connection dbConn = DBOHelper.connect2DB(CONNECTION_STRING,USERNAME,PASSWORD);
            String selectAll = "Select * from "+ table;
            Statement stmt = dbConn.createStatement();
            String fields = "";
            ResultSet rs = stmt.executeQuery(selectAll);
            while(rs.next()){
                fields = rs.getString(columnName);
                System.out.println(fields);
            }
            if(fields.equals("")) {
                dbConn.close();
                stmt.close();
                rs.close();
                return 0;
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return 1;
    }

    public int insertInto (String table, Evaluations eval){
        try{
            DBOHelper.loadDriver(CLIENTDRIVER);
            Connection dbConn = DBOHelper.connect2DB(CONNECTION_STRING,USERNAME,PASSWORD);

            String insertInto = "insert into dbo.\"Numbers\" " +
                                "(\"Anxiety\", \"Depression\", \"SelfHarmNumber\", \"SuicidalIdeation\", \"EnergyLevel\", \"CravingLevel\", \"PhysicalHarm\", datetime)"
                                + " Values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = dbConn.prepareStatement(insertInto);
            stmt.setInt(1,eval.getAnxietyScore());
            stmt.setInt(2, eval.getDepressionScore());
            stmt.setInt(3, eval.getSelfHarmScore());
            stmt.setInt(4, eval.getSuicidalIdeationScore());
            stmt.setInt(5, eval.getEnergyLevelScore());
            stmt.setInt(6, eval.getCravingsScore());
            stmt.setBoolean(7, eval.isPhysicalSelfHarm());
            stmt.setString(8, eval.getDate());
            int rs = stmt.executeUpdate();
            if(rs > 0){
                System.out.println("Success");
                stmt.close();
                dbConn.close();
                return 1;
            }else{
                System.out.println("There was a problem");
                stmt.close();
                dbConn.close();
                return 0;
            }
        }catch (SQLException exception){
            exception.printStackTrace();
            return 0;
        }

//INSERT INTO dbo.Evaluation_Numbers (Anxiety,Depression,Self_Harm_Level,Suicidal_Ideation,Energy_Level,Craving_Level,Self_Harm,Datetime) VALUES (0,0,0,0,0,0,false,Thu Aug 24 02:16:42 CDT 2023)
    }

//    public int searchTime(ScheduleBean aSchedule){
//        try{
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        }catch(ClassNotFoundException e){
//            System.err.println(e.getMessage);
//            System.exit(0);
//        }
//        try{
//            String myDb = "jdbc:derby://localhost:1527/DemoTime";
//            Connection DbConn = DriverManager.getConnection(myDb,"root","toor");
//            String find = "Select * from IT353.Schedule where timeslot = '" + aSchedule.getTimeSlot() + "' and groupname = '";
//            Statement stmt = (Statement) DbConn.createStatement();
//            String groupName = "";
//            ResultSet rs = stmt.executeQuery(find);
//            while(rs.next()){
//                groupName = rs.getString("groupname");
//            }
//            if(groupName.equals("")){
//                rs.close();
//                stmt.close();
//                DbConn.close();
//                return 0;
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

}
