package FromJsonToMysql.Configuration;

import FromJsonToMysql.Entity.Prodotto;
import FromJsonToMysql.Processor.ProductItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration // Imposta un file TaskRepository che memorizza le info sull'esecuzione dell'attività
public class BatchConfiguration {

    @Autowired
    private DataSource datasource;

    @Bean
    public JsonItemReader<Prodotto> jsonItemReader(){
        return new JsonItemReaderBuilder<Prodotto>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(Prodotto.class))
                .resource(new ClassPathResource("file.json"))
                .name("fileJsonItemReade3r")
                .build();
    }

    @Bean
    public ProductItemProcessor processor(){
        return new ProductItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Prodotto> writer() {
        JdbcBatchItemWriter<Prodotto> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("insert into prodotto(id,name,prezzo,prezzo_scontato) values (:id,:name,:prezzo,:prezzo_scontato)");
        writer.setDataSource(datasource);
        return writer;
    }


    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("step1", jobRepository)
                .<Prodotto,Prodotto>chunk(1,transactionManager)
                .reader(jsonItemReader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job importProductJob(JobRepository jobRepository, Step step1){
        return new JobBuilder("importProductJob", jobRepository)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public JdbcCursorItemReader<Prodotto> JdbcReader(){
        return new JdbcCursorItemReaderBuilder<Prodotto>()
                .dataSource(datasource)
                .name("productReader")
                .sql("select id,name, prezzo, prezzo_scontato FROM prodotto")
                .rowMapper(new BeanPropertyRowMapper<>(Prodotto.class))
                .build();

    }

    /*
     * NON DEVO PROCESSARE DATI QUINDI NON SERVE UN PROCESSOR
     */

    @Bean
    public FlatFileItemWriter<Prodotto> ItemWriter() {
        return new FlatFileItemWriterBuilder<Prodotto>()
                .name("productWriter")
                .resource(new FileSystemResource("output.csv"))
                .lineAggregator(new DelimitedLineAggregator<Prodotto>(){
                    {
                        setDelimiter(",");
                        setFieldExtractor(product -> new Object[]{
                                product.getId(), product.getName(), product.getPrezzo(), product.getPrezzo_scontato()
                        });
                    }
                })
                .build();
    }

    @Bean
    public Step step2(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("step2", jobRepository)
                .<Prodotto, Prodotto> chunk(1,transactionManager)
                .reader(JdbcReader())
                .writer(ItemWriter())
                .allowStartIfComplete(true)// a quanto ho capito serve a continuare lo step anche se il primo job è stato eseguito
                .build();
    }

    @Bean
    public Job exportProductJob(JobRepository jobRepository, Step step2) {
        return new JobBuilder("exportProductJob", jobRepository)
                .flow(step2)
                .end()
                .build();
    }
}
