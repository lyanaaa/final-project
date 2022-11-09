public class Citizen {
    String name;
    String ic;
    String state;
    int age;
    String category;
    String firstdose;
    String seconddose;
    String certificate;

    public Citizen(String name, String ic, String state, int age, String Category, String firstdose, String seconddose, String certificate){

        this.name = name;
        this.ic = ic;
        this.state = state;
        this.age = age;
        this.category = category;
        this.firstdose = firstdose;
        this.seconddose = seconddose;
        this.certificate = certificate;
    }
    public String getName() {
        return name;
    }
    public String getIc() {
        return ic;
    }
    public int getAge() {
        return age;
    }
    public String getState() {
        return state;
    }
    public String getCategory() {
        return category;
    }
    public String getFirstdose() {
        return firstdose;
    }
    public String getSeconddose() {
        return seconddose;
    }
    public String getCertificate() {
        return certificate;
    }
    public void setName(String name) {
       this. name = name;
    }
    public void setIc(String ic) {
        this.ic = ic;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setFirstdose(String firstdose) {
        this.firstdose = firstdose;
    }
    public void setSeconddose(String seconddose) {
        this.seconddose = seconddose;
    }
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String toString(){
        return (String.format("| %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |\n ", name, ic, state, age, category, firstdose, seconddose, certificate));
    }    
    
}
