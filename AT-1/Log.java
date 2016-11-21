/**
 * Class Log writes information
 * about tests in log.txt
 */
public class Log {
  /**
   * writes in log file the commands'
   * results, command and time
   *
   * @param result     - "+" if test passed, otherwise "!"
   * @param command    - done command
   * @param startOpen  - start time doing command
   * @param finishOpen - finish time doing command
   */
  public void getCommandTime(String result, String command, double startOpen, double finishOpen) {
    double time = (finishOpen - startOpen);
    int i = (int) Math.round(time);
    time = (double) i / 1000;
    System.err.println(result + command + " " + time);
  }

  /**
   * writes in log file the amount
   * of total tests
   *
   * @param totalTests - amount of total tests
   */
  public void getTotalTests(int totalTests) {
    System.err.println("Total tests: " + totalTests);
  }

  /**
   * writes in log file the amount of
   * passed and failed tests
   *
   * @param totalTests - amount of total tests
   * @param failed     - amount of failed tests
   */
  public void getPassedFailed(int totalTests, int failed) {
    System.err.println("Passed/Failed: " + (totalTests - failed) + "/" + failed);
  }

  /**
   * writes in log file total time
   * of all tests
   *
   * @param start  - start time of all tests
   * @param finish - finish time of all tests
   */
  public void getTotalTime(double start, double finish) {
    double time = (finish - start) / 1000;
    System.err.format("Total time: " + "%.3f", time);
  }

  /**
   * writes in log file the average time
   * of all tests
   *
   * @param start     - start time of all tests
   * @param finish    - finish time of all tests
   * @param totalTest - amount of total tests
   */
  public void getAverageTime(double start, double finish, int totalTest) {
    double averageTime = (finish - start) / (totalTest * 1000);
    System.err.format("\nAverage time: " + "%.3f", averageTime);
  }
}
