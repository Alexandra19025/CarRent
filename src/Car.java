public class Car {
    private String  id;
    private String plate;
    private String carBrand;
    private String model;
    private int year;
    private String color;
    private String situation;
    public Car(String id, String plate, String carBrand, String model, int year, String color, String situation) {
        this.id = id;
        this.plate = plate;
        this.carBrand = carBrand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.situation = situation;
    }
    public String getId() {
        return id;
    }
    public String getPlate() {
        return plate;
    }
    public String getCarBrand() {
        return carBrand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public String getSituation() {
        return situation;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSituation(String situation) {
        this.situation = situation;
    }
}
