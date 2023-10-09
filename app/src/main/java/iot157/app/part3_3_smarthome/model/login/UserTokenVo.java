package iot157.app.part3_3_smarthome.model.login;
import java.util.Date;
public class UserTokenVo {
    private String token;
    private String userId;
    private Date expiredTime;
    private Long expiredTs;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Long getExpiredTs() {
        return expiredTs;
    }

    public void setExpiredTs(Long expiredTs) {
        this.expiredTs = expiredTs;
    }
}
