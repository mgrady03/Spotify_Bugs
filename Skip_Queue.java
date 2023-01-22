import java.io.*;
import java.util.*;

/* a class representing a 
new queue traverse for spotify*/


public class Skip_Queue()
{
  private CDLL_Node<T> head;//pointer to the first elemant 
  private CDLL_Node<T> current;//pointer to current song being played
  private boolean pressBack=false;
  private boolean skip=false;

  public Skip_Queue(){
      head=null;
    current=head;;
  }
  
  public Skip_Queue( String fileName, String insertionMode ) throws Exception
	{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
			while ( infile.ready() )
			{	@SuppressWarnings("unchecked")
				T data = (T) infile.readLine(); // CAST CUASES WARNING (WHICH WE CONVENIENTLY SUPPRESS)
				if ( insertionMode.equals("atFront") )
					insertAtFront( data );
				else if ( insertionMode.equals( "atTail" ) )
					insertAtTail( data );
				else
					die( "FATAL ERROR: Unrecognized insertion mode <" + insertionMode + ">. Aborting program" );
			}
			infile.close();
	}

	private void die( String errMsg )
	{
		System.out.println( errMsg );
		System.exit(0);
	}
  
 
  
  
  
  
  @SuppressWarnings("unchecked")
	public int size()
	{
		int count=0;
		CDLL_Node<T> curr=head;

    if(curr==null)
		return 0;

		do
		{
			count++;
			curr=curr.next;

		}while(curr!=head);

		return count;
	}
  
  public void insertAtFront(T data)
	{
		
 		CDLL_Node<T> newNode = new CDLL_Node<T>( data,null,null);

		if (head==null)
			{
				newNode.next=newNode;
				newNode.prev=newNode;
				head = newNode;
				return;
			}
	
			head.prev.next=newNode;
  		newNode.next=head;
  		newNode.prev=head.prev;
  		head.prev=newNode;
  		head=newNode;

	}
  
  @SuppressWarnings("unchecked")
  public void play(){
    //test case 
    
    while(current!=null)
    {
    if(pressBack==true){
        current=current.prev;
        print();
      }
    if(skip==true){
      if(current.next==null)
        current=current.next;
      print();
    }
      
      else 
        print();
      
    } 
  }
  
  @SuppressWarnings("unchecked")
  public void print()//printing out what the queue looks like at each step;
  {
    current.toString();
  }
  
  @SuppressWarnings("unchecked")
	public String toString()
	{
		String result="";
		CDLL_Node<T> curr=head;
    do
		{
			if(curr!=head)
			   {
			result+="<=>"+curr;
		     }
			else
			  {
			result+=curr;
		    }

			curr=curr.next;

		}while(curr!=head);

		return result;
	}
  
}

class CDLL_Node<T>
{
  T data; // DONT DEFINE MEMBERS AS PUBLIC OR PRIVATE
  CDLL_Node<T> prev, next; //
  CDLL_Node() 		{ this( null, null, null ); }
  CDLL_Node(T data) { this( data, null, null);  }
  CDLL_Node(T data, CDLL_Node<T> prev, CDLL_Node<T> next)
  {	this.data=data; this.prev=prev; this.next=next;
  }
  public String toString() // TOSTRING MUST BE PUBLIC
  {	return ""+data;
  }
} //END NODE CLASS
