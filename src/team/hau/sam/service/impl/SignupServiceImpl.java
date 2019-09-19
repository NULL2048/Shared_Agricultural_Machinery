package team.hau.sam.service.impl;

import org.apache.log4j.Logger;
import team.hau.sam.dao.SignupDao;
import team.hau.sam.dbc.DatabaseConnection;
import team.hau.sam.factory.DaoFactory;
import team.hau.sam.pojo.vo.PeasantHouseholdVo;
import team.hau.sam.service.SignupService;

public class SignupServiceImpl implements SignupService {
    private Logger logger = Logger.getLogger(SignupServiceImpl.class);
    DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public int peasantHouseholdSignupService(PeasantHouseholdVo psVo) {
        logger.debug("发起注册请求");
        SignupDao suD = DaoFactory.getSignupDaoInstance(dbc.getConnection());
        boolean flag = suD.isPeasantHouseholdExistDao(psVo.getTel());
        if (flag) {
            if (suD.insertPeasantHouseholdDao(psVo)) {
                dbc.close();
                return 1;
            } else {
                dbc.close();
                return 0;
            }
        } else {
            dbc.close();
            return -1;
        }
    }
}
