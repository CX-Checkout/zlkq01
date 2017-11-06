import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import befaster.solutions.App;
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
	public void check_mix() {
		assertThat(App.checkout("ABCD"), equalTo(115));
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
	public void check_A_multi() {
		assertThat(App.checkout("AAA"), equalTo(130));
	}
	
	@Test
	public void check_B_multi() {
		assertThat(App.checkout("BB"), equalTo(45));
	}
	
	@Test
	public void check_Complex_Multi() {
		assertThat(App.checkout("AABCAABCDB"), equalTo(310));
	}
}
