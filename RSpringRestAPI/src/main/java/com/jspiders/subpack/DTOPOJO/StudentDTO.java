package com.jspiders.subpack.DTOPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Details")
public class StudentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   
   private String name;
   
   private String email;
   
   private long contact;
   
   private String username;
   
   private String password;
   
}
