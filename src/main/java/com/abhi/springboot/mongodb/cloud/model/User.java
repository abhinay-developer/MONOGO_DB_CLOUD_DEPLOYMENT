package com.abhi.springboot.mongodb.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.Date;


@Document("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Long mobileNumber;
    private Date createdDate;
    private Date updatedDate;
    private boolean status;
}
