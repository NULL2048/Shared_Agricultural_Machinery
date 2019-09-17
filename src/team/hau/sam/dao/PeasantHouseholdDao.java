package team.hau.sam.dao;

import team.hau.sam.pojo.vo.PeasantHouseholdVo;
import team.hau.sam.pojo.vo.User;

public interface PeasantHouseholdDao {
    Boolean updatePwdDao(User user, String newPwd);
    PeasantHouseholdVo getPeasantHouseholdInfoDao(User user);
    Boolean updatePeasantHouseholdInfoDao(PeasantHouseholdVo phVo);
}
