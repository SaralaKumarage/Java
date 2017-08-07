import java.util.Stack;

public class StackSort{
	public static void main(String[] args) {

		Stack<Integer> stack1 = new Stack<>();
		stack1.push(23);
		stack1.push(45);
		stack1.push(90);
		stack1.push(3);
		stack1.push(17);
		stack1.push(25);
		stack1.push(47);
		stack1.push(12);
		stack1.push(75);
		stack1.push(38);
		stack1.add(100);
		stack1.add(5);

		Stack<Integer> stack2 = new Stack<>();
		int size = stack1.size();

		int maxloc = 0;
		int round = 1;

		while (round <= size) {
			Integer max = stack1.get(0);
			for (int i = 0; i < size; i++) {
				if ((i + 1) >= size) {

					maxloc = stack1.indexOf(max);

					stack1.set(maxloc, 0);

					stack2.add(max);
					break;
				}

				if (max < stack1.get(i + 1)) {

					max = stack1.get(i + 1);
				}

			}
			round = round + 1;
		}

	    System.out.println("Sorted Array");
		System.out.println(stack2);
		
	}
}
