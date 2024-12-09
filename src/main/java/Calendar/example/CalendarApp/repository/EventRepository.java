package Calendar.example.CalendarApp.repository;

import Calendar.example.CalendarApp.Dto.EventResponse;
import Calendar.example.CalendarApp.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EventRepository {
    EventResponse saveEvent(Event event);

    List<ResponseEntity<EventResponse>> findAllEvent();

    EventResponse findByIdEvent(Long id);

    EventResponse update(Long id, String name, String text);

    void delete(Long id);
}
