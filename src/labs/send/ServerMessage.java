package labs.send;


import labs.structures.Route;

public class ServerMessage implements ServerMessageRoute{
    private String serverToken = null;
    private Route route = null;
    private Integer id = null;
    private Float distance = null;
    private String name = null;
    public ServerMessage setServerToken(String serverToken) {
        this.serverToken = serverToken;
        return this;
    }
    public ServerMessage setRoute(Route route) {
        this.route = route;
        return this;
    }
    public ServerMessage setId(int id) {
        this.id = id;
        return this;
    }
    public ServerMessage setDistance(float distance) {
        this.distance = distance;
        return this;
    }
    public ServerMessage setName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public String getToken() {
        return serverToken;
    }
    @Override
    public Object getArgument() {
        return route;
    }
    @Override
    public Float getDistance() {
        return distance;
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public Route getRoute() {
        return route;
    }
    @Override
    public String getName() {
        return name;
    }
}
