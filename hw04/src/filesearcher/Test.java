package filesearcher;
import testutil.TestRunner;


public class Test {
	public static void main(String[] args) {
		TestRunner.enableException(true);

		TestRunner.runTest(()->{
			String inputFile = "/home/zhuzhenhao/java_hw/hw4/data/dialog.txt";
			int ans = FileSearcher.search(inputFile, "we");
			System.out.println("Ans: "+ans);
			System.out.println("Expected: "+35);
			if (ans==35) System.out.println("Accept");
			else System.out.println("Wrong Answer");
		},1000);

		TestRunner.runTest(()->{
			String inputFile = "/home/zhuzhenhao/java_hw/hw4/data/dialog.txt";
			int ans = FileSearcher.search(inputFile, "Queenstown");
			System.out.println("Ans: "+ans);
			System.out.println("Expected: "+2);
			if (ans==2) System.out.println("Accept");
			else System.out.println("Wrong Answer");
		},1000);

		TestRunner.runTest(()->{
			String inputFile = "/home/zhuzhenhao/java_hw/hw4/data/dialog.txt";
			int ans = FileSearcher.search(inputFile, "August");
			System.out.println("Ans: "+ans);
			System.out.println("Expected: "+46);
			if (ans==46) System.out.println("Accept");
			else System.out.println("Wrong Answer");
		},1000);

		System.exit(0);
	}
}

