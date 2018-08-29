package example.com.calculator.AndroidThreadTest;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import example.com.calculator.R;

public class ThreadTestActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int UPADTE_TEXT = 1;

    private TextView text;

    private Button changText;


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){

        public void handleMessage(Message msg){
            switch (msg.what){
                case UPADTE_TEXT:
                    text.setText("Nice to me you!");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);
        changText = (Button)findViewById(R.id.chang_text);
        text = (TextView) findViewById(R.id.text);
        changText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.chang_text){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPADTE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
        }
    }
}
