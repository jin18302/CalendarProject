package Calendar.example.CalendarApp.Entity;


import Calendar.example.CalendarApp.Dto.EventRequest;
import lombok.Getter;

@Getter

public class Event {
    private long id;
    private String name;
    private String password;
    private String text;
    private String CreationDate;
    private String ModificationDate;

   public Event(String name, String password, String text){
        this.name=name;
        this.password=password;
        this.text=text;
    }




    public Event update(EventRequest request){
        this.name=request.getName();
        this.text=request.getText();
        return this;
    }

}
