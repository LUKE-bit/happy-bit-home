package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Stu;
import model.StuDao;
import util.NaXinUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    static class Request{
        public String yhm;
        public String mm;
    }
    static class Response{
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
        try {
            String body = NaXinUtil.readBody(req);
            Request request = gson.fromJson(body,Request.class);
            StuDao stuDao = new StuDao();
            Stu stu = stuDao.selectByXuehao(request.yhm);
            if (stu==null || !stu.getPassword().equals(request.mm)) {
                throw new Exception("用户名或密码错误");
            }
            //创建成功就建立session对象
            HttpSession session = req.getSession();
            session.setAttribute("stu",stu);
            response.status = "success";
            response.id = stu.getId();
            response.name = stu.getName();
            response.subject = stu.getSubject();
            response.Tel = stu.getTel();
            response.way = stu.getWay();
            response.comment = stu.getComment();
            response.point = stu.getPoint();
            response.InterViewer = stu.getInterViewer();
            response.InterViewProcess = stu.getInterViewProcess();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            String jsonString = gson.toJson(response);
            resp.setContentType("application/json; charset = utf-8");
            resp.getWriter().write(jsonString);
        }
    }
}
