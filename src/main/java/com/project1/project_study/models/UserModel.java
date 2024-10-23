package com.project1.project_study.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name =  "usuario", uniqueConstraints = {
		@UniqueConstraint(name = "user_email", columnNames = "email")
}, indexes = {
		@Index(name = "idx_email", columnList = "email")
})
public class UserModel extends ModelsId {



	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 100)
	private String email;
	
	@OneToMany
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(
			name = "fk_roles"
		))
	private Set<Roles> roles = new HashSet<>();
	
	@OneToMany
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(
			name = "fk_products"
		))
	private Set<Products> products;

}
