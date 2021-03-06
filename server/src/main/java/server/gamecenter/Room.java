package server.gamecenter;


import server.game.Game;
import server.user.User;
import base.element.GameMap;
import base.reactor.Reactor;

import java.util.ArrayList;
import java.util.List;


public class Room {
    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public enum Status {WAITING, PLAYING, PAUSED, OVER}

    private Status status = Status.WAITING;
    private String name;
    private GameMap gameMap;
    private Reactor reactor;
    private Game game;
    private List<User> users = new ArrayList<>();

    public Room(String name, Reactor reactor) {
        this.name = name;

    }

    public void loadmap(String mapname) {
//        this.gameMap = GameMap.loadMap(mapname);
    }

    public void startGame() {
        status = Status.PLAYING;
        game = new Game(reactor, gameMap);
        game.run();
    }

    public void stopGame() {
        game.stopGame();
    }

    public Game getGame() {
        return game;
    }
}
