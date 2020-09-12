// Implementation of a integer doubly linked list

class Node
{
	int data;
	Node prev,next;

	Node(int d)
	{
		data  = d;
		prev = next = null;
	}
}

class List
{
	Node head, tail;

	List()
	{
		head = tail = null;
	}

	void addElement(int data)
	{
		Node a = new Node(data);
		if(isEmpty())
		{
			head = tail = a;
			return;
		}
		tail.next = a;
		a.prev = tail;
		tail = a;
	}

	void addElement(int position, int data)
	{
		int length = getLength();
		if(position<0)
		{
			System.err.println("Invalid position, negative ");
			return ;
		}
		if(position>length)
		{
			System.err.println("Position is greater than length, ignoring insert...");
			return;
		}
		if(isEmpty())
			addElement(data);
		else
		{
			if(position==0)
			{
				Node a = new Node(data);
				a.next = head;
				head.prev = a;
				head = a;
			}
			else
			{
				Node current = head;
				for(int i=0;i<position-1;i++)
					current = current.next;
				Node a = new Node(data);
				a.prev = current;
				a.next = current.next;
				if(current.next!=null)
				{
					current.next.prev = a;
					tail  = a;
				}
				current.next  = a;
			}
		}
	}


	boolean isEmpty()
	{
		return head==null;
	}

	int getLength()
	{
		if(isEmpty())
			return 0;
		int i = 0;
		Node current = head;
		while(current!=null)
		{
			i++;
			current = current.next;
		}
		return i;
	}

	void printList(boolean reverse)
	{
		if(!reverse)
		{
			Node current = head;
			while(current!=null)
			{
				System.out.print(current.data+"  ");
				current = current.next;
			}
		}
		else
		{
			Node current = tail;
			while(current!=null)
			{
				System.out.print(current.data+"  ");
				current = current.prev;
			}
		}
		System.out.println();
	}
}

public class DoublyLinkedList
{
	public static void main(String[] args)
	{
		List l = new List();
		l.addElement(6);
		l.addElement(4);
		l.addElement(8);
		l.printList(false);
		l.addElement(0,-1);
		l.addElement(4,-6);
		l.addElement(7,30);
		l.addElement(-2,30);
		l.printList(false);
	}
}
