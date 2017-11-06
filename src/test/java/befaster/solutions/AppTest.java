package befaster.solutions;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class AppTest {

	@Test
	public void check_Invalid_Input() {
		assertThat(App.checkout("ACAI"), equalTo(-1));
	}
	
	@Test
	public void check_A() {
		assertThat(App.checkout("A"), equalTo(50));
	}
	
	@Test
	public void check_AA() {
		assertThat(App.checkout("AA"), equalTo(100));
	}
	
	@Test
	public void check_One_Each() {
		assertThat(App.checkout("ABCDE"), equalTo(155));
	}
	
	@Test
	public void check_empty() {
		assertThat(App.checkout(""), equalTo(0));
	}
	
	@Test
	public void check_A_Offer() {
		assertThat(App.checkout("ABCD"), equalTo(115));
	}
	
	@Test
	public void check_A_Multi_3() {
		assertThat(App.checkout("AAA"), equalTo(130));
	}
	
	@Test
	public void check_A_Multi_5() {
		assertThat(App.checkout("AAAAA"), equalTo(200));
	}
	
	@Test
	public void check_B_multi() {
		assertThat(App.checkout("BB"), equalTo(45));
	}
	
	@Test
	public void check_Complex_Multi() {
		assertThat(App.checkout("AABCAABCDB"), equalTo(310));
	}
	
	@Test
	public void check_E_Only_Multi() {
		assertThat(App.checkout("EEE"), equalTo(120));
	}
	
	@Test
	public void check_E_Multi_With_B() {
		assertThat(App.checkout("EBE"), equalTo(80));
	}
	
	@Test
	public void check_Multi_Free_B_Only_One_B() {
		assertThat(App.checkout("EBEEE"), equalTo(160));
	}
	
	@Test
	public void check_Multi_Free_B_Multy_B() {
		assertThat(App.checkout("BBEEEE"), equalTo(160));
	}
	
	@Test
	public void check_Multi_Free_B_Multy_B_Complex() {
		assertThat(App.checkout("AAAAAAAABBBEE"), equalTo(455));
	}
	
	@Test
	public void check_Multi_Free_B_Multy_B_Complex1B() {
		assertThat(App.checkout("EEBBB"), equalTo(125));
	}
	
	@Test
	public void check_Multi_Free_B_Multy_B_Complex2() {
		assertThat(App.checkout("ABCDECBAABCABBAAAEEAA"), equalTo(665));
	}
	
	//Test for calculate amount of type
	@Test
	public void calculateAmountForType() {
		String allItems = "ABCDECBAABCABBAAAEEAA";
		assertThat(App.calculateAmountForType(allItems, "A"), equalTo(9));
	}

	//Test for checkValidInput amount of type
	@Test
	public void checkValidInput_Valid_ReturnTrue() {
		String allItems = "ABCDECBAABCABBAAAEEAA";
		assertThat(App.checkValidInput(allItems.toCharArray()), equalTo(true));
	}
	
	//Test for checkInValidInput amount of type
	@Test
	public void checkValidInput_Invalid_ReturnFalse() {
		String allItems = "ABCDECBAABCABBA9AEEAA";
		assertThat(App.checkValidInput(allItems.toCharArray()), equalTo(false));
	}
	
	//Test for removeFreeItems amount of type
	@Test
	public void removeFreeItems_FreeItems_ReturnsRemaining() {
		String allItems = "EBE";
		assertThat(App.removeFreeItems(allItems), equalTo("EE"));
	}
	
	//Test for removeFreeItems amount of type
	@Test
	public void removeFreeItems_NoFreeItemsReturnsSame() {
		String allItems = "A";
		assertThat(App.removeFreeItems(allItems), equalTo("A"));
	}
}
