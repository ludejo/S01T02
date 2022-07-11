package n2e1;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Entrada {

    private static final Pattern patternNumeric = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final Scanner scanner = new Scanner(System.in);


    public static byte llegirByte(String missatge) {
        Byte in = null;
        while (in == null) {
            System.out.print(missatge);
            try {
                in = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Input no vàlid: " + e.getMessage());
            }
            scanner.nextLine();
        }
        return in;
    }

    /*
    public static byte llegirByteOpt(String missatge) {
        Optional<Byte> in = Optional.empty();
        while (in.isEmpty()) {
            System.out.print(missatge);
            try {
                in = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Input no vàlid: " + e.getMessage());
                scanner.next();
            }
        }
        return in;
    }
     */

    public static int llegirInt(String missatge) {
        Integer in = null;
        while (in == null) {
            System.out.print(missatge);
            try {
                in = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input no vàlid: " + e.getMessage());
            }
            scanner.nextLine();
        }
        return in;
    }

    public static float llegirFloat(String missatge) {
        Float in = null;
        while (in == null) {
            System.out.print(missatge);
            try {
                in = scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Input no vàlid: " + e.getMessage());

            }
            scanner.nextLine();
        }
        return in;
    }

    public static double llegirDouble(String missatge) {
        Double in = null;
        while (in == null) {
            System.out.print(missatge);
            try {
                in = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Input no vàlid: " + e.getMessage());
            }
            scanner.nextLine();
        }
        return in;
    }

    public static char llegirChar(String missatge) {
        Character in = null;
        while (in == null) {
            System.out.print(missatge);
            try {
                String tmps = scanner.nextLine();
                if (tmps.length() == 1) {
                    char tmpc = tmps.charAt(0);
                    if (Character.isLetter(tmpc)) {
                        in = tmpc;
                    } else {
                        throw new Exception("input ha de ser una lletra");
                    }
                } else {
                    throw new Exception("input ha de ser un únic caràcter");
                }
            } catch (Exception e) {
                System.out.println("Input no vàlid: " + e.getMessage());
            }
        }
        return in;
    }

    public static String llegirString(String missatge) {
        String in = null;
        while (in == null) {
            System.out.print(missatge);
            try {
                String tmp = scanner.nextLine();
                if (!patternNumeric.matcher(tmp).matches()) {
                    in = tmp;
                } else {
                    throw new Exception("input no pot ser estrictament numèric");
                }
            } catch (Exception e) {
                System.out.println("Input no vàlid: " + e.getMessage());
            }
        }
        return in;
    }

    public static boolean llegirSiNo(String missatge) {
        Boolean in = null;
        while (in == null) {
            System.out.print(missatge);
            try {
                String tmps = scanner.nextLine().toLowerCase();
                if (tmps.length() == 1) {
                    char tmpc = tmps.charAt(0);
                    if (tmpc == 's' || tmpc == 'n') {
                        in = tmpc == 's';
                    } else {
                        throw new Exception("input ha de ser n/s/N/S");
                    }
                } else {
                    throw new Exception("input ha de ser un únic caràcter");
                }
            } catch (Exception e) {
                System.out.println("Input no vàlid: " + e.getMessage());
            }
        }
        return in;
    }

}
