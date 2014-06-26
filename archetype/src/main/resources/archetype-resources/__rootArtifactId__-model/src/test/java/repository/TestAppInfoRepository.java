#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import static com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb.InMemoryMongoRuleBuilder.newInMemoryMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${package}.domain.AppInfo;
import ${package}.repository.mongodb.AppInfoRepository;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mongodb/springdata-mongodb.xml")
//@ActiveProfiles()
public class TestAppInfoRepository{
	@Autowired
	private ApplicationContext applicationContext;
	
	@ClassRule
	public static final InMemoryMongoDb IN_MEMORY_MONGO_DB = newInMemoryMongoDbRule().build();
	
	@Rule
	public MongoDbRule remoteMongoDbRule = newMongoDbRule().defaultSpringMongoDb("test");
	
	@Autowired
	private AppInfoRepository appInfoDemoRepository;
	
	@Test
	@UsingDataSet(locations="/mongodb/testdata/initialdata.json",loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByGroupId(){
		List<AppInfo> appInfoDemos = appInfoDemoRepository.findByGroupId("lenovo.com");
		assertThat(appInfoDemos,hasSize(1));
	}

	
}
