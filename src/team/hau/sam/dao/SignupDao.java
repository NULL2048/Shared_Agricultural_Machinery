package team.hau.sam.dao;

public interface SignupDao {
    /**
     * 根据联系电话判断账号是否已经存在
     * @param tel
     * @return
     */
    boolean isExist(String tel);

    //boolean insert
}
