package com.slut.alumni.bean.gson;

/**
 * Created by 七月在线科技 on 2016/11/9.
 */

public class LoginBean {


    /**
     * errno : 0
     * msg : 登录成功
     * data : {"oauth_info":{"access_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIzIiwiaWF0IjoxNDc4ODQ3MTc2LCJleHAiOjE0Nzk0NTE5NzZ9._qA1Aes5Ru3QoAFnI-lMmUxkSFVnngtKiSzTCY58O8I"},"user_info":{"uid":"3","phone_no":null,"email":"shijianan33@gmail.com","password":"e10adc3949ba59abbe56e057f20f883e","nickname":"史建安","avatar_url":null,"school_id":null,"faculty_id":null,"major_id":null,"reg_time":"1478685389","last_login":"1478685389","login_num":"1","login_ip":"192.168.37.1","access_token":null}}
     */

    private int errno;
    private String msg;
    /**
     * oauth_info : {"access_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIzIiwiaWF0IjoxNDc4ODQ3MTc2LCJleHAiOjE0Nzk0NTE5NzZ9._qA1Aes5Ru3QoAFnI-lMmUxkSFVnngtKiSzTCY58O8I"}
     * user_info : {"uid":"3","phone_no":null,"email":"shijianan33@gmail.com","password":"e10adc3949ba59abbe56e057f20f883e","nickname":"史建安","avatar_url":null,"school_id":null,"faculty_id":null,"major_id":null,"reg_time":"1478685389","last_login":"1478685389","login_num":"1","login_ip":"192.168.37.1","access_token":null}
     */

    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIzIiwiaWF0IjoxNDc4ODQ3MTc2LCJleHAiOjE0Nzk0NTE5NzZ9._qA1Aes5Ru3QoAFnI-lMmUxkSFVnngtKiSzTCY58O8I
         */

        private OauthInfoBean oauth_info;
        /**
         * uid : 3
         * phone_no : null
         * email : shijianan33@gmail.com
         * password : e10adc3949ba59abbe56e057f20f883e
         * nickname : 史建安
         * avatar_url : null
         * school_id : null
         * faculty_id : null
         * major_id : null
         * reg_time : 1478685389
         * last_login : 1478685389
         * login_num : 1
         * login_ip : 192.168.37.1
         * access_token : null
         */

        private UserInfoBean user_info;

        public OauthInfoBean getOauth_info() {
            return oauth_info;
        }

        public void setOauth_info(OauthInfoBean oauth_info) {
            this.oauth_info = oauth_info;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public static class OauthInfoBean {
            private String access_token;

            public String getAccess_token() {
                return access_token;
            }

            public void setAccess_token(String access_token) {
                this.access_token = access_token;
            }
        }

        public static class UserInfoBean {
            private String uid;
            private String phone_no;
            private String email;
            private String password;
            private String nickname;
            private String avatar_url;
            private int school_id;
            private int faculty_id;
            private int major_id;
            private String reg_time;
            private String last_login;
            private String login_num;
            private String login_ip;
            private String access_token;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getPhone_no() {
                return phone_no;
            }

            public void setPhone_no(String phone_no) {
                this.phone_no = phone_no;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public int getSchool_id() {
                return school_id;
            }

            public void setSchool_id(int school_id) {
                this.school_id = school_id;
            }

            public int getFaculty_id() {
                return faculty_id;
            }

            public void setFaculty_id(int faculty_id) {
                this.faculty_id = faculty_id;
            }

            public int getMajor_id() {
                return major_id;
            }

            public void setMajor_id(int major_id) {
                this.major_id = major_id;
            }

            public String getReg_time() {
                return reg_time;
            }

            public void setReg_time(String reg_time) {
                this.reg_time = reg_time;
            }

            public String getLast_login() {
                return last_login;
            }

            public void setLast_login(String last_login) {
                this.last_login = last_login;
            }

            public String getLogin_num() {
                return login_num;
            }

            public void setLogin_num(String login_num) {
                this.login_num = login_num;
            }

            public String getLogin_ip() {
                return login_ip;
            }

            public void setLogin_ip(String login_ip) {
                this.login_ip = login_ip;
            }

            public Object getAccess_token() {
                return access_token;
            }

            public void setAccess_token(String access_token) {
                this.access_token = access_token;
            }
        }
    }
}
