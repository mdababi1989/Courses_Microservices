package com.mdababi.catalogapplication;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatalogController {

    @Autowired
    private EurekaClient client;

    @RequestMapping("/")
    public String getCatalogHome() {
        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        String courseAppMesage = restTemplate.getForObject(courseAppURL, String.class);

        return ("Welcome to our Course Catalog " + courseAppMesage);
    }

    @RequestMapping("/catalog")
    public String getCatalog() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/courses";
        RestTemplate restTemplate = new RestTemplate();
        String courses = restTemplate.getForObject(courseAppURL, String.class);

        return ("Our courses are " + courses);
    }

    @RequestMapping("/firstcourse")
    public String getSpecificCourse() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/1";
        RestTemplate restTemplate = new RestTemplate();

        Course course = restTemplate.getForObject(courseAppURL, Course.class);
        if (course != null)
            return ("Our first course is " + course.getCourseName());
        else return ("No course added yet");
    }

}
