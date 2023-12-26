package ru.netologi.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void fistPlayerWon() {

        Player dima = new Player(123, "Дима", 70);
        Player kolya = new Player(234, "Коля", 45);
        Game game = new Game();

        game.register(dima);
        game.register(kolya);

        int expected = 1;
        int actual = game.round("Дима", "Коля");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerWon() {

        Player kolya = new Player(234, "Коля", 45);
        Player dima = new Player(123, "Дима", 70);
        Game game = new Game();

        game.register(kolya);
        game.register(dima);

        int expected = 2;
        int actual = game.round("Коля", "Дима");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void wasDraw() {

        Player dima = new Player(123, "Дима", 70);
        Player kolya = new Player(234, "Коля", 70);
        Game game = new Game();

        game.register(dima);
        game.register(kolya);

        int expected = 0;
        int actual = game.round("Дима", "Коля");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void firstPlayerNotRegistered() {
        Player dima = new Player(123, "Дима", 70);
        Player kolya = new Player(234, "Коля", 45);
        Game game = new Game();

        game.register(dima);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Андрей", "Коля"));

    }

    @Test
    public void secondPlayerNotRegistered() {
        Player dima = new Player(123, "Дима", 70);
        Player kolya = new Player(234, "Коля", 45);
        Game game = new Game();

        game.register(dima);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Дима", "Саша"));
    }

    @Test
    public void allPlayersNotRegistered() {
        Player dima = new Player(123, "Дима", 70);
        Player kolya = new Player(234, "Коля", 45);
        Game game = new Game();

        game.register(dima);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Андрей", "Артём"));
    }
}

