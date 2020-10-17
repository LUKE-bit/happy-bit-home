package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Stu;
import model.StuDao;
import util.NaXinUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentLogin")
public class RegisterServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Request {
        public String yhm;
        public String mm;
        public String Telephone;
        public String 方向;
    }

    static class Response {
        public String status;
        public String id;
        public String name;
        public String subject;
        public String Tel;
        public String way;
        public String comment;
        public String point;
        public String InterViewer;
        public String InterViewProcess;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        ConnectJWGL test = null;
        try{
            //读取body数据
            String body = NaXinUtil.readBody(req);
            System.out.println(body);
            //将读取到的body解析成对象
            Request request = gson.fromJson(body, Request.class);
            //按找学生学号进行查找
            StuDao stuDao = new StuDao();
            Stu exitstudent = stuDao.selectByXuehao(request.yhm);
            if (exitstudent != null) {
                response.status = "failed";
                resp.setContentType("application/json; charset=utf-8");
                String jsonString = gson.toJson(response);
                resp.getWriter().write(jsonString);
                return;
            }
            test = new ConnectJWGL(request.yhm, request.mm);
            test.init();
            boolean flag = test.beginLogin();
            if (flag) {
                Stu student = new Stu();
                student.setId(request.yhm);
                student.setPassword(request.mm);
                student.setTel(request.Telephone);
                student.setWay(request.方向);
                stuDao.add(student);
                response.status = "success";
                response.id = student.getId();
                response.name = student.getName();
                //response.subject = student.getSubject();
                response.Tel = student.getTel();
                response.way = student.getWay();
                //response.comment = student.getComment();
                //response.point = student.getPoint();
                //response.Interviewer = student.getInterviewer();
                //response.InterviewerProcess = student.getInterviewerProcess();
            } else {
                response.status = "failed";
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            String jsonString = gson.toJson(response);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(jsonString);
        }
    }
}


