package airlinesystem.model.entity.airline;

import airlinesystem.model.entity.seat.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Airplane 
{
    private List<Seat> seats;
    private String company;
    private String model;
    private Date manufacturingDate;
    private int airplaneNumber;
    
    public Airplane(int airplaneNumber, List<Seat> seats, String company, String model, Date manufacturingDate)
    {
        this.airplaneNumber = airplaneNumber;
        this.seats = seats;
        this.company = company;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
    }

    public int getAirplaneNumber() 
    {
        return airplaneNumber;
    }

    public void setAirplaneNumber(int airplaneNumber) 
    {
        this.airplaneNumber = airplaneNumber;
    }

    public List<Seat> getSeats() 
    {
        return seats;
    }

    public void setSeats(List<Seat> seats) 
    {
        this.seats = seats;
    }

    public String getCompany() 
    {
        return company;
    }

    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getModel() 
    {
        return model;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public Date getManufacturingDate() 
    {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) 
    {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() 
    {
        return  airplaneNumber + 
                ":\nModelo: " + model + 
                "\nCompanhia: " + company +
                "\nData de Fabricação: " + manufacturingDate;
    }
    
    public List<Seat> checkReleasedSeats()
    {
        List <Seat> availableSeats = new ArrayList<>();
        
        for (Seat seat : this.seats)
        {
            if (seat.isOccupiedSeat())
            {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
}
