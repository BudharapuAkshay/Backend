package com.ust.Directors.service;

import com.ust.Directors.model.Director;
import com.ust.Directors.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Director getDirectorById(String directorId) {
        return directorRepository.findById(directorId).orElse(null);
    }

    public Director addDirector(String directorId, Director director) {
        director.setDirectorId(directorId);
        return directorRepository.save(director);
    }

    public Director updateDirector(String directorId, Director director) {
        director.setDirectorId(directorId);
        return directorRepository.save(director);
    }

    public void deleteDirector(String directorId) {
        directorRepository.deleteById(directorId);
    }
}
