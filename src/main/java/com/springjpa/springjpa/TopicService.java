package com.springjpa.springjpa;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class TopicService extends Thread {

    @Autowired
    private TopicRepository topicRepository;
    ExecutorService exec;
    public void run() {
        exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Topic topic=new Topic("hello","hello","hello");
        add(topic);
        exec.shutdown();
    }
    public List<Topic> getAllTopics () {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }
    public Topic getTopic (String id){
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topicRepository.findId(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public  synchronized void add (Topic topic){
        topicRepository.save(topic);
        System.out.println("thread no writes data:"+Thread.currentThread().getName());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTopic (Topic topic, String id){
        topicRepository.save(topic);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTopic (String id){
//        topics.removeIf(t->t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
