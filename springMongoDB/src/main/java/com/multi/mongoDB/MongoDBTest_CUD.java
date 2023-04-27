package com.multi.mongoDB;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class MongoDBTest_CUD {

	public static void main(String[] args) {
		// 1. 몽고db 프로그램에 연결
		MongoClient client = new MongoClient("localhost", 27017);
		System.out.println("1.몽고db 프로그램에 연결 성공.");
		// 2. shop2 db로 연결
		MongoDatabase database = client.getDatabase("shop2");
		System.out.println("2.shop2 db로 연결 성공.");
		// 3.member 컬렉션에 연결
		MongoCollection<Document> collection = database.getCollection("memo");
		System.out.println("3.memo 컬렉션에 연결 성공.");

		// insertOne
//		Document doc = new Document();
//		doc.append("age", 500);
//		doc.append("name", "song");
//		doc.append("office", "busan");
//		doc.append("phone", "011");
//		collection.insertOne(doc);
//		System.out.println("4.memo 컬렉션에 insertOne 성공.");
		
		// insertMany
//		Document doc2 = new Document();
//		doc2.append("age", 501);
//		doc2.append("name", "song2");
//		doc2.append("office", "busan");
//		doc2.append("phone", "011");
//		Document doc3 = new Document();
//		doc3.append("age", 502);
//		doc3.append("name", "song3");
//		doc3.append("office", "busan");
//		doc3.append("phone", "011");
//		Document doc4 = new Document();
//		doc4.append("age", 503);
//		doc4.append("name", "song4");
//		doc4.append("office", "busan");
//		doc4.append("phone", "011");
//		
//		List<Document> list = new ArrayList<Document>();
//		list.add(doc2);
//		list.add(doc3);
//		list.add(doc4);
//		collection.insertMany(list);
//		System.out.println("4.memo 컬렉션에 insertMany 성공.");
		
		//deleteOne
//		Document filter = new Document();
//		filter.append("age", 500);
//		collection.deleteOne(filter);
//		System.out.println("4.memo 컬렉션에 deleteOne 성공.");
		
		//updateOne
//		Document filter = new Document();
//		filter.append("age", 501);
//		Bson set = Updates.set("name", "song");
//		collection.updateOne(filter, set);
//		System.out.println("4.memo 컬렉션에 updateOne 성공.");
		
		//updateMany
//		Document filter = new Document();
//		filter.append("office", "busan");
//		Bson set2 = Updates.set("phone", "9999");
//		Bson set3 = Updates.set("name", "songsong2");
//		Bson set4 = Updates.set("age", 555);
//		
//		
//		List<Bson> list = new ArrayList<Bson>();
//		list.add(set2);
//		list.add(set3);
//		list.add(set4);
//		
//		Bson sets = Updates.combine(list);
//		collection.updateMany(filter, sets);
//		System.out.println("4.memo 컬렉션에 updateMany 성공.");
		
		//find
		FindIterable<Document> list = collection.find();
		List<MemoVO> result = new ArrayList<MemoVO>();
		for (Document doc : list) {
			MemoVO bag = new MemoVO();
			bag.setName(doc.getString("name"));
			bag.setAge(doc.getInteger("age"));
			bag.setOffice(doc.getString("office"));
			bag.setPhone(doc.getString("phone"));
			result.add(bag);
		}
		System.out.println(result);
	}

}
