package api;


import model.LoginDaoImp2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/managestudent")
public class admainistrator extends HttpServlet {
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
//String id = "2";
        //把获取到的数据传到数据库，进行判断
        LoginDaoImp2 loginService = new LoginDaoImp2();
        ArrayList<String> rs=loginService.RegistNameAndPwd2(id);
        //如果注册成功
        try {
            if(rs.get(0) != "fail"){
                String jsonStr = new String();
//                jsonStr = "[";
                jsonStr += "{\"stutas\":\""+"success" +
                        "\",\"id\":\""+rs.get(0)+
                        "\",\"name\":\""+rs.get(1)+
                        "\"}";
//                    jsonStr += "]";
                PrintWriter printWriter=response.getWriter();
                printWriter.write(jsonStr);
                printWriter.close();
//                System.out.println(jsonStr);
            } else {
                String json = new String();
//                json = "[";
                json += "{\"stutas\":\""+rs.get(0) +
                        "\"}";
//                json += "]";
                PrintWriter printWriter=response.getWriter();
                printWriter.write(json);
                printWriter.close();
//                System.out.println(json);
            }
//        获取表单提交过来的信息

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
}

