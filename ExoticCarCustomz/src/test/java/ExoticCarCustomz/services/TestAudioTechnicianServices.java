package ExoticCarCustomz.services;

import ExoticCarCustomz.App;
import ExoticCarCustomz.conf.factory.AudioTechnicianFactory;
import ExoticCarCustomz.domain.AudioTechnician;
import ExoticCarCustomz.repository.AudioTechnicianRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/10.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestAudioTechnicianServices extends AbstractTestNGSpringContextTests {

    @Autowired
    private AudioTechnicianServices service;

    private Long id;

    @Autowired
    private AudioTechnicianRepository repository;
    private Map<String, String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
    }

    @Test
    public void create() throws Exception {

        values.put("LastName", "Tseleng");
        values.put("FirstName", "Rudy");

        AudioTechnician technician = AudioTechnicianFactory
                .createAudioTechnician(values);

        repository.save(technician);
        id= technician.getTechnicianID();
        Assert.assertNotNull(technician.getTechnicianID());
    }
}
