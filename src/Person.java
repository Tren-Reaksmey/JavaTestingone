public class Person {
  private String name;
  private String Address;

  public Person(String name,String Address){
      this.name=name;
      this.Address=Address;
  }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
