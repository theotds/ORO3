package com.educationalconference;

import com.educationalconference.Entities.ConferenceRoom;
import com.educationalconference.Entities.Presentation;
import com.educationalconference.Repositories.ConferenceRoomRepository;
import com.educationalconference.Repositories.PresentationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PresentationRepositoryTests {

    @Autowired
    private PresentationRepository presentationRepository;

    @Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    @Test
    public void testFindAllPresentationTopics() {
        ConferenceRoom room = new ConferenceRoom("Main Hall", 100);
        conferenceRoomRepository.save(room);

        Presentation pres1 = new Presentation("Global Warming", room);
        presentationRepository.save(pres1);

        List<String> topics = presentationRepository.findAllPresentationTopics();
        assertThat(topics).containsExactly("Global Warming");
    }

    @Test
    public void testCountPresentationsByRoom() {
        ConferenceRoom room = new ConferenceRoom("Main Hall", 100);
        conferenceRoomRepository.save(room);

        Presentation pres1 = new Presentation("Global Warming", room);
        presentationRepository.save(pres1);

        List<Object[]> counts = presentationRepository.countPresentationsByRoom();
        assertThat(counts).hasSize(1);
        assertThat(counts.get(0)[0]).isEqualTo("Main Hall");
        assertThat(counts.get(0)[1]).isEqualTo(1L);
    }
}
