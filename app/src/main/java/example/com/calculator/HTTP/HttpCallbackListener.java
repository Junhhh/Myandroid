package example.com.calculator.HTTP;

/**
 * Created by 钱俊华 on 2018/8/23 0023.
 */

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}
