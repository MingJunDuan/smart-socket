package org.smartboot.socket.protocol.p2p;

/**
 * 消息解码异常
 * 
 * @author Seer
 * 
 */
public class DecodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DecodeException(String string) {
		super(string);
	}

}
