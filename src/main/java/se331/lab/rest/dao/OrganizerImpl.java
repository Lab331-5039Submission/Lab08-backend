package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("Kat Laydee")
                .organization("Abandon Feline Association")
                .address("Cat Planet, S319-A3 System")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(2L)
                .name("Fern Pollin")
                .organization("The Chiang Mai food Local Community")
                .address("Chiang Mai, Thailand")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(3L)
                .name("Carey Wales")
                .organization("Earth Keeper Organization")
                .address("Atlantis, Earth")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(4L)
                .name("Dawg Dahd")
                .organization("Happy Canine For everyone")
                .address("Dubai, Arab Emirate")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(5L)
                .name("Kahn Opiner")
                .organization("Waste food for your life")
                .address("Bangkok, Thailand")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(6L)
                .name("Brody Kill")
                .organization("Waste food for your life")
                .address("Bangkok, Thailand")
                .build()
        );
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;

        int firstIndex = (page-1) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,pageSize),organizerList.size()) ;
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(org -> org.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer org){
        org.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(org);
        return org;
    }
}
