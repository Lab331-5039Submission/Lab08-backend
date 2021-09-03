package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sep")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer("CAMT")
                .build());
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for Celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00-4.00 pm.")
                .petAllowed(false)
                .organizer("CMU")
                .build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Kra Tong")
                .description("A time for kratong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai")
                .build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th Apr")
                .time("10.00-6.00 pm.")
                .petAllowed(true)
                .organizer("Chiang Mai Municipality")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("CAMT")
                .organization("CAMT CMU")
                .address("CAMT Building")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("CMU")
                .organization("CMU CAMT")
                .address("CAMT Convention hall")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("Chiang Mai")
                .organization("River Ping")
                .address("Ping River")
                .build());
        organizerRepository.save(Organizer.builder()
                .name("Chiang Mai Municipality")
                .organization("Chiang Mai Municipality")
                .address("Chaing Mai Moat")
                .build());

    }
}