package dbo;


import Therapy.Evaluations;

import java.sql.*;

public class DboImplements implements DBOHelper {

    private static final String CONNECTION_STRING ="jdbc:derby://localhost:1527/MentalHealthSwingDB";
    private static final String CLIENTDRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";


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

//    public int insertInto (String table, Evaluations eval){
//        DBOHelper.loadDriver(CLIENTDRIVER);
//        Connection dbConn = DBOHelper.connect2DB(CONNECTION_STRING,USERNAME,PASSWORD);
//        String insertInto = "INSERT INTO " + table + "VALUES ("
//                + eval.getAnxietyScore() + ","
//                + eval.getDepressionScore() + ","
//                + eval.getSelfHarmScore() + ","
//                + eval.getSuicidalIdeationScore() + ","
//                + eval.getEnergyLevelScore() + ","
//                + eval.getCravingsScore() + ","
//                + eval.isPhysicalSelfHarm() + ","
//
//    }

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
