package team.hau.sam.service.impl;

import org.apache.log4j.Logger;
import team.hau.sam.dbc.DatabaseConnection;
import team.hau.sam.factory.DaoFactory;
import team.hau.sam.pojo.vo.User;
import team.hau.sam.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private Logger logger = Logger.getLogger(LoginServiceImpl.class);
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public Boolean checkLoginService(User user) throws Exception {
        try {
            // 打印日志
            logger.debug("用户：" + user.getId() + " 发起了登录请求");
            return DaoFactory.getLoginDaoInstance(dbc.getConnection()).checkLoginDao(user);
        } catch(Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
    }
}
