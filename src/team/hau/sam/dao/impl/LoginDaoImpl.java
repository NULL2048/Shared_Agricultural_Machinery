package team.hau.sam.dao.impl;

import team.hau.sam.dao.LoginDao;
import team.hau.sam.pojo.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public LoginDaoImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public Boolean checkLoginDao(User user) throws Exception {
        // 声明JDBC对象
        // 加载驱动
        // 获取连接对象

        // 创建SQL命令
        String sql = "select * from user_information where id = ? and password = ? and account_type = ?";
        // 创建SQL命令对象
        pstmt = conn.prepareStatement(sql);
        // 给占位符赋值
        pstmt.setInt(1, user.getId());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getAccountType());
        // 执行
        rs = pstmt.executeQuery();

        // 遍历执行结果
        if (rs.next()) {
            rs.close();
            pstmt.close();
            return true;
        } else {
            rs.close();
            pstmt.close();
            return false;
        }
        // 关闭资源
        // 返回
    }
}
