package ritih.org.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ritih.org.ecommerce.dto.Topic;
import ritih.org.ecommerce.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics(){
		List<Topic> topicList = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}
	
	public void addTopic(Topic topic) {
		
		topicRepository.save(topic);
	}
	
	public Optional<Topic> getTopic(String id) {
		
		return	topicRepository.findById(id);
		
	}
	
	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
		
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);	
	}

}
