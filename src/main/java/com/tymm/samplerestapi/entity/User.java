package com.tymm.samplerestapi.entity;

import lombok.Data;

/**
 *
 * @author cheong.tymm
 */
@Data
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
}
