import java.util.*;

class RunningMedian {

    private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public void insert(int num) {

        if(left.isEmpty() || num <= left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }
        if(left.size() > right.size() + 1){
            right.offer(left.poll());
        } 
        else if(right.size() > left.size() + 1){
            left.offer(right.poll());
        }
    }

    public float getMedian() {

        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0f;
        }

        if (left.size() > right.size()) {
            return left.peek();
        }

        return right.peek();
    }
}
