package com.board.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBConn {
	private DBConn() {}
	
	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps=null;
	
	public static Connection getInstance() {
		if (dbConn == null) {
			try {
				System.out.println("Trying to load the driver...");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String id = "hr";
				String pw = "hr";
				dbConn = DriverManager.getConnection(url, id, pw);
				System.out.println("DBConnection....");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
			if (dbConn != null)
				dbConn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			st = null;
			ps = null;
			dbConn = null;
		}
	}
	public static int statementUpdate(String sql) {
        Connection conn = getInstance();
        int rValue = -1;

        if (conn != null) {
            try {
                st = conn.createStatement();
                rValue = st.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not connected...");
        }
        return rValue;
    }

    public static ResultSet statementQuery(String sql) {
        Connection conn = getInstance();
        ResultSet rs = null;

        if (conn != null) {
            try {
                st = conn.createStatement();
                rs = st.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not connected...");
        }
        return rs;
    }
	
	public static int preparedUpdate(String sql) {
        DBConn.getInstance();
        int rValue = -1;

        if (dbConn != null) {
            try {
                if (ps == null) {
                    ps = dbConn.prepareStatement(sql);
                }
                rValue = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not connected...");
        }
        return rValue;
    }

    public static ResultSet preparedQuery(String sql) {
        DBConn.getInstance();
        if (dbConn != null) {
            try {
                if (ps == null) {
                    ps = dbConn.prepareStatement(sql);
                }
                rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not connected...");
        }
        return rs;
    }
    
}