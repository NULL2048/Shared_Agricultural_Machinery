package team.hau.sam.service;
import team.hau.sam.pojo.vo.*;

public interface SignupService {
    /**
     * 农户账号注册
     * @param psVo
     * @return 1表示成功注册 0表示注册失败 -1表示用户已存在
     */
    int peasantHouseholdSignupService(PeasantHouseholdVo psVo);
}
