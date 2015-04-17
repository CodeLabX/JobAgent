package team.core.agent.DBUtility;

/**
 * Created by wusq on 2015/4/17.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sun.rowset.CachedRowSetImpl;

public class SQLiteHelper {

    static {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String connString = new String("jdbc:sqlite:"
            + "hello.db.sqlite");

    public static List<Map<String, Object>> Query(String connString,
                                                  String SQL, Object[] Params) throws Exception {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(connString);
            pstmt = conn.prepareStatement(SQL);

            int i = 1;
            if (Params != null) {
                for (Object item : Params) {
                    pstmt.setObject(i, item);
                    i++;
                }
            }

            rs = pstmt.executeQuery();

            ResultSetMetaData rsm = rs.getMetaData();
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> map = new TreeMap<String, Object>();
                for (int index = 1; index <= rsm.getColumnCount(); index++) {
                    map.put(rsm.getColumnName(index), rs.getObject(index));
                }
                result.add(map);
            }

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            rs.close();
            pstmt.close();
            conn.close();
        }

    }

    public static CachedRowSetImpl Query_CachedRowSet(String connString,
                                                      String SQL, Object[] Params) throws Exception {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(connString);
            pstmt = conn.prepareStatement(SQL);

            int i = 1;
            if (Params != null) {
                for (Object item : Params) {
                    pstmt.setObject(i, item);
                    i++;
                }
            }

            rs = pstmt.executeQuery();

            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs.populate(rs);
            return crs;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            rs.close();
            pstmt.close();
            conn.close();
        }

    }

    public static int ExecuteNoTrans(String connString, String SQL,
                                     Object[] Params) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(connString);
            pstmt = conn.prepareStatement(SQL);

            int i = 1;
            if (Params != null) {
                for (Object item : Params) {
                    pstmt.setObject(i, item);
                    i++;
                }
            }

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            pstmt.close();
            conn.close();
        }
    }

    public static Connection ExecuteWithTrans(Connection conn, String SQL,
                                              Object[] Params, int Commit) throws Exception {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(connString);
            }
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            int i = 1;
            if (Params != null) {
                for (Object item : Params) {
                    pstmt.setObject(i, item);
                    i++;
                }
            }
            pstmt.executeUpdate();

            if (Commit == 1) {// 输入1表示提交
                conn.commit();
                pstmt.close();
                conn.close();
            } else if (Commit == -1) {// 输入-1表示回滚
                conn.rollback();
                pstmt.close();
                conn.close();
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {

        }

    }
}
