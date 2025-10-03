package com.example.Pet.Petfunctions;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PetRepository {

    private final JdbcClient jd;

    public PetRepository(JdbcClient jd) {
        this.jd = jd;
    }
    RowMapper<Pet> ord=(rs, rowNo)->{
        int id=rs.getInt("PID");
        String desc=rs.getString("PDesc");
        String photo=rs.getString("PPhoto");
        String name=rs.getString("PName");
        int age=rs.getInt("PAge");
        String breed=rs.getString("PBreed");
        String health=rs.getString("PHealth");
        int sid=rs.getInt("Sid");
        Pet p=new Pet(desc,id,photo,name,age,breed,health,sid);
        return p;

    };


    public void save(Pet p){
        jd.sql("Insert into Pet (PID,PDesc,PPhoto,PName,PAge,PHealth,Sid,PBreed) values (:PID,:d,:ph,:n,:a,:h,:s,:b)")
                .param("PID",p.getPID())
                .param("d",p.getPDesc())
                .param("ph",p.getPPhoto())
                .param("n",p.getPName())
                .param("a",p.getPAge())
                .param("h",p.getPHealth())
                .param("s",p.getSid())
                .param("b",p.getPBreed())
                .update();

    }


    List<Pet> findAll(){
        return jd.sql("Select PID,PDesc,PPhoto,PName,PAge,PBreed,PHealth,Sid from Pet")
                .query(ord).list();
    }

    public List<Pet> findbysid(int sid){

        return jd.sql("Select PID,PDesc,PPhoto,PName,PAge,PBreed,PHealth,Sid from Pet where Sid=:s")
        .param("s",sid).query(ord).list();


    }
    public Optional<Pet> findbypid(int pid){

        return jd.sql("Select PID,PDesc,PPhoto,PName,PAge,PBreed,PHealth,Sid from Pet where PID=:se")
                .param("se",pid).query((rs,rowNo)-> new Pet(rs.getString("PDesc"),rs.getInt("PID"),rs.getString("PPhoto"),rs.getString("PName"),rs.getInt("PAge"),rs.getString("PBreed"),rs.getString("PHealth"),rs.getInt("Sid")))
                        .optional();


    }
}
