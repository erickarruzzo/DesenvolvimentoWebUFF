package airlinesystem.model.entity.seat;

import airlinesystem.model.valueobject.enums.SeatCategory;

public class Seat 
{
    private String airplaneClass;
    private String airplaneSeat;
    private SeatCategory category;
    private boolean occupiedSeat; //Estado do assento
    
    public Seat(String airplaneClass, String airplaneSeat, SeatCategory category)
    {
        this.airplaneClass = airplaneClass;
        this.airplaneSeat = airplaneSeat;
        this.category = category;
        this.occupiedSeat = false;
    }

    public String getAirplaneClass() 
    {
        return airplaneClass;
    }

    public void setAirplaneClass(String airplaneClass) 
    {
        this.airplaneClass = airplaneClass;
    }

    public String getAirplaneSeat() 
    {
        return airplaneSeat;
    }

    public void setAirplaneSeat(String airplaneSeat) 
    {
        this.airplaneSeat = airplaneSeat;
    }

    public SeatCategory getCategory() 
    {
        return category;
    }

    public void setCategory(SeatCategory category) 
    {
        this.category = category;
    }

    public boolean isOccupiedSeat() 
    {
        return occupiedSeat;
    }

    public void setOccupiedSeat(boolean occupedSeat) 
    {
        this.occupiedSeat = occupedSeat;
    }    
}
