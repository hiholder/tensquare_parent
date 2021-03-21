import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MongoTest {
    //客户端
    private MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
    //数据库
    MongoDatabase commentdb = mongoClient.getDatabase("commentdb");
    //集合
    private MongoCollection<Document> comment = commentdb.getCollection("comment");

    @Before
    public void init() {
        //创建连接
        System.out.println("第一步，创建连接");
        mongoClient = new MongoClient("127.0.0.1", 27017);
        //打开数据库
        System.out.println("第二步，打开数据库");
        MongoDatabase commentdb = mongoClient.getDatabase("commentdb");
        //获取集合
        System.out.println("第三步，获取集合");
        comment = commentdb.getCollection("comment");
    }

    //查询所有数据
    @Test
    public void test1() {
        /*mongoClient=new MongoClient("127.0.0.1",27017);
        //打开数据库
        MongoDatabase commentdb = mongoClient.getDatabase("commentdb");
        comment=commentdb.getCollection("comment");*/
        //查询
        //FindIterable<Document> documents = comment.find(new BasicDBObject("_id", "1"));
        FindIterable<Document> documents = comment.find(new BasicDBObject());
        //查询记录获取文档集合
        for (Document document : documents) {
            System.out.println("_id：" + document.get("_id"));
            System.out.println("内容：" + document.get("content"));
            System.out.println("用户ID:" + document.get("userid"));
            System.out.println("点赞数：" + document.get("thumbup"));

        }
        mongoClient.close();
    }

    @After
    public void after() {
        //关闭连接
        System.out.println("关闭连接");
        mongoClient.close();
    }

    // 根据条件_id查询数据，db.comment.find({"_id" : "1"})
    @Test
    public void test2() {
        //封装查询条件
        BasicDBObject bson = new BasicDBObject("_id", "1");
        //执行查询
        FindIterable<Document> documents = comment.find(bson);
        for (Document document : documents) {
            System.out.println("-----------------");
            System.out.println("_id:" + document.get("_id"));
            System.out.println("content:" + document.get("content"));
            System.out.println("userid:" + document.get("userid"));
            System.out.println("thumbup:" + document.get("thumbup"));
        }
    }

    // 新增db.comment.insert({"_id" : "5", "content" : "坚持就是胜利123", "userid" : "1018", "thumbup" : 1212})
    @Test
    public void test3() {
        //封装新增数据
        Map<String, Object> map = new HashMap<>();
        map.put("_id", "6");
        map.put("content", "新增测试");
        map.put("userid", "1019");
        map.put("thumbup", "666");
        //封装新增文档对象
        Document document = new Document(map);
        //执行新增
        comment.insertOne(document);
    }

    //修改，db.comment.update({"_id" : "5"},{$set:{"userid" : "888"}})
    @Test
    public void test4() {
        //创建修改条件
        BasicDBObject filter = new BasicDBObject("_id", "6");
        //创建修改的值
        BasicDBObject update = new BasicDBObject("$set", new Document("userid", "999"));
        //执行修改
        comment.updateOne(filter, update);
    }

    //删除，db.comment.remove({"_id" : "5"})
    @Test
    public void test5() {
        //创建删除的条件
        BasicDBObject bson = new BasicDBObject("_id", "6");
        //执行删除
        comment.deleteOne(bson);
    }

}
