package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class LoginDaoImp2  {

    //登录时，进行数据库判断，账号和密码是否正确
    public boolean searchNameAndPwd2(String id,String name,String telephone,String clas) {
        //连接数据库
        Connection conn = DBUtil.getConnection();
        String sql="UPDATE stu SET name = ? WHERE id=? ";

        try {
            PreparedStatement pre=(PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, id);
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
    public ArrayList<String> RegistNameAndPwd2(String id) {
        // TODO Auto-generated method stub

        Connection conn = DBUtil.getConnection();
        String sql="SELECT id,name FROM stu WHERE id=?";
        try {
            PreparedStatement pre=(PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs=pre.executeQuery();
            if (rs.next()) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                return list;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        list.add("fail");
        return list;
    }



}




