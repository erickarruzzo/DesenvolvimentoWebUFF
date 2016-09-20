package airlinesystem.model.entity.airline;

import java.time.Period;
import java.util.GregorianCalendar;

public class Route 
{
    private Airplane airplane;
    private String origin; //can become class airport
    private String destiny;
    private GregorianCalendar landTime;
    private GregorianCalendar flightTime;
    private double priceFactor;//Should be multiplied by the weight of the Seat
    private Period duration;
    private boolean available;
    
    public Route(String origin, String destiny, GregorianCalendar landTime, GregorianCalendar flightTime)
    { 
      this.origin = origin;
      this.destiny = destiny;
      this.landTime = landTime;
      this.flightTime = flightTime;
      this.available = true;
      //this.expectedFlightDuration = Period.between(flightTime, landTime);
    }

    public Airplane getAirplane() 
    {
        return airplane;
    }

    public void setAirplane(Airplane airplane) 
    {
        this.airplane = airplane;
    }

    public String getOrigin() 
    {
        return origin;
    }

    public void setOrigin(String origin) 
    {
        this.origin = origin;
    }

    public String getDestiny() 
    {
        return destiny;
    }

    public void setDestiny(String destiny) 
    {
        this.destiny = destiny;
    }

    public GregorianCalendar getLandTime() 
    {
        return landTime;
    }

    public void setLandTime(GregorianCalendar landTime) 
    {
        this.landTime = landTime;
    }

    public GregorianCalendar getFlightTime() 
    {
        return flightTime;
    }

    public void setFlightTime(GregorianCalendar flightTime) 
    {
        this.flightTime = flightTime;
    }

    public double getPriceFactor() 
    {
        return priceFactor;
    }

    public void setPriceFactor(double priceFactor) 
    {
        this.priceFactor = priceFactor;
    }

    public Period getDuration() 
    {
        return duration;
    }

    public void setDuration(Period duration) 
    {
        this.duration = duration;
    }

    public boolean isAvailable() 
    {
        if (this.airplane.checkReleasedSeats() == null) 
        {
            this.available = false;
        }
        else
        {
            this.available = true;
        }
        
        return available;
    }
}
