package com.collage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CollageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clgId;
	private String collageCode;
	private String collageName;
	private String collageAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="branch_Id")
	private BranchEnitity branchEnitity;
}
