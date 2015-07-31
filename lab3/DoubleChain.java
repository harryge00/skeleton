
public class DoubleChain {
	
	private DNode head;
	
	public DoubleChain(double val) {
		/* your code here. */
		head = new DNode(val); 
	}

	public DNode getFront() {
		return head;
	}

	/** Returns the last item in the DoubleChain. */		
	public DNode getBack() {
		/* your code here */
//		if(head==null || head.next==null)
//			return head;
//		else
//		{
//			return head.next.getBack();
//		}
		DNode p=head;
		while(p!=null && p.next!=null)
			p=p.next;
		return p;
	
	}
	
	/** Adds D to the front of the DoubleChain. */	
	public void insertFront(double d) {
		/* your code here */
		head=new DNode(null,d,head);
		
	}
	
	/** Adds D to the back of the DoubleChain. */	
	public void insertBack(double d) {
		/* your code here */
		if(head==null)
			head=new DNode(d);
		else
		{
			DNode p=head;
			while(p.next!=null)
			{
				p=p.next;
			}
			p.next=new DNode(p,d,null);
		}
	}
	
	/** Removes the last item in the DoubleChain and returns it. 
	  * This is an extra challenge problem. */
	public DNode deleteBack() {
		/* your code here */
		if(head==null)
			return null;
		else{
			DNode p=head;
			while(p.next!=null)
				p=p.next;
			p.prev.next=null;
			return p;
		}
		
	}
	
	/** Returns a string representation of the DoubleChain. 
	  * This is an extra challenge problem. */
	public String toString() {
		/* your code here */
		String str="";
		DNode p=head;
		while(p!=null)
		{
			str+=Double.toString(p.val)+" ";
			p=p.next;
		}
		return str;
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;
		
		private DNode(double val) {
			this(null, val, null);
		}
		
		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next =next;
		}
	}
	
}
