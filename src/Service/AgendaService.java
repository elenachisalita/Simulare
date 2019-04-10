package Service;

import Domain.Agenda;
import Repository.InMemoryRepository;

import java.util.List;

public class AgendaService {


    private InMemoryRepository agendaRepository;
    public AgendaService(InMemoryRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public void insert(String id, String description, String day, int duration, String hour) {
        Agenda agenda= new Agenda(id, description, day, duration, hour);
        agendaRepository.insert(agenda);
    }

    /**
     * @return an List with all invoices
     */
    public List<Agenda> getAll() {
        return agendaRepository.getAll();
    }

}
