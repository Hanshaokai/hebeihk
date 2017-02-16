package cn.huischool.huixiao.framework.network;


import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import cn.huischool.huixiao.BuildConfig;
import cn.huischool.huixiao.common.utils.LogUtil;
import cn.huischool.huixiao.framework.network.ServerInterfaceDefinition.RequestMethod;

import android.os.AsyncTask;
import android.util.Log;

/**
 * 网路层 发送 异步请求 post 和get
 * HttpClient
 *
 * @author han
 *         <p/>
 *         2016-4-15
 */


public class HttpRequestAsyncTask extends AsyncTask<Request, Void, Object> {


    private String urlString;
    private String token;
    private String resultString;
    private Object object;
    private OnCompleteListener onCompleteListener;
    @Override
    protected Object doInBackground(Request... params) {
        // TODO Auto-generated method stub
        urlString = BuildConfig.URL;
        token = BuildConfig.TOKEN;
        DefaultHttpClient httpClient = ReqClient.getInstance();
        Request request = params[0];
        HttpResponse httpResponse;
        HttpGet httpGet = null;
        HttpPost httpPost = null;

        LogUtil.d("--------" + urlString + "  " + token);
        try {
            /**
             * GET请求字符串 拼接
             */
            if (RequestMethod.GET.equals(request.getServerInterfaceDefinition()
                    .getRequestMethod())) {
                urlString = urlString
                        + request.getServerInterfaceDefinition().getOpt();

                StringBuffer stringBuffer = new StringBuffer(urlString + "?");
                Set<Entry<String, String>> entrySet = request.getParamsMap().entrySet();
                for (Entry<String, String> entry : entrySet) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append('=');
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append('&');
                }

                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                Log.d("tag", "httpRequest==get请求地址" + stringBuffer);

                httpGet = new HttpGet(stringBuffer.toString());
                httpGet.addHeader("token", token);
                httpResponse = httpClient.execute(httpGet);
            } else {
                /**
                 * POST 请求
                 */
                urlString = urlString
                        + request.getServerInterfaceDefinition().getOpt();
                Log.d("tag", "httpRequest===post请求地址" + urlString);
                httpPost = new HttpPost(urlString);
                // 判断登录请求
                            /*if (urlString.contains(ServerInterfaceDefinition.OPT_LOGIN
                                    .getOpt())) {*
									//登录接口区别于别的接口
								httpPost.addHeader("token", "a312eaf0f03d9936b8082fb46b2638a7");
								//httpPost.addHeader("contentType", "application/json");
								
					/*		}*/
                httpPost.addHeader("token", token);

                JSONObject jsonParam = new JSONObject();
                if (request.getParamsMap() != null) {
                    Set<Entry<String, String>> entrySet = request.getParamsMap().entrySet();
                    for (Entry<String, String> entry : entrySet) {
                        jsonParam.put(entry.getKey(), entry.getValue());
                        Log.d("tag", "参数" + entry.getValue());
                    }
                }
                if (request.getJsonObject() != null) {

                    JSONObject jsonObject = request.getJsonObject();
                    jsonParam = jsonObject;
                    Log.d("tag", "参数" + jsonObject.toString());
                }
                if (null != jsonParam) {
                            /*Log.d("tag", ""+jsonParam.get("userName")+jsonParam.get("password"));	*/
                    //传入json字符串 后台 获得 json 请求形式

                    StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                    Log.d("tag", "httpRequest传入后台的字符串" + jsonParam.toString());
                    entity.setContentEncoding("UTF-8");
                    entity.setContentType("application/json");
                    httpPost.setEntity(entity);
                }

                httpResponse = httpClient.execute(httpPost);
            }

            if (httpResponse.getStatusLine().getStatusCode() != 200) {

                if (null != httpPost) {
                    httpPost.abort();
                }
                if (null != httpGet) {
                    httpGet.abort();
                }

                // 中断请求 留功能
            } else {

                resultString = EntityUtils.toString(httpResponse.getEntity(),
                        "UTF-8");
            }
            Log.d("tag", "httpRequest=====返回json" + resultString);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (request.getJsonParser() != null) {
            object = request.getJsonParser().parse(resultString);
        }//调用解析方法 获得结果
        Log.d("tag", object == null ? "解析为空" : "httpRequest==解析成功");
        return object;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        if (null != onCompleteListener) {
            if (null == result) {
                onCompleteListener.onComplete(null, null);
            } else {
                onCompleteListener.onComplete(result, resultString);//通过接口回调将数据传入到 数据处理层
            }
        }
    }

    /**
     * 定义回调接口
     *
     * @param <T> javabean
     * @author Administrator
     */
    public interface OnCompleteListener<T> {//泛型类

        public void onComplete(T result, String resultString);
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        // TODO Auto-generated method stub
        this.onCompleteListener = onCompleteListener;
    }

}
