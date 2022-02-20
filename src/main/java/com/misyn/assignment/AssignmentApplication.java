package com.misyn.assignment;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Autowired
	private DataSource datasource;

	@Override
	public void run(String... args) throws Exception {
		String script = "src/main/resources/company.sql";
		ScriptRunner scriptRunner = new ScriptRunner(datasource.getConnection());
		scriptRunner.runScript(new BufferedReader(new FileReader(script)));
	}

}
