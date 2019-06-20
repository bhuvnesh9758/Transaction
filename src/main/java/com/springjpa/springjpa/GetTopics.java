package com.springjpa.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class GetTopics {
    @Autowired
    private TopicService topicService;
    @RequestMapping("/topics")
    public List<Topic> GetAll(){
        return topicService.getAllTopics();
    }
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTopic( @RequestBody Topic topic){
        topicService.add(topic);
    }
    @RequestMapping(method= RequestMethod.PUT,value = "/topics/{id}")
    public void updateTopic( @RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(topic,id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
