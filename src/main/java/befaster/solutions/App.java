package befaster.solutions;

public class App {
	public static Integer checkout(String input) {
//		
//		if(input.length() == 0) {
//			return 0;
//		}
		
		Integer total = 0;
		int count_A = 0;
		int count_B = 0;
		String current = "";
		for(int i = 0; i < input.length(); i++) {
			current = "" + input.charAt(i);
			switch(current) {
			case "A":
				total += 50;
				count_A++;
				if(count_A == 3) {
					total -= 20;
					count_A = 0;
				}
				break;
			case "B":
				total += 30;
				count_B++;
				if(count_B == 2) {
					total -= 15;
					count_B = 0;
				}
				break;
			case "C":
				total += 20;
				break;
			case "D":
				total += 15;
				break;
			default:
				return -1;
			}
		}
		return total;
	}
}