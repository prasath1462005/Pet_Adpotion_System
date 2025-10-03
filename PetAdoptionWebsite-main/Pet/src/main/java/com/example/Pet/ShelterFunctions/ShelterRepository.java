package com.example.Pet.ShelterFunctions;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class ShelterRepository {

    private JdbcClient jc;
    public ShelterRepository(JdbcClient jc) {

        this.jc = jc;
    }



    public Optional<Shelter> findByID(int id){
        return  jc.sql("Select * from Ashelter where Sid=:Sid")
                .param("Sid",id)
                .query((rs,rowNo)->new Shelter(rs.getInt("Sid"),rs.getString("SName"),rs.getString("SPassw"),rs.getString("SEmail"),rs.getString("SPhoneNo")))
                .optional();
    }

    public void insert(Shelter se){
        jc.sql("Insert into AShelter values(:i,:n,:p,:e,:ph)")
                .param("i",se.getSid())
                .param("n",se.getSname())
                .param("p", se.getSpass())
                .param("e",se.getSemail())
                .param("ph",se.getSPhoneNo()).update();

    }

    public Optional<Shelter> findbyemail(String e){
        return jc.sql("select * from Ashelter where Semail =:S")
                .param("S",e)
                .query((rs,rowNo)->new Shelter(rs.getInt("Sid"),rs.getString("SName"),rs.getString("SPassw"),rs.getString("SEmail"),rs.getString("SPhoneNo")))
                .optional();
    }
}
