package Lab4_1;

import java.util.ArrayList;

public class Shop {

    private final ArrayList<Shop.ShopInfo> InfoService;

    public Shop(){
        InfoService = new ArrayList<>();
    }

    public void addInfo(String department, String product, String service){

        ShopInfo info = new ShopInfo();
        info.setDepartment(department);
        info.setProduct(product);
        info.setService(service);
        InfoService.add(info);

    }

    public ArrayList<Shop.ShopInfo> getInfoService() {
        return InfoService;
    }

    public  static  class ShopInfo{

        private String department;
        private String product;
        private String service;

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getProduct() {
            return product;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getService() {
            return service;
        }

    }

}
