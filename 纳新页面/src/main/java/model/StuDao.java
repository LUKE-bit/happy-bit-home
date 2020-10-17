package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StuDao {
    public void add(Stu student) {
        //1.先获取和数据库的连结
        Connection connection = DBUtil.getConnection();
        String sql = "insert into stu values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getPassword());
            ps.setString(4,student.getSubject());
            ps.setString(5,student.getTel());
            ps.setString(6,student.getWay());
            ps.setString(7,student.getComment());
            ps.setString(8,student.getPoint());
            ps.setString(9,student.getInterViewer());
            ps.setString(10,student.getInterViewProcess());
            ps.setInt(11,student.getSign());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }
    public Stu selectByXuehao(String xueHao) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from stu where id = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,xueHao);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Stu student = new Stu();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));
                student.setTel(resultSet.getString("Tel"));
                student.setSubject(resultSet.getString("subject"));
                student.setWay(resultSet.getString("way"));
                student.setComment(resultSet.getString("comment"));
                student.setPoint(resultSet.getString("point"));
                student.setInterViewer(resultSet.getString("InterViewer"));
                student.setInterViewProcess(resultSet.getString("InterViewProcess"));
                student.setSign(resultSet.getInt("sign"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
        return null;
    }
}
