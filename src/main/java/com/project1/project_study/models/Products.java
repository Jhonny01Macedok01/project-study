package com.project1.project_study.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Products extends ModelsId {

	@Column(nullable = false, length = 100)
	private String name;

	@Column(precision = 19, scale = 2)
	private BigDecimal price;

	@Column(nullable = false, length = 100)
	private String description;
	
	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(
			name = "fk_category"
		))
	private Category category;
	

}
