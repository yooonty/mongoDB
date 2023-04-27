package com.multi.mongoDB;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBTest_find {

	public static void main(String[] args) {
		// 1. 몽고db 프로그램에 연결
		MongoClient client = new MongoClient("localhost", 27017);
		System.out.println("1.몽고db 프로그램에 연결 성공.");
		// 2. shop2 db로 연결
		MongoDatabase database = client.getDatabase("shop2");
		System.out.println("2.shop2 db로 연결 성공.");
		// 3.member 컬렉션에 연결
		MongoCollection<Document> collection = database.getCollection("member");
		System.out.println("3.member 컬렉션에 연결 성공.");

		FindIterable<Document> list = collection.find(); //전체 검색
		List<memberVO> result = new ArrayList<memberVO>();
		for (Document doc : list) {
			System.out.println(doc);
			memberVO bag = new memberVO();
			bag.setId(doc.getString("id"));
			bag.setPw(doc.getString("pw"));
			bag.setName(doc.getString("name"));
			bag.setTel(doc.getString("tel"));
			result.add(bag);
		}
		System.out.println(result);
	}

}
