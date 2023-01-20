package org.launchcode.HomeBartender.data;

public class LoginData {
        private String psw;

        private String userName;

        public String getPsw() {
            return psw;
        }

        public void setPsw(String psw) {
            this.psw = psw;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

    }

//    method to find specific username, if not in database, block from logging in.

