public class SList {
	private SNode head;
	public SList(){
		head=null;
	}
	public void insert(double val, int position) {
		if(head==null )
		{	head=new SNode(val,null);
			return;
		}
		else if(position==0)
		{
			head=new SNode(val,head);
			return;
		}
		SNode p=head,q=head.next;
		while(q!=null && position>1)
		{
			position--;
			p=q;
			q=q.next;
		}
		p.next=new SNode(val,q);
	}
	public void print(){
		SNode p=head;
		while(p!=null){
			System.out.print(p.val+" ");
			p=p.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		SList sl=new SList();
		sl.insert(2.0,0);
		sl.insert(5.0,0);sl.insert(4.0,1);sl.insert(9.0,9);
		sl.print();
		sl.insert(4.5,2);sl.print();
	}
}