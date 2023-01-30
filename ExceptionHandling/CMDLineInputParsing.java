class CMDLineInputParsing {
  public static void main(String[] args) {
    int noofValid = 0, noofInvalid = 0;
    for (int i = 0; i < args.length; i++) {
        try {
            Integer.parseInt(args[i]);   // if it cannot parse it, invalid straightaway
            noofValid++;
        } catch (NumberFormatException e) {
            System.out.println(e);
            noofInvalid++;
        }
    }
    System.out.println("No. of Valid Integers: " + noofValid);
    System.out.println("No. of Invalid Integers: " + noofInvalid);
}
}
