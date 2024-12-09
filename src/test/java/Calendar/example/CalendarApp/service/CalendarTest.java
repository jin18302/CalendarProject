package Calendar.example.CalendarApp.service;

import Calendar.example.CalendarApp.Dto.EventResponse;
import Calendar.example.CalendarApp.Event;
import Calendar.example.CalendarApp.repository.JdbcEventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcEventRepository.class)
class JdbcEventRepositoryTest {

    @Autowired
    private JdbcEventRepository repository;

    @Test
    void saveEventTest() {
//        // given
//        Event event = new Event("테스트 이벤트", "1234", "테스트 내용");
//
//        // when
//        EventResponse savedEvent = repository.saveEvent(event);
//
//        // then
//        assertThat(savedEvent).isNotNull();
//        assertThat(savedEvent.getId()).isNotNull();
//        assertThat(savedEvent.getName()).isEqualTo("테스트 이벤트");
//        assertThat(savedEvent.getText()).isEqualTo("테스트 내용");
    }

    @Test
    @Sql("/test-data.sql") // 테스트 데이터를 미리 삽입
    void findAllEventTest() {
        // when
        List<ResponseEntity<EventResponse>>events = repository.findAllEvent();

        // then
        assertThat(events).isNotEmpty();
    }

    @Test
    @Sql("/test-data.sql")
    void findByIdEventTest() {
        // given
        Long id = 1L;

        // when
        EventResponse event = repository.findByIdEvent(id);

        // then
        assertThat(event).isNotNull();
        assertThat(event.getId()).isEqualTo(id);
    }

    @Test
    @Sql("/test-data.sql")
    void updateEventTest() {
        // given
        Long id = 1L;
        String newName = "수정된 이벤트";
        String newText = "수정된 내용";

        // when
        EventResponse updatedEvent = repository.update(id, newName, newText);

        // then
        assertThat(updatedEvent).isNotNull();
        assertThat(updatedEvent.getName()).isEqualTo(newName);
        assertThat(updatedEvent.getText()).isEqualTo(newText);
    }

    @Test
    @Sql("/test-data.sql")
    void deleteEventTest() {
        // given
        Long id = 1L;

        // when
        repository.delete(id);
        List<ResponseEntity<EventResponse>> events = repository.findAllEvent();

        // then
        assertThat(events).isEmpty();
    }
}
