

public class NoQuarterState extends State {

	@Override
	public void insertQuarter(GumballMachine machine) {
		machine.state = GumballMachine.HAS_QUARTER;
		System.out.println("You inserted a quarter");		
	}

}
