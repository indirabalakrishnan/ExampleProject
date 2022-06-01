package utils;

import org.json.JSONObject;

public class JiraCredentials{
    String username;
    String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public String getFileName(String filename) {
//        return ICredentials.super.getFileName(filename);
//    }
//
//    @Override
//    public String getJson() {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("username", username );
//        jsonObject.put("password", password);
//        return jsonObject.toString();
//    }
}
