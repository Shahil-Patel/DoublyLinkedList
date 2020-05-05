public class ShahilDLLRunner
{
	public ShahilDLLRunner()
	{
		DoublyLinkedList<Integer> list=new DoublyLinkedList<Integer>();
		for(int x=0;x<30;x++)
		{
			list.add((int)(Math.random()*1000)+1);
		}
		System.out.println("List: "+list);
		System.out.println("List Reversed: "+list.toReversedString()+"\n");
		System.out.println("List Size: "+list.size()+"\n");
		int sum=0;
		int sumEven=0;
		int sumOdd=0;
		DoublyLinkedList<Integer> tempList=new DoublyLinkedList<Integer>();
		int size=list.size();
		for(int x=0;x<size;x++)
		{
			tempList.add(list.getRoot());
			if(x%2==0)
			{
				sumEven+=list.getRoot();
			}
			if(x%2==1)
			{
				sumOdd+=list.getRoot();
			}
			sum+=list.getRoot();
			list.getNext();
		}
		list=tempList;
		DoublyLinkedList<Integer> tempList2=new DoublyLinkedList<Integer>();
		System.out.println("Sum Even: "+sumEven);
		System.out.println("Sum Odd: "+sumOdd);
		System.out.println("Sum: "+sum+"\n");
		for(int x=0;x<size;x++)
		{
			tempList.add(list.getRoot());
			if(list.getRoot()%2==0)
			{
				tempList2.add(list.getRoot());
			}
			list.getNext();
		}
		for(int x=0;x<tempList2.size();x++)
		{
			tempList.add(tempList2.getRoot());
			tempList2.getNext();
		}
		list=tempList;
		tempList=new DoublyLinkedList<Integer>();
		tempList2=new DoublyLinkedList<Integer>();
		System.out.println("Duplicate Evens: "+list+"\n");
		for(int x=0;x<list.size();x++)
		{
			if(list.get(x)%3==0)
			{
				list.remove(x);
			}
		}
		System.out.println("No #/3: "+list+"\n");
		list.add(3,5555);
		System.out.println("Add(3,5555): "+list+"\n");
		for(int x=0;x<list.size();x++)
		{
			for(int y=0;y<list.size()-1;y++)
			{
				if(list.get(y)<list.get(y+1))
				{




				}
			}
		}
		System.out.println("Sorted: "+list+"\n");
		DoublyLinkedList<String> strList=new DoublyLinkedList<String>();
		String str="Georgia Tech is overrated along with University of Michigan";
		String st[]=str.split(" ");
		for(int x=0;x<st.length;x++)
		{
			strList.add(st[x]);
		}
		System.out.println("String DLL: "+strList+"\n");
		for(int x=0;x<strList.size();x++)
		{
			if(strList.get(x).length()<=3)
			{
				strList.remove(x);
			}
		}
		System.out.println("No Short Words: "+strList+"\n");
		for(int x=0;x<strList.size();x++)
		{
			for(int y=0;y<strList.size()-1;y++)
			{



			}
		}
		System.out.println("Sorted: "+strList+"\n");
		double avg=0.0;
		size=strList.size();
		for(int x=0;x<size;x++)
		{
			avg+=strList.getRoot().length();
			strList.getNext();
		}
		avg/=size;
		System.out.println("Average Length: "+avg+"\n");
	}
	public static void main(String[] args)
	{
		ShahilDLLRunner app=new ShahilDLLRunner();
	}
}