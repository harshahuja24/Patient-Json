package Model;

public class Patient {
    private String name;
    private int age;
    private int patient_id;
    private String email;

    public String getName() {
        return name;
    }
// right click - generate - getter setter
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Patient(String name,int patient_id, int age , String email)
    {
        this.name=name;
        this.patient_id=patient_id;
        this.age=age;
        this.email=email;
    }
    public String toString(){
        return "Patient name: "+this.name+"\nPatient id "+this.patient_id+"\nPatient age: "+this.age+"\nPatient email: "+this.email+"\n--------------";
    }
}
