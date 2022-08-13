package methods.defining_methods.hard.q8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "100";
    return new Clause[] {
        new StringLiteral("Enter the cost of rent per month:"),
        new Optional(new StringLiteral(" ")),
        new NewLine(),
        new StringLiteral("The total cost of rent per year is \\$"),
        new DoubleLiteral("rentYearly")
    };
  };

  public void runMain() {
    RentMethod.main(new String[0]);
  }

  static Stream<Arguments> rentPricesProvider() {
    return Stream.of(
        Arguments.of(100.0, 1200.0),
        Arguments.of(200.0, 2400.0),
        Arguments.of(500.0, 6000.0),
        Arguments.of(600.0, 7200.0),
        Arguments.of(700.0, 8400.0),
        Arguments.of(1000.0, 12000.0),
        Arguments.of(321.344, 3856.128),
        Arguments.of(1.1, 13.2));
  }

  @ParameterizedTest
  @MethodSource("rentPricesProvider")
  void correctCalculatesRent(double rentMonthly, double rentYearly) throws Throwable {
    String errorMsg = "Your method \"rentCalcYear()\" does not calculate the yearly rent correctly.";
    Object output = MethodUtil.invokeIfMethodExists(RentMethod.class, "rentCalcYear", new Object[] { rentMonthly },
        double.class);
    CustomAssertions._assertEquals(output, rentYearly, 0.01, errorMsg);
  }

  @ParameterizedTest
  @MethodSource("rentPricesProvider")
  void printsCorrectYearlyRent(double rentMonthly, double rentYearly) {
    String errorMsg = "Your program does not print the correct yearly rent.";
    runWithInput(rentMonthly + "");
    assertEquals(Double.parseDouble(getItemByName("rentYearly")), rentYearly, 0.001, errorMsg);

  }
}
