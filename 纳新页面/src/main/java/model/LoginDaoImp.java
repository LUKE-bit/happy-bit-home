package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class LoginDaoImp  {

    //登录时，进行数据库判断，账号和密码是否正确
    public boolean searchNameAndPwd(String id) {
        //连接数据库
        Connection conn = DBUtil.getConnection();

        String sql="UPDATE stu set sign = 1 WHERE id=? ";
        try {
            PreparedStatement pre=(PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, id);
            int i = pre.executeUpdate();
            while(i != 0){
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    //注册，在数据库中插入账号和密码
    public ArrayList<String> RegistNameAndPwd(String id) {
        // TODO Auto-generated method stub

        Connection conn = DBUtil.getConnection();
        String sql="SELECT id,name,subject,Tel,sign,way,comment,point,InterViewer,InterViewProcess FROM stu WHERE id=?";
        try {
            PreparedStatement pre= conn.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs=pre.executeQuery();
            if (rs.next()) {
                ArrayList<String> list = new ArrayList<>();
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
                list.add(rs.getString(6));
                list.add(rs.getString(7));
                list.add(rs.getString(8));
                list.add(rs.getString(9));
                list.add(rs.getString(10));
                return list;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("fail");
        return list;
    }

}




