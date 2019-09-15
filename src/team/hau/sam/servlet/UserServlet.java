package team.hau.sam.servlet;

import org.apache.log4j.Logger;
import team.hau.sam.factory.ServiceFactory;
import team.hau.sam.pojo.vo.PeasantHouseholdVo;
import team.hau.sam.pojo.vo.User;
import team.hau.sam.service.LoginService;
import team.hau.sam.service.PeasantHouseholdService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

public class UserServlet extends javax.servlet.http.HttpServlet {
    private Logger logger = Logger.getLogger(UserServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置相应编码格式
            // 设置请求编码信息
            // 设置响应编码信息
        req.setCharacterEncoding("utf-8"); // 不光要设置respinse的字符集是utf-8,还要设置requst是utf-8，否则控制台日志的汉字就会是乱码
        resp.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        String oper = req.getParameter("oper");
        logger.debug("当前请求：" + oper);
        if ("login".equals(oper)) {
            login(req, resp);
        } else if ("signup".equals(oper)) {
            signup(req, resp);
        } else if ("out".equals(oper)) {
            out(req, resp);
        } else if ("show".equals(oper)) {
            show(req, resp);
        }  else if ("pwd".equals(oper)) {
            userChangePwd(req, resp);
        }
        else {
            logger.warn("没有找到对应的操作符:" + oper);
        }
    }
    // 注册用户
    private void signup(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");
        String accountType = req.getParameter("accountType");
        System.out.println(name + " " + password + " " + sex + " " + birthday
            + " " + tel + " " + address + " " + accountType);

        if ("农户".equals(accountType)) {
            PeasantHouseholdVo phVo = new PeasantHouseholdVo(null, password, accountType, sex, tel, name, Date.valueOf(birthday), address, null);

        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String accountType = req.getParameter("accountType");

        User user = new User(Integer.parseInt(id), password, accountType);
        //获取业务层对象
        LoginService lS = ServiceFactory.getLoginServiceInstance();
        // 处理请求信息
        try {
            if (lS.checkLoginService(user)) {
                logger.debug("用户：" + user.getId() + " 登陆成功");
                // 获取Session对象
                HttpSession hs = req.getSession();
                // 将用户数据存储到session中
                hs.setAttribute("user", user);
                // 重定向
                resp.sendRedirect("/sam/main/main.jsp");
            } else {
                logger.debug("用户：" + user.getId() + " 登陆失败");
                req.setAttribute("flag", 0);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 用户退出
    private void out(HttpServletRequest req, HttpServletResponse resp) {
        // 获取session对象
        HttpSession hs = req.getSession();
        // 强制销毁session
        hs.invalidate();
        // 重定向
        try {
            resp.sendRedirect("/sam/login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 用户修改密码
    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) {
        // 获取新密码数据
        String newPwd = req.getParameter("newPwd");
        // 从session中获取用户信息
        User user = (User) req.getSession().getAttribute("user");
        Integer uId = user.getId();
        String accountType = user.getAccountType();

        try {
            if ("农户".equals(accountType)) {
                PeasantHouseholdService phS = ServiceFactory.getPeasantHouseholdServiceInstance();
                if (phS.updatePwdService(user, newPwd)) {
                    // 获取session对象
                    HttpSession hs = req.getSession();
                    hs.setAttribute("newPwd", true);
                    // 重定向到登陆页面
                    resp.sendRedirect("/sam/login.jsp");
                }
            } else if("机手".equals(accountType)) {

            } else if("农机管理部门".equals(accountType)) {

            } else if("系统管理员".equals(accountType)) {

            } else {
                logger.warn("不存在的用户类型：" + accountType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        Object teapUser = null;

        if ("农户".equals(user.getAccountType())) {
            teapUser = ServiceFactory.getPeasantHouseholdServiceInstance().getPeasantHouseholdInfoService(user);
        }

        if (teapUser != null) {
            // 将查询到的用户信息存储到request对象中
            req.setAttribute("userInfo", teapUser);
            // 请求转发
            try {
                req.getRequestDispatcher("/user/userInfo.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}