package team.hau.sam.dao.impl;

import team.hau.sam.dao.SignupDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignupDaoImpl implements SignupDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public SignupDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean isExist(String tel) {
        String sql = "select * from peasant_household where tel = ?";
        boolean flag = true;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tel);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return flag;

    }
}
