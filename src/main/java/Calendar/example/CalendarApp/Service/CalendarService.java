package Calendar.example.CalendarApp.Service;

import Calendar.example.CalendarApp.Dto.EventRequest;
import Calendar.example.CalendarApp.Dto.EventResponse;
import Calendar.example.CalendarApp.Entity.Event;
import Calendar.example.CalendarApp.repository.JdbcEventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalendarService {

    JdbcEventRepository eventRepository;

    public CalendarService(JdbcEventRepository eventRepository){
        this.eventRepository=eventRepository;
    }

    public EventResponse saveEvent(EventRequest request){
        Event event = new Event(request.getName(), request.getPassword(), request.getText());

        if(request.getName()==null || request.getPassword()==null || request.getText()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"null exists in request value");
        }

        return new EventResponse(eventRepository.saveEvent(event));
    }

    public List<ResponseEntity<EventResponse>> findAllEvent(String name, String day){
        LocalDate date = null;
        if(day != null){
            date=LocalDate.parse(day);
        }
        return eventRepository.findAllEvent(name, date);
    }

    public EventResponse findByIdEvent(Long id){
       Event event = eventRepository.findByIdEvent(id);
       if(event == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found id:"+id);
       }
        return new EventResponse(eventRepository.findByIdEvent(id));
    }

    public EventResponse update(Long id, EventRequest request){
        Event event = eventRepository.findByIdEvent(id);
        if(event == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found id:"+id);
        }

        if(event.getPassword().equals(request.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password doesn't match");
        }
        return new EventResponse(eventRepository.update(id, request.getName(), request.getText()));

    }

    public void delete(Long id, EventRequest request){
        Event event = eventRepository.findByIdEvent(id);
        if(event == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found id:"+id);
        }

        if(event.getPassword().equals(request.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password doesn't match");
        }
        eventRepository.delete(id);
    }

}
