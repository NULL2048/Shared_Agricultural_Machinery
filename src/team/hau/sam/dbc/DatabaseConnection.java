package team.hau.sam.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 本类负责数据库的连接操作，在进行本类对象实例化时自动进行数据库的连接处理
 */
public class DatabaseConnection {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver"; // 加载MySQL数据库驱动
    //private static final String DBURL = "jdbc:mysql://localhost:3306/Shared_Agricultural_Machinery_DB?serverTimezone=GMT"; // 填写数据源，即数据库名
    private static final String DBURL = "jdbc:mysql://localhost:3306/Shared_Agricultural_Machinery_DB?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false"; // 填写数据源，即数据库名

    private static final String DBUSER = "root";
    private static final String PASSWORD = "123456";
    private Connection conn = null;
    /**
     * 在构造方法调用时将进行数据库连接对象的取得
     */
    public DatabaseConnection() {
        try {
            Class.forName(DBDRIVER); // 加载数据库驱动程序
            this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); // 取得连接对象
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    /**
     * 取得数据库连接对象
     * @return 实例化的Connection对象，如果返回null，就表示没有连接成功
     */
    public Connection getConnection() {
        return this.conn;
    }
    /**
     * 进行数据库的关闭操作
     */
    public void close() {
        if (this.conn != null) { // 要先判断数据库是否已连接
            try {
                this.conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
