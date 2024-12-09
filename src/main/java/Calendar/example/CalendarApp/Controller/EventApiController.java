package Calendar.example.CalendarApp.Controller;

import Calendar.example.CalendarApp.Dto.EventRequest;
import Calendar.example.CalendarApp.Dto.EventResponse;
import Calendar.example.CalendarApp.Service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class EventApiController {
    @Autowired
    CalendarService service;

    @PostMapping//0
    public ResponseEntity<EventResponse> saveEvent(@RequestBody EventRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEvent(request));
    }

    @GetMapping//0
    public List <ResponseEntity<EventResponse>> findAllEvent() {
        return service.finalAllEvent();
    }

    @GetMapping("/{id}")//0
    public ResponseEntity<EventResponse> findByEvent(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findByIdEvent(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventResponse> update(@PathVariable("id") Long id, @RequestBody EventRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
