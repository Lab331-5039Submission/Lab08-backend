package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Organizer;

import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    OrganizerDao organizerDao;

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return organizerDao.getOrganizers(pageSize,page);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerDao.getOrganizer(id);
    }

    @Override
    public Organizer save(Organizer org) {
        return organizerDao.save(org);
    }
}
