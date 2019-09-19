package team.hau.sam.service.impl;

import org.apache.log4j.Logger;
import team.hau.sam.dao.PeasantHouseholdDao;
import team.hau.sam.dbc.DatabaseConnection;
import team.hau.sam.factory.DaoFactory;
import team.hau.sam.pojo.vo.PeasantHouseholdVo;
import team.hau.sam.pojo.vo.User;
import team.hau.sam.service.PeasantHouseholdService;

public class PeasantHouseholdServiceImpl implements PeasantHouseholdService {
    private Logger logger = Logger.getLogger(PeasantHouseholdServiceImpl.class);
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public Boolean updatePwdService(User user, String newPwd) throws Exception {
        logger.debug(user.getId() + "：发起密码修改请求");
        Boolean flag = DaoFactory.getPeasantHouseholdDao(dbc.getConnection()).updatePwdDao(user, newPwd);
        dbc.close();

        if (flag) {
            logger.debug(user.getId() + "：修改密码成功");
        } else {
            logger.debug(user.getId() + "：修改密码失败");
        }

        return flag;
    }

    @Override
    public PeasantHouseholdVo getPeasantHouseholdInfoService(User user) {
        logger.debug(user.getId() + "：发起查看个人信息请求");
        PeasantHouseholdVo ph = DaoFactory.getPeasantHouseholdDao(dbc.getConnection()).getPeasantHouseholdInfoDao(user);
        dbc.close();

        if (ph != null) {
            logger.debug(user.getId() + "：查找个人信息成功");
        } else {
            logger.debug(user.getId() + "：查找个人信息失败");
        }

        return ph;
    }

    @Override
    public Boolean updatePeasantHouseholdInfoService(User user, PeasantHouseholdVo phVo) {
        logger.debug(user.getId() + "：发起个人信息修改请求");

        PeasantHouseholdDao phDao = DaoFactory.getPeasantHouseholdDao(dbc.getConnection());

        if (phDao.updatePeasantHouseholdInfoDao(phVo, user)) {
            logger.debug(user.getId() + "：个人信息修改成功");
            return true;
        }
        logger.debug(user.getId() + "：个人信息修改失败");
        return false;
    }
}
