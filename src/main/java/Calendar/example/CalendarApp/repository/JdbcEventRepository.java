package Calendar.example.CalendarApp.repository;

import Calendar.example.CalendarApp.Dto.EventResponse;
import Calendar.example.CalendarApp.Entity.Event;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcEventRepository implements EventRepository {
    JdbcTemplate template;

    public JdbcEventRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public EventResponse saveEvent(Event event) {
            SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
            insert.withTableName("events").usingGeneratedKeyColumns("id");

            Map<String, Object> eventMap = new HashMap<>();
            eventMap.put("name", event.getName());
            eventMap.put("password", event.getPassword());
            eventMap.put("text", event.getText());
            eventMap.put("CreationDate", LocalDateTime.now());
            eventMap.put("ModificationDate",LocalDateTime.now());

            Number key = insert.executeAndReturnKey(new MapSqlParameterSource(eventMap));
            Long id = key.longValue();

            return findByIdEvent(id);

    }

    @Override
    public  List<ResponseEntity<EventResponse>> findAllEvent(String name, LocalDate day) {
       List parameter = new ArrayList();
        StringBuilder sql = new StringBuilder("SELECT* FROM events WHERE 0=0");

        if (name != null ){
        sql.append(" AND name = ?");
        parameter.add(name);
        }

        if(day != null){
            sql.append(" AND DATE(CreationDate) = ?");
            parameter.add(day);
        }

        System.out.println("SQL Query: " + sql);
        System.out.println("Parameters: " + parameter);


        List<EventResponse> Events = template.query(sql.toString(), eventRowMapper(),parameter.toArray());



        List<ResponseEntity<EventResponse>> allEvents = Events.stream().map(event -> ResponseEntity.status(HttpStatus.OK).body(event)).toList();
        return allEvents;
    }

    @Override
    public EventResponse findByIdEvent(Long id) {
        EventResponse event = template.queryForObject("SELECT* FROM events WHERE id=?", eventRowMapper(), id);
        return event;
    }

    @Override
    public EventResponse update(Long id, String name, String text) {
        template.update("UPDATE events SET name = ?, ModificationDate = ?, text = ?  WHERE id=?", name, LocalDateTime.now(), text,id);
        return findByIdEvent(id);
    }

    @Override
    public void delete(Long id) {
    template.update("delete from events where id=?",id);
    }


    private RowMapper<EventResponse> eventRowMapper() {
        return new RowMapper<EventResponse>() {
            @Override
            public EventResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new EventResponse(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("text"),
                        rs.getString("CreationDate"),
                        rs.getString("ModificationDate")
                );
            }
        };
    }
}
