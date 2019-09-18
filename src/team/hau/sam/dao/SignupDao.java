package team.hau.sam.dao;

import team.hau.sam.pojo.vo.PeasantHouseholdVo;

public interface SignupDao {
    /**
     * 根据联系电话判断账号是否已经存在
     * @param tel
     * @return
     */
    boolean isPeasantHouseholdExistDao(String tel);

    boolean insertPeasantHouseholdDao(PeasantHouseholdVo phVo);
}
