

public class HasQuarterState extends State {

	@Override
	public void insertQuarter(GumballMachine machine) {
		System.out.println("You can't insert another quarter");		
	}

}
