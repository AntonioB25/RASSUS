// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: uppercase.proto

package hr.fer.rassus;

public final class UppercaseOuterClass {
  private UppercaseOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hr_fer_rassus_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hr_fer_rassus_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hr_fer_rassus_SensorReading_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hr_fer_rassus_SensorReading_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017uppercase.proto\022\rhr.fer.rassus\"\032\n\007Mess" +
      "age\022\017\n\007payload\030\001 \001(\t\"n\n\rSensorReading\022\023\n" +
      "\013temperature\030\001 \001(\001\022\020\n\010pressure\030\002 \001(\001\022\020\n\010" +
      "humidity\030\003 \001(\001\022\n\n\002co\030\004 \001(\001\022\013\n\003so2\030\005 \001(\001\022" +
      "\013\n\003no2\030\006 \001(\0012Q\n\tUppercase\022D\n\020RequestUppe" +
      "rcase\022\026.hr.fer.rassus.Message\032\026.hr.fer.r" +
      "assus.Message\"\0002a\n\016SensorReadings\022O\n\025Req" +
      "uestSensorReadings\022\026.hr.fer.rassus.Messa" +
      "ge\032\034.hr.fer.rassus.SensorReading\"\000B\021\n\rhr" +
      ".fer.rassusP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_hr_fer_rassus_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_hr_fer_rassus_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hr_fer_rassus_Message_descriptor,
        new java.lang.String[] { "Payload", });
    internal_static_hr_fer_rassus_SensorReading_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_hr_fer_rassus_SensorReading_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hr_fer_rassus_SensorReading_descriptor,
        new java.lang.String[] { "Temperature", "Pressure", "Humidity", "Co", "So2", "No2", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
