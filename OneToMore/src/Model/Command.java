package Model;

import java.io.Serializable;
import java.util.Date; //��֪����sql����utl

public class Command implements Serializable{
	private Date sendDate;

	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}	
}