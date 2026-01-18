package com.lucasdevx.cinema_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lucasdevx.cinema_api.dto.request.RoomRequestDTO;
import com.lucasdevx.cinema_api.dto.response.RoomResponseDTO;
import com.lucasdevx.cinema_api.entity.Room;
import com.lucasdevx.cinema_api.exception.ObjectNotFoundException;
import com.lucasdevx.cinema_api.repository.RoomRepository;

@Service
public class RoomService {
	
	private RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public RoomResponseDTO insert(RoomRequestDTO roomRequestDTO) {
		Room Room = toRoom(roomRequestDTO);
		
		return toDTO(roomRepository.save(Room));
	}
	
	public RoomResponseDTO findById(Long id) {

		Room RoomDB = roomRepository.findById(id)
				.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
		
		return toDTO(RoomDB);
	}
	
	public List<RoomResponseDTO> findAll(){
		
		List<Room> Rooms = roomRepository.findAll();
		
		
		return Rooms.stream().map((Room) -> {
			return toDTO(Room);
		}).collect(Collectors.toList());
	}
	
	public RoomResponseDTO update(RoomRequestDTO roomRequestDTO, Long id) {
		Room RoomDB = roomRepository.findById(id)
				.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
		
		RoomDB.setNumber(roomRequestDTO.roomNumber());
		RoomDB.setCapacity(roomRequestDTO.capacity());

		return toDTO(roomRepository.save(RoomDB));
	}
	
	public void deleteById(Long id) {
		roomRepository.deleteById(id);
	}
	
	public RoomResponseDTO toDTO(Room room) {
		
		return new RoomResponseDTO(
				room.getId(),
				room.getNumber(),
				room.getCapacity());
	}
	
	public Room toRoom(RoomRequestDTO roomRequestDTO) {
		Room Room = new Room();
		
		Room.setNumber(roomRequestDTO.roomNumber());
		Room.setCapacity(roomRequestDTO.capacity());
		
		return Room;
	}
	
	
}
