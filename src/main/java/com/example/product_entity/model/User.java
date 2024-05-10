package com.example.product_entity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	private String userName;
	@Min(value = 6000000000l,message = "invalid number,less then    6000000000")
	@Max(value = 9999999999l,message = "invalid number,maximum then    99999999")
	private long mobileNo;
	@Email(regexp = "[a-z0-9]+@[a-z0-9.-]+\\.[2,3]{2,3}")
	private String userMail;
	@NotBlank(message = "password is required")
	@NotNull(message = "password is required")
	@Size(min=8,max=20,message = "password must be 8 to 20 charecters")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z})(?+.*[@#$%^&+=])(?=\\s+$).{8,}$",message = "password must"
	+" contain at leat one letter, one number, one special character")
	private String password;

	
	
	

}
