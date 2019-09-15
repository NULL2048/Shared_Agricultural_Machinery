package team.hau.sam.service;

import team.hau.sam.pojo.vo.PeasantHouseholdVo;
import team.hau.sam.pojo.vo.User;

public interface PeasantHouseholdService {
    /**
     * 修改农户账号密码
     * @param user
     * @param newPwd
     * @return
     * @throws Exception
     */
    Boolean updatePwdService(User user, String newPwd) throws Exception;

    /**
     * 查看农户账号信息
     * @param user
     * @return
     */
    PeasantHouseholdVo getPeasantHouseholdInfoService(User user);
}
