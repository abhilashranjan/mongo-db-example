package demo.mongodb.event;
import com.mongodb.*;

public class MyApp {

    public static void main(String[] args) throws Exception {

        MongoClient mongoClient = new MongoClient();
        DBCollection coll = mongoClient.getDB("users").getCollection("login");

        final DBCursor cur = coll.find().sort(BasicDBObjectBuilder.start("$natural", 1).get())
                .addOption(Bytes.QUERYOPTION_TAILABLE | Bytes.QUERYOPTION_AWAITDATA);

        System.out.println("== open cursor ==");
        Thread task = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("\tWaiting for events");
				while (cur.hasNext()) {
					DBObject obj = cur.next();
					System.out.println( obj );
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
        task.start();
        
    }
    
}