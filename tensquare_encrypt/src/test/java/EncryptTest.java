import com.tensquare.encrypt.EncryptApplication;
import com.tensquare.encrypt.rsa.RsaKeys;
import com.tensquare.encrypt.service.RsaService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EncryptApplication.class)
public class EncryptTest {

    @Autowired
    private RsaService rsaService;

    @Before
    public void before() throws Exception{
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void genEncryptDataByPubKey() {
        String data = "{\"title\":\"java\"}";

        try {

            String encData = rsaService.RSAEncryptDataPEM(data, RsaKeys.getServerPubKey());

            System.out.println("data: " + data);
            System.out.println("encData: " + encData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() throws Exception {
        String requestData="b0qTJrYoTZDdHNEp4pLYCr+7wjw2PXIhT49JWQ95AtVrugF9nYyuJhI4MVvAL5Xum/EzGTMlcyk70MD2BvdaJ7U1kSYUWkU1vGpRobpf5qbX6VZgWOh7OUuVBNsbpc68Kwn0MZnFhAdYUFX2X9mEEQAH8a6r4AqugdF0z+lBCsx4aOzvt5orrNYSXvIer4tNTDca5l2TdbdU6yYYmUXS4je49lqg5kmP6DtxjSoKLtWNPKFQgE4Po9VeXJRPsdWomxU514ntnvRaUiFmuNpMJmQbn9fGh1xNO2Qg+slZQJIQ9brkuFcJ7J7yAm3v26YkScfroJTGaZ6UeVy9PBEGuA==";
        String s = rsaService.RSADecryptDataPEM(requestData, RsaKeys.getServerPrvKeyPkcs8());
        System.out.println(s);
    }
}
