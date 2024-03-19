package Controller;

import Model.Patient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class PatientController {
    //manages all the array dynamic array and all the logic part
    public ArrayList<Patient>  patientArrayList = new ArrayList<>();

    ObjectMapper objectMapper=new ObjectMapper();
    public PatientController(){
        try{
            JsonNode jsonNode= objectMapper.readTree(new File("src/Patient.json"));
            if(jsonNode.isArray()){
                for(int i=0;i<jsonNode.size();i++)
                {
                    String name=jsonNode.get(i).get("name").asText();
                    int id=jsonNode.get(i).get("patient_id").asInt();
                    int age=jsonNode.get(i).get("age").asInt();
                    String email =jsonNode.get(i).get("email").asText();
                    Patient p =new Patient(name,id,age,email);
                    patientArrayList.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void addPatient(Patient patient)
    {
        patientArrayList.add(patient);

        try {
            objectMapper.writeValue(new File("src/Patient.json"),patientArrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void displayPatient(){
        for(Patient p:patientArrayList){
            System.out.println(p);
        }
    }
    public void updatePatient(int rn,int innerOption,String value){
        Patient p=null;
        boolean found=false;
        int i=0;
        for (i=0;i<patientArrayList.size();i++)
        {
            if(patientArrayList.get(i).getPatient_id()==rn)
            {
                p=patientArrayList.get(i);
                found=true;
                break;
            }
        }
        if(found==false){
            System.out.println("Id maybe not found !");
            return;
        }
        switch(innerOption)
        {
            case 1:
                p.setName(value);break;
            case 2:
                p.setAge(Integer.parseInt(value));break;
            case 3:
                p.setEmail(value);break;

        }
        patientArrayList.set(i,p);

        try {
            objectMapper.writeValue(new File("src/Patient.json"),patientArrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void deletePatient( int rn1)
    {
        Patient p;
        boolean found=false;
        int i=0;
        for(i=0;i<patientArrayList.size();i++){
            if(patientArrayList.get(i).getPatient_id()==rn1)
            {
                p=patientArrayList.get(i);
                found=true;
                break;
            }
        }
        if(found==false)
        {
            System.out.println("Id not found ");
            return;
        }
        patientArrayList.remove(i);
        try {
            objectMapper.writeValue(new File("src/Patient.json"),patientArrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
