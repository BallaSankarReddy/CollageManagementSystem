package com.collage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class S3Config {
	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey;
	@Value("${cloud.aws.credentials.secretKey}")
	private String secretKey;
	@Value("${cloud.aws.region.static}")
	private String region;

	/*
	 * Access Key ID: AKIATSTTLU24RBMD5S4K Secret Access Key:
	 * 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
	 * 
	 */

	@Bean
	public AmazonS3Client generateS3Client() {

		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		
	//	AmazonS3 build = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
		AmazonS3Client client = new AmazonS3Client(credentials);
		return client;
	}
}
