public class Port {
    private boolean docOneAvailable = true;
    private boolean docTwoAvailable = true;
    private int busyDocs = 0;

    public Port() {
    }
    public boolean getDocOneAvailable() {
        return this.docOneAvailable;
    }
    public boolean getDocTwoAvailable() {
        return this.docTwoAvailable;
    }
    public int getBusyDocs() {
        return this.busyDocs;
    }
    public synchronized void doc1(String shipName, int boxes) {
        busyDocs += 1;
        docOneAvailable = false;
        printInfo(shipName, boxes, "docOne");
        docOneAvailable = true;
        busyDocs -= 1;
        notifyAll();
    }
    public void doc2(String shipName, int boxes) {
        busyDocs += 1;
        docTwoAvailable = false;
        printInfo(shipName, boxes, "docTwo");
        docTwoAvailable = true;
        busyDocs -= 1;
        notifyAll();
    }
    private void printInfo(String shipName, int boxes, String docNumber) {
        for (int i = 1; i <= boxes; i+=1) {
            System.out.println(docNumber + " - " + shipName + " выгружено: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


//public class Port {
//    private final Object doc1Lock = new Object();
//    private final Object doc2Lock = new Object();
//
//    public void unloadAtAvailableDoc(String shipName, int boxes) {
//        boolean unloaded = false;
//
//        while (!unloaded) {
//            // Пробуем док1
//            if (tryUnload(doc1Lock, shipName, boxes, "Док 1")) {
//                unloaded = true;
//            }
//            // Пробуем док2
//            else if (tryUnload(doc2Lock, shipName, boxes, "Док 2")) {
//                unloaded = true;
//            }
//            // Оба дока заняты — подождем и попробуем снова
//            else {
//                try {
//                    Thread.sleep(100); // ждём 0.1 сек и пробуем снова
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private boolean tryUnload(Object lock, String name, int boxes, String dockName) {
//        // Пытаемся занять док
//        if (tryLock(lock)) {
//            // Мы успешно зашли в док — разгружаемся
//            unload(name, boxes, dockName);
//            return true;
//        }
//        return false;
//    }
//
//    private boolean tryLock(Object lock) {
//        // Пытаемся синхронизироваться — если кто-то внутри, мы не ждём, просто возвращаем false
//        if (Thread.holdsLock(lock)) return false;
//
//        synchronized (lock) {
//            return true; // мы вошли — док занят теперь
//        }
//    }
//
//    private void unload(String shipName, int boxes, String dockName) {
//        for (int i = 1; i <= boxes; i++) {
//            System.out.println(dockName + ": " + shipName + " выгрузил ящик " + i);
//            try {
//                Thread.sleep(500); // 0.5 сек за ящик
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
