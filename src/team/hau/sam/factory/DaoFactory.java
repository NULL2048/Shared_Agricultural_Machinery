package team.hau.sam.factory;

import team.hau.sam.dao.LoginDao;
import team.hau.sam.dao.PeasantHouseholdDao;
import team.hau.sam.dao.SignupDao;
import team.hau.sam.dao.impl.LoginDaoImpl;
import team.hau.sam.dao.impl.PeasantHouseholdDaoImpl;
import team.hau.sam.dao.impl.SignupDaoImpl;

import java.sql.Connection;

public class DaoFactory {
    public static LoginDao getLoginDaoInstance(Connection conn) {
        return new LoginDaoImpl(conn);
    }

    public static SignupDao getSignupDaoInstance(Connection conn) {
        return new SignupDaoImpl(conn);
    }
    public static PeasantHouseholdDao getPeasantHouseholdDao(Connection conn) {
        return new PeasantHouseholdDaoImpl(conn);
    }
}
