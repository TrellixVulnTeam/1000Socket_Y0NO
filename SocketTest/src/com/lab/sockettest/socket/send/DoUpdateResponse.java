package com.lab.sockettest.socket.send;

import com.lab.sockettest.console.util.BytesUtil;
import com.lab.sockettest.console.util.CRC16Util;
import shit.socket.pack.Send;

public class DoUpdateResponse extends BaseSendPack {

	/**
	 *
	 */
	private static final long serialVersionUID = -3698977595014511293L;

	public DoUpdateResponse() {
		super();
		funcCode = new byte[] {05, 04};
	}

	private int packCount;

	private int packIndex;

	private byte[] pack;

	public int getPackCount() {
		return packCount;
	}

	public void setPackCount(int packCount) {
		this.packCount = packCount;
	}

	public int getPackIndex() {
		return packIndex;
	}

	public void setPackIndex(int packIndex) {
		this.packIndex = packIndex;
	}

	public byte[] getPack() {
		return pack;
	}

	public void setPack(byte[] pack) {
		this.pack = pack;
	}


	@Override
	protected byte[] body() {
		int packSize = pack.length;
		byte[] b = new byte[8 + packSize];
		BytesUtil.addBytes(b, 0, BytesUtil.intToBytes(packCount, 2));
		BytesUtil.addBytes(b, 2, BytesUtil.intToBytes(packIndex, 2));
		BytesUtil.addBytes(b, 4, BytesUtil.intToBytes(packSize, 2));
		BytesUtil.addBytes(b, 6, pack);
		BytesUtil.addBytes(b, 6 + packSize, BytesUtil.intToBytes(CRC16Util.calcCrc16(pack), 2));
		return b;
	}

	@Send
	@Override
	public byte[] send() {
		return super.send();
	}
	
	

}
