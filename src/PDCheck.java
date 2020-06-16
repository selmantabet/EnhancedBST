import java.util.*;

public class PDCheck {

	public PDCheck() {
		
	}

	public static void main(String[] args) {
		
		PDCheck eXec = new PDCheck(); //uncomment to execute.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Check palindrome: ");
		
		String inp = scan.nextLine();
		String inp2 = inp.replaceAll("\\s+",""); //Remove space using regex
		inp2 = inp2.toLowerCase();
		inp2 = inp2.replaceAll("\\p{Punct}", ""); //Removing punctuation marks using regex and setting all chars to lowercase.
		
		Stack<Character> stack1 = new Stack<Character>();
		
		for (int i = 0; i < inp2.length(); i++) { //Extract characters and push into Stack 1 (L2R parse)
			stack1.push(inp2.charAt(i));
		}
		
		Stack<Character> tmp = (Stack<Character>)stack1.clone(); //Take a copy of Stack1 to be pushed into 
		Stack<Character> stack2= new Stack<Character>();
		
		while(!tmp.empty()) {
			stack2.push(tmp.pop());
		}

		scan.close();
		while(!stack1.empty() && !stack2.empty()) {
			if (stack1.pop() != stack2.pop()) {
				System.out.print(false);
				return;
			}
			
		}
		
		if (stack1.isEmpty() && stack2.isEmpty()) { //both stacks should be empty by now, can use assert stack size too
			System.out.print(true);
			return;
		}
		
		System.out.print(false); //palindromes have equal number of characters
		
	}

}
