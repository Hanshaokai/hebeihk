package cn.huischool.huixiao.framework.network;

import org.apache.http.HttpVersion;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

/**
 * 对httpClient 进行配置 
 * 添加例如 cookies 的处理
 * @author han
 *
 * 2016-4-15
 */
public class ReqClient {
private static DefaultHttpClient httpClient;
public static DefaultHttpClient getInstance(){
	
	if (ReqClient.httpClient==null) {
		initHttpClient();
		
	}
	
	
	return httpClient;
	
	
	
	
	
}
private static void initHttpClient() {
	// TODO Auto-generated method stub

	HttpParams mDefaultHttpParams = new BasicHttpParams();
	/**
	 *这里具体 配置httpClient参数
	 */
	//设置连接超时
	HttpConnectionParams.setConnectionTimeout(mDefaultHttpParams, 15000);
	//设置请求超时
	HttpConnectionParams.setSoTimeout(mDefaultHttpParams, 15000);
	HttpConnectionParams.setTcpNoDelay(mDefaultHttpParams, true);
	HttpProtocolParams.setVersion(mDefaultHttpParams, HttpVersion.HTTP_1_1);
	HttpProtocolParams.setContentCharset(mDefaultHttpParams, HTTP.UTF_8);
	//持续握手
	HttpProtocolParams.setUseExpectContinue(mDefaultHttpParams, true);
	httpClient = new DefaultHttpClient(mDefaultHttpParams);
	
	
	
}
}
