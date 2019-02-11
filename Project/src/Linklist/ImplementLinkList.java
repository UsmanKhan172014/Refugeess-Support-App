package Linklist;

import java.awt.event.MouseEvent;

public class ImplementLinkList {
	public static int serial=0;
	
	private Node start , end , temp,temp2;
	public ImplementLinkList() {
		start = null;
		end= null;
		temp= null;
	}
	public void Insert(Node n) {
		Node node = new Node();
		node = n;
		if (start==null) {
			start = node;
			end= node;
			end.link=null;
			serial++;
		}
		else {
			end.link= node;
			end= node;
			serial++;
			end.link=null;
		}
	}
	public String getModels() {
		temp= start;
		do {
		temp2=temp.link;
		return temp.name;
		}while(temp!=null);
	}
}
