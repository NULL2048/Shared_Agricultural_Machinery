package team.hau.sam.dao;

import team.hau.sam.pojo.vo.User;

public interface LoginDao {
    Boolean checkLoginDao(User user) throws Exception;
}
