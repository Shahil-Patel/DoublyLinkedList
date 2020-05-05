public class ListNode
{
	private Object value;
	private ListNode next;
	private ListNode previous;
	public ListNode(Object initValue)
	{
		value=initValue;
		next=null;
	}
	public Object getValue()
	{
		return value;
	}
	public ListNode getNext()
	{
		return next;
	}
	public ListNode getPrevious()
	{
		return previous;
	}
	public void setValue(Object theNewValue)
	{
		value=theNewValue;
	}
	public void setNext(ListNode theNewNext)
	{
		next=theNewNext;
	}
	public void setPrevious(ListNode thePreviousPrevious)
	{
		previous=thePreviousPrevious;
	}
	public boolean hasNext()
	{
		if(next!=null)
		{
			return true;
		}
		return false;
	}
	public boolean hasPrevious()
	{
		if(previous!=null)
		{
			return true;
		}
		return false;
	}
}
