package com.project1.project_study.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Roles extends ModelsId {

	@Column(nullable = false, length = 50)
	private String role;

}
