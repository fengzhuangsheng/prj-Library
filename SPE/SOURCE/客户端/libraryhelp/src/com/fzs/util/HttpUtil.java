package com.fzs.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	// ����HttpClient����
	// public static HttpClient httpClient = new DefaultHttpClient();
	public static final String BASE_URL = "http://192.168.173.1:8080/GDUT-Library-RM-SRS/";

	/**
	 * @param url���������URL
	 * @return ��������Ӧ�ַ���
	 * @throws Exception
	 */
	public static String getRequest(final String url) throws Exception {
		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {

						// ����HttpGet����
						HttpGet get = new HttpGet(url);
						// ����HttpClient����
						HttpClient httpClient = new DefaultHttpClient();
						// ����GET����
						HttpResponse httpResponse = httpClient.execute(get);
						// ����������ɹ��ط�����Ӧ
						if (httpResponse.getStatusLine().getStatusCode() == 200) {
							// ��ȡ��������Ӧ�ַ���
							String result = EntityUtils.toString(httpResponse
									.getEntity());
							get.abort();
							return result;
						}
						return null;

					}
				});
		new Thread(task).start();
		return task.get();
	}

	/**
	 * @param url
	 *            ���������URL
	 * @param params
	 *            �������
	 * @return ��������Ӧ�ַ���
	 * @throws Exception
	 */
	public static String postRequest(final String url,
			final Map<String, String> rawParams) throws Exception {
		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// ����HttpPost����
						HttpPost post = new HttpPost(url);
						String result = null;
						// ������ݲ��������Ƚ϶�Ļ����ԶԴ��ݵĲ������з�װ
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						for (String key : rawParams.keySet()) {
							// ��װ�������
							params.add(new BasicNameValuePair(key, rawParams
									.get(key)));
						}
						// �����������
						post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
						try {
							// ����HttpClient����
							HttpClient httpClient = new DefaultHttpClient();
							// ����POST����
							HttpResponse httpResponse = httpClient
									.execute(post);
							if (httpResponse.getStatusLine().getStatusCode() == 200) {
								result = EntityUtils.toString(httpResponse
										.getEntity());
								post.abort();
								return result;
							}
						} catch (ClientProtocolException e) {
							e.printStackTrace();
							result = "�����쳣��";
							return result;
						} catch (IOException e) {
							e.printStackTrace();
							result = "�����쳣��";
							return result;
						}
						return null;
					}
				});
		new Thread(task).start();
		return task.get();
	}
}
