package cn.com.gome.hawkeye.common.client.impl;

import cn.com.gome.hawkeye.common.client.AgentClient;
import cn.com.gome.hawkeye.common.model.MetricValue;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/26 0026
 */
public class HttpAgentClient implements AgentClient {

    private String url;
    private int timeout;

    public HttpAgentClient(String url) {
        this.url = url;
        this.timeout = 10;
    }

    public HttpAgentClient(String url, int timeout) {
        this.url = url;
        this.timeout = timeout;
    }

    public boolean send(List<MetricValue> dList) throws Exception {

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(this.timeout)
                .setConnectionRequestTimeout(this.timeout)
                .setSocketTimeout(this.timeout).build();
        HttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig).build();
        HttpPost post = new HttpPost(this.url);

        boolean flag = false;
        try {
            String textJson = JSON.toJSONString(dList);
            StringEntity s = new StringEntity(textJson);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
//            System.out.println("text josn" + textJson);

            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                String body = EntityUtils.toString(res.getEntity());
                if ("success".equals(body)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return flag;
    }
}
