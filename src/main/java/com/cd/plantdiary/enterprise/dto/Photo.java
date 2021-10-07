package com.cd.plantdiary.enterprise.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="photos")
public @Data class Photo {
	
	@Id
	@GeneratedValue
	private int photoId;
	private String photographer;
	private String path;
	private String fileName;
	private String comments;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="specimen_id")
	private Specimen specimen;

}
