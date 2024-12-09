package Calendar.example.CalendarApp.Service;

import Calendar.example.CalendarApp.Dto.EventRequest;
import Calendar.example.CalendarApp.Dto.EventResponse;
import Calendar.example.CalendarApp.Event;
import Calendar.example.CalendarApp.repository.JdbcEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CalendarService {
    @Autowired
    JdbcEventRepository eventRepository;

    public EventResponse saveEvent(EventRequest request){
        Event event = new Event(request.getName(), request.getPassword(), request.getText());
        return eventRepository.saveEvent(event);
    }

    public List<ResponseEntity<EventResponse>> finalAllEvent(){
        return eventRepository.findAllEvent();
    }

    public EventResponse findByIdEvent(Long id){
        return  eventRepository.findByIdEvent(id);
    }

    public EventResponse update(Long id, EventRequest request){

        return eventRepository.update(id, request.getName(), request.getText());
    }

    public void delete(Long id){
        eventRepository.delete(id);
    }

}
