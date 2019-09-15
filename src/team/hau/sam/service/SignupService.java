package team.hau.sam.service;
import team.hau.sam.pojo.vo.*;

public interface SignupService {
    /**
     * 农户账号注册
     * @param psVo
     * @return
     */
    Boolean peasantHouseholdSignupService(PeasantHouseholdVo psVo);
}
