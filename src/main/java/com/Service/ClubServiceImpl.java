package com.Service;

import com.Repository.ClubRepository;
import com.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl{

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }


    public List<Club> obtenerTodosLosClubes() {
        return clubRepository.findAll();
    }

    public Club obtenerClubPorId(Long id) {
        Optional<Club> clubOptional = clubRepository.findById(id);
        return clubOptional.orElse(null);
    }


    public Club agregarClub(Club club) {
        return clubRepository.save(club);
    }

    public Club actualizarClub(Long id, Club club) {
        if (clubRepository.existsById(id)) {
            club.setId(id);
            return clubRepository.save(club);
        }
        return null;
    }

    public void eliminarClub(Long id) {
        clubRepository.deleteById(id);
    }

}
