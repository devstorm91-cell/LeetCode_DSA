class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {

        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    private void balance() {

        while (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }

        while (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {

        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {

        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }

        left.addLast(val);
        balance();
    }

    public void pushBack(int val) {

        right.addLast(val);
        balance();
    }

    public int popFront() {

        if (left.isEmpty())
            return -1;

        int value = left.removeFirst();

        balance();

        return value;
    }

    public int popMiddle() {

        if (left.isEmpty())
            return -1;

        int value = left.removeLast();

        balance();

        return value;
    }

    public int popBack() {

        if (left.isEmpty())
            return -1;

        int value;

        if (!right.isEmpty())
            value = right.removeLast();
        else
            value = left.removeLast();

        balance();

        return value;
    }
}