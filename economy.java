package airline;

public class economy extends seat_chart{
private String seat;
	
	public economy( ){
		seat = " ";
	}

	public economy(String seat){
		this.seat = seat;
	}
	
	public String getSeat(){
		
		return this.seat;
	}
	
	public void setSeat(String seat){
		this.seat = seat;
	}
	
public void reserved_seat(int row, int coloum){
		
		
	}

	
}

