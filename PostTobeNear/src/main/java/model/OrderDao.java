package model;

import util.PostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 操作订单
// 1. 新增订单
// 2. 接受订单
// 3. 查看所有订单
// 4. 修改订单状态(订单是否已经完成) 必要性存疑
public class OrderDao {
    // 新增订单
    public void add(Order order) throws PostException {
        addOrder(order);
    }

    public void take(int orderId) throws PostException{
        deleteOrder(orderId);
    }
    //新增订单
    private void addOrder(Order order) throws PostException {
        // 1. 先获取到数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 构造 SQL
        String sql = "insert into orders values(null,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement.setString(1, order.getType());
            statement.setInt(2, order.getMoney());
            statement.setDate(3, order.getTime());
            statement.setString(4, order.getDescription());
            statement.setInt(5, 0);
            // 3. 执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new PostException("插入订单失败");
            }
            System.out.println("插入订单第一步成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostException("插入订单失败");
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private void deleteOrder(int orderId) throws PostException {
        //1.先获取到数据库连接
        Connection connection = DBUtil.getConnection();
        //2.构造sql请求
        String sql = "delete from orders where orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            //3.执行sql
            int ret = statement.executeUpdate();
            if (ret!=1) {
                throw new PostException("接单失败");
            }
            System.out.println("接单成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,null);
        }
    }

    // 获取到所有的订单信息
    public List<Order> selectAll() {
        List<Order> orders = new ArrayList<>();
        // 1. 获取到数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "select * from orders where isTake = 0";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            // 3. 直接执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setType(resultSet.getString("type"));
                order.setMoney(resultSet.getInt("money"));
                order.setTime(resultSet.getDate("time"));
                order.setDescription(resultSet.getString("description"));
                order.setIsTake(resultSet.getInt("isTake"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 断开连接
            DBUtil.close(connection, statement, resultSet);
        }
        return orders;
    }

    public void changeState(int orderId, int isTake) throws PostException {
        Connection connection = DBUtil.getConnection();
        String sql = "update orders set isTake = ? where orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, isTake);
            statement.setInt(2, orderId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new PostException("修改订单状态失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostException("修改订单状态失败");
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}