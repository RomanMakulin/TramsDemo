package com.example.TramsRest.service;

import com.example.TramsRest.models.Tram;

import java.util.List;

public interface TramsService {
    List<Tram> getAllTrams();

    Tram createTrams(Tram tram);

    Tram getTramById(int id);

    Tram updateTramById(int id, Tram tramDetails);

    void deleteTramById(int id);
}
