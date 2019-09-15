package team.hau.sam.service;

import team.hau.sam.pojo.vo.User;

public interface LoginService {
    Boolean checkLoginService(User user) throws Exception;
}
