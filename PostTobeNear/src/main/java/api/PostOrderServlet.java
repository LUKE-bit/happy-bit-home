package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Order;
import model.OrderDao;
import model.User;
import util.PostException;
import util.PostUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


@WebServlet("/PostOrder")
public class PostOrderServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    static class Request{
        public String type;
        public int money;
        public Date time;
        public String description;
    }
    static class Response{
        public int ok;
        public String message;
    }

    //新增订单
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        try {
//            HttpSession session = req.getSession(false);
//            if (session == null) {
//                throw new PostException("您尚未登陆");
//            }
//            User user = (User) session.getAttribute("User");
//            if (user == null) {
//                throw new PostException("您尚未登陆");
//            }
            String body = PostUtil.readBody(req);
            Request request = gson.fromJson(body,Request.class);
            Order order = new Order();
            order.setType(request.type);
            order.setMoney(request.money);
            order.setTime(request.time);
            order.setDescription(request.description);
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            response.ok = 1;
            response.message = "";
        } catch (PostException postException) {
            response.ok = 0;
            response.message = postException.getMessage();
        }finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }


    //查看所有订单
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        List<Order> orders = new ArrayList<>();
        OrderDao orderDao = new OrderDao();
        // 2. 查找数据库, 查找所有订单
        orders = orderDao.selectAll();
        // 3. 构造响应结果
        String jsonString = gson.toJson(orders);
        resp.getWriter().write(jsonString);
//        try {
//             //1. 验证用户登陆状态.
//            HttpSession session = req.getSession(false);
//            if (session == null) {
//                throw new PostException("您尚未登陆");
//            }
//            User user = (User) session.getAttribute("User");
//            if (user == null) {
//                throw new PostException("您尚未登陆");
//            }
//
//        } catch (PostException e) {
//            // 5. 处理异常情况
//            String jsonString = gson.toJson(orders);
//            resp.getWriter().write(jsonString);
//        }
    }

}
