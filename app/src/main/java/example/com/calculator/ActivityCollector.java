package example.com.calculator;

import android.app.Activity;

import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 钱俊华 on 2018/7/14 0014.
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivivty(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
                //android.os.Process.killProcess(android.os.Process.myPid());
            }
        }
    }
}
