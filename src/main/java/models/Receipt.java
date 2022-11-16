package models;

public class Receipt {
    private String name;
    private boolean domestic;
    private float price;
    private String weight;
    private String description;

    public Receipt(String name, boolean domestic, float price, String weight, String description) {
        this.name = name;
        this.domestic = domestic;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "name='" + name + '\'' +
                ", domestic=" + domestic +
                ", price=" + price +
                ", weight='" + weight + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String printNav() {
        if (domestic){
            if (!weight.equals("N/A")){
                return ". Domestic" +"\n"+
                        "... " +name + "\n"+
                        "    " + "Price: "+price + "\n"+
                        "    " + "Description: " +description +"\n"+
                        "    " + "Weight: "+weight+ "g";
            }
            else{
                return ". Domestic" +"\n"+
                        "... " +name + "\n"+
                        "    " + "Price: "+price + "\n"+
                        "    " + "Description: " +description +"\n"+
                        "    " + "Weight: "+weight;
            }

        }
        else{
            if (!weight.equals("N/A")){
                return ". Imported" +"\n"+
                        "... " +name + "\n"+
                        "    " + "Price: "+price + "\n"+
                        "    " + "Description: " +description +"\n"+
                        "    " + "Weight: "+weight+ "g";
            }
            else{
                return ". Imported" +"\n"+
                        "... " +name + "\n"+
                        "    " + "Price: "+price + "\n"+
                        "    " + "Description: " +description +"\n"+
                        "    " + "Weight: "+weight;
            }
        }

    }
}
