package cn.yangjian.www.httputil;

/**
 * Created by yangjian on 16-12-21.
 */
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by yangjian on 16-10-24.
 */
public class HttpUtil {
    /**
     * @param url
     * @param jsonParam
     * @return JSONObject
     */
    public static JSONObject doHttpPost(String url, JSONObject jsonParam) {
        //post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                StringEntity entity = new StringEntity(jsonParam.toString());
                method.setEntity(entity);
                method.setHeader("Accept", "application/json");
                method.setHeader("Content-Type", "application/json");
            }
            HttpResponse result = null;
            result = httpClient.execute(method);
            // System.out.println(result);
            //  url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            System.out.println(result.getStatusLine().getStatusCode());
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(str);

            }
        } catch (IOException e) {
            System.out.println(e);
            //logger.error("post请求提交失败:" + url, e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonResult;
    }

    public static JSONObject doHttpRestPost(String url) {
        //post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            HttpResponse result = null;
            try {
                result = httpClient.execute(method);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //  url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(str);
            }
        } catch (IOException e) {
            //logger.error("post请求提交失败:" + url, e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonResult;
    }

    public static JSONObject doHttpGet(String url) {
        JSONObject jsonResutl = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet getRequest = new HttpGet(url);

        // getRequest.addHeader("accept", "application/json");

        HttpResponse response = null;
        try {
            response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                HttpEntity httpEntity = response.getEntity();
                String apiOutput = null;
                apiOutput = EntityUtils.toString(httpEntity);
                jsonResutl = JSONObject.fromObject(apiOutput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonResutl;
    }
}
