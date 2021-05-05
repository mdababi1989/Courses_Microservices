package com.mdababi.catalogapplication;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CatalogController {

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
        if (course != null) {
            instanceInfo = client.getNextServerFromEureka("user-service", false);
            String userAppUrl = instanceInfo.getHomePageUrl() + "/course/" + course.getCourseId();
            User[] users = restTemplate.getForEntity(userAppUrl, User[].class).getBody();
            String userNames = Arrays.stream(users).map(User::getUsername).collect(Collectors.joining(" ++ "));
            return ("Our first course is ****" + course.getCourseName() +"**** and enrolled users are ****"+ userNames +"****" );
        }
        return ("No course added yet");
    }

}
