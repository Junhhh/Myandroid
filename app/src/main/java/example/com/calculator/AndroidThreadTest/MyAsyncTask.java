package example.com.calculator.AndroidThreadTest;

import android.os.AsyncTask;

/**
 * Created by 钱俊华 on 2018/8/27 0027.
 */

public class MyAsyncTask extends AsyncTask<Void,Integer,Integer> {

    //在后台任务开始前执行，比如显示一个进度条
    @Override
    protected void onPreExecute() {

    }
    //这个方法所有代码都会在子线程中运行
    @Override
    protected Integer doInBackground(Void... voids) {
        return null;
    }
    //在这里可以进行UI操作，即在主线程运行
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
    //这里提示下载结束的结果
    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

}
