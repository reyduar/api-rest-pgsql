package com.api.pgrest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="articulo")
public class Article implements Serializable{
	
private static final long serialVersionUID = -4259759082862515685L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private Integer id;
@Column(name="nombre")
private String nombre;

}
