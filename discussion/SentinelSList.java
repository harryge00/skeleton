public class SentinelSList {
	private SNode front;
	private SNode back;
	public SentinelSList() {
		this.back = new SNode(0, null);
		this.front = new SNode(0, back);
	}
	public void insert(double val, int position) {
		if(front.next==back || position==0)
		{
			front.next=new SNode(val,front.next);
		}
		else
		{
			SNode p=front.next.next, temp=front.next;
			while(p!=back && position>1)
			{
				temp=p;p=p.next;
				position--;
			}
			temp.next=new SNode(val,temp.next);
		}
		
	}
	public int[] xify (int[] x)
	{
		int sum=0;
		for (int i=0;i<x.length;i++)
			sum+=x[i];
		
		int [] y=new int[sum];
		int index=0;
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[i];j++)
				y[index++]=x[i];
		}
		return y;
	}
	public void print(){
		SNode p=front.next;
		while(p!=back){
			System.out.print(p.val+" ");
			p=p.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		SentinelSList  sl=new SentinelSList ();
		sl.insert(2.0,0);
		sl.insert(5.0,0);sl.insert(4.0,1);sl.insert(9.0,9);
		sl.print();
		sl.insert(4.5,2);sl.print();
		int []x={2,3,4,1};
		x=sl.xify(x);
		for(int i=0;i<x.length;i++)
		{
			System.out.print(x[i]+" ");
			
		
		}
	}
}
