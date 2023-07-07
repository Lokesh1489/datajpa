package com.nit.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKey;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEE_INFO_TAB")
@Data
public class EmployeeInfo {
	@Id
	@GeneratedValue
	private Integer eno;

	@Column(length = 20)
	private String ename;

	@ElementCollection // Enables the collection mapping
	@CollectionTable(name = "EMPLOYEE_FRIENDS", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO"))
	@Column(name = "FRIEND_NAME", length = 20) // To store list elements
	@OrderColumn(name = "FRIEND_INDEX") // To store the list element index
	@ListIndexBase(1)
	private List<String> friends;

	@ElementCollection // Enables the collection mapping
	@CollectionTable(name = "EMPLOYEE_FRIENDS", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO"))
	@Column(name = "PHONE_NUMBERS", length = 20) // To store Set elements
	private Set<Long> phone;

	@ElementCollection // Enables the collection mapping
	@CollectionTable(name = "EMPLOYEE_ID", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO"))
	@Column(name = "ID_DETAILS", length = 20) // To store Map elements
	@MapKeyColumn(name="ID_TYPE",length = 20) // To store Map elements keys
	private Map<String, Long> idDetails;
}
