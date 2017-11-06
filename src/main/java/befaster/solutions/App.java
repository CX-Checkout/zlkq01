package befaster.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	private static int count_A = 0;
	private static int count_B = 0;
	private static int discounted_Bs = 0;
	private static int count_E = 0;
	private static int possible_free_Bs = 0;
	private static String mInput = "";
	private static String[] itemTypesArray = {"A", "B", "C", "D", "E"};
	
	public static Integer checkout(String input) {
		
		if(input.length() == 0) {
			return 0;
		}
		mInput = removeFreeItems(input);
		reset();
		
		char[] inputArray = mInput.toCharArray();
		Arrays.sort(inputArray);
		Integer total = 0;
		if(checkValidInput(inputArray)) {
			for(String itemType: itemTypesArray) {
				total += addItemToTotal(itemType.charAt(0));
			}
		} else {
			return -1;
		}
		
		return total;
	}

	protected static boolean checkValidInput(char[] inputArray) {
		for(char character: inputArray) {
			String itemType = "" + character;
			switch(itemType) {
			case "A":
				break;
			case "B":
				break;
			case "C":
				break;
			case "D":
				break;
			case "E":
				break;
			default:
				return false;
			}
		}
		return true;
	}
	
	public static void reset() {
		count_A = 0;
		count_B = 0;
		discounted_Bs = 0;
		count_E = 0;
		String without_Bs = mInput.replace("B", "");
		possible_free_Bs = mInput.length() - without_Bs.length();
	}
	
	public static int calculateAmountForType(String total, String type) {
		String total_without_type = total.replace(type, "");
		return total.length() - total_without_type.length();
	}
	
	public static int addItemToTotal(char character) {
		int item_cost = 0;
		String current = "" + character;
		int itemsTypeTotal = 0;
		switch(current) {
		case "A":
			itemsTypeTotal = calculateAmountForType(mInput, "A");
			while(itemsTypeTotal >= 5) {
				item_cost += 200;
				itemsTypeTotal -= 5;
			}
			if(itemsTypeTotal >= 3) {
				item_cost += 130;
				itemsTypeTotal -= 3;
			}
			item_cost += 50 * itemsTypeTotal;
			break;
		case "B":
			itemsTypeTotal = calculateAmountForType(mInput, "B");
			while(itemsTypeTotal >= 2) {
				item_cost += 45;
				itemsTypeTotal -= 2;
			}
			item_cost += 30 * itemsTypeTotal;
			break;
		case "C":
			itemsTypeTotal = calculateAmountForType(mInput, "C");
			item_cost += 20 * itemsTypeTotal;
			break;
		case "D":
			itemsTypeTotal = calculateAmountForType(mInput, "D");
			item_cost += 15 * itemsTypeTotal;
			break;
		case "E":
			itemsTypeTotal = calculateAmountForType(mInput, "E");
			item_cost += 40 * itemsTypeTotal;
//			while(itemsTypeTotal >= 2) {
//				item_cost -= 30;
//				itemsTypeTotal -= 2;
//			}
			break;
		default:
			return -1;
		}
			
		return item_cost;
	}

	public static String removeFreeItems(String input) {
		int itemsTypeTotal = calculateAmountForType(input, "E");
		while(itemsTypeTotal >= 2) {
			if(input.contains("B")) {
				input = input.replaceFirst("B", "");
			}
			itemsTypeTotal -= 2;
		}
		return input;
	}
}
