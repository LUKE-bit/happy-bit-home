package api;




import model.LoginDaoImp;

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
import java.util.List;


@WebServlet("/managestudent")
public class managestudent extends HttpServlet {
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
//        String id = "2";
        //把获取到的数据传到数据库，进行判断
        LoginDaoImp loginService = new LoginDaoImp();
        ArrayList<String> rs=loginService.RegistNameAndPwd(id);
        try {
            if(rs.get(0) != "fail"){
//                int id1 = rs.getInt(1);
//                String name1 = rs.getString(2);
//                String class2 = rs.getString(3);
//                int telephone1 = rs.getInt(4);
//                int sign1 = rs.getInt(5);
                String jsonStr = new String();
//                jsonStr = "[";
                    jsonStr += "{\"status\":\""+"success" +
                            "\",\"id\":\""+rs.get(0)+
                            "\",\"name\":\""+rs.get(1)+
                            "\",\"subject\":\""+rs.get(2) +
                            "\",\"Tel\":\""+rs.get(3)+
                            "\",\"sign\":\""+rs.get(4)+
                            "\",\"way\":\""+rs.get(5)+
                            "\",\"comment\":\""+rs.get(6)+
                            "\",\"point\":\""+rs.get(7)+
                            "\",\"InterViewer\":\""+rs.get(8)+
                            "\",\"InterViewProcess\":\""+rs.get(9)+
                            "\"}";
//                    jsonStr += "]";

//                s.setId1(rs.getInt(1));
//                s.setName1(name1);
//                s.setClass2(class2);
//                s.setTelephone1(telephone1);
//                s.setSign1(sign1);
//                arrayList.add(s);

                PrintWriter printWriter=response.getWriter();
                printWriter.write(jsonStr);
                printWriter.close();
//                System.out.println(jsonStr);
//                request.getSession().setAttribute("id", id1);
//                request.getSession().setAttribute("name", name1);
//                request.getSession().setAttribute("class", class2);
//                request.getSession().setAttribute("telephone", telephone1);
//                request.getSession().setAttribute("sign", sign1);
            } else {

                String json = new String();
//                json = "[";
                json += "{\"status\":\""+rs.get(0) +
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

