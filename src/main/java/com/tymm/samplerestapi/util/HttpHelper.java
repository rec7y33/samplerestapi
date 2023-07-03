package com.tymm.samplerestapi.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author cheong.tymm
 */
public class HttpHelper {
    public static <T, S> T postForObject(String path, S param, Class<T> clazz) throws Exception {
        HttpPost post = new HttpPost(path);
        post.addHeader("Content-Type", "application/json");

        // send a JSON data
        post.setEntity(new StringEntity(JSONObject.toJSONString(param)));

        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(post)) {
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new Exception(EntityUtils.toString(response.getEntity()));
            }
            
            T result = JSONObject.parseObject(EntityUtils.toString(response.getEntity()), clazz);

            return result;
        }
    }
}
