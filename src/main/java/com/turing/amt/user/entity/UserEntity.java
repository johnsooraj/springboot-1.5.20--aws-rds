package com.turing.amt.user.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.turing.amt.enums.UserStatus;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String middileName;

	private String lastName;

	private int age;

	private Date birthday;

	@Column(unique = true)
	private String email;

	private String phoneNumber;

	private String gender;

	private int status = UserStatus.ACTIVE.getValue();

	@UpdateTimestamp
	private Timestamp timestamp;

	@CreationTimestamp
	private Date createDate;

	private byte flags;

	@JsonBackReference
	@OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private UserCredentialsEntity userCredentials;

	@OneToMany(cascade = CascadeType.ALL)
	private List<UserAddressEntity> userAddress;

	public UserEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddileName() {
		return middileName;
	}

	public void setMiddileName(String middileName) {
		this.middileName = middileName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserCredentialsEntity getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentialsEntity userCredentials) {
		this.userCredentials = userCredentials;
	}

	public List<UserAddressEntity> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddressEntity> userAddress) {
		this.userAddress = userAddress;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getFlags() {
		return flags;
	}

	public void setFlags(byte flags) {
		this.flags = flags;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
