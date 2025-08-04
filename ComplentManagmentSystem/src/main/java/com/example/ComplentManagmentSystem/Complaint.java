package com.example.ComplentManagmentSystem;

import jakarta.persistence.*;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;

    private String subject;
    private String description;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	// ✅ ADD THIS FIELD to fix the mappedBy issue
    @ManyToOne
    @JoinColumn(name = "user_id") // Optional: you can rename the column
    private UserEntity user;

	public String getEmail() {
		return email;
		
	}

	public String getName() {
	
		return name;
	}

	public void setEmail(String email) {
		this.email=email;
		
	}

	public void setName(String name) {
		this.name=name;
		
	}

}
