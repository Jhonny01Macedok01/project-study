package com.project1.project_study.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
abstract class ModelsId {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
