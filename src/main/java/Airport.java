public class Airport {

    private int elevation;
    private String country;
    private String iata;
    private String city;
    private String tz;
    private String name;
    private String icao;
    private String state;
    float lat;
    float lon;

    Airport(int elevation, String country, String iata, String city, String tz, String name, String icao,
            String state, float lat, float lon) {
        this.elevation = elevation;
        this.country = country;
        this.iata = iata;
        this.city = city;
        this.tz = tz;
        this.name = name;
        this.icao = icao;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
    }

    public int getElevation() {
        return elevation;
    }

    public String getCountry() {
        return country;
    }

    public String getIata() {
        return iata;
    }

    public String getCity() {
        return city;
    }

    public String getTz() {
        return tz;
    }

    public String getName() {
        return name;
    }

    public String getIcao() {
        return icao;
    }

    public String getState() {
        return state;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return String.format("City: " + this.city +
                             "\tCountry: " + this.country +
                             "\tName: " + this.name +
                             "\tIata: " + this.iata +
                             "\tTz: " + this.tz +
                             "\tIcao: " + this.icao +
                             "\tState: " + this.state +
                             "\tLAT: " + this.lat +
                             "\tLON: " + this.lon +
                             "\tElevation: " + this.elevation

        );
    }


}
