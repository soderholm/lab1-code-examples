

public class SoldOutState extends State {

	@Override
	public void insertQuarter(GumballMachine machine) {
		System.out.println("You can't insert a quarter, the machine is sold out");
		
	}

}
