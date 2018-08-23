package example.com.calculator.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

import example.com.calculator.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationActivity.this,NotificationOneActivity.class);

                PendingIntent p = PendingIntent.getActivity(NotificationActivity.this,0,intent,0);

                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                Notification notification = new NotificationCompat.Builder(NotificationActivity.this)
                        .setContentTitle("This is Title!")//标题
                        .setContentText("This is text")//正文
                        .setWhen(System.currentTimeMillis())//显示时间
                        .setSmallIcon(R.mipmap.ic_launcher)//状态栏图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))//大图标
                        .setContentIntent(p)//设置点击跳转事件
                        .setAutoCancel(true)//点击后通知会消失
                        /*.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Lyra.ogg")))
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .setLights(Color.GREEN,1000,1000)*/
                        .setDefaults(NotificationCompat.DEFAULT_ALL)//使用默认通知铃声震动等
                        .setPriority(NotificationCompat.PRIORITY_MAX)//通知级别最高，也就是紧急通知，一定要立刻通知到用户
                        .build();
                manager.notify(1,notification);
            }
        });
    }
}
