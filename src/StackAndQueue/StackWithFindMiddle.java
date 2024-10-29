package src.StackAndQueue;

public class StackWithFindMiddle {
    class StackNode{
        int val;
        StackNode prev;
        StackNode next;

        StackNode(int val) {
            this.val = val;
        }
    }
    StackNode head, tail;
    int count = 0;
    StackNode mid;

    StackWithFindMiddle() {
        head = new StackNode(Integer.MIN_VALUE);
        tail = new StackNode(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
        mid = head;
        count = 0;
    }

    public static void main(String args[])
    {
        StackWithFindMiddle ms = new StackWithFindMiddle();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);

        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : "
                + ms.findMiddle());
        ms.deleteMiddleElement();
        System.out.println("New Middle Element : "
                + ms.findMiddle());
    }

    private void deleteMiddleElement() {
        if (mid == head) {
            return ; // empty array
        }
        mid.prev.next = mid.next;
        mid.next.prev = mid.prev;
        count--;
        if (count %2 != 0) {
            mid= mid.prev;
        } else {
            mid = mid.next;
        }
    }

    private int findMiddle() {
        if (mid != head) {
            return mid.val;
        }
        // empty stack
        return -1;
    }

    private int pop() {
        if (head.next == tail) {
            // no element in stack
            return -1;
        }
        StackNode prev = tail.prev;
        prev.next = tail.next;
        prev.prev.next = tail;
        tail.prev = prev.prev;

        count--;
        if (count %2 != 0) {
            mid= mid.prev;
        }
        return prev.val;
    }

    private void push(int val) {
        StackNode newNode = new StackNode(val);
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        count++;
        if (count %2 != 0) {
            mid= mid.next;
        }
    }
}
