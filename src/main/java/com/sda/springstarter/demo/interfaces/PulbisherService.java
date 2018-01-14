package com.sda.springstarter.demo.interfaces;

import com.sda.springstarter.demo.model.Publisher;

import java.util.List;

public interface PulbisherService {
    List<Publisher> getAllPublisher();
    void savePublisher (Publisher publisher);
}
