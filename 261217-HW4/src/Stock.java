public class Stock {
    private List list;
    private int totalShares;

    public Stock(String costBasis) { // กำหนดวิธีคิดผมกำไรของ Stock หาก costBasis เป็น FIFO จะสร้าง Queue หากเป็น
                                     // LIFO จะสร้างแบบ Stack
        switch (costBasis) {
            case "FIFO":
                list = new Queue();
                break;
            case "LIFO":
                list = new Stack();
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }

    public void buy(int boughtShares, double boughtPrice) { // รับ boughtShares และ boughtPrice แล้วเอามาสร้าง Node แล้ว
                                                            // push เข้า list แล้วบวกค่า totalShares ด้วย boughtShares
        list.push(new Node(boughtShares, boughtPrice));
        totalShares += boughtShares;
    }

    public void sell(int soldShares, double soldPrice) { // รับ soldShares และ soldPrice มาแล้วเช็คว่าถ้า soldShares
                                                         // น้อยกว่า totalShares ให้
        if (soldShares <= totalShares) {
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;

            while (soldShares > 0 && list.top() != null) {
                Node currentShares = list.top();
                if (soldShares >= currentShares.shares) {
                    realizedGain += (soldPrice - currentShares.price) * currentShares.shares;
                    soldShares -= currentShares.shares;
                    list.pop();
                } else {
                    realizedGain += (soldPrice - currentShares.price) * soldShares;
                    currentShares.shares -= soldShares;
                    soldShares = 0;
                }
            }

            Node current = list.top();
            while (current != null) {
                unrealizedGain += (soldPrice - current.price) * current.shares;
                current = current.next;
            }

            totalShares -= soldShares;
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
        } else {
            System.out.println("Sell command rejected");
        }
    }

    public void showList() { // ปริ้น list ตั้งแต่ head จนถึง tail
        Node currentNode = list.top();
        System.out.print("head -> ");
        while (currentNode != null) {
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}