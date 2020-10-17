package model;

public class Login {
    private String LoginName;
    private String LoginPwd;
    public String getLoginName() {
        return LoginName;
    }
    public void setLoginName(String loginName) {
        LoginName = loginName;
    }
    public String getLoginPwd() {
        return LoginPwd;
    }
    public void setLoginPwd(String loginPwd) {
        LoginPwd = loginPwd;
    }
    public Login(String loginName, String loginPwd) {
        super();
        LoginName = loginName;
        LoginPwd = loginPwd;
    }
    public Login(String loginName) {
        super();
        LoginName = loginName;
    }
    public Login() {

        super();
    }
}

