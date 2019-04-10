package Repository;

import Domain.Agenda;
import Domain.AgendaValidator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository {

    private Map<String, Agenda> storage = new HashMap<>();
    private AgendaValidator validator;

    public InMemoryRepository(AgendaValidator validator) {
        this.validator = validator;
    }

    /**
     * inserts an invoice
     * @param agenda
     * @throws RepositoryException if an event with that id already exists
     */
    public void insert(Agenda agenda) {
        if (storage.containsKey(agenda.getId())) {
            throw new RepositoryException("An event with " + agenda.getId() + " ID already exists");
        }
        validator.validate(agenda);
        storage.put(agenda.getId(), agenda);
    }

    /**
     * @return a list with all invoices
     */
    public List<Agenda> getAll() {
        return new ArrayList<>(storage.values());
    }

}