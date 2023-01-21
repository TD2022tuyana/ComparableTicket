import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Ticket t1 = new Ticket(1, 6000, "EUR", "JAK", 6);
    Ticket t2 = new Ticket(2, 6000, "AFR", "SOA", 9);
    Ticket t3 = new Ticket(3, 7000, "EUR", "JAK", 6);
    Ticket t4 = new Ticket(4, 2000, "EUR", "JAK", 4);
    Ticket t5 = new Ticket(5, 4000, "SEA", "SOA", 5);
    Ticket t6 = new Ticket(6, 1500, "EUR", "JAK", 6);

    Ticket t7 = new Ticket(7, 6000, "EUR", "JAK", 6);


    @Test
    public void ticketFewFounds() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Ticket[] expected = {t6, t4, t1, t3};
        Ticket[] actual = manager.searchBy("EUR", "JAK");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void ticketOneFounds() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Ticket[] expected = {t5};
        Ticket[] actual = manager.searchBy("SEA", "SOA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ticketNoFounds() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("EUR", "SOA");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ticketSameFounds() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t5);
        manager.add(t7);

        Ticket[] expected = {t1, t7};
        Ticket[] actual = manager.searchBy("EUR", "JAK");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ticketAdd() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Ticket[] expected = {t1, t2, t3, t4, t5, t6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}