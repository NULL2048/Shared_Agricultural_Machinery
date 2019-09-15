package team.hau.sam.service.impl;

import org.apache.log4j.Logger;
import team.hau.sam.dbc.DatabaseConnection;
import team.hau.sam.factory.DaoFactory;
import team.hau.sam.pojo.vo.PeasantHouseholdVo;
import team.hau.sam.service.SignupService;

public class SignupServiceImpl implements SignupService {
    private Logger logger = Logger.getLogger(SignupServiceImpl.class);
    DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public Boolean peasantHouseholdSignupService(PeasantHouseholdVo psVo) {
        boolean flag = (DaoFactory.getSignupDaoInstance(dbc.getConnection())).isExist(psVo.getTel());
        if (flag) {

        }

        dbc.close();
        return false;
    }
}
