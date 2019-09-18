package team.hau.sam.dao.impl;

import team.hau.sam.dao.SignupDao;
import team.hau.sam.pojo.vo.PeasantHouseholdVo;

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
    public boolean isPeasantHouseholdExistDao(String tel) {
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

    @Override
    public boolean insertPeasantHouseholdDao(PeasantHouseholdVo phVo) {
        int flag = 0;
        try {
            String sql = "insert into peasant_household(account_type, name, password, tel, birthday, address, sex) values(?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phVo.getAccountType());
            pstmt.setString(2, phVo.getName());
            pstmt.setString(3, phVo.getTel());
            pstmt.setDate(4, phVo.getBirthday());
            pstmt.setString(5, phVo.getAddress());
            pstmt.setString(6, phVo.getSex());

            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }
}
