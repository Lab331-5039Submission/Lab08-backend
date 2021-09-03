package se331.lab.rest.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer org);
}
