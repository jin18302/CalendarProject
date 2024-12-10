package Calendar.example.CalendarApp.repository;

import Calendar.example.CalendarApp.Dto.EventResponse;
import Calendar.example.CalendarApp.Entity.Event;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository {
    EventResponse saveEvent(Event event);

    List<ResponseEntity<EventResponse>> findAllEvent(String name, LocalDateTime day );

    EventResponse findByIdEvent(Long id);

    EventResponse update(Long id, String name, String text);

    void delete(Long id);
}
