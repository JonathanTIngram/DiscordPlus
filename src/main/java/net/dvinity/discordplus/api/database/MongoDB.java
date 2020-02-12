/*
 * Copyright 2019-2020 Christian Larcomb, Jonathan Ingram, Delmond Wyllis, and the DiscordPlus contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dvinity.discordplus.api.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDB
{

    private String uri;
    private MongoClientURI clientURI;
    private MongoClient mongoClient;

    /*
    * Creates an instance of the MongoDB class which ultimately
    * establishes a connection to your Mongo Database.
    *
    * Utilized to simplify the process of connecting to MongoDB and
    * managing your collections/documents.
    *
    * @see
    *
    * @since 1.0
    *
    * @param connectionString
    *        Connection string used to give access to
    *        your MongoDatabase Collection.
    */
    MongoDB(String connectionString, String username, String password)
    {
      this.uri = "mongodb+srv://" + username + ":"+ password + "@botdata-ofqqb.mongodb.net/test?retryWrites=true&w=majority";
      this.clientURI = new MongoClientURI(uri);
      this.mongoClient = new MongoClient(clientURI);
    }

    /*
     * @return
     *
     * @see
     *
     * @since 1.0
     */
    public MongoClient getMongoClient()
    {
        return this.mongoClient;
    }

    /*
     * @return
     *
     * @see
     *
     * @since 1.0
     */
    public MongoClientURI getMongoClientURI()
    {
        return this.clientURI;
    }

    /*
     * Gets the connection string URI.
     *
     * @see
     *
     * @since 1.0
     */
    public String getStringURI()
    {
        return this.uri;
    }

    /*
     * Retrieves the Mongo Database.
     *
     * @since 1.0
     *
     * @param connectionString
     *        Connection string used to give access to
     *        your MongoDatabase Collection.
     */
    public MongoDatabase getMongoDatabase(String databaseName)
    {
        return getMongoClient().getDatabase(databaseName);
    }

}
