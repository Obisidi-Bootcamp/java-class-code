package DataStructures;


class Stack{
	
	int[] stack=new int[5];
	int top=0;
	
	public void push(int data) {
		
		stack[top]=data;
		top++;
	}
	
	public int pop() {
	
		int data;
		top--;
		data=stack[top];//fetch the element and store it inside data
		stack[top]=0;//delete the element after fetching it
		return data;
		
	}
	
	public int peek() {
		
		int data;
		data=stack[top-1]; //fetch the element and store it inside the variable data
		return data;
		
	}
	
	public boolean isEmpty() {
		if(top<0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void show() {
		
		for(int i: stack) {
			System.out.print( i + " "); 
		}
	}
}
public class JavaStack {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack num=new Stack();
		
		num.push(12);
		num.push(6);
		System.out.println(num.peek());
		num.push(9);
		
		System.out.println(num.pop());
		
		num.show();
		
		System.out.println(num.isEmpty());

	}

}
