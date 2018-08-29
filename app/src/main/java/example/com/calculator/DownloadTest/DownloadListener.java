package example.com.calculator.DownloadTest;

/**
 * Created by 钱俊华 on 2018/8/27 0027.
 */

public interface DownloadListener{

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
