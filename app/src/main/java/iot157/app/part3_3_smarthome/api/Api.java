package iot157.app.part3_3_smarthome.api;

import iot157.app.part3_3_smarthome.model.login.LoginRequest;
import iot157.app.part3_3_smarthome.model.login.UserTokenVo;
import iot157.app.part3_3_smarthome.model.message.ResMsg;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "http://10.0.0.2:8098";
    Retrofit RETROFIT = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build();
    /*登录获取令牌
    * @param loginRequest
    * @return*/
    @POST("/signin_for_token")
    Call<ResMsg<UserTokenVo>> login(@Body LoginRequest loginRequest);
}
