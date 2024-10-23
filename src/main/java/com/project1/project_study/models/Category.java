package com.project1.project_study.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends ModelsId {

	@Column(nullable = false, length = 100)
	private String categoryName;

	@OneToOne(mappedBy = "category")
	private Products products;

}
