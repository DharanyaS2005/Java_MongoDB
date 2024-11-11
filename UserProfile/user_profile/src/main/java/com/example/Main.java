
package com.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // Create a MongoDB client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        
        // Get the database
        MongoDatabase database = mongoClient.getDatabase("UserProfileManager");
        
        // Get the collection
        MongoCollection<Document> collection = database.getCollection("UserProfileManager");
        
        // Create documents to insert
        Document user1 = new Document("name", "saran")
            .append("bio", "Health and wellness advocate with a background in nutrition and personal training.")
            .append("pic_url", "https://www.saranPro.com");
        
        // Insert documents
        collection.insertOne(user1);
        
        
        System.out.println("Documents inserted successfully!");

        // List the documents
        FindIterable<Document> documents = collection.find();
        for (Document doc : documents) {
            System.out.println(doc.toJson());
        }

        collection.updateOne(
            Filters.eq("username", "vaishu"),
            Updates.set("bio", "Financial analyst adept at using data-driven insights to guide investment decisions and business strategies.")
        );

        System.out.println("Document updated successfully!");


        // Close the connection
        mongoClient.close();
    }
}