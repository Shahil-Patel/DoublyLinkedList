public class DoublyLinkedList<E>
{
	private ListNode root;
	private ListNode end;
	private int length=0;
	public DoublyLinkedList()
	{
		root=null;
		end=null;
	}
	public DoublyLinkedList(E root)
	{
		this.root=new ListNode(root);
		end=null;
	}
	public E getRoot()
	{
		return (E)root.getValue();
	}
	public E get(int pos)
	{
		int count=0;
		for(ListNode<E> x=root;x!=null;x=x.getNext())
		{
			if(count==pos)
			{
				return (E)x.getValue();
			}
			count++;
		}
		return null;
	}
	public E getEnd()
	{
		return (E)end.getValue();
	}
	public void add(E obj)
	{
		if(root==null)
		{
			root=new ListNode(obj);
			end=new ListNode(obj);
		}
		else if(!end.hasPrevious())
		{
			end=new ListNode(obj);
			end.setPrevious(root);
			root.setNext(end);
		}
		else
		{
			end.setNext(new ListNode(obj));
			end.getNext().setPrevious(end);
			end.getPrevious().setNext(end);
			end=end.getNext();
		}
		length++;
	}
	public void add(int pos,E obj)
	{
		if(pos<0||pos>length)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(pos==length)
		{
			add(obj);
		}
		else if(pos==0)
		{
			if(root==null)
			{
				root=new ListNode(obj);
				end=new ListNode(obj);
			}
			else if(!end.hasPrevious())
			{
				root=new ListNode(obj);
				root.setNext(end);
				end.setPrevious(root);
			}
			else
			{
				root.setPrevious(new ListNode(obj));
				root.getPrevious().setNext(root);
				root.getNext().setPrevious(root);
				root=root.getPrevious();
			}
			length++;
		}
		else
		{
			ListNode temp=root;
			for(int x=0;x<pos-1;x++)
			{
				temp=temp.getNext();
			}
			ListNode next=temp.getNext();
			ListNode newN=new ListNode(obj);
			newN.setPrevious(temp);
			newN.setNext(next);
			temp.setNext(newN);
			next.setPrevious(newN);
			length++;
		}
	}
	public void clear()
	{
		root=null;
		end=null;
	}
	public boolean contains(E obj)
	{
		for(ListNode x=root;x!=null;x=x.getNext())
		{
			if(x.getValue().equals(obj))
			{
				return true;
			}
		}
		return false;
	}
	public boolean isEmpty()
	{
		return length<1;
	}
	public E getNext()
	{
		return (E)remove(0);
	}
	public ListNode<E> remove(int pos)
	{
		ListNode temp=new ListNode(root);
		if(pos<0||pos>length)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(pos==length)
		{
			if(length==1)
			{
				root=null;
				end=null;
				length--;
				return temp;
			}
			else if(length==2)
			{
				end=new ListNode(root);
				root=new ListNode(root);
				length--;
				return temp;
			}
			else
			{
				ListNode endTemp=end;
				end=end.getPrevious();
				end.setNext(null);
				end.setPrevious(end.getPrevious());
				length--;
				return endTemp;
			}
		}
		else if(pos==0)
		{
			if(length==1)
			{
				root=null;
				end=null;
				length--;
				return temp;
			}
			else if(length==2)
			{
				ListNode rootTemp=root;
				root=root.getNext();
				root.setPrevious(null);
				root.setNext(null);
				end=root;
				length--;
				return rootTemp;
			}
			else
			{
				ListNode rootTemp=root;
				root=root.getNext();
				root.setPrevious(null);
				root.setNext(root.getNext());
				length--;
				return rootTemp;
			}
		}
		else
		{
			ListNode temp2=root;
			for(int x=0;x<pos;x++)
			{
				temp2=temp2.getNext();
			}
			if(temp2.getValue().equals(end.getValue()))
			{
				ListNode endTemp=end;
				end=end.getPrevious();
				end.setNext(null);
				end.setPrevious(end.getPrevious());
				length--;
				return endTemp;
			}
			else
			{
				ListNode returnTemp=temp2;
				ListNode next=temp2.getNext();
				ListNode previous=temp2.getPrevious();
				temp2.getPrevious().setNext(next);
				temp2.getNext().setPrevious(previous);
				length--;
				return returnTemp;
			}
		}
	}
	public int size()
	{
		return length;
	}
	public String toString()
	{
		String t="[";
		for(ListNode x=root;x!=null;x=x.getNext())
		{
			t+=x.getValue();
			if(x.getNext()!=null)
			{
				t+=", ";
			}
		}
		return t+="]";
	}
	public String toReversedString()
	{
		String t="[";
		for(ListNode x=end;x!=null;x=x.getPrevious())
		{
			t+=x.getValue();
			if(x.getPrevious()!=null)
			{
				t+=", ";
			}
		}
		return t+="]";
	}
	public class ListNode<E>
	{
		private E value;
		private ListNode next;
		private ListNode previous;
		public ListNode(E initValue)
		{
			value=initValue;
			next=null;
		}
		public E getValue()
		{
			return value;
		}
		public ListNode<E> getNext()
		{
			return next;
		}
		public ListNode<E> getPrevious()
		{
			return previous;
		}
		public void setValue(E theNewValue)
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
}