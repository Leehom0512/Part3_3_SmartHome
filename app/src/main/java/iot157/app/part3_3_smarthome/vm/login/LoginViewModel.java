package iot157.app.part3_3_smarthome.vm.login;

import androidx.lifecycle.ViewModel;
import iot157.app.part3_3_smarthome.model.login.ObservableLoginInfo;

public class LoginViewModel extends ViewModel {
    private ObservableLoginInfo loginVo;
    public LoginViewModel(){
        loginVo = new ObservableLoginInfo();
    }

    public ObservableLoginInfo getLoginVo() {
        return loginVo;
    }

    public void setLoginVo(ObservableLoginInfo loginVo) {
        this.loginVo = loginVo;
    }
}
