package demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpGet;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ratpack.handling.ChainAction;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class Routes extends ChainAction {
	@Override
	protected void execute() throws Exception {
		handler("google", new Handler() {
			@Override
			public void handle(Context context) throws Exception {
				context.redirect("http://google.com");
			}
		});

		get("yahoo", new Handler() {
			@Override
			public void handle(Context context) throws Exception {
				context.redirect("http://yahoo.com");
			}
		});

		get("callwait/:waitTimeInMilis", new Handler() {
			@Override
			public void handle(Context context) throws Exception {
				int waitTime = context.getPathTokens().asInt("waitTimeInMilis");
				String content = getContent(waitTime);
				
				context.getResponse().contentType("application/json");
				context.getResponse().send(createResponse(content));
			}

			private String createResponse(String content) throws IOException {
				ObjectMapper mapper = new ObjectMapper();
				
				JsonData data = mapper.readValue(content, JsonData.class);
				data.setServiceName("Spring boot with Ratpack");
				data.setStatusCode(911);
				data.setRight(true);
				
				String response = mapper.writeValueAsString(data);
				return response;
			}

			private String getContent(int waitTime) throws IOException {
				URL obj = new URL("http://slow1.fedce.jetdev2.syseng.tmcs:8080/wait/" + waitTime);
				URLConnection conn = obj.openConnection();
				String content = IOUtils.toString(conn.getInputStream());
				return content;
			}
		});

		assets("public", "index.html");
	}
}