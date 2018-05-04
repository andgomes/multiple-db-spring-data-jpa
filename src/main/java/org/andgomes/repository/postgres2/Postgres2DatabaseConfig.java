package org.andgomes.repository.postgres2;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "org.andgomes.repository.postgres2",
		transactionManagerRef = "otherTransactionManager",
		entityManagerFactoryRef = "otherEntityManagerFactory")
public class Postgres2DatabaseConfig {

	@Bean("otherDataSourceProperties")
	@Qualifier("otherDataSourceProperties")
	@ConfigurationProperties("db2.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean("otherDataSource")
	@Qualifier("otherDataSource")
	@ConfigurationProperties("db2.datasource")
	public DataSource dataSource(
			@Qualifier("otherDataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}
	
	@Bean("otherEntityManagerFactory")
	@Qualifier("otherEnitityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("otherDataSource") DataSource dataSource) {
		
		return builder.
				dataSource(dataSource).
				packages("org.andgomes.bean").
				persistenceUnit("PersonPU").
				build();
		
	}
	
	@Bean("otherTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("otherEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}
