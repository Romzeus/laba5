package labs.send;

import labs.structures.Route;

public interface ServerMessageRoute extends ServerMessageObject{
    default Route getRoute() {return (Route)getArgument();}
    Integer getId();
    Float getDistance();
    String getName();
}
