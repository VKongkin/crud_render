package kongkin.bbu.edu.crud.SharePoint.Models;

public class AccessTokenResponse {
    private String token_type;
    private int expires_in;
    private int ext_expires_in;
    private String access_token;

    // Getters and Setters
    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public int getExt_expires_in() {
        return ext_expires_in;
    }

    public void setExt_expires_in(int ext_expires_in) {
        this.ext_expires_in = ext_expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}