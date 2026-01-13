package com.lucasdevx.cinema_api.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ROOM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_number", nullable = false, length = 2)
	private String number;
	
	@Column(name = "room_capacity", nullable = false, length = 3)
	private int capacity;
	
	

}
