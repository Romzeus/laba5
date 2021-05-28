package labs.send;

import labs.structures.Route;

public interface ServerMessageRoute extends ServerMessageObject{
    default Route getRoute() {return (Route)getArgument();}
    int getId();
    float getDistance();
    String getName();
}
