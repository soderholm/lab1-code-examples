

public class GumballMachine {
 
	final static State SOLD_OUT = new SoldOutState();
	final static State NO_QUARTER = new NoQuarterState();
	final static State HAS_QUARTER = new HasQuarterState();
	final static State SOLD = new SoldState();
 
	State state = SOLD_OUT;
	int count = 0;
  
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
  
	public void insertQuarter() {
		state.insertQuarter(this);
	}

	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			System.out.println("You haven't inserted a quarter");
		} else if (state == SOLD) {
			System.out.println("Sorry, you already turned the crank");
		} else if (state == SOLD_OUT) {
        	System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}
 

 
 
	public void turnCrank() {
		if (state == SOLD) {
			System.out.println("Turning twice doesn't get you another gumball!");
		} else if (state == NO_QUARTER) {
			System.out.println("You turned but there's no quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("You turned, but there are no gumballs");
		} else if (state == HAS_QUARTER) {
			System.out.println("You turned...");
			state = SOLD;
			dispense();
		}
	}
 
	public void dispense() {
		if (state == SOLD) {
			System.out.println("A gumball comes rolling out the slot");
			count = count - 1;
			if (count == 0) {
				System.out.println("Oops, out of gumballs!");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {
			System.out.println("You need to pay first");
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed");
		}
	}
 
	public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = NO_QUARTER;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_QUARTER) {
			result.append("waiting for quarter");
		} else if (state == HAS_QUARTER) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}
}

