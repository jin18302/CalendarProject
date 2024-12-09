package Calendar.example.CalendarApp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventRequest {
    String name;
    String password;
    String text;
}
