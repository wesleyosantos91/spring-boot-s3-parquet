//package io.github.wesleyosantos91.mapper;
//
//import io.github.wesleyosantos91.exception.BusinessException;
//import io.github.wesleyosantos91.request.Person;
//import org.apache.avro.Schema;
//import org.apache.avro.SchemaBuilder;
//import org.apache.avro.generic.GenericData;
//import org.apache.avro.generic.GenericRecord;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PersonMapper {
//
//    private final Schema schema;
//
//    public PersonMapper() {
//        this.schema = SchemaBuilder.record("Person").fields()
//                .name("name").type().stringType().noDefault()
//                .name("age").type().intType().noDefault()
//                .name("email").type().stringType().noDefault()
//                .endRecord();
//    }
//
//    public Schema getSchema() {
//        return schema;
//    }
//
//    public GenericRecord toAvro(Object object) {
//        if (object instanceof Person p) {
//            GenericRecord record = new GenericData.Record(getSchema());
//            record.put("name", p.name());
//            record.put("age", p.age());
//            record.put("email", p.email());
//
//
//            return record;
//        }
//
//        throw new BusinessException("Invalid object");
//    }
//}
