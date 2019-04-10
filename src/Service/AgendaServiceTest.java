package Service;

import Domain.AgendaValidator;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AgendaServiceTest {

    private AgendaValidator validator = new AgendaValidator();
    private InMemoryRepository repository = new InMemoryRepository(validator);
    private AgendaService service = new AgendaService(repository);

    @Test
    void testsIfInsertAndGetAllWorksProperly() {
        service.insert("1","dadad","monday",50,"5");
        assertEquals(50, service.getAll().get(0).getDuration());


        try {
            service.insert("1","dadad","monday",50,"5");
        } catch (RuntimeException rex) { assertTrue(true); }
    }
}