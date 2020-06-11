package com.spring5.springserviceproject.JpaService;

import com.spring5.springserviceproject.Model.Visit;
import com.spring5.springserviceproject.Repository.VisitRepository;
import com.spring5.springserviceproject.Service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Visit object) {
         visitRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
