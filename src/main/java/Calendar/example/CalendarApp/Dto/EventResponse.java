package Calendar.example.CalendarApp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EventResponse {
    private long id;
    private String name;
    private String text;
    private String CreationDate;
    private String ModificationDate;

}
