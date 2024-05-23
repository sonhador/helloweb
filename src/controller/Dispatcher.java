package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler.Abstract.NonBlocking;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.Callback;

public class Dispatcher extends NonBlocking {
	private InfoHandler infoHandler;
	
	public Dispatcher() {
		this.infoHandler = new InfoHandler();
	}
	
	@Override
	public boolean handle(Request request, Response response, Callback callback) throws Exception {
		String path = request.getHttpURI().getPath();
		
		switch(path) {
		case "/info":
			this.infoHandler.handle(request, response);
			break;
		case "/work":
			break;
		default:
			return false;
		}
		return true;
	}
}
