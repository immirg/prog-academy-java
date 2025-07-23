public class Ship implements Runnable{
    private int boxes;
    private Port port;
    private String shipName;

    public Ship() {
    }
    public Ship(Port port, int goods, String shipName) {
        this.boxes = goods;
        this.port = port;
        this.shipName = shipName;
    }
    @Override
    public void run() {
        while (port.getBusyDocs() == 2) {
            try {
                port.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (port.getDocOneAvailable()) {
            port.doc1(shipName, boxes);
        } else {
            port.doc2(shipName, boxes);
        }
    }
}


//public class Ship implements Runnable {
//    private Port port;
//    private int boxes;
//    private String name;
//
//    public Ship(Port port, int boxes, String name) {
//        this.port = port;
//        this.boxes = boxes;
//        this.name = name;
//    }
//
//    @Override
//    public void run() {
//        port.unloadAtAvailableDoc(name, boxes);
//    }
//}
