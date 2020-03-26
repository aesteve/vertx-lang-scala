/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.sqlclient
import io.vertx.sqlclient.{PropertyKind => JPropertyKind}
import io.vertx.mysqlclient.{MySQLClient => JMySQLClient}
package object mysqlclient{





  type GeometryCollection = io.vertx.mysqlclient.data.spatial.GeometryCollection
  object GeometryCollection {
    def apply() = new GeometryCollection()
    def apply(json: JsonObject) = new GeometryCollection(json)
  }



  type LineString = io.vertx.mysqlclient.data.spatial.LineString
  object LineString {
    def apply() = new LineString()
    def apply(json: JsonObject) = new LineString(json)
  }



  type MultiLineString = io.vertx.mysqlclient.data.spatial.MultiLineString
  object MultiLineString {
    def apply() = new MultiLineString()
    def apply(json: JsonObject) = new MultiLineString(json)
  }



  type MultiPoint = io.vertx.mysqlclient.data.spatial.MultiPoint
  object MultiPoint {
    def apply() = new MultiPoint()
    def apply(json: JsonObject) = new MultiPoint(json)
  }



  type MultiPolygon = io.vertx.mysqlclient.data.spatial.MultiPolygon
  object MultiPolygon {
    def apply() = new MultiPolygon()
    def apply(json: JsonObject) = new MultiPolygon(json)
  }



  type MySQLAuthOptions = io.vertx.mysqlclient.MySQLAuthOptions
  object MySQLAuthOptions {
    def apply() = new MySQLAuthOptions()
    def apply(json: JsonObject) = new MySQLAuthOptions(json)
  }





  type MySQLConnectOptions = io.vertx.mysqlclient.MySQLConnectOptions
  object MySQLConnectOptions {
    def apply() = new MySQLConnectOptions()
    def apply(json: JsonObject) = new MySQLConnectOptions(json)
  }




  /**
    * An interface which represents a connection to MySQL server.
    * <P>
    *   The connection object supports all the operations defined in the  interface,
    *   in addition it provides MySQL utility command support:
    *   <ul>
    *     <li>COM_PING</li>
    *     <li>COM_CHANGE_USER</li>
    *     <li>COM_RESET_CONNECTION</li>
    *     <li>COM_DEBUG</li>
    *     <li>COM_INIT_DB</li>
    *     <li>COM_STATISTICS</li>
    *     <li>COM_SET_OPTION</li>
    *   </ul>
    * </P>

    */

  implicit class MySQLConnectionScala(val asJava: io.vertx.mysqlclient.MySQLConnection) extends AnyVal {


    /**
     * Like prepare from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def prepareFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedStatement] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedStatement]()
      asJava.prepare(sql, new Handler[AsyncResult[io.vertx.sqlclient.PreparedStatement]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedStatement]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like ping from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pingFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.ping(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like specifySchema from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def specifySchemaFuture(schemaName: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.specifySchema(schemaName, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getInternalStatistics from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getInternalStatisticsFuture() : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.getInternalStatistics(new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like setOption from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def setOptionFuture(option: io.vertx.mysqlclient.MySQLSetOption) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.setOption(option, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like resetConnection from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resetConnectionFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.resetConnection(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like debug from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def debugFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.debug(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like changeUser from [[io.vertx.mysqlclient.MySQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def changeUserFuture(options: io.vertx.mysqlclient.MySQLAuthOptions) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.changeUser(options, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object MySQLPool {
    /**
     * Like pool from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(connectionUri: java.lang.String) = {
      io.vertx.mysqlclient.MySQLPool.pool(connectionUri)
  }

    /**
     * Like pool from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(connectionUri: java.lang.String, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.mysqlclient.MySQLPool.pool(connectionUri, poolOptions)
  }

    /**
     * Like pool from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(vertx: io.vertx.core.Vertx, connectionUri: java.lang.String) = {
      io.vertx.mysqlclient.MySQLPool.pool(vertx, connectionUri)
  }

    /**
     * Like pool from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(vertx: io.vertx.core.Vertx, connectionUri: java.lang.String, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.mysqlclient.MySQLPool.pool(vertx, connectionUri, poolOptions)
  }

    /**
     * Like pool from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(connectOptions: io.vertx.mysqlclient.MySQLConnectOptions, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.mysqlclient.MySQLPool.pool(connectOptions, poolOptions)
  }

    /**
     * Like pool from [[io.vertx.mysqlclient.MySQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pool(vertx: io.vertx.core.Vertx, connectOptions: io.vertx.mysqlclient.MySQLConnectOptions, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.mysqlclient.MySQLPool.pool(vertx, connectOptions, poolOptions)
  }
  }


  type Point = io.vertx.mysqlclient.data.spatial.Point
  object Point {
    def apply() = new Point()
    def apply(json: JsonObject) = new Point(json)
  }



  type Polygon = io.vertx.mysqlclient.data.spatial.Polygon
  object Polygon {
    def apply() = new Polygon()
    def apply(json: JsonObject) = new Polygon(json)
  }



}