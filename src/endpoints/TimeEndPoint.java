/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoints;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/time")
public class TimeEndPoint {
	Thread childThread;

	@OnOpen
	public void openConnection(final Session session) {
		System.out.println("Opened connection for TimeEndPoint");
		childThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(5000);
						// write to all
						session.getBasicRemote().sendText(
								new java.util.Date().toString());
					} catch (Exception ex) {
					}
				}
			}
		});
		childThread.start();
	}

}
