/**
 * Project: BoatRandomizer
 * Description: to hold the attributes of a boat, including seats and configuration
 * FHT VERSION: 1.4 05/23/2017
 *
 * @author Seth LiaBraaten
 * @version 1.0 created 23-May-2017 11:26:27 AM
 */

public class Boat
{
    private int numSeats;
    private String seatConfig;

    /**
     * constructor for a new boat
     * @param numSeats the number of rowing seats in the boat
     * @param seatConfig the configuration of the seats in the boat P for port, S for starbord and C for cox
     * @throws InvalidSeatConfigurationException if number of seats or configuration of the seats is outside
     * the parameters of a boat
     */
    public Boat (int numSeats, String seatConfig) throws InvalidSeatConfigurationException
    {
        setNumSeats(numSeats);
        setSeatConfig(seatConfig);
    }

    /**
     * sets the configuration of the seats in the boat
     * @param seatFormat string without spaces depicting the configuration of the boat, P = port,
     *  S = starbord, C = coxswain
     * @throws InvalidSeatConfigurationException if an invalid configuration of seats exist
     */
    public void setSeatConfig(String seatFormat) throws InvalidSeatConfigurationException
    {
        if (!verifySeatingConfig(seatFormat))
            throw new InvaidSeatConfigurationException(seatFormat + " is an invalid seat configuration");

        this.seatConfig = seatFormat;
    }

    /**
     * sets the number of seats in the boat
     * @param numSeats the number of seats in the boat
     */
    public void setNumSeats(int numSeats) throws InvalidSeatConfigurationException
    {
        if (!verifyNumSeats(numSeats))
            throw new InvalidSeatConfiguration(numSeats + " seats found, value is outside of expected range");

        this.numSeats = numSeats;
    }

    /**
     * gets the configuration of the seats in the boat using the format P for port, S for starbord, C for cox
     * @return the seat configuration
     */
    public String getSeatConfig()
    {
        return this.seatConfig;
    }

    /**
     * gets the current number of rowing seats in the boat
     * @return the number of seats in the boat
     */
    public int getNumSeats()
    {
        return this.numSeats;
    }

    /**
     * verifies the accuracy of the seating configuration given it
     * @param seatFormat seat configuration to test
     * @return true if the system can exist, false if the config is invalid
     */
    private boolean verifySeatingConfig(String seatFormat)
    {
        if (seatFormat.length() > 9 || seatFormat.length() < 1)
            return false;


        for (char ch : seatFormat.toCharArray())
            if (ch.equalsIgnoreCase("C") || ch.equalsIgnoreCase("P") || ch.equalsIgnoreCase("S"))
                return true;

        return false;
    }

    /**
     * verifes the number of seats in the boat to ensure it is within paramters
     * @param numSeats the seat number to verify
     * @return true if the number of seats is acceptable, false if not
     */
    private boolean verifyNumSeats(int numSeats)
    {
        if (numSeats != 8 || numSeats != 4 || numSeats != 2 || numSeats != 1)
            return false;

        return true;
    }

}