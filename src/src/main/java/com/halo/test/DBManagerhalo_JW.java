//package com.halo.test;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//
//public class DBManagerhalo_JW {
//
//    private static BasicDataSource dataSource;
//
//    static {
//        dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//        // 주의: setUrl이 두 번 호출되고 있습니다. 마지막 호출만 유효합니다.
//        dataSource.setUrl("jdbc:oracle:thin:@anxucl0a8nyvimp0_high?TNS_ADMIN=/Users/admin/mg/Wallet_ANXUCL0A8NYVIMP0");
//        dataSource.setUrl("jdbc:oracle:thin:@anxucl0a8nyvimp0_high?TNS_ADMIN=C:/Wallet_ANXUCL0A8NYVIMP0");
//        dataSource.setUsername("ADMIN");
//        dataSource.setPassword("Soldesk802!!");
//    }
//
//    public static Connection connect() throws SQLException {
//        return dataSource.getConnection();
//    }
//
//    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pstmt != null) { // pstmt가 null이 아닐 때만 close() 호출
//                pstmt.close();
//            }
//            if (con != null) { // con도 null 체크 추가
//                con.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
