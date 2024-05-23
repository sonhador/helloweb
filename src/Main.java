import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import controller.Dispatcher;

public class Main {
	public static void main(String []args) throws Exception {
		Server server = new Server(9090);
		Connector connector = new ServerConnector(server);
		server.addConnector(connector);
		
		server.setHandler(new Dispatcher());
		server.start();
	}
}
