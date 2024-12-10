package Calendar.example.CalendarApp.Dto;

import Calendar.example.CalendarApp.Entity.Event;
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

    public EventResponse(Event event){
        this.id=event.getId();
        this.name=event.getName();
        this.text=event.getText();
        this.CreationDate=event.getCreationDate();
        this.ModificationDate=event.getModificationDate();
    }

}
