public class Repository {

    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tickets.length] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;

    }

//    private Ticket findById(int id) {
//        for (Ticket ticket : tickets) {
//            if (ticket.getId() == id) {
//                return ticket;
//            }
//        }
//        return null;
//    }

}