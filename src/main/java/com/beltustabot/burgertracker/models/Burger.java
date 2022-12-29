package com.beltustabot.burgertracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200, message= "burger must not be null")
    private String burgerName;
    @NotNull
    @Size(min = 5, max = 200 ,message= "restuarant must not be null")
    private String restaurantName;
    @NotNull
    @Min(0)
    private Integer rating;
    @NotNull
    @Size(min=5)
    private String notes;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	    
//	   ====== Constructor===========
		public Burger(Long id, String burgerName, String restaurantName, @NotNull @Size int rating, String notes, Date createdAt,
				Date updatedAt) {
			super();
			this.id = id;
			this.burgerName = burgerName;
			this.restaurantName = restaurantName;
			this.rating = rating;
			this.notes = notes;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}
        public Burger() {}
		
		
		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getBurgerName() {
			return burgerName;
		}



		public void setBurgerName(String burgerName) {
			this.burgerName = burgerName;
		}



		public String getRestaurantName() {
			return restaurantName;
		}



		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}



		public Integer getRating() {
			return rating;
		}



		public void setRating(Integer rating) {
			this.rating = rating;
		}



		public String getNotes() {
			return notes;
		}



		public void setNotes(String notes) {
			this.notes = notes;
		}



		public Date getCreatedAt() {
			return createdAt;
		}



		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}



		public Date getUpdatedAt() {
			return updatedAt;
		}



		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}



		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	   @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
    
	    

}