import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestVotingSystemApp{

@Test
public void TestForAgeValidation(){

//Arrange
int age = 22;

//Act
boolean result = VotingSystemApp.ageValidator(age);
//Assert
assertEquals(result , true);

}

@Test
public void TestForFalseAgeValidation(){

//Arrange
int age = 15;

//Act
boolean result = VotingSystemApp.ageValidator(age);
//Assert
assertEquals(result , false);

}

@Test
public void TestForTrueAgeValidation(){

//Arrange
int age = 18;

//Act
boolean result = VotingSystemApp.ageValidator(age);
//Assert
assertEquals(result , true);

}


@Test
public void TestNationalityValidator(){

//Arrange
String country = "Nigeria";

//Act
boolean result = VotingSystemApp.nationalityValidator(country);
//Assert
assertEquals(result , true);

}

@Test
public void TestForLowerCaseInNationalityValidator(){

//Arrange
String country = "nigeria";

//Act
boolean result = VotingSystemApp.nationalityValidator(country);
//Assert
assertEquals(result , true);

}

@Test
public void TestForUpperCaseInNationalityValidator(){

//Arrange
String country = "NIGERIA";

//Act
boolean result = VotingSystemApp.nationalityValidator(country);
//Assert
assertEquals(result , true);

}

@Test
public void TestForOtherCountriesInNationalityValidator(){

//Arrange
String country = "Ghana";

//Act
boolean result = VotingSystemApp.nationalityValidator(country);
//Assert
assertEquals(result , false);

}

@Test
public void TestForAnotherCountryInNationalityValidator(){

//Arrange
String country = "niger";

//Act
boolean result = VotingSystemApp.nationalityValidator(country);
//Assert
assertEquals(result , false);

}

@Test
public void TestForTimeToStartMethod(){

//Arrange
int time = 5;

//Act
boolean result = VotingSystemApp.timeToStart(time);
//Assert
assertEquals(result , true);

}

@Test
public void TestForTimeToEndMethod(){

//Arrange
int time = 5;

//Act
boolean result = VotingSystemApp.timeToEnd(time);
//Assert
assertEquals(result , false);

}




}