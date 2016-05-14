package tai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tai.dao.EventDao;
import tai.domain.Event;

@RestController
@RequestMapping("event")
public class EventService {

	@Autowired
	EventDao eventDao;
	
	@RequestMapping(value = "/{eventId}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Event> getEvent(@PathVariable String eventId){
		Event event = eventDao.getEvent(eventId);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/eventlist", method=RequestMethod.GET)
	public @ResponseBody List<Event> getEvents(){
		return eventDao.getEventList();
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public void saveEvent(@RequestBody Event event){
		eventDao.insertData(event);
	}
	
	@RequestMapping(value = "/update/{eventId}", method=RequestMethod.PUT)
	public void updateEvent(@PathVariable String eventId, @RequestBody Event event){
		eventDao.updateData(event, eventId);
	}
	
}
