package Lab4_1;

import java.util.ArrayList;
import java.util.Calendar;

public class PubTransportInfService {

    private final ArrayList<RouteInfo> InfoService;

    public PubTransportInfService(){
        InfoService = new ArrayList<>();
    }

    public void addInfo(Calendar time, String route, double cost){

        RouteInfo info = new RouteInfo();
        info.setTime(time);
        info.setRoute(route);
        info.setCost(cost);
        InfoService.add(info);

    }

    public ArrayList<RouteInfo> getInfoService() {
        return InfoService;
    }

    public  static  class RouteInfo{

        private Calendar time;
        private String route;
        private double cost;

        public void setTime(Calendar time) {
            this.time = time;
        }

        public Calendar getTime() {
            return time;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getRoute() {
            return route;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getCost() {
            return cost;
        }
    }

}
