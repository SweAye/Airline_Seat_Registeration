package airline;

public class seat_chart {
	public class Seat_Chart {
		char preference_seat;//w for window, m for middle
		char type; //f for first class, e for economy class
		
		
		//consturctor
		public Seat_Chart()
		{
			preference_seat=' ';
			type = ' ';
		}
		
		public Seat_Chart(char seat, char type){
			
			this.preference_seat = seat;
			this.type = type;
		}
		//this function will be used by economy and first class
		public void display_Manifact(){//this will dispaly all unavaiable and avaiable seat 
			
			
		}
		
		//this function will be used by economy and first class
		
		public void display_avaialbe_seat(){
			
		}
		

	}

}
