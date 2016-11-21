/**
 * Parses command
 */
public class ParserCommand {
  /**
   * deletes quotes from command
   *
   * @param line - command
   * @return new line without quotes
   */
  public String lineWithoutQuotes(String line) {
    String newLine = "";
    char k = '"';
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) != k) {
        newLine += line.charAt(i);
      }
    }
    return newLine;
  }

  /**
   * selects operation from command
   *
   * @param line - command
   * @return - done operation
   */
  public String parserOperation(String line) {
    String operation = line.split("\\s+")[0];
    return operation;
  }

  /**
   * selects url from operation "open"
   *
   * @param line - command
   * @return url from operation "open"
   */
  public String parserOpenUrl(String line) {
    return lineWithoutQuotes(line).split("\\s+")[1];
  }

  /**
   * selects timeout from operation "open"
   *
   * @param line - command
   * @return timeout from operation "open"
   */
  public String parserOpenTime(String line) {
    return lineWithoutQuotes(line).split("\\s+")[2];
  }

  /**
   * selects command's argument
   *
   * @param line - command
   * @return command's argument
   */
  public String parserArgument(String line) {
    String[] stringLine = new String[1];
    stringLine[0] = lineWithoutQuotes(line).split("\\s+")[0];
    String argument = "";
    if (lineWithoutQuotes(line).contains(stringLine[0])) {
      argument = lineWithoutQuotes(line).replaceAll(stringLine[0], "");
    }
    if (argument.contains(" ")) {
      argument = argument.replaceFirst(" ", "");
    }
    return argument;
  }
}
