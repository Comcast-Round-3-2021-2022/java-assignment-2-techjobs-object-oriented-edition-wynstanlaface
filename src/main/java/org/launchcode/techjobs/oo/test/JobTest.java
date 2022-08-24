package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.lang.model.element.Name;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
  @Test
    public void testSettingJobId(){ //check assigned IDs and confirm inequality
      Job testjob1 = new Job();
      Job testjob2 = new Job();
      assertNotEquals(testjob1.getId(),testjob2.getId());
  }

  @Test
    public void testJobConstructorSetsAllFields(){
      Job newjob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));


              assertTrue(newjob.getEmployer() instanceof Employer);
              assertTrue(newjob.getLocation() instanceof Location);
              assertTrue(newjob.getPositionType() instanceof PositionType);
              assertTrue(newjob.getCoreCompetency() instanceof CoreCompetency);
              assertTrue(newjob instanceof Job);

              assertEquals(newjob.getName(),"Product tester");
              assertEquals(newjob.getEmployer().getValue(),"ACME");
              assertEquals(newjob.getLocation().getValue(),"Desert");
              assertEquals(newjob.getPositionType().getValue(),"Quality control");
              assertEquals(newjob.getCoreCompetency().getValue(),"Persistence");

  }
  @Test
  public void testJobsForEquality(){
      Job newjob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));
      Job newjob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
              new PositionType("Quality control"), new CoreCompetency("Persistence"));

      assertFalse((newjob1.equals(newjob2)));
  }
    @Test
        public void testToStringStartsAndEndsWithNewLine(){

        Job stringjob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstchar = stringjob.toString().charAt(0);
        char lastchar = stringjob.toString().charAt(stringjob.toString().length()-1);

        assertEquals(firstchar,'\n');
        assertEquals(lastchar,'\n');

    }

    @Test     //use assertEquals
        public void testToStringContainsCorrectLabelsAndData(){
        Job stringjob = new Job("Product tester",
                        new Employer("ACME"),
                        new Location("Desert"),
                        new PositionType("Quality control"),
                        new CoreCompetency("Persistence"));

        assertEquals(stringjob.toString(),"\n" +
                "ID: " + stringjob.getId() + "\n" +
                "Name: " + stringjob.getName() + "\n" +
                "Employer: " + stringjob.getEmployer().getValue() + "\n" +
                "Location: " + stringjob.getLocation().getValue() + "\n" +
                "Position Type: " + stringjob.getPositionType().getValue() + "\n" +
                "Core Competency: " + stringjob.getCoreCompetency().getValue() + "\n");


    }
    @Test
    public void testToStringHandlesEmptyField(){
                                    Job stringjob = new Job("",
                                            new Employer(""),
                                            new Location(""),
                                            new PositionType(""),
                                            new CoreCompetency(""));

        assertEquals(stringjob.toString(),"\n" + "ID: " + stringjob.getId() + "\n"
                                                     + "Name: " + "Data not available" + "\n"
                                                     + "Employer: " + "Data not available" + "\n"
                                                     + "Location: " + "Data not available" + "\n"
                                                     + "Position Type: " + "Data not available" + "\n"
                                                     + "Core Competency: " + "Data not available"
                                                                + "\n");

    }

}
