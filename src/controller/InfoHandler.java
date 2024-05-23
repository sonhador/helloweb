package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;

import com.google.gson.Gson;

import model.Info;
import model.InfoResponse;
import util.Util;

public class InfoHandler {
	public void handle(Request request, Response response) throws IOException {
		String body = Util.bodyToString(request);
		
		Gson gson = new Gson();
		Info info = gson.fromJson(body, Info.class);
		
		InfoResponse res = new InfoResponse();
		res.setMsg("Hello "+info.getName());
		
		response.write(true, StandardCharsets.UTF_8.encode(gson.toJson(res)), null);
	}
}
