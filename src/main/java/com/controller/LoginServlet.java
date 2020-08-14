package com.controller;

import com.entity.Admin;
import com.entity.Reader;
import com.service.ReaderService;
import com.service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author 17586
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    ReaderService readerService = new ReaderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 处理登录的业务逻辑
     * @param req 请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException io异常
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        Object object = readerService.login(username,password,type);
        if(object!=null){
            HttpSession session = req.getSession();
            switch (type){
                case "reader":
                    Reader reader = (Reader) object;
                    session.setAttribute("reader",reader);
                    break;
                case "admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin",admin);
                    break;
                default:
                    break;
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("login.jsp");
        }
    }
}
