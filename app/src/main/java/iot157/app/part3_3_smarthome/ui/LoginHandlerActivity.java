package iot157.app.part3_3_smarthome.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import iot157.app.part3_3_smarthome.R;
import iot157.app.part3_3_smarthome.databinding.ActivityLoginBinding;
import iot157.app.part3_3_smarthome.vm.login.LoginViewModel;

public class LoginHandlerActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding activityLoginBinding;
    private ProgressBar progressBar;
    private TextView username;
    private TextView password;
    private LoginHandler handler;
    private Button loginBtn;

    private static final class LoginHandler extends Handler {
        private WeakReference<LoginHandlerActivity> activity;

        public LoginHandler (LoginHandlerActivity act) {
            activity = new WeakReference<LoginHandlerActivity>(act);
        }

        @Override
        public void handleMessage(Message msg) {
            //TODO:请完成此处代码，获取用户名，跳转到MainActivity，并提示“欢迎你+用户名”。
            if (msg.what == 1){
                ProgressBar pb = (ProgressBar) activity.get().findViewById(R.id.progressBar);
                Button btn = (Button) activity.get().findViewById(R.id.loginBtn);
                pb.setVisibility(View.GONE);
                btn.setEnabled(true);
                Toast.makeText(activity.get(),"欢迎你 " + msg.obj,Toast.LENGTH_SHORT).show();
                activity.get().startActivity(new Intent(activity.get(), MainActivity.class));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从视图中获取绑定对象
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        //设置绑定对象的生命周期拥有者为本对象
        activityLoginBinding.setLifecycleOwner(this);
        //创建 ViewModel
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        //绑定对象设值 ViewModel
        activityLoginBinding.setLoginViewModel(loginViewModel);
        loginBtn=(Button)findViewById(R.id.loginBtn);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        handler=new LoginHandler(LoginHandlerActivity.this);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String uname=loginViewModel.getLoginVo().username.get();
                progressBar.setVisibility(View.VISIBLE);
                loginBtn.setEnabled(false);
                new Thread(){
                    @Override
                    public void run() {
                        //子线程内部不能执行UI操作，只传输数据
                        try {
                            //睡眠3秒 模拟网络请求
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //TODO: 发送用户名给handler
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = uname;
                        handler.sendMessage(msg);
                    }
                }.start();
            }
        });
//        Button fillBtn = (Button) findViewById(R.id.fillBtn);
//        fillBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //给ViewModel的username设值，观察视图的用户名是否绑定对应的值
//                loginViewModel.getLoginVo().username.set("On9");
//                loginViewModel.getLoginVo().password.set("167169");
//            }
//        });
    }
}
