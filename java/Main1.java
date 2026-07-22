import java.util.*;

class RobotMessageTracker{
    HashMap<String,Long> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();

    public void shouldPrintMessage(long timeStamp,String message){

        // if(!map.containsKey(message) || timeStamp -map.get(message)>=10){
        //     System.out.println(message+timeStamp);
        //     map.put(message,timeStamp);
        // }
        
        for(String msg: new ArrayList<>(map.keySet())){
            long firstTime = map.get(msg);
            if(timeStamp-firstTime>=10){
                if(!set.contains(msg)){
                    System.out.println(msg+map.get(msg));
                }
                map.remove(msg);
                set.remove(msg);
            }
        }
        if(map.containsKey(message)){
            set.add(message);
        }else{
            map.put(message,timeStamp);
        }

        
    }
}
class Main {
    public static void main(String[] args) {
        RobotMessageTracker logger = new RobotMessageTracker();
        logger.shouldPrintMessage(1, "foo");
        logger.shouldPrintMessage(2, "bar");
        logger.shouldPrintMessage(3, "foo");
        logger.shouldPrintMessage(13, "foo");
        logger.shouldPrintMessage(14, "foo");
        logger.shouldPrintMessage(15, "foo");
        logger.shouldPrintMessage(16, "foo");
        logger.shouldPrintMessage(18, "foo");

        logger.shouldPrintMessage(46, "bar");
        logger.shouldPrintMessage(90, "foo");
        // logger.shouldPrintMessage(90, "foo");


        logger.shouldPrintMessage(100, "foo");


    }
}