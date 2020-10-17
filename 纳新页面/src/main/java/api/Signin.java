package api;

import model.LoginDaoImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Signin")
public class Signin extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取表单传过来的数据
        String id = request.getParameter("id");
        //把获取到的数据传到数据库，进行判断
//        String id = "2";
        LoginDaoImp loginService = new LoginDaoImp();
        boolean	isHave=loginService.searchNameAndPwd(id);
        //如果账号密码正确，登录成功
        if(isHave){
            request.setAttribute("id", id);
            String json = new String();
//                json = "[";
            json += "{\"status\":\""+"1" +
                    "\"}";
//                json += "]";

            PrintWriter printWriter=response.getWriter();
            printWriter.write(json);
            printWriter.close();
//            System.out.println(json);
        }
        else{
            //如果失败，报告错误
            String json = new String();
//                json = "[";
            json += "{\"status\":\""+"0" +
                    "\"}";
//                json += "]";

            PrintWriter printWriter=response.getWriter();
            printWriter.write(json);
            printWriter.close();
//            System.out.println(json);
        }

    }


}

