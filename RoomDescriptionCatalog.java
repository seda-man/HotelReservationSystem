//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : RoomDescriptionCatalog.java
//  @ Date : 10/27/2017
//  @ Author : 
//
//


import java.util.HashMap;

public class RoomDescriptionCatalog {
 private HashMap<String, RoomDescription> roomDescriptions = new HashMap<String, RoomDescription>();

 public RoomDescriptionCatalog() {
  load();
 }

 public RoomDescription getRoomDescription(String roomType) {
  return roomDescriptions.get(roomType);
 }

 private void load() {
  RoomDescription rd1 = new RoomDescription();
  RoomDescription rd2 = new RoomDescription();
  rd1.setNumberOfRelatedRooms(2);
  rd2.setNumberOfRelatedRooms(1);
  rd1.setRoomType("single");
  rd2.setRoomType("double");
  roomDescriptions.put("single", rd1);
  roomDescriptions.put("double", rd2);
 }

 public HashMap<String, RoomDescription> getRoomDescriptions() {
  return roomDescriptions;
 }

 public void setRoomDescriptions(HashMap<String, RoomDescription> roomDescriptions) {
  this.roomDescriptions = roomDescriptions;
 }


}
