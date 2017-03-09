import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class main {

    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet("https://stream.twitter.com/1.1/statuses/sample.json");

            System.out.println("Executing request " + httpget.getRequestLine());

            String AUTHORIZATION_HEADER = "OAuth oauth_consumer_key=\"zj4ULVaOJsEitv2SWCHbFyKuK\"" +
                    "oauth_nonce=\"k4444BB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg\"" +
                    "oauth_timestamp=\"1448336861939\"" +
                    "oauth_token=\"3210281393-OZuruJwCZ6vSdBdhqwbUUPcPiV9Zijg1SD47oWP\"" +
                    "oauth_version=\"1.0\"";
            httpget.setHeader("Authorization", AUTHORIZATION_HEADER);

            CloseableHttpResponse response = httpclient.execute(httpget);

            try {
                System.out.println("-----------------status-----------------");
                System.out.println("status is " + response.getStatusLine());
                System.out.println("-----------------stream-------------------");
                System.out.println(EntityUtils.toString(response.getEntity()));
                System.out.println("------------------end-------------------");
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
