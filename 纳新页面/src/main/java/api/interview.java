package api;

import model.LoginDaoImp2;

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
public class interview extends HttpServlet {
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
        String name = request.getParameter("name");
        String telephone = request.getParameter("Tel");
        String clas = request.getParameter("subject");
        //把获取到的数据传到数据库，进行判断
        LoginDaoImp2 loginService = new LoginDaoImp2();
        boolean	isHave=loginService.searchNameAndPwd2(id,name,telephone,clas);
        //如果账号密码正确，登录成功
        if(isHave){
            request.setAttribute("id", id);
            String jsonStr = new String();
//                json = "[";
            jsonStr += "{\"stutas\":\""+"1" +
                    "\"}";
//                json += "]";
            PrintWriter printWriter=response.getWriter();
            printWriter.write(jsonStr);
            printWriter.close();
        }
        else{
            //如果失败，报告错误
            String json = new String();
//                json = "[";
            json += "{\"stutas\":\""+"0" +
                    "\"}";
//                json += "]";
            PrintWriter printWriter=response.getWriter();
            printWriter.write(json);
            printWriter.close();

        }

    }


}

