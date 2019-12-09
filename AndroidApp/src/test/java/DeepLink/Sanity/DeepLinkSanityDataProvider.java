package DeepLink.Sanity;

import customexception.TestParametersNotFound;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.sql.SQLException;


public class DeepLinkSanityDataProvider {

    @DataProvider(name = "deepLinkSanityData")
    public Object[][] getFrontEndTestData(Method method) throws SQLException, TestParametersNotFound {
      return new Object[][]{{"8447405515@nocash.mobikwik.com","priyanka123"}};

}}
