import org.eclipse.jetty.client.ContentResponse;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.StringRequestContent;

import com.google.gson.Gson;

import model.Info;

public class Test {
	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.start();
		
		Info info = new Info();
		info.setName("MJ");
		
		Gson gson = new Gson();
		String jsonReq = gson.toJson(info);
		
		ContentResponse res = client.POST("http://127.0.0.1:9090/info").body(new StringRequestContent(jsonReq)).send();
		System.out.println(res.getStatus());
		System.out.println(res.getContentAsString());
	}
}
