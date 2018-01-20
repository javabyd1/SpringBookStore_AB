package com.sda.springstarter.demo.service;

import com.sda.springstarter.demo.interfaces.PulbisherService;
import com.sda.springstarter.demo.model.Publisher;
import com.sda.springstarter.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublisherServiceImpl implements PulbisherService {

    @Autowired
    private PublisherRepository pulbisherRepository;

    @Override
    public List<Publisher> getAllPublisher(){
        return pulbisherRepository.findAll();
    }

    @Override
    public void savePublisher (Publisher publisher) {
        pulbisherRepository.save(publisher);
    }
}

