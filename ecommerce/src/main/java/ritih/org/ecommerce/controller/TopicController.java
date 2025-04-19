package ritih.org.ecommerce.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ritih.org.ecommerce.dto.Topic;
import ritih.org.ecommerce.service.TopicService;

@RestController
@RequestMapping("/api")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAlltopics(){
		return topicService.getAllTopics();
		
	}
	
	@GetMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id){
		return topicService.getTopic(id);
		
	}
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		
	}
	
	@PutMapping("/topics")
	public void updateTopic(@RequestBody Topic topic) {
	    topicService.updateTopic(topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
	    topicService.deleteTopic(id);
	}

	
	
	

}
