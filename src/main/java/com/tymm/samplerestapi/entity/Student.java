package com.tymm.samplerestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/**
 *
 * @author cheong.tymm
 */
@Data
@Entity
public class Student {   
    @Id
    private String ic;
    private String name;
    private Integer age;
    private String address;
    private Long enrolldate;
    private Long lastupdateddate;
}
