package io.github.wesleyosantos91.service;

import com.jerolba.carpet.CarpetWriter;
import io.github.wesleyosantos91.request.Person;
import io.github.wesleyosantos91.sor.PersonSor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.*;


@Service
public class S3Service {

    private final S3Client s3Client;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void convertAndUpload(Person person, String bucketName) throws IOException {


        File parquetFile = File.createTempFile("people", ".parquet");

        PersonSor personSor = new PersonSor(person.name(), "teste", person.age(), person.email());

        try (OutputStream outputStream = new FileOutputStream(parquetFile)) {
            try (CarpetWriter<PersonSor> writer = new CarpetWriter<>(outputStream, PersonSor.class)) {
                writer.write(personSor);
            }
        }


        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(parquetFile.getName())
                .build();

        try (InputStream inputStream = new FileInputStream(parquetFile)) {
            s3Client.putObject(request, RequestBody.fromInputStream(inputStream, parquetFile.length()));
        }

        parquetFile.delete();


    }


}
