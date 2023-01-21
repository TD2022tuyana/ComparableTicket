import java.util.Arrays;

public class Manager {
    Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);

    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getTo().equals(to)) {
            if(ticket.getFrom().equals(from)){
                return true;
            }
        }
        return false;
    }
}