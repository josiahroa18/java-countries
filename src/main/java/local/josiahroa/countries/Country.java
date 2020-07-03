package local.josiahroa.countries;

public class Country {
    private String name;
    private long population;
    private long landMassInKm;
    private int medianAge;

    public Country(String name, long population, long landMassInKm, int medianAge) {
        this.name = name;
        this.population = population;
        this.landMassInKm = landMassInKm;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandMassInKm() {
        return landMassInKm;
    }

    public void setLandMassInKm(long landMassInKm) {
        this.landMassInKm = landMassInKm;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", landMassInKm=" + landMassInKm +
                ", medianAge=" + medianAge +
                '}';
    }
}
