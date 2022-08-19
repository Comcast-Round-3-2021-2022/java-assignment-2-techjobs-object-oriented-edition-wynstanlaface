package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.lang.model.element.Name;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
  @Test
    public void testSettingJobId(){ //check assigned IDs and confirm inequality(difference of 1)
      Job testjob1 = new Job();
      Job testjob2 = new Job();
      assertNotEquals(testjob1.getId(),testjob2.getId(),1);
  }

  @Test
    public void testJobConstructorSetsAllFields(){
      Job newjob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));
              assertEquals(newjob.getName(),"Product tester");
              assertEquals(newjob.getEmployer().getValue(),"ACME");
              assertEquals(newjob.getLocation().getValue(),"Desert");
              assertEquals(newjob.getPositionType().getValue(),"Quality control");
              assertEquals(newjob.getCoreCompetency().getValue(),"Persistence");

              assertTrue(newjob.getEmployer() instanceof Employer);
              assertTrue(newjob.getLocation() instanceof Location);
              assertTrue(newjob.getPositionType() instanceof PositionType);
              assertTrue(newjob.getCoreCompetency() instanceof CoreCompetency);
              assertTrue(newjob instanceof Job);

  }
  @Test
  public void testJobsForEquality(){
      Job newjob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));
      Job newjob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));

      assertTrue(!(newjob1.equals(newjob2)));
  }


}
