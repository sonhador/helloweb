package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.jetty.io.Content.Chunk;
import org.eclipse.jetty.server.Request;

public class Util {
	public static String bodyToString(Request request) throws IOException {
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		Chunk chunk = request.read();
		while (chunk.remaining() > 0) {
			byte[] bytes = new byte[4];
			int readCnt = chunk.get(bytes, 0, 4);
			
			byte[] read = new byte[readCnt];
			System.arraycopy(bytes, 0, read, 0, readCnt);
			
			buf.write(read);
		}
		
		return new String(buf.toByteArray());
	}
}
