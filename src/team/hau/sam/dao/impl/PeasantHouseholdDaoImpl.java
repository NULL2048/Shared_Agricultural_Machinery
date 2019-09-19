package team.hau.sam.dao.impl;

import team.hau.sam.dao.PeasantHouseholdDao;
import team.hau.sam.pojo.vo.PeasantHouseholdVo;
import team.hau.sam.pojo.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PeasantHouseholdDaoImpl implements PeasantHouseholdDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public PeasantHouseholdDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Boolean updatePwdDao(User user, String newPwd) {
        int flag = 0;
        try {
            String sql = "update peasant_household set password = ? where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPwd);
            pstmt.setInt(2, user.getId());
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

    @Override
    public PeasantHouseholdVo getPeasantHouseholdInfoDao(User user) {
        PeasantHouseholdVo ph = null;
        try {
            String sql = "select * from peasant_household where id = ? and account_type = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getAccountType());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                ph = new PeasantHouseholdVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9));
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
        return ph;
    }

    @Override
    public Boolean updatePeasantHouseholdInfoDao(PeasantHouseholdVo phVo, User user) {
        int flag = 0;
        try {
            String sql = "update peasant_household set name = ?, sex = ?, tel = ?, birthday = ?, address = ?, remark = ? where id = ? and account_type = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, phVo.getName());
            pstmt.setString(2, phVo.getSex());
            pstmt.setString(3, phVo.getTel());
            pstmt.setDate(4, phVo.getBirthday());
            pstmt.setString(5, phVo.getAddress());
            pstmt.setString(6, phVo.getRemark());
            pstmt.setInt(7, user.getId());
            pstmt.setString(8, user.getAccountType());

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
