package com.mencner.moviedb.controller;

import com.mencner.moviedb.data.Name;
import com.mencner.moviedb.data.NamesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class BasicController {

    @Autowired
    private NamesDao namesDao;

    @RequestMapping("/time")
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }

    @RequestMapping("/names")
    public List<Name> getNames() {
        return namesDao.findAll();
    }
}
